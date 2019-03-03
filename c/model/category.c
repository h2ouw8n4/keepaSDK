#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "category.h"


char* domainIdcategory_ToString(domainId_e domainId){
    char *domainIdArray[] =  { "N1","N2","N3","N4","N5","N6","N7","N8","N9","N10","N11","N12","N13" };
    return domainIdArray[domainId];

}

domainId_e domainIdcategory_FromString(char* domainId){
    int stringToReturn = 0;
    char *domainIdArray[] =  { "N1","N2","N3","N4","N5","N6","N7","N8","N9","N10","N11","N12","N13" };
    size_t sizeofArray = sizeof(domainIdArray) / sizeof(domainIdArray[0]);
    while(stringToReturn < sizeofArray) {
        if(strcmp(domainId, domainIdArray[stringToReturn]) == 0) {
            return stringToReturn;
        }
        stringToReturn++;
    }
}

category_t *category_create(
    int domainId,
    int catId,
    char *name,
    list_t *children,
    int parent,
    int highestRank,
    int productCount
    ) {
	category_t *category = malloc(sizeof(category_t));
	category->domainId = domainId;
	category->catId = catId;
	category->name = name;
	category->children = children;
	category->parent = parent;
	category->highestRank = highestRank;
	category->productCount = productCount;

	return category;
}


void category_free(category_t *category) {
    listEntry_t *listEntry;
    free(category->name);
	list_ForEach(listEntry, category->children) {
		free(listEntry->data);
	}
	list_free(category->children);

	free(category);
}

cJSON *category_convertToJSON(category_t *category) {
	cJSON *item = cJSON_CreateObject();
	// category->domainId
    if(cJSON_AddNumberToObject(item, "domainId", category->domainId) == NULL) {
    goto fail; //Numeric
    }

	// category->catId
    if(cJSON_AddNumberToObject(item, "catId", category->catId) == NULL) {
    goto fail; //Numeric
    }

	// category->name
    if(cJSON_AddStringToObject(item, "name", category->name) == NULL) {
    goto fail; //String
    }

	// category->children
	cJSON *children = cJSON_AddArrayToObject(item, "children");
	if(children == NULL) {
		goto fail; //primitive container
	}

	listEntry_t *childrenListEntry;
    list_ForEach(childrenListEntry, category->children) {
        if(cJSON_AddNumberToObject(children, "", *(double *)childrenListEntry->data) == NULL)
        {
            goto fail;
        }
    }

	// category->parent
    if(cJSON_AddNumberToObject(item, "parent", category->parent) == NULL) {
    goto fail; //Numeric
    }

	// category->highestRank
    if(cJSON_AddNumberToObject(item, "highestRank", category->highestRank) == NULL) {
    goto fail; //Numeric
    }

	// category->productCount
    if(cJSON_AddNumberToObject(item, "productCount", category->productCount) == NULL) {
    goto fail; //Numeric
    }

	return item;
fail:
	cJSON_Delete(item);
	return NULL;
}

category_t *category_parseFromJSON(char *jsonString){

    category_t *category = NULL;
    cJSON *categoryJSON = cJSON_Parse(jsonString);
    if(categoryJSON == NULL){
        const char *error_ptr = cJSON_GetErrorPtr();
        if (error_ptr != NULL) {
            fprintf(stderr, "Error Before: %s\n", error_ptr);
            goto end;
        }
    }

    // category->domainId
    cJSON *domainId = cJSON_GetObjectItemCaseSensitive(categoryJSON, "domainId");
    if(!cJSON_IsNumber(domainId))
    {
    goto end; //Numeric
    }

    // category->catId
    cJSON *catId = cJSON_GetObjectItemCaseSensitive(categoryJSON, "catId");
    if(!cJSON_IsNumber(catId))
    {
    goto end; //Numeric
    }

    // category->name
    cJSON *name = cJSON_GetObjectItemCaseSensitive(categoryJSON, "name");
    if(!cJSON_IsString(name) || (name->valuestring == NULL)){
    goto end; //String
    }

    // category->children
    cJSON *children;
    cJSON *childrenJSON = cJSON_GetObjectItemCaseSensitive(categoryJSON, "children");
    if(!cJSON_IsArray(childrenJSON)) {
        goto end;//primitive container
    }
    list_t *childrenList = list_create();

    cJSON_ArrayForEach(children, childrenJSON)
    {
        if(!cJSON_IsNumber(children))
        {
            goto end;
        }
        list_addElement(childrenList , &children->valuedouble);

    }

    // category->parent
    cJSON *parent = cJSON_GetObjectItemCaseSensitive(categoryJSON, "parent");
    if(!cJSON_IsNumber(parent))
    {
    goto end; //Numeric
    }

    // category->highestRank
    cJSON *highestRank = cJSON_GetObjectItemCaseSensitive(categoryJSON, "highestRank");
    if(!cJSON_IsNumber(highestRank))
    {
    goto end; //Numeric
    }

    // category->productCount
    cJSON *productCount = cJSON_GetObjectItemCaseSensitive(categoryJSON, "productCount");
    if(!cJSON_IsNumber(productCount))
    {
    goto end; //Numeric
    }


    category = category_create (
        domainId->valuedouble,
        catId->valuedouble,
        strdup(name->valuestring),
        childrenList,
        parent->valuedouble,
        highestRank->valuedouble,
        productCount->valuedouble
        );
 cJSON_Delete(categoryJSON);
    return category;
end:
    cJSON_Delete(categoryJSON);
    return NULL;

}

