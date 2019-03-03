# OAIProductApi

All URIs are relative to *https://virtserver.swaggerhub.com/magicCashew/keepa/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**product**](OAIProductApi.md#product) | **GET** /product | Retrieve the product for the specified ASIN and domain.


# **product**
```objc
-(NSURLSessionTask*) productWithKey: (NSString*) key
    domain: (NSNumber*) domain
    asin: (NSString*) asin
    code: (NSString*) code
        completionHandler: (void (^)(NSArray<OAICategory>* output, NSError* error)) handler;
```

Retrieve the product for the specified ASIN and domain.

Retrieves the product object for the specified ASIN and domain. If our last update is older than one hour it will be automatically refreshed before delivered to you to ensure you get near to real-time pricing data.  You can request products via either their ASIN (preferred) or via UPC and EAN codes. You can not use both parameters, asin and code, in the same request. Keepa can not track Amazon Fresh and eBooks.

### Example 
```objc

NSString* key = @"key_example"; // Your private API key.
NSNumber* domain = @56; // Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)
NSString* asin = @"asin_example"; // The ASIN of the product you want to request. For batch requests a comma separated list of ASINs (up to one hundred). (optional)
NSString* code = @"code_example"; // The product code of the product you want to request. We currently allow UPC, EAN and ISBN-13 codes. For batch requests a comma separated list of codes (up to one hundred). Multiple ASINs can have the same product code, so requesting a product code can return multiple products. (optional)

OAIProductApi*apiInstance = [[OAIProductApi alloc] init];

// Retrieve the product for the specified ASIN and domain.
[apiInstance productWithKey:key
              domain:domain
              asin:asin
              code:code
          completionHandler: ^(NSArray<OAICategory>* output, NSError* error) {
                        if (output) {
                            NSLog(@"%@", output);
                        }
                        if (error) {
                            NSLog(@"Error calling OAIProductApi->product: %@", error);
                        }
                    }];
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **key** | **NSString***| Your private API key. | 
 **domain** | **NSNumber***| Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au) | 
 **asin** | **NSString***| The ASIN of the product you want to request. For batch requests a comma separated list of ASINs (up to one hundred). | [optional] 
 **code** | **NSString***| The product code of the product you want to request. We currently allow UPC, EAN and ISBN-13 codes. For batch requests a comma separated list of codes (up to one hundred). Multiple ASINs can have the same product code, so requesting a product code can return multiple products. | [optional] 

### Return type

[**NSArray<OAICategory>***](OAICategory.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

