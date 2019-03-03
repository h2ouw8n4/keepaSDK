# OpenAPI\Server\Api\CategoryApiInterface

All URIs are relative to *https://virtserver.swaggerhub.com/magicCashew/keepa/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**category**](CategoryApiInterface.md#category) | **GET** /category | Returns Amazon category information from Keepa API.


## Service Declaration
```yaml
# src/Acme/MyBundle/Resources/services.yml
services:
    # ...
    acme.my_bundle.api.category:
        class: Acme\MyBundle\Api\CategoryApi
        tags:
            - { name: "open_apiserver.api", api: "category" }
    # ...
```

## **category**
> OpenAPI\Server\Model\Category category($key, $domain, $category, $parents)

Returns Amazon category information from Keepa API.

Retrieve category objects using their node ids and (optional) their parent tree.

### Example Implementation
```php
<?php
// src/Acme/MyBundle/Api/CategoryApiInterface.php

namespace Acme\MyBundle\Api;

use OpenAPI\Server\Api\CategoryApiInterface;

class CategoryApi implements CategoryApiInterface
{

    // ...

    /**
     * Implementation of CategoryApiInterface#category
     */
    public function category($key, $domain, $category, $parents)
    {
        // Implement the operation ...
    }

    // ...
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **key** | **string**| Your private API key. |
 **domain** | **int**| Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au) |
 **category** | **int**| The category node id of the category you want to request. For batch requests a comma separated list of ids (up to 10, the token cost stays the same). Alternatively you can specify the value 0, which will retrieve a list of all root categories. |
 **parents** | **int**| Whether or not to include the category tree for each category. (1 &#x3D; include, 0 &#x3D; do not include.) |

### Return type

[**OpenAPI\Server\Model\Category**](../Model/Category.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

