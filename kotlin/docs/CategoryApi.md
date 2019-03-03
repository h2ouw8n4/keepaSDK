# CategoryApi

All URIs are relative to *https://virtserver.swaggerhub.com/magicCashew/keepa/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**category**](CategoryApi.md#category) | **GET** /category | Returns Amazon category information from Keepa API.


<a name="category"></a>
# **category**
> kotlin.Array&lt;Category&gt; category(key, domain, category, parents)

Returns Amazon category information from Keepa API.

Retrieve category objects using their node ids and (optional) their parent tree.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CategoryApi()
val key : kotlin.String = key_example // kotlin.String | Your private API key.
val domain : kotlin.Int = 56 // kotlin.Int | Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)
val category : kotlin.Int = 56 // kotlin.Int | The category node id of the category you want to request. For batch requests a comma separated list of ids (up to 10, the token cost stays the same). Alternatively you can specify the value 0, which will retrieve a list of all root categories.
val parents : kotlin.Int = 56 // kotlin.Int | Whether or not to include the category tree for each category. (1 = include, 0 = do not include.)
try {
    val result : kotlin.Array<Category> = apiInstance.category(key, domain, category, parents)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CategoryApi#category")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CategoryApi#category")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **key** | **kotlin.String**| Your private API key. | [default to null]
 **domain** | **kotlin.Int**| Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au) | [default to null] [enum: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13]
 **category** | **kotlin.Int**| The category node id of the category you want to request. For batch requests a comma separated list of ids (up to 10, the token cost stays the same). Alternatively you can specify the value 0, which will retrieve a list of all root categories. | [default to null]
 **parents** | **kotlin.Int**| Whether or not to include the category tree for each category. (1 &#x3D; include, 0 &#x3D; do not include.) | [default to null] [enum: 0, 1]

### Return type

[**kotlin.Array&lt;Category&gt;**](Category.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

