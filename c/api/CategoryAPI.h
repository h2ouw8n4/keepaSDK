#include <stdlib.h>
#include <stdio.h>
#include "../include/apiClient.h"
#include "../include/list.h"
#include "../external/cJSON.h"
#include "../include/keyValuePair.h"
#include "../model/category.h"


// Returns Amazon category information from Keepa API.
//
// Retrieve category objects using their node ids and (optional) their parent tree.
//
list_t*
CategoryAPI_category(apiClient_t *apiClient,char* key ,int domain ,int category ,int parents );



