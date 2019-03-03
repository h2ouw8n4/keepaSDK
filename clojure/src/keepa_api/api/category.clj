(ns keepa-api.api.category
  (:require [keepa-api.core :refer [call-api check-required-params with-collection-format *api-context*]]
            [clojure.spec.alpha :as s]
            [spec-tools.core :as st]
            [orchestra.core :refer [defn-spec]]
            [keepa-api.specs.category :refer :all]
            )
  (:import (java.io File)))


(defn-spec category-with-http-info any?
  "Returns Amazon category information from Keepa API.
  Retrieve category objects using their node ids and (optional) their parent tree."
  [key string?, domain int?, category int?, parents int?]
  (check-required-params key domain category parents)
  (call-api "/category" :get
            {:path-params   {}
             :header-params {}
             :query-params  {"key" key "domain" domain "category" category "parents" parents }
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec category (s/coll-of category-spec)
  "Returns Amazon category information from Keepa API.
  Retrieve category objects using their node ids and (optional) their parent tree."
  [key string?, domain int?, category int?, parents int?]
  (let [res (:data (category-with-http-info key domain category parents))]
    (if (:decode-models *api-context*)
       (st/decode (s/coll-of category-spec) res st/string-transformer)
       res)))


