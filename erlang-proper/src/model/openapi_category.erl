-module(openapi_category).

-include("openapi.hrl").

-export([openapi_category/0]).

-export([openapi_category/1]).

-export_type([openapi_category/0]).

-type openapi_category() ::
  [ {'domainId', integer() }
  | {'catId', integer() }
  | {'name', binary() }
  | {'children', list(integer()) }
  | {'parent', integer() }
  | {'highestRank', integer() }
  | {'productCount', integer() }
  ].


openapi_category() ->
    openapi_category([]).

openapi_category(Fields) ->
  Default = [ {'domainId', integer() }
            , {'catId', integer() }
            , {'name', binary() }
            , {'children', list(integer()) }
            , {'parent', integer() }
            , {'highestRank', integer() }
            , {'productCount', integer() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

