#include <glib-object.h>
#include <json-glib/json-glib.h>

#include "CategoryManager.h"
#include "NetClient.h"
#include "Helpers.h"
#include "Error.h"
#include "RequestInfo.h"

using namespace std;
using namespace Tizen::ArtikCloud;


CategoryManager::CategoryManager()
{

}

CategoryManager::~CategoryManager()
{

}

static gboolean __CategoryManagerresponseHandler(gpointer data)
{
	RequestInfo *request = static_cast<RequestInfo*>(data);
	g_thread_join(request->thread);

	// invoke the callback function
	bool retval = request->processor(*(request->p_chunk), *(request->code), request->errormsg, request->userData, request->handler);

	delete request;
	return FALSE;
}

static gpointer __CategoryManagerthreadFunc(gpointer data)
{
	RequestInfo *request = static_cast<RequestInfo*>(data);

	// handle the request
	NetClient::easycurl(request->host, request->path, request->method, request->queryParams,
	request->mBody, request->headerList, request->p_chunk, request->code, request->errormsg);

	request->thread = g_thread_self();
	g_idle_add(__CategoryManagerresponseHandler, static_cast<gpointer>(request));

	return NULL;
}


static bool categoryProcessor(MemoryStruct_s p_chunk, long code, char* errormsg, void* userData,
	void(* voidHandler)())
{
	void(* handler)(std::list<Category>, Error, void* )
	= reinterpret_cast<void(*)(std::list<Category>, Error, void* )> (voidHandler);
	
	JsonNode* pJson;
	char * data = p_chunk.memory;

	std::list<Category> out;
	

	if (code >= 200 && code < 300) {
		Error error(code, string("No Error"));



		pJson = json_from_string(data, NULL);
		JsonArray * jsonarray = json_node_get_array (pJson);
		guint length = json_array_get_length (jsonarray);
		for(guint i = 0; i < length; i++){
			JsonNode* myJson = json_array_get_element (jsonarray, i);
			char * singlenodestr = json_to_string(myJson, false);
			Category singlemodel;
			singlemodel.fromJson(singlenodestr);
			out.push_front(singlemodel);
			g_free(static_cast<gpointer>(singlenodestr));
			json_node_free(myJson);
		}
		json_array_unref (jsonarray);
		json_node_free(pJson);


	} else {
		Error error;
		if (errormsg != NULL) {
			error = Error(code, string(errormsg));
		} else if (p_chunk.memory != NULL) {
			error = Error(code, string(p_chunk.memory));
		} else {
			error = Error(code, string("Unknown Error"));
		}
		 handler(out, error, userData);
		return false;
			}
}

static bool categoryHelper(char * accessToken,
	std::string key, int domain, int category, int parents, 
	void(* handler)(std::list<Category>, Error, void* )
	, void* userData, bool isAsync)
{

	//TODO: maybe delete headerList after its used to free up space?
	struct curl_slist *headerList = NULL;

	
	string accessHeader = "Authorization: Bearer ";
	accessHeader.append(accessToken);
	headerList = curl_slist_append(headerList, accessHeader.c_str());
	headerList = curl_slist_append(headerList, "Content-Type: application/json");

	map <string, string> queryParams;
	string itemAtq;
	

	itemAtq = stringify(&key, "std::string");
	queryParams.insert(pair<string, string>("key", itemAtq));


	itemAtq = stringify(&domain, "int");
	queryParams.insert(pair<string, string>("domain", itemAtq));


	itemAtq = stringify(&category, "int");
	queryParams.insert(pair<string, string>("category", itemAtq));


	itemAtq = stringify(&parents, "int");
	queryParams.insert(pair<string, string>("parents", itemAtq));

	string mBody = "";
	JsonNode* node;
	JsonArray* json_array;

	string url("/category");
	int pos;


	//TODO: free memory of errormsg, memorystruct
	MemoryStruct_s* p_chunk = new MemoryStruct_s();
	long code;
	char* errormsg = NULL;
	string myhttpmethod("GET");

	if(strcmp("PUT", "GET") == 0){
		if(strcmp("", mBody.c_str()) == 0){
			mBody.append("{}");
		}
	}

	if(!isAsync){
		NetClient::easycurl(CategoryManager::getBasePath(), url, myhttpmethod, queryParams,
			mBody, headerList, p_chunk, &code, errormsg);
		bool retval = categoryProcessor(*p_chunk, code, errormsg, userData,reinterpret_cast<void(*)()>(handler));

		curl_slist_free_all(headerList);
		if (p_chunk) {
			if(p_chunk->memory) {
				free(p_chunk->memory);
			}
			delete (p_chunk);
		}
		if (errormsg) {
			free(errormsg);
		}
		return retval;
	} else{
		GThread *thread = NULL;
		RequestInfo *requestInfo = NULL;

		requestInfo = new(nothrow) RequestInfo (CategoryManager::getBasePath(), url, myhttpmethod, queryParams,
			mBody, headerList, p_chunk, &code, errormsg, userData, reinterpret_cast<void(*)()>(handler), categoryProcessor);;
		if(requestInfo == NULL)
			return false;

		thread = g_thread_new(NULL, __CategoryManagerthreadFunc, static_cast<gpointer>(requestInfo));
		return true;
	}
}




bool CategoryManager::categoryAsync(char * accessToken,
	std::string key, int domain, int category, int parents, 
	void(* handler)(std::list<Category>, Error, void* )
	, void* userData)
{
	return categoryHelper(accessToken,
	key, domain, category, parents, 
	handler, userData, true);
}

bool CategoryManager::categorySync(char * accessToken,
	std::string key, int domain, int category, int parents, 
	void(* handler)(std::list<Category>, Error, void* )
	, void* userData)
{
	return categoryHelper(accessToken,
	key, domain, category, parents, 
	handler, userData, false);
}

