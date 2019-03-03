#include <stdlib.h>
#include <stdio.h>
#include <ctype.h>
#include "ProductAPI.h"


#define MAX_BUFFER_LENGTH 4096
#define intToStr(dst, src) \
    do {\
    char dst[256];\
    snprintf(dst, 256, "%ld", (long int)(src));\
}while(0)

// Retrieve the product for the specified ASIN and domain.
//
// Retrieves the product object for the specified ASIN and domain. If our last update is older than one hour it will be automatically refreshed before delivered to you to ensure you get near to real-time pricing data.  You can request products via either their ASIN (preferred) or via UPC and EAN codes. You can not use both parameters, asin and code, in the same request. Keepa can not track Amazon Fresh and eBooks.
//
list_t*
ProductAPI_product(apiClient_t *apiClient, char* key, int domain, char* asin, char* code) {
    list_t    *localVarQueryParameters = list_create();
    list_t    *localVarHeaderParameters = NULL;
    list_t    *localVarFormParameters = NULL;
    list_t *localVarHeaderType = list_create();
    list_t *localVarContentType = NULL;
    char      *localVarBodyParameters = NULL;

    // create the path
    long sizeOfPath = strlen("/product")+1;
    char *localVarPath = malloc(sizeOfPath);
    snprintf(localVarPath, sizeOfPath, "/product");


    // query parameters
    char *keyQuery_key;
    char *valueQuery_key;
    keyValuePair_t *keyPairQuery_key = 0;
    if (key)
    {
    //string
    keyQuery_key = strdup("key");
    valueQuery_key = strdup(key);
    keyPairQuery_key = keyValuePair_create(keyQuery_key, valueQuery_key);
    list_addElement(localVarQueryParameters,keyPairQuery_key);
    }

    // query parameters
    char *keyQuery_domain;
    int valueQuery_domain;
    keyValuePair_t *keyPairQuery_domain = 0;
    if (domain)
    {
    //not string
    keyQuery_domain = strdup("domain");
    valueQuery_domain = domain;
    keyPairQuery_domain = keyValuePair_create(keyQuery_domain, &valueQuery_domain);
    list_addElement(localVarQueryParameters,keyPairQuery_domain);
    }

    // query parameters
    char *keyQuery_asin;
    char *valueQuery_asin;
    keyValuePair_t *keyPairQuery_asin = 0;
    if (asin)
    {
    //string
    keyQuery_asin = strdup("asin");
    valueQuery_asin = strdup(asin);
    keyPairQuery_asin = keyValuePair_create(keyQuery_asin, valueQuery_asin);
    list_addElement(localVarQueryParameters,keyPairQuery_asin);
    }

    // query parameters
    char *keyQuery_code;
    char *valueQuery_code;
    keyValuePair_t *keyPairQuery_code = 0;
    if (code)
    {
    //string
    keyQuery_code = strdup("code");
    valueQuery_code = strdup(code);
    keyPairQuery_code = keyValuePair_create(keyQuery_code, valueQuery_code);
    list_addElement(localVarQueryParameters,keyPairQuery_code);
    }
    list_addElement(localVarHeaderType,"application/json"); //produces
    apiClient_invoke(apiClient,
                    localVarPath,
                    localVarQueryParameters,
                    localVarHeaderParameters,
                    localVarFormParameters,
                    localVarHeaderType,
                    localVarContentType,
                    localVarBodyParameters,
                    "GET");

    if (apiClient->response_code == 200) {
        printf("%s\n","search results matching criteria");
    }
    if (apiClient->response_code == 400) {
        printf("%s\n","bad input parameter");
    }
    cJSON *ProductAPIlocalVarJSON = cJSON_Parse(apiClient->dataReceived);
    if(!cJSON_IsArray(ProductAPIlocalVarJSON)) {
        return 0;//nonprimitive container
    }
    list_t *elementToReturn = list_create();
    cJSON *VarJSON;
    cJSON_ArrayForEach(VarJSON, ProductAPIlocalVarJSON)
    {
        if(!cJSON_IsObject(VarJSON))
        {
           // return 0;
        }
        char *localVarJSONToChar = cJSON_Print(VarJSON);
        list_addElement(elementToReturn , localVarJSONToChar);
    }

    cJSON_Delete( ProductAPIlocalVarJSON);
    cJSON_Delete( VarJSON);
    //return type
    if (apiClient->dataReceived) {
        free(apiClient->dataReceived);
    }
    list_free(localVarQueryParameters);
    
    
    list_free(localVarHeaderType);
    
    free(localVarPath);
    free(keyQuery_key);
    free(valueQuery_key);
    keyValuePair_free(keyPairQuery_key);
    free(keyQuery_domain);
    keyValuePair_free(keyPairQuery_domain);
    free(keyQuery_asin);
    free(valueQuery_asin);
    keyValuePair_free(keyPairQuery_asin);
    free(keyQuery_code);
    free(valueQuery_code);
    keyValuePair_free(keyPairQuery_code);
    return elementToReturn;
end:
    return NULL;

}

