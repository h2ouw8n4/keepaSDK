#include <map>
#include <cstdlib>
#include <glib-object.h>
#include <json-glib/json-glib.h>
#include "Helpers.h"


#include "Category.h"

using namespace std;
using namespace Tizen::ArtikCloud;

Category::Category()
{
	//__init();
}

Category::~Category()
{
	//__cleanup();
}

void
Category::__init()
{
	//domainId = int(0);
	//catId = int(0);
	//name = std::string();
	//new std::list()std::list> children;
	//parent = int(0);
	//highestRank = int(0);
	//productCount = int(0);
}

void
Category::__cleanup()
{
	//if(domainId != NULL) {
	//
	//delete domainId;
	//domainId = NULL;
	//}
	//if(catId != NULL) {
	//
	//delete catId;
	//catId = NULL;
	//}
	//if(name != NULL) {
	//
	//delete name;
	//name = NULL;
	//}
	//if(children != NULL) {
	//children.RemoveAll(true);
	//delete children;
	//children = NULL;
	//}
	//if(parent != NULL) {
	//
	//delete parent;
	//parent = NULL;
	//}
	//if(highestRank != NULL) {
	//
	//delete highestRank;
	//highestRank = NULL;
	//}
	//if(productCount != NULL) {
	//
	//delete productCount;
	//productCount = NULL;
	//}
	//
}

void
Category::fromJson(char* jsonStr)
{
	JsonObject *pJsonObject = json_node_get_object(json_from_string(jsonStr,NULL));
	JsonNode *node;
	const gchar *domainIdKey = "domainId";
	node = json_object_get_member(pJsonObject, domainIdKey);
	if (node !=NULL) {
	

		if (isprimitive("int")) {
			jsonToValue(&domainId, node, "int", "");
		} else {
			
		}
	}
	const gchar *catIdKey = "catId";
	node = json_object_get_member(pJsonObject, catIdKey);
	if (node !=NULL) {
	

		if (isprimitive("int")) {
			jsonToValue(&catId, node, "int", "");
		} else {
			
		}
	}
	const gchar *nameKey = "name";
	node = json_object_get_member(pJsonObject, nameKey);
	if (node !=NULL) {
	

		if (isprimitive("std::string")) {
			jsonToValue(&name, node, "std::string", "");
		} else {
			
		}
	}
	const gchar *childrenKey = "children";
	node = json_object_get_member(pJsonObject, childrenKey);
	if (node !=NULL) {
	
		{
			JsonArray* arr = json_node_get_array(node);
			JsonNode*  temp_json;
			list<int> new_list;
			int inst;
			for (guint i=0;i<json_array_get_length(arr);i++) {
				temp_json = json_array_get_element(arr,i);
				if (isprimitive("int")) {
					jsonToValue(&inst, temp_json, "int", "");
				} else {
					
				}
				new_list.push_back(inst);
			}
			children = new_list;
		}
		
	}
	const gchar *parentKey = "parent";
	node = json_object_get_member(pJsonObject, parentKey);
	if (node !=NULL) {
	

		if (isprimitive("int")) {
			jsonToValue(&parent, node, "int", "");
		} else {
			
		}
	}
	const gchar *highestRankKey = "highestRank";
	node = json_object_get_member(pJsonObject, highestRankKey);
	if (node !=NULL) {
	

		if (isprimitive("int")) {
			jsonToValue(&highestRank, node, "int", "");
		} else {
			
		}
	}
	const gchar *productCountKey = "productCount";
	node = json_object_get_member(pJsonObject, productCountKey);
	if (node !=NULL) {
	

		if (isprimitive("int")) {
			jsonToValue(&productCount, node, "int", "");
		} else {
			
		}
	}
}

Category::Category(char* json)
{
	this->fromJson(json);
}

char*
Category::toJson()
{
	JsonObject *pJsonObject = json_object_new();
	JsonNode *node;
	if (isprimitive("int")) {
		int obj = getDomainId();
		node = converttoJson(&obj, "int", "");
	}
	else {
		
	}
	const gchar *domainIdKey = "domainId";
	json_object_set_member(pJsonObject, domainIdKey, node);
	if (isprimitive("int")) {
		int obj = getCatId();
		node = converttoJson(&obj, "int", "");
	}
	else {
		
	}
	const gchar *catIdKey = "catId";
	json_object_set_member(pJsonObject, catIdKey, node);
	if (isprimitive("std::string")) {
		std::string obj = getName();
		node = converttoJson(&obj, "std::string", "");
	}
	else {
		
	}
	const gchar *nameKey = "name";
	json_object_set_member(pJsonObject, nameKey, node);
	if (isprimitive("int")) {
		list<int> new_list = static_cast<list <int> > (getChildren());
		node = converttoJson(&new_list, "int", "array");
	} else {
		node = json_node_alloc();
		list<int> new_list = static_cast<list <int> > (getChildren());
		JsonArray* json_array = json_array_new();
		GError *mygerror;
		
	}


	
	const gchar *childrenKey = "children";
	json_object_set_member(pJsonObject, childrenKey, node);
	if (isprimitive("int")) {
		int obj = getParent();
		node = converttoJson(&obj, "int", "");
	}
	else {
		
	}
	const gchar *parentKey = "parent";
	json_object_set_member(pJsonObject, parentKey, node);
	if (isprimitive("int")) {
		int obj = getHighestRank();
		node = converttoJson(&obj, "int", "");
	}
	else {
		
	}
	const gchar *highestRankKey = "highestRank";
	json_object_set_member(pJsonObject, highestRankKey, node);
	if (isprimitive("int")) {
		int obj = getProductCount();
		node = converttoJson(&obj, "int", "");
	}
	else {
		
	}
	const gchar *productCountKey = "productCount";
	json_object_set_member(pJsonObject, productCountKey, node);
	node = json_node_alloc();
	json_node_init(node, JSON_NODE_OBJECT);
	json_node_take_object(node, pJsonObject);
	char * ret = json_to_string(node, false);
	json_node_free(node);
	return ret;
}

int
Category::getDomainId()
{
	return domainId;
}

void
Category::setDomainId(int  domainId)
{
	this->domainId = domainId;
}

int
Category::getCatId()
{
	return catId;
}

void
Category::setCatId(int  catId)
{
	this->catId = catId;
}

std::string
Category::getName()
{
	return name;
}

void
Category::setName(std::string  name)
{
	this->name = name;
}

std::list<int>
Category::getChildren()
{
	return children;
}

void
Category::setChildren(std::list <int> children)
{
	this->children = children;
}

int
Category::getParent()
{
	return parent;
}

void
Category::setParent(int  parent)
{
	this->parent = parent;
}

int
Category::getHighestRank()
{
	return highestRank;
}

void
Category::setHighestRank(int  highestRank)
{
	this->highestRank = highestRank;
}

int
Category::getProductCount()
{
	return productCount;
}

void
Category::setProductCount(int  productCount)
{
	this->productCount = productCount;
}


