# OpenAPI\Client\CategoryApi

All URIs are relative to *https://virtserver.swaggerhub.com/magicCashew/keepa/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**category**](CategoryApi.md#category) | **GET** /category | Returns Amazon category information from Keepa API.


# **category**
> \OpenAPI\Client\Model\Category[] category($key, $domain, $category, $parents)

Returns Amazon category information from Keepa API.

Retrieve category objects using their node ids and (optional) their parent tree.

### Example
```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


$apiInstance = new OpenAPI\Client\Api\CategoryApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client()
);
$key = 'key_example'; // string | Your private API key.
$domain = 56; // int | Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)
$category = 56; // int | The category node id of the category you want to request. For batch requests a comma separated list of ids (up to 10, the token cost stays the same). Alternatively you can specify the value 0, which will retrieve a list of all root categories.
$parents = 56; // int | Whether or not to include the category tree for each category. (1 = include, 0 = do not include.)

try {
    $result = $apiInstance->category($key, $domain, $category, $parents);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling CategoryApi->category: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **key** | **string**| Your private API key. |
 **domain** | **int**| Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au) |
 **category** | **int**| The category node id of the category you want to request. For batch requests a comma separated list of ids (up to 10, the token cost stays the same). Alternatively you can specify the value 0, which will retrieve a list of all root categories. |
 **parents** | **int**| Whether or not to include the category tree for each category. (1 &#x3D; include, 0 &#x3D; do not include.) |

### Return type

[**\OpenAPI\Client\Model\Category[]**](../Model/Category.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

