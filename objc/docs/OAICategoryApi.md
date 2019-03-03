# OAICategoryApi

All URIs are relative to *https://virtserver.swaggerhub.com/magicCashew/keepa/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**category**](OAICategoryApi.md#category) | **GET** /category | Returns Amazon category information from Keepa API.


# **category**
```objc
-(NSURLSessionTask*) categoryWithKey: (NSString*) key
    domain: (NSNumber*) domain
    category: (NSNumber*) category
    parents: (NSNumber*) parents
        completionHandler: (void (^)(NSArray<OAICategory>* output, NSError* error)) handler;
```

Returns Amazon category information from Keepa API.

Retrieve category objects using their node ids and (optional) their parent tree.

### Example 
```objc

NSString* key = @"key_example"; // Your private API key.
NSNumber* domain = @56; // Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)
NSNumber* category = @56; // The category node id of the category you want to request. For batch requests a comma separated list of ids (up to 10, the token cost stays the same). Alternatively you can specify the value 0, which will retrieve a list of all root categories.
NSNumber* parents = @56; // Whether or not to include the category tree for each category. (1 = include, 0 = do not include.)

OAICategoryApi*apiInstance = [[OAICategoryApi alloc] init];

// Returns Amazon category information from Keepa API.
[apiInstance categoryWithKey:key
              domain:domain
              category:category
              parents:parents
          completionHandler: ^(NSArray<OAICategory>* output, NSError* error) {
                        if (output) {
                            NSLog(@"%@", output);
                        }
                        if (error) {
                            NSLog(@"Error calling OAICategoryApi->category: %@", error);
                        }
                    }];
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **key** | **NSString***| Your private API key. | 
 **domain** | **NSNumber***| Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au) | 
 **category** | **NSNumber***| The category node id of the category you want to request. For batch requests a comma separated list of ids (up to 10, the token cost stays the same). Alternatively you can specify the value 0, which will retrieve a list of all root categories. | 
 **parents** | **NSNumber***| Whether or not to include the category tree for each category. (1 &#x3D; include, 0 &#x3D; do not include.) | 

### Return type

[**NSArray<OAICategory>***](OAICategory.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

