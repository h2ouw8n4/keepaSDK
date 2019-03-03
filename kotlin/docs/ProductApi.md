# ProductApi

All URIs are relative to *https://virtserver.swaggerhub.com/magicCashew/keepa/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**product**](ProductApi.md#product) | **GET** /product | Retrieve the product for the specified ASIN and domain.


<a name="product"></a>
# **product**
> kotlin.Array&lt;Category&gt; product(key, domain, asin, code)

Retrieve the product for the specified ASIN and domain.

Retrieves the product object for the specified ASIN and domain. If our last update is older than one hour it will be automatically refreshed before delivered to you to ensure you get near to real-time pricing data.  You can request products via either their ASIN (preferred) or via UPC and EAN codes. You can not use both parameters, asin and code, in the same request. Keepa can not track Amazon Fresh and eBooks.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = ProductApi()
val key : kotlin.String = key_example // kotlin.String | Your private API key.
val domain : kotlin.Int = 56 // kotlin.Int | Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)
val asin : kotlin.String = asin_example // kotlin.String | The ASIN of the product you want to request. For batch requests a comma separated list of ASINs (up to one hundred).
val code : kotlin.String = code_example // kotlin.String | The product code of the product you want to request. We currently allow UPC, EAN and ISBN-13 codes. For batch requests a comma separated list of codes (up to one hundred). Multiple ASINs can have the same product code, so requesting a product code can return multiple products.
try {
    val result : kotlin.Array<Category> = apiInstance.product(key, domain, asin, code)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ProductApi#product")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ProductApi#product")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **key** | **kotlin.String**| Your private API key. | [default to null]
 **domain** | **kotlin.Int**| Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au) | [default to null] [enum: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13]
 **asin** | **kotlin.String**| The ASIN of the product you want to request. For batch requests a comma separated list of ASINs (up to one hundred). | [optional] [default to null]
 **code** | **kotlin.String**| The product code of the product you want to request. We currently allow UPC, EAN and ISBN-13 codes. For batch requests a comma separated list of codes (up to one hundred). Multiple ASINs can have the same product code, so requesting a product code can return multiple products. | [optional] [default to null]

### Return type

[**kotlin.Array&lt;Category&gt;**](Category.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

