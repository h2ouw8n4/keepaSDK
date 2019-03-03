#ifndef _CategoryManager_H_
#define _CategoryManager_H_

#include <string>
#include <cstring>
#include <list>
#include <glib.h>
#include "Category.h"
#include "Error.h"

/** \defgroup Operations API Endpoints
 *  Classes containing all the functions for calling API endpoints
 *
 */

namespace Tizen{
namespace ArtikCloud {
/** \addtogroup Category Category
 * \ingroup Operations
 *  @{
 */
class CategoryManager {
public:
	CategoryManager();
	virtual ~CategoryManager();

/*! \brief Returns Amazon category information from Keepa API.. *Synchronous*
 *
 * Retrieve category objects using their node ids and (optional) their parent tree.
 * \param key Your private API key. *Required*
 * \param domain Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au) *Required*
 * \param category The category node id of the category you want to request. For batch requests a comma separated list of ids (up to 10, the token cost stays the same). Alternatively you can specify the value 0, which will retrieve a list of all root categories. *Required*
 * \param parents Whether or not to include the category tree for each category. (1 = include, 0 = do not include.) *Required*
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool categorySync(char * accessToken,
	std::string key, int domain, int category, int parents, 
	void(* handler)(std::list<Category>, Error, void* )
	, void* userData);

/*! \brief Returns Amazon category information from Keepa API.. *Asynchronous*
 *
 * Retrieve category objects using their node ids and (optional) their parent tree.
 * \param key Your private API key. *Required*
 * \param domain Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au) *Required*
 * \param category The category node id of the category you want to request. For batch requests a comma separated list of ids (up to 10, the token cost stays the same). Alternatively you can specify the value 0, which will retrieve a list of all root categories. *Required*
 * \param parents Whether or not to include the category tree for each category. (1 = include, 0 = do not include.) *Required*
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool categoryAsync(char * accessToken,
	std::string key, int domain, int category, int parents, 
	void(* handler)(std::list<Category>, Error, void* )
	, void* userData);



	static std::string getBasePath()
	{
		return "https://virtserver.swaggerhub.com/magicCashew/keepa/1.0.0";
	}
};
/** @}*/

}
}
#endif /* CategoryManager_H_ */
