<?php
declare(strict_types=1);

namespace App\DTO;

use Articus\DataTransfer\Annotation as DTA;

/**
 */
class Category
{
    /**
     * Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)
     * @DTA\Data(field="domainId")
     * @DTA\Validator(name="Type", options={"type":"int"})
     * @var int
     */
    public $domain_id;
    /**
     * The category node id used by Amazon. Represents the identifier of the category. Also part of the Product object’s categories and rootCategory fields. Always a positive Long value. Note - The id 9223372036854775807 (max signed long value) denotes a blank category with the name “?”. We use this in cases where a product is listed in no or non-existent categories.
     * @DTA\Data(field="catId")
     * @DTA\Validator(name="Type", options={"type":"int"})
     * @var int
     */
    public $cat_id;
    /**
     * The name of the category.
     * @DTA\Data(field="name")
     * @DTA\Validator(name="Type", options={"type":"string"})
     * @var string
     */
    public $name;
    /**
     * List of all sub categories. null or [] (empty array) if the category has no sub categories.
     * @DTA\Data(field="children")
     * TODO check validator and strategy are correct and can handle container item type
     * @DTA\Validator(name="Collection", options={"validators":{
     *     {"name":"Type", "options":{"type":"int"}}
     * }})
     * @var int[]
     */
    public $children;
    /**
     * The parent category’s Id. Always a positive Long value. If it is 0 the category is a root category and has no parent category.
     * @DTA\Data(field="parent")
     * @DTA\Validator(name="Type", options={"type":"int"})
     * @var int
     */
    public $parent;
    /**
     * The highest (root category) sales rank we have observed of a product that is listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.
     * @DTA\Data(field="highestRank")
     * @DTA\Validator(name="Type", options={"type":"int"})
     * @var int
     */
    public $highest_rank;
    /**
     * Number of products that are listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.
     * @DTA\Data(field="productCount")
     * @DTA\Validator(name="Type", options={"type":"int"})
     * @var int
     */
    public $product_count;
}
