
package org.openapitools.client.model


case class Category (
    /* Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au) */
    _domainId: Integer,
    /* The category node id used by Amazon. Represents the identifier of the category. Also part of the Product object’s categories and rootCategory fields. Always a positive Long value. Note - The id 9223372036854775807 (max signed long value) denotes a blank category with the name “?”. We use this in cases where a product is listed in no or non-existent categories. */
    _catId: Integer,
    /* The name of the category. */
    _name: String,
    /* List of all sub categories. null or [] (empty array) if the category has no sub categories. */
    _children: List[Integer],
    /* The parent category’s Id. Always a positive Long value. If it is 0 the category is a root category and has no parent category. */
    _parent: Integer,
    /* The highest (root category) sales rank we have observed of a product that is listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon. */
    _highestRank: Integer,
    /* Number of products that are listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon. */
    _productCount: Integer
)
object Category {
    def toStringBody(var_domainId: Object, var_catId: Object, var_name: Object, var_children: Object, var_parent: Object, var_highestRank: Object, var_productCount: Object) =
        s"""
        | {
        | "domainId":$var_domainId,"catId":$var_catId,"name":$var_name,"children":$var_children,"parent":$var_parent,"highestRank":$var_highestRank,"productCount":$var_productCount
        | }
        """.stripMargin
}
