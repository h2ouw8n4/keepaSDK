# \CategoryApi

All URIs are relative to *https://virtserver.swaggerhub.com/magicCashew/keepa/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**category**](CategoryApi.md#category) | **Get** /category | Returns Amazon category information from Keepa API.


# **category**
> Vec<::models::Category> category(key, domain, category, parents)
Returns Amazon category information from Keepa API.

Retrieve category objects using their node ids and (optional) their parent tree.

### Required Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
  **key** | **String**| Your private API key. | 
  **domain** | **i32**| Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au) | 
  **category** | **i32**| The category node id of the category you want to request. For batch requests a comma separated list of ids (up to 10, the token cost stays the same). Alternatively you can specify the value 0, which will retrieve a list of all root categories. | 
  **parents** | **i32**| Whether or not to include the category tree for each category. (1 = include, 0 = do not include.) | 

### Return type

[**Vec<::models::Category>**](category.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

