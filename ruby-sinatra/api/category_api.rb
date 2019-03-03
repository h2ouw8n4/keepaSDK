require 'json'


MyApp.add_route('GET', '/magicCashew/keepa/1.0.0/category', {
  "resourcePath" => "/Category",
  "summary" => "Returns Amazon category information from Keepa API.",
  "nickname" => "category", 
  "responseClass" => "Array<category>",
  "endpoint" => "/category", 
  "notes" => "Retrieve category objects using their node ids and (optional) their parent tree.",
  "parameters" => [
    {
      "name" => "key",
      "description" => "Your private API key.",
      "dataType" => "String",
      "allowableValues" => "",
      "paramType" => "query",
    },
    {
      "name" => "domain",
      "description" => "Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)",
      "dataType" => "Integer",
      "allowableValues" => "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13]",
      "paramType" => "query",
    },
    {
      "name" => "category",
      "description" => "The category node id of the category you want to request. For batch requests a comma separated list of ids (up to 10, the token cost stays the same). Alternatively you can specify the value 0, which will retrieve a list of all root categories.",
      "dataType" => "Integer",
      "allowableValues" => "",
      "paramType" => "query",
    },
    {
      "name" => "parents",
      "description" => "Whether or not to include the category tree for each category. (1 &#x3D; include, 0 &#x3D; do not include.)",
      "dataType" => "Integer",
      "allowableValues" => "[0, 1]",
      "paramType" => "query",
    },
    ]}) do
  cross_origin
  # the guts live here

  {"message" => "yes, it worked"}.to_json
end

