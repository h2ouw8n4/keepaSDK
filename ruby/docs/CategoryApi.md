# OpenapiClient::CategoryApi

All URIs are relative to *https://virtserver.swaggerhub.com/magicCashew/keepa/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**category**](CategoryApi.md#category) | **GET** /category | Returns Amazon category information from Keepa API.


# **category**
> Array&lt;Category&gt; category(key, domain, category, parents)

Returns Amazon category information from Keepa API.

Retrieve category objects using their node ids and (optional) their parent tree.

### Example
```ruby
# load the gem
require 'openapi_client'

api_instance = OpenapiClient::CategoryApi.new
key = 'key_example' # String | Your private API key.
domain = 56 # Integer | Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)
category = 56 # Integer | The category node id of the category you want to request. For batch requests a comma separated list of ids (up to 10, the token cost stays the same). Alternatively you can specify the value 0, which will retrieve a list of all root categories.
parents = 56 # Integer | Whether or not to include the category tree for each category. (1 = include, 0 = do not include.)

begin
  #Returns Amazon category information from Keepa API.
  result = api_instance.category(key, domain, category, parents)
  p result
rescue OpenapiClient::ApiError => e
  puts "Exception when calling CategoryApi->category: #{e}"
end
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **key** | **String**| Your private API key. | 
 **domain** | **Integer**| Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au) | 
 **category** | **Integer**| The category node id of the category you want to request. For batch requests a comma separated list of ids (up to 10, the token cost stays the same). Alternatively you can specify the value 0, which will retrieve a list of all root categories. | 
 **parents** | **Integer**| Whether or not to include the category tree for each category. (1 &#x3D; include, 0 &#x3D; do not include.) | 

### Return type

[**Array&lt;Category&gt;**](Category.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json



