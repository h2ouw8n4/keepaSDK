require 'json'


MyApp.add_route('GET', '/magicCashew/keepa/1.0.0/product', {
  "resourcePath" => "/Product",
  "summary" => "Retrieve the product for the specified ASIN and domain.",
  "nickname" => "product", 
  "responseClass" => "Array<category>",
  "endpoint" => "/product", 
  "notes" => "Retrieves the product object for the specified ASIN and domain. If our last update is older than one hour it will be automatically refreshed before delivered to you to ensure you get near to real-time pricing data.  You can request products via either their ASIN (preferred) or via UPC and EAN codes. You can not use both parameters, asin and code, in the same request. Keepa can not track Amazon Fresh and eBooks.",
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
      "name" => "asin",
      "description" => "The ASIN of the product you want to request. For batch requests a comma separated list of ASINs (up to one hundred).",
      "dataType" => "String",
      "allowableValues" => "",
      "paramType" => "query",
    },
    {
      "name" => "code",
      "description" => "The product code of the product you want to request. We currently allow UPC, EAN and ISBN-13 codes. For batch requests a comma separated list of codes (up to one hundred). Multiple ASINs can have the same product code, so requesting a product code can return multiple products.",
      "dataType" => "String",
      "allowableValues" => "",
      "paramType" => "query",
    },
    ]}) do
  cross_origin
  # the guts live here

  {"message" => "yes, it worked"}.to_json
end

