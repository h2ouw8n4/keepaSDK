#include <stdlib.h>
#include <stdio.h>
#include <ctype.h>
#include "CategoryAPI.h"


#define MAX_BUFFER_LENGTH 4096
#define intToStr(dst, src) \
    do {\
    char dst[256];\
    snprintf(dst, 256, "%ld", (long int)(src));\
}while(0)

// Returns Amazon category information from Keepa API.
//
// Retrieve category objects using their node ids and (optional) their parent tree.
//
list_t*
CategoryAPI_category(apiClient_t *apiClient, char* key, int domain, int category, int parents) {
    list_t    *localVarQueryParameters = list_create();
    list_t    *localVarHeaderParameters = NULL;
    list_t    *localVarFormParameters = NULL;
    list_t *localVarHeaderType = list_create();
    list_t *localVarContentType = NULL;
    char      *localVarBodyParameters = NULL;

    // create the path
    long sizeOfPath = strlen("/category")+1;
    char *localVarPath = malloc(sizeOfPath);
    snprintf(localVarPath, sizeOfPath, "/category");


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
    char *keyQuery_category;
    int valueQuery_category;
    keyValuePair_t *keyPairQuery_category = 0;
    if (category)
    {
    //not string
    keyQuery_category = strdup("category");
    valueQuery_category = category;
    keyPairQuery_category = keyValuePair_create(keyQuery_category, &valueQuery_category);
    list_addElement(localVarQueryParameters,keyPairQuery_category);
    }

    // query parameters
    char *keyQuery_parents;
    int valueQuery_parents;
    keyValuePair_t *keyPairQuery_parents = 0;
    if (parents)
    {
    //not string
    keyQuery_parents = strdup("parents");
    valueQuery_parents = parents;
    keyPairQuery_parents = keyValuePair_create(keyQuery_parents, &valueQuery_parents);
    list_addElement(localVarQueryParameters,keyPairQuery_parents);
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
    cJSON *CategoryAPIlocalVarJSON = cJSON_Parse(apiClient->dataReceived);
    if(!cJSON_IsArray(CategoryAPIlocalVarJSON)) {
        return 0;//nonprimitive container
    }
    list_t *elementToReturn = list_create();
    cJSON *VarJSON;
    cJSON_ArrayForEach(VarJSON, CategoryAPIlocalVarJSON)
    {
        if(!cJSON_IsObject(VarJSON))
        {
           // return 0;
        }
        char *localVarJSONToChar = cJSON_Print(VarJSON);
        list_addElement(elementToReturn , localVarJSONToChar);
    }

    cJSON_Delete( CategoryAPIlocalVarJSON);
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
    free(keyQuery_category);
    keyValuePair_free(keyPairQuery_category);
    free(keyQuery_parents);
    keyValuePair_free(keyPairQuery_parents);
    return elementToReturn;
end:
    return NULL;

}

