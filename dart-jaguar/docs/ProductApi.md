# openapi.api.ProductApi

## Load the API package
```dart
import 'package:openapi/api.dart';
```

All URIs are relative to *https://virtserver.swaggerhub.com/magicCashew/keepa/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**product**](ProductApi.md#product) | **Get** /product | Retrieve the product for the specified ASIN and domain.


# **product**
> List<Category> product(key, domain, asin, code)

Retrieve the product for the specified ASIN and domain.

Retrieves the product object for the specified ASIN and domain. If our last update is older than one hour it will be automatically refreshed before delivered to you to ensure you get near to real-time pricing data.  You can request products via either their ASIN (preferred) or via UPC and EAN codes. You can not use both parameters, asin and code, in the same request. Keepa can not track Amazon Fresh and eBooks.

### Example 
```dart
import 'package:openapi/api.dart';

var api_instance = new ProductApi();
var key = key_example; // String | Your private API key.
var domain = 56; // int | Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)
var asin = asin_example; // String | The ASIN of the product you want to request. For batch requests a comma separated list of ASINs (up to one hundred).
var code = code_example; // String | The product code of the product you want to request. We currently allow UPC, EAN and ISBN-13 codes. For batch requests a comma separated list of codes (up to one hundred). Multiple ASINs can have the same product code, so requesting a product code can return multiple products.

try { 
    var result = api_instance.product(key, domain, asin, code);
    print(result);
} catch (e) {
    print("Exception when calling ProductApi->product: $e\n");
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **key** | **String**| Your private API key. | [default to null]
 **domain** | **int**| Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au) | [default to null]
 **asin** | **String**| The ASIN of the product you want to request. For batch requests a comma separated list of ASINs (up to one hundred). | [optional] [default to null]
 **code** | **String**| The product code of the product you want to request. We currently allow UPC, EAN and ISBN-13 codes. For batch requests a comma separated list of codes (up to one hundred). Multiple ASINs can have the same product code, so requesting a product code can return multiple products. | [optional] [default to null]

### Return type

[**List<Category>**](Category.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

