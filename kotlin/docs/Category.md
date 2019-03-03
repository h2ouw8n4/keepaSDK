
# Category

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**domainId** | [**inline**](#DomainIdEnum) | Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au) | 
**catId** | **kotlin.Int** | The category node id used by Amazon. Represents the identifier of the category. Also part of the Product object’s categories and rootCategory fields. Always a positive Long value. Note - The id 9223372036854775807 (max signed long value) denotes a blank category with the name “?”. We use this in cases where a product is listed in no or non-existent categories. | 
**name** | **kotlin.String** | The name of the category. | 
**children** | **kotlin.Array&lt;kotlin.Int&gt;** | List of all sub categories. null or [] (empty array) if the category has no sub categories. | 
**parent** | **kotlin.Int** | The parent category’s Id. Always a positive Long value. If it is 0 the category is a root category and has no parent category. | 
**highestRank** | **kotlin.Int** | The highest (root category) sales rank we have observed of a product that is listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon. | 
**productCount** | **kotlin.Int** | Number of products that are listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon. | 


<a name="DomainIdEnum"></a>
## Enum: domainId
Name | Value
---- | -----
domainId | 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13



