# openapi.model.Category

## Load the model package
```dart
import 'package:openapi/api.dart';
```

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**domainId** | **int** | Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au) | [default to null]
**catId** | **int** | The category node id used by Amazon. Represents the identifier of the category. Also part of the Product object’s categories and rootCategory fields. Always a positive Long value. Note - The id 9223372036854775807 (max signed long value) denotes a blank category with the name “?”. We use this in cases where a product is listed in no or non-existent categories. | [default to null]
**name** | **String** | The name of the category. | [default to null]
**children** | **List&lt;int&gt;** | List of all sub categories. null or [] (empty array) if the category has no sub categories. | [default to const []]
**parent** | **int** | The parent category’s Id. Always a positive Long value. If it is 0 the category is a root category and has no parent category. | [default to null]
**highestRank** | **int** | The highest (root category) sales rank we have observed of a product that is listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon. | [default to null]
**productCount** | **int** | Number of products that are listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon. | [default to null]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


