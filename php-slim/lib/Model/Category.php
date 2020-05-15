<?php
/**
 * Category
 *
 * PHP version 7
 *
 * @package OpenAPIServer\Model
 * @author  OpenAPI Generator team
 * @link    https://github.com/openapitools/openapi-generator
 */

/**
 * NOTE: This class is auto generated by the openapi generator program.
 * https://github.com/openapitools/openapi-generator
 */
namespace OpenAPIServer\Model;

/**
 * Category
 *
 * @package OpenAPIServer\Model
 * @author  OpenAPI Generator team
 * @link    https://github.com/openapitools/openapi-generator
 */
class Category
{
    
    /** @var int $domainId Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)*/
    private $domainId;
    
    /** @var int $catId The category node id used by Amazon. Represents the identifier of the category. Also part of the Product object’s categories and rootCategory fields. Always a positive Long value. Note - The id 9223372036854775807 (max signed long value) denotes a blank category with the name “?”. We use this in cases where a product is listed in no or non-existent categories.*/
    private $catId;
    
    /** @var string $name The name of the category.*/
    private $name;
    
    /** @var int[] $children List of all sub categories. null or [] (empty array) if the category has no sub categories.*/
    private $children;
    
    /** @var int $parent The parent category’s Id. Always a positive Long value. If it is 0 the category is a root category and has no parent category.*/
    private $parent;
    
    /** @var int $highestRank The highest (root category) sales rank we have observed of a product that is listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.*/
    private $highestRank;
    
    /** @var int $productCount Number of products that are listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.*/
    private $productCount;
}