#![allow(unused_imports, unused_qualifications, unused_extern_crates)]
extern crate chrono;
extern crate uuid;


use serde::ser::Serializer;

use std::collections::HashMap;
use models;
use swagger;


#[derive(Debug, Clone, PartialEq, Serialize, Deserialize)]
pub struct Category {
    /// Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)
    // Note: inline enums are not fully supported by openapi-generator
    #[serde(rename = "domainId")]
    pub domain_id: i32,

    /// The category node id used by Amazon. Represents the identifier of the category. Also part of the Product object’s categories and rootCategory fields. Always a positive Long value. Note - The id 9223372036854775807 (max signed long value) denotes a blank category with the name “?”. We use this in cases where a product is listed in no or non-existent categories.
    #[serde(rename = "catId")]
    pub cat_id: i32,

    /// The name of the category.
    #[serde(rename = "name")]
    pub name: String,

    /// List of all sub categories. null or [] (empty array) if the category has no sub categories.
    #[serde(rename = "children")]
    pub children: Vec<i32>,

    /// The parent category’s Id. Always a positive Long value. If it is 0 the category is a root category and has no parent category.
    #[serde(rename = "parent")]
    pub parent: i32,

    /// The highest (root category) sales rank we have observed of a product that is listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.
    #[serde(rename = "highestRank")]
    pub highest_rank: i32,

    /// Number of products that are listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.
    #[serde(rename = "productCount")]
    pub product_count: i32,

}

impl Category {
    pub fn new(domain_id: i32, cat_id: i32, name: String, children: Vec<i32>, parent: i32, highest_rank: i32, product_count: i32, ) -> Category {
        Category {
            domain_id: domain_id,
            cat_id: cat_id,
            name: name,
            children: children,
            parent: parent,
            highest_rank: highest_rank,
            product_count: product_count,
        }
    }
}
