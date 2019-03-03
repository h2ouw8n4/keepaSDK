# ProductApi

All URIs are relative to *https://virtserver.swaggerhub.com/magicCashew/keepa/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**product**](ProductApi.md#product) | **GET** /product | Retrieve the product for the specified ASIN and domain.


<a name="product"></a>
# **product**
> List&lt;Category&gt; product(key, domain, asin, code)

Retrieve the product for the specified ASIN and domain.

Retrieves the product object for the specified ASIN and domain. If our last update is older than one hour it will be automatically refreshed before delivered to you to ensure you get near to real-time pricing data.  You can request products via either their ASIN (preferred) or via UPC and EAN codes. You can not use both parameters, asin and code, in the same request. Keepa can not track Amazon Fresh and eBooks.

### Example
```java
// Import classes:
//import org.openapitools.client.ApiException;
//import org.openapitools.client.api.ProductApi;


ProductApi apiInstance = new ProductApi();
String key = "key_example"; // String | Your private API key.
Integer domain = 56; // Integer | Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)
String asin = "asin_example"; // String | The ASIN of the product you want to request. For batch requests a comma separated list of ASINs (up to one hundred).
String code = "code_example"; // String | The product code of the product you want to request. We currently allow UPC, EAN and ISBN-13 codes. For batch requests a comma separated list of codes (up to one hundred). Multiple ASINs can have the same product code, so requesting a product code can return multiple products.
try {
    List<Category> result = apiInstance.product(key, domain, asin, code);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductApi#product");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **key** | **String**| Your private API key. |
 **domain** | **Integer**| Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au) | [enum: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13]
 **asin** | **String**| The ASIN of the product you want to request. For batch requests a comma separated list of ASINs (up to one hundred). | [optional]
 **code** | **String**| The product code of the product you want to request. We currently allow UPC, EAN and ISBN-13 codes. For batch requests a comma separated list of codes (up to one hundred). Multiple ASINs can have the same product code, so requesting a product code can return multiple products. | [optional]

### Return type

[**List&lt;Category&gt;**](Category.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

