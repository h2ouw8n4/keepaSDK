# KeepaApi.Category

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**domainId** | **Number** | Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au) | 
**catId** | **Number** | The category node id used by Amazon. Represents the identifier of the category. Also part of the Product object’s categories and rootCategory fields. Always a positive Long value. Note - The id 9223372036854775807 (max signed long value) denotes a blank category with the name “?”. We use this in cases where a product is listed in no or non-existent categories. | 
**name** | **String** | The name of the category. | 
**children** | **[Number]** | List of all sub categories. null or [] (empty array) if the category has no sub categories. | 
**parent** | **Number** | The parent category’s Id. Always a positive Long value. If it is 0 the category is a root category and has no parent category. | 
**highestRank** | **Number** | The highest (root category) sales rank we have observed of a product that is listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon. | 
**productCount** | **Number** | Number of products that are listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon. | 


<a name="DomainIdEnum"></a>
## Enum: DomainIdEnum


* `1` (value: `1`)

* `2` (value: `2`)

* `3` (value: `3`)

* `4` (value: `4`)

* `5` (value: `5`)

* `6` (value: `6`)

* `7` (value: `7`)

* `8` (value: `8`)

* `9` (value: `9`)

* `10` (value: `10`)

* `11` (value: `11`)

* `12` (value: `12`)

* `13` (value: `13`)




