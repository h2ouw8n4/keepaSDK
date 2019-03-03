-module(openapi_api).

-export([ product/2
        ]).

-define(BASE_URL, "/magicCashew/keepa/1.0.0").

%% @doc Retrieve the product for the specified ASIN and domain.
%% Retrieves the product object for the specified ASIN and domain. If our last update is older than one hour it will be automatically refreshed before delivered to you to ensure you get near to real-time pricing data.  You can request products via either their ASIN (preferred) or via UPC and EAN codes. You can not use both parameters, asin and code, in the same request. Keepa can not track Amazon Fresh and eBooks.
-spec product(binary(), integer()) ->
  openapi_utils:response().
product(Key, Domain) ->
  Method      = get,
  Host        = application:get_env(openapi, host, "http://localhost:8080"),
  Path        = ["/product"],
  QueryString = [<<"key=">>, Key, <<"&">>, <<"domain=">>, Domain, <<"&">>, <<"asin=">>, Asin, <<"&">>, <<"code=">>, Code, <<"&">>],

  openapi_utils:request(Method, [Host, ?BASE_URL, Path, <<"?">>, QueryString]).

