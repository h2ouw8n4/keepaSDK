import 'package:jaguar_serializer/jaguar_serializer.dart';

part 'category.jser.dart';

class Category {
   /* Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au) */
  @Alias('domainId')
  final int domainId;
  //enum domainIdEnum {  1,  2,  3,  4,  5,  6,  7,  8,  9,  10,  11,  12,  13,  }; /* The category node id used by Amazon. Represents the identifier of the category. Also part of the Product object’s categories and rootCategory fields. Always a positive Long value. Note - The id 9223372036854775807 (max signed long value) denotes a blank category with the name “?”. We use this in cases where a product is listed in no or non-existent categories. */
  @Alias('catId')
  final int catId;
   /* The name of the category. */
  @Alias('name')
  final String name;
   /* List of all sub categories. null or [] (empty array) if the category has no sub categories. */
  @Alias('children')
  final List<int> children;
   /* The parent category’s Id. Always a positive Long value. If it is 0 the category is a root category and has no parent category. */
  @Alias('parent')
  final int parent;
   /* The highest (root category) sales rank we have observed of a product that is listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon. */
  @Alias('highestRank')
  final int highestRank;
   /* Number of products that are listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon. */
  @Alias('productCount')
  final int productCount;
  

  Category(
      

{
    
     this.domainId = null,  
     this.catId = null,  
     this.name = null,  
     this.children = const [],  
     this.parent = null,  
     this.highestRank = null,  
     this.productCount = null 
    }
  );

  @override
  String toString() {
    return 'Category[domainId=$domainId, catId=$catId, name=$name, children=$children, parent=$parent, highestRank=$highestRank, productCount=$productCount, ]';
  }
}

@GenSerializer(nullableFields: true)
class CategorySerializer extends Serializer<Category> with _$CategorySerializer {

}
