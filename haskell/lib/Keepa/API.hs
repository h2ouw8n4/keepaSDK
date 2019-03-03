{-# LANGUAGE DataKinds                  #-}
{-# LANGUAGE DeriveDataTypeable         #-}
{-# LANGUAGE DeriveGeneric              #-}
{-# LANGUAGE DeriveTraversable          #-}
{-# LANGUAGE FlexibleContexts           #-}
{-# LANGUAGE FlexibleInstances          #-}
{-# LANGUAGE GeneralizedNewtypeDeriving #-}
{-# LANGUAGE OverloadedStrings          #-}
{-# LANGUAGE RecordWildCards            #-}
{-# LANGUAGE TypeFamilies               #-}
{-# LANGUAGE TypeOperators              #-}
{-# LANGUAGE ViewPatterns               #-}
{-# OPTIONS_GHC
-fno-warn-unused-binds -fno-warn-unused-imports -freduction-depth=328 #-}

module Keepa.API
  -- * Client and Server
  ( Config(..)
  , KeepaBackend(..)
  , createKeepaClient
  , runKeepaServer
  , runKeepaClient
  , runKeepaClientWithManager
  , callKeepa
  , KeepaClient
  , KeepaClientError(..)
  -- ** Servant
  , KeepaAPI
  ) where

import           Keepa.Types

import           Control.Monad.Catch                (Exception, MonadThrow, throwM)
import           Control.Monad.Except               (ExceptT, runExceptT)
import           Control.Monad.IO.Class
import           Control.Monad.Trans.Reader         (ReaderT (..))
import           Data.Aeson                         (Value)
import           Data.Coerce                        (coerce)
import           Data.Data                          (Data)
import           Data.Function                      ((&))
import qualified Data.Map                           as Map
import           Data.Monoid                        ((<>))
import           Data.Proxy                         (Proxy (..))
import           Data.Text                          (Text)
import qualified Data.Text                          as T
import           Data.UUID                          (UUID)
import           GHC.Exts                           (IsString (..))
import           GHC.Generics                       (Generic)
import           Network.HTTP.Client                (Manager, newManager)
import           Network.HTTP.Client.TLS            (tlsManagerSettings)
import           Network.HTTP.Types.Method          (methodOptions)
import qualified Network.Wai.Handler.Warp           as Warp
import           Servant                            (ServantErr, serve)
import           Servant.API
import           Servant.API.Verbs                  (StdMethod (..), Verb)
import           Servant.Client                     (ClientEnv, Scheme (Http), ServantError, client,
                                                     mkClientEnv, parseBaseUrl)
import           Servant.Client.Core                (baseUrlPort, baseUrlHost)
import           Servant.Client.Internal.HttpClient (ClientM (..))
import           Servant.Server                     (Handler (..))
import           Web.FormUrlEncoded
import           Web.HttpApiData




-- | List of elements parsed from a query.
newtype QueryList (p :: CollectionFormat) a = QueryList
  { fromQueryList :: [a]
  } deriving (Functor, Applicative, Monad, Foldable, Traversable)

-- | Formats in which a list can be encoded into a HTTP path.
data CollectionFormat
  = CommaSeparated -- ^ CSV format for multiple parameters.
  | SpaceSeparated -- ^ Also called "SSV"
  | TabSeparated -- ^ Also called "TSV"
  | PipeSeparated -- ^ `value1|value2|value2`
  | MultiParamArray -- ^ Using multiple GET parameters, e.g. `foo=bar&foo=baz`. Only for GET params.

instance FromHttpApiData a => FromHttpApiData (QueryList 'CommaSeparated a) where
  parseQueryParam = parseSeparatedQueryList ','

instance FromHttpApiData a => FromHttpApiData (QueryList 'TabSeparated a) where
  parseQueryParam = parseSeparatedQueryList '\t'

instance FromHttpApiData a => FromHttpApiData (QueryList 'SpaceSeparated a) where
  parseQueryParam = parseSeparatedQueryList ' '

instance FromHttpApiData a => FromHttpApiData (QueryList 'PipeSeparated a) where
  parseQueryParam = parseSeparatedQueryList '|'

instance FromHttpApiData a => FromHttpApiData (QueryList 'MultiParamArray a) where
  parseQueryParam = error "unimplemented FromHttpApiData for MultiParamArray collection format"

parseSeparatedQueryList :: FromHttpApiData a => Char -> Text -> Either Text (QueryList p a)
parseSeparatedQueryList char = fmap QueryList . mapM parseQueryParam . T.split (== char)

instance ToHttpApiData a => ToHttpApiData (QueryList 'CommaSeparated a) where
  toQueryParam = formatSeparatedQueryList ','

instance ToHttpApiData a => ToHttpApiData (QueryList 'TabSeparated a) where
  toQueryParam = formatSeparatedQueryList '\t'

instance ToHttpApiData a => ToHttpApiData (QueryList 'SpaceSeparated a) where
  toQueryParam = formatSeparatedQueryList ' '

instance ToHttpApiData a => ToHttpApiData (QueryList 'PipeSeparated a) where
  toQueryParam = formatSeparatedQueryList '|'

instance ToHttpApiData a => ToHttpApiData (QueryList 'MultiParamArray a) where
  toQueryParam = error "unimplemented ToHttpApiData for MultiParamArray collection format"

formatSeparatedQueryList :: ToHttpApiData a => Char ->  QueryList p a -> Text
formatSeparatedQueryList char = T.intercalate (T.singleton char) . map toQueryParam . fromQueryList


-- | Servant type-level API, generated from the OpenAPI spec for Keepa.
type KeepaAPI
    =    "category" :> QueryParam "key" Text :> QueryParam "domain" Int :> QueryParam "category" Int :> QueryParam "parents" Int :> Verb 'GET 200 '[JSON] [Category] -- 'category' route
    :<|> "product" :> QueryParam "key" Text :> QueryParam "domain" Int :> QueryParam "asin" Text :> QueryParam "code" Text :> Verb 'GET 200 '[JSON] [Category] -- 'product' route


-- | Server or client configuration, specifying the host and port to query or serve on.
data Config = Config
  { configUrl :: String  -- ^ scheme://hostname:port/path, e.g. "http://localhost:8080/"
  } deriving (Eq, Ord, Show, Read)


-- | Custom exception type for our errors.
newtype KeepaClientError = KeepaClientError ServantError
  deriving (Show, Exception)
-- | Configuration, specifying the full url of the service.


-- | Backend for Keepa.
-- The backend can be used both for the client and the server. The client generated from the Keepa OpenAPI spec
-- is a backend that executes actions by sending HTTP requests (see @createKeepaClient@). Alternatively, provided
-- a backend, the API can be served using @runKeepaServer@.
data KeepaBackend m = KeepaBackend
  { category :: Maybe Text -> Maybe Int -> Maybe Int -> Maybe Int -> m [Category]{- ^ Retrieve category objects using their node ids and (optional) their parent tree. -}
  , product :: Maybe Text -> Maybe Int -> Maybe Text -> Maybe Text -> m [Category]{- ^ Retrieves the product object for the specified ASIN and domain. If our last update is older than one hour it will be automatically refreshed before delivered to you to ensure you get near to real-time pricing data.  You can request products via either their ASIN (preferred) or via UPC and EAN codes. You can not use both parameters, asin and code, in the same request. Keepa can not track Amazon Fresh and eBooks. -}
  }

newtype KeepaClient a = KeepaClient
  { runClient :: ClientEnv -> ExceptT ServantError IO a
  } deriving Functor

instance Applicative KeepaClient where
  pure x = KeepaClient (\_ -> pure x)
  (KeepaClient f) <*> (KeepaClient x) =
    KeepaClient (\env -> f env <*> x env)

instance Monad KeepaClient where
  (KeepaClient a) >>= f =
    KeepaClient (\env -> do
      value <- a env
      runClient (f value) env)

instance MonadIO KeepaClient where
  liftIO io = KeepaClient (\_ -> liftIO io)

createKeepaClient :: KeepaBackend KeepaClient
createKeepaClient = KeepaBackend{..}
  where
    ((coerce -> category) :<|>
     (coerce -> product)) = client (Proxy :: Proxy KeepaAPI)

-- | Run requests in the KeepaClient monad.
runKeepaClient :: Config -> KeepaClient a -> ExceptT ServantError IO a
runKeepaClient clientConfig cl = do
  manager <- liftIO $ newManager tlsManagerSettings
  runKeepaClientWithManager manager clientConfig cl

-- | Run requests in the KeepaClient monad using a custom manager.
runKeepaClientWithManager :: Manager -> Config -> KeepaClient a -> ExceptT ServantError IO a
runKeepaClientWithManager manager Config{..} cl = do
  url <- parseBaseUrl configUrl
  runClient cl $ mkClientEnv manager url

-- | Like @runClient@, but returns the response or throws
--   a KeepaClientError
callKeepa
  :: (MonadIO m, MonadThrow m)
  => ClientEnv -> KeepaClient a -> m a
callKeepa env f = do
  res <- liftIO $ runExceptT $ runClient f env
  case res of
    Left err       -> throwM (KeepaClientError err)
    Right response -> pure response

-- | Run the Keepa server at the provided host and port.
runKeepaServer
  :: (MonadIO m, MonadThrow m)
  => Config -> KeepaBackend (ExceptT ServantErr IO) -> m ()
runKeepaServer Config{..} backend = do
  url <- parseBaseUrl configUrl
  let warpSettings = Warp.defaultSettings
        & Warp.setPort (baseUrlPort url)
        & Warp.setHost (fromString $ baseUrlHost url)
  liftIO $ Warp.runSettings warpSettings $ serve (Proxy :: Proxy KeepaAPI) (serverFromBackend backend)
  where
    serverFromBackend KeepaBackend{..} =
      (coerce category :<|>
       coerce product)
