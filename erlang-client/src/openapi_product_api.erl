-module(openapi_product_api).

-export([product/3, product/4]).

-define(BASE_URL, "/magicCashew/keepa/1.0.0").

%% @doc Retrieve the product for the specified ASIN and domain.
%% Retrieves the product object for the specified ASIN and domain. If our last update is older than one hour it will be automatically refreshed before delivered to you to ensure you get near to real-time pricing data.  You can request products via either their ASIN (preferred) or via UPC and EAN codes. You can not use both parameters, asin and code, in the same request. Keepa can not track Amazon Fresh and eBooks.
-spec product(ctx:ctx(), binary(), integer()) -> {ok, [openapi_category:openapi_category()], openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
product(Ctx, Key, Domain) ->
    product(Ctx, Key, Domain, #{}).

-spec product(ctx:ctx(), binary(), integer(), maps:map()) -> {ok, [openapi_category:openapi_category()], openapi_utils:response_info()} | {ok, hackney:client_ref()} | {error, term(), openapi_utils:response_info()}.
product(Ctx, Key, Domain, Optional) ->
    _OptionalParams = maps:get(params, Optional, #{}),
    Cfg = maps:get(cfg, Optional, application:get_env(kuberl, config, #{})),

    Method = get,
    Path = ["/product"],
    QS = lists:flatten([{<<"key">>, Key}, {<<"domain">>, Domain}])++openapi_utils:optional_params(['asin', 'code'], _OptionalParams),
    Headers = [],
    Body1 = [],
    ContentTypeHeader = openapi_utils:select_header_content_type([]),
    Opts = maps:get(hackney_opts, Optional, []),

    openapi_utils:request(Ctx, Method, [?BASE_URL, Path], QS, ContentTypeHeader++Headers, Body1, Opts, Cfg).


