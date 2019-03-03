# Org.OpenAPITools.Api.CategoryApi

All URIs are relative to *https://virtserver.swaggerhub.com/magicCashew/keepa/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**Category**](CategoryApi.md#category) | **GET** /category | Returns Amazon category information from Keepa API.


<a name="category"></a>
# **Category**
> List<Category> Category (string key, int? domain, int? category, int? parents)

Returns Amazon category information from Keepa API.

Retrieve category objects using their node ids and (optional) their parent tree.

### Example
```csharp
using System;
using System.Diagnostics;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class CategoryExample
    {
        public void main()
        {
            var apiInstance = new CategoryApi();
            var key = key_example;  // string | Your private API key.
            var domain = 56;  // int? | Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)
            var category = 56;  // int? | The category node id of the category you want to request. For batch requests a comma separated list of ids (up to 10, the token cost stays the same). Alternatively you can specify the value 0, which will retrieve a list of all root categories.
            var parents = 56;  // int? | Whether or not to include the category tree for each category. (1 = include, 0 = do not include.)

            try
            {
                // Returns Amazon category information from Keepa API.
                List&lt;Category&gt; result = apiInstance.Category(key, domain, category, parents);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling CategoryApi.Category: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **key** | **string**| Your private API key. | 
 **domain** | **int?**| Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au) | 
 **category** | **int?**| The category node id of the category you want to request. For batch requests a comma separated list of ids (up to 10, the token cost stays the same). Alternatively you can specify the value 0, which will retrieve a list of all root categories. | 
 **parents** | **int?**| Whether or not to include the category tree for each category. (1 &#x3D; include, 0 &#x3D; do not include.) | 

### Return type

[**List<Category>**](Category.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

