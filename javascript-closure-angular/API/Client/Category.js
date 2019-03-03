goog.provide('API.Client.category');

/**
 * @record
 */
API.Client.Category = function() {}

/**
 * Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)
 * @type {!number}
 * @export
 */
API.Client.Category.prototype.domainId;

/**
 * The category node id used by Amazon. Represents the identifier of the category. Also part of the Product object’s categories and rootCategory fields. Always a positive Long value. Note - The id 9223372036854775807 (max signed long value) denotes a blank category with the name “?”. We use this in cases where a product is listed in no or non-existent categories.
 * @type {!number}
 * @export
 */
API.Client.Category.prototype.catId;

/**
 * The name of the category.
 * @type {!string}
 * @export
 */
API.Client.Category.prototype.name;

/**
 * List of all sub categories. null or [] (empty array) if the category has no sub categories.
 * @type {!Array<!number>}
 * @export
 */
API.Client.Category.prototype.children;

/**
 * The parent category’s Id. Always a positive Long value. If it is 0 the category is a root category and has no parent category.
 * @type {!number}
 * @export
 */
API.Client.Category.prototype.parent;

/**
 * The highest (root category) sales rank we have observed of a product that is listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.
 * @type {!number}
 * @export
 */
API.Client.Category.prototype.highestRank;

/**
 * Number of products that are listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.
 * @type {!number}
 * @export
 */
API.Client.Category.prototype.productCount;

/** @enum {string} */
API.Client.Category.DomainIdEnum = { 
  1: '1',
  2: '2',
  3: '3',
  4: '4',
  5: '5',
  6: '6',
  7: '7',
  8: '8',
  9: '9',
  10: '10',
  11: '11',
  12: '12',
  13: '13',
}
