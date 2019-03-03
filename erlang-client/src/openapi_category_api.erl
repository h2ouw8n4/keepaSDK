-module(openapi_category_api).

-export([category/5, category/6]).

-define(BASE_URL, "/magicCashew/keepa/1.0.0").

%% @doc Returns Amazon category information from Keepa API.
%% Retrieve category objects using their node ids and (optional) their parent tree.
-spec category(ctx:ctx(), binary(), integer(), integer(), integer()) -> {ok, [openapi_category:openapi_category()], openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
category(Ctx, Key, Domain, Category, Parents) ->
    category(Ctx, Key, Domain, Category, Parents, #{}).

-spec category(ctx:ctx(), binary(), integer(), integer(), integer(), maps:map()) -> {ok, [openapi_category:openapi_category()], openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
category(Ctx, Key, Domain, Category, Parents, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(kuberl, config, #{})),

    Method = get,
    Path = ["/category"],
    QS = lists:flatten([{<<"key">>, Key}, {<<"domain">>, Domain}, {<<"category">>, Category}, {<<"parents">>, Parents}])++openapi_utils:optional_params([], _OptionalParams),
    Headers = [],
    Body1 = [],
    ContentTypeHeader = openapi_utils:select_header_content_type([]),
    Opts = maps:get(hackney_opts, Optional, []),

    openapi_utils:request(Ctx, Method, [?BASE_URL, Path], QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).


