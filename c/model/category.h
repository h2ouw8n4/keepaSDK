/*
 * category.h
 *
 * 
 */

#ifndef _category_H_
#define _category_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"


typedef enum  {  N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13 } domainId_e;

char* domainIdcategory_ToString(domainId_e domainId);

domainId_e domainIdcategory_FromString(char* domainId);

typedef struct category_t {
        int domainId; //numeric
        int catId; //numeric
        char *name; //no enum string
        list_t *children; //primitive container
        int parent; //numeric
        int highestRank; //numeric
        int productCount; //numeric

} category_t;

category_t *category_create(
        int domainId,
        int catId,
        char *name,
        list_t *children,
        int parent,
        int highestRank,
        int productCount
);

void category_free(category_t *category);

category_t *category_parseFromJSON(char *jsonString);

cJSON *category_convertToJSON(category_t *category);

#endif /* _category_H_ */

