# openapi_client.ProductApi

All URIs are relative to *https://virtserver.swaggerhub.com/magicCashew/keepa/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**product**](ProductApi.md#product) | **GET** /product | Retrieve the product for the specified ASIN and domain.


# **product**
> list[Category] product(key, domain, asin=asin, code=code)

Retrieve the product for the specified ASIN and domain.

Retrieves the product object for the specified ASIN and domain. If our last update is older than one hour it will be automatically refreshed before delivered to you to ensure you get near to real-time pricing data.  You can request products via either their ASIN (preferred) or via UPC and EAN codes. You can not use both parameters, asin and code, in the same request. Keepa can not track Amazon Fresh and eBooks.

### Example

```python
from __future__ import print_function
import time
import openapi_client
from openapi_client.rest import ApiException
from pprint import pprint

# create an instance of the API class
api_instance = openapi_client.ProductApi()
key = 'key_example' # str | Your private API key.
domain = 56 # int | Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)
asin = 'asin_example' # str | The ASIN of the product you want to request. For batch requests a comma separated list of ASINs (up to one hundred). (optional)
code = 'code_example' # str | The product code of the product you want to request. We currently allow UPC, EAN and ISBN-13 codes. For batch requests a comma separated list of codes (up to one hundred). Multiple ASINs can have the same product code, so requesting a product code can return multiple products. (optional)

try:
    # Retrieve the product for the specified ASIN and domain.
    api_response = api_instance.product(key, domain, asin=asin, code=code)
    pprint(api_response)
except ApiException as e:
    print("Exception when calling ProductApi->product: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **key** | **str**| Your private API key. | 
 **domain** | **int**| Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au) | 
 **asin** | **str**| The ASIN of the product you want to request. For batch requests a comma separated list of ASINs (up to one hundred). | [optional] 
 **code** | **str**| The product code of the product you want to request. We currently allow UPC, EAN and ISBN-13 codes. For batch requests a comma separated list of codes (up to one hundred). Multiple ASINs can have the same product code, so requesting a product code can return multiple products. | [optional] 

### Return type

[**list[Category]**](Category.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

