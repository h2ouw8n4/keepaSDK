-module(openapi_category).

-export([encode/1]).

-export_type([openapi_category/0]).

-type openapi_category() ::
    #{ 'domainId' := integer(),
       'catId' := integer(),
       'name' := binary(),
       'children' := list(),
       'parent' := integer(),
       'highestRank' := integer(),
       'productCount' := integer()
     }.

encode(#{ 'domainId' := DomainId,
          'catId' := CatId,
          'name' := Name,
          'children' := Children,
          'parent' := Parent,
          'highestRank' := HighestRank,
          'productCount' := ProductCount
        }) ->
    #{ 'domainId' => DomainId,
       'catId' => CatId,
       'name' => Name,
       'children' => Children,
       'parent' => Parent,
       'highestRank' => HighestRank,
       'productCount' => ProductCount
     }.
