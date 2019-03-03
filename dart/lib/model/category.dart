part of openapi.api;

class Category {
  /* Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au) */
  int domainId = null;
  //enum domainIdEnum {  1,  2,  3,  4,  5,  6,  7,  8,  9,  10,  11,  12,  13,  };{
  /* The category node id used by Amazon. Represents the identifier of the category. Also part of the Product object’s categories and rootCategory fields. Always a positive Long value. Note - The id 9223372036854775807 (max signed long value) denotes a blank category with the name “?”. We use this in cases where a product is listed in no or non-existent categories. */
  int catId = null;
  /* The name of the category. */
  String name = null;
  /* List of all sub categories. null or [] (empty array) if the category has no sub categories. */
  List<int> children = [];
  /* The parent category’s Id. Always a positive Long value. If it is 0 the category is a root category and has no parent category. */
  int parent = null;
  /* The highest (root category) sales rank we have observed of a product that is listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon. */
  int highestRank = null;
  /* Number of products that are listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon. */
  int productCount = null;
  Category();

  @override
  String toString() {
    return 'Category[domainId=$domainId, catId=$catId, name=$name, children=$children, parent=$parent, highestRank=$highestRank, productCount=$productCount, ]';
  }

  Category.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
    if (json['domainId'] == null) {
      domainId = null;
    } else {
          domainId = json['domainId'];
    }
    if (json['catId'] == null) {
      catId = null;
    } else {
          catId = json['catId'];
    }
    if (json['name'] == null) {
      name = null;
    } else {
          name = json['name'];
    }
    if (json['children'] == null) {
      children = null;
    } else {
      children = (json['children'] as List).cast<int>();
    }
    if (json['parent'] == null) {
      parent = null;
    } else {
          parent = json['parent'];
    }
    if (json['highestRank'] == null) {
      highestRank = null;
    } else {
          highestRank = json['highestRank'];
    }
    if (json['productCount'] == null) {
      productCount = null;
    } else {
          productCount = json['productCount'];
    }
  }

  Map<String, dynamic> toJson() {
    return {
      'domainId': domainId,
      'catId': catId,
      'name': name,
      'children': children,
      'parent': parent,
      'highestRank': highestRank,
      'productCount': productCount
    };
  }

  static List<Category> listFromJson(List<dynamic> json) {
    return json == null ? new List<Category>() : json.map((value) => new Category.fromJson(value)).toList();
  }

  static Map<String, Category> mapFromJson(Map<String, dynamic> json) {
    var map = new Map<String, Category>();
    if (json != null && json.length > 0) {
      json.forEach((String key, dynamic value) => map[key] = new Category.fromJson(value));
    }
    return map;
  }
}

