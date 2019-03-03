/*
 * Category.h
 *
 * 
 */

#ifndef _Category_H_
#define _Category_H_


#include <string>
#include <list>
#include "Object.h"

/** \defgroup Models Data Structures for API
 *  Classes containing all the Data Structures needed for calling/returned by API endpoints
 *
 */

namespace Tizen {
namespace ArtikCloud {


/*! \brief 
 *
 *  \ingroup Models
 *
 */

class Category : public Object {
public:
	/*! \brief Constructor.
	 */
	Category();
	Category(char* str);

	/*! \brief Destructor.
	 */
	virtual ~Category();

	/*! \brief Retrieve a string JSON representation of this class.
	 */
	char* toJson();

	/*! \brief Fills in members of this class from JSON string representing it.
	 */
	void fromJson(char* jsonStr);

	/*! \brief Get Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)
	 */
	int getDomainId();

	/*! \brief Set Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)
	 */
	void setDomainId(int  domainId);
	/*! \brief Get The category node id used by Amazon. Represents the identifier of the category. Also part of the Product object’s categories and rootCategory fields. Always a positive Long value. Note - The id 9223372036854775807 (max signed long value) denotes a blank category with the name “?”. We use this in cases where a product is listed in no or non-existent categories.
	 */
	int getCatId();

	/*! \brief Set The category node id used by Amazon. Represents the identifier of the category. Also part of the Product object’s categories and rootCategory fields. Always a positive Long value. Note - The id 9223372036854775807 (max signed long value) denotes a blank category with the name “?”. We use this in cases where a product is listed in no or non-existent categories.
	 */
	void setCatId(int  catId);
	/*! \brief Get The name of the category.
	 */
	std::string getName();

	/*! \brief Set The name of the category.
	 */
	void setName(std::string  name);
	/*! \brief Get List of all sub categories. null or [] (empty array) if the category has no sub categories.
	 */
	std::list<int> getChildren();

	/*! \brief Set List of all sub categories. null or [] (empty array) if the category has no sub categories.
	 */
	void setChildren(std::list <int> children);
	/*! \brief Get The parent category’s Id. Always a positive Long value. If it is 0 the category is a root category and has no parent category.
	 */
	int getParent();

	/*! \brief Set The parent category’s Id. Always a positive Long value. If it is 0 the category is a root category and has no parent category.
	 */
	void setParent(int  parent);
	/*! \brief Get The highest (root category) sales rank we have observed of a product that is listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.
	 */
	int getHighestRank();

	/*! \brief Set The highest (root category) sales rank we have observed of a product that is listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.
	 */
	void setHighestRank(int  highestRank);
	/*! \brief Get Number of products that are listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.
	 */
	int getProductCount();

	/*! \brief Set Number of products that are listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.
	 */
	void setProductCount(int  productCount);

private:
	int domainId;
	int catId;
	std::string name;
	std::list <int>children;
	int parent;
	int highestRank;
	int productCount;
	void __init();
	void __cleanup();

};
}
}

#endif /* _Category_H_ */
