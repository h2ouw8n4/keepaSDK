#ifndef _ProductManager_H_
#define _ProductManager_H_

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
/** \addtogroup Product Product
 * \ingroup Operations
 *  @{
 */
class ProductManager {
public:
	ProductManager();
	virtual ~ProductManager();

/*! \brief Retrieve the product for the specified ASIN and domain.. *Synchronous*
 *
 * Retrieves the product object for the specified ASIN and domain. If our last update is older than one hour it will be automatically refreshed before delivered to you to ensure you get near to real-time pricing data.  You can request products via either their ASIN (preferred) or via UPC and EAN codes. You can not use both parameters, asin and code, in the same request. Keepa can not track Amazon Fresh and eBooks.
 * \param key Your private API key. *Required*
 * \param domain Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au) *Required*
 * \param asin The ASIN of the product you want to request. For batch requests a comma separated list of ASINs (up to one hundred).
 * \param code The product code of the product you want to request. We currently allow UPC, EAN and ISBN-13 codes. For batch requests a comma separated list of codes (up to one hundred). Multiple ASINs can have the same product code, so requesting a product code can return multiple products.
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool productSync(char * accessToken,
	std::string key, int domain, std::string asin, std::string code, 
	void(* handler)(std::list<Category>, Error, void* )
	, void* userData);

/*! \brief Retrieve the product for the specified ASIN and domain.. *Asynchronous*
 *
 * Retrieves the product object for the specified ASIN and domain. If our last update is older than one hour it will be automatically refreshed before delivered to you to ensure you get near to real-time pricing data.  You can request products via either their ASIN (preferred) or via UPC and EAN codes. You can not use both parameters, asin and code, in the same request. Keepa can not track Amazon Fresh and eBooks.
 * \param key Your private API key. *Required*
 * \param domain Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au) *Required*
 * \param asin The ASIN of the product you want to request. For batch requests a comma separated list of ASINs (up to one hundred).
 * \param code The product code of the product you want to request. We currently allow UPC, EAN and ISBN-13 codes. For batch requests a comma separated list of codes (up to one hundred). Multiple ASINs can have the same product code, so requesting a product code can return multiple products.
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool productAsync(char * accessToken,
	std::string key, int domain, std::string asin, std::string code, 
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
#endif /* ProductManager_H_ */
