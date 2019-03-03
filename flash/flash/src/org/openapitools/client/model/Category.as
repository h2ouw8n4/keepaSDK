package org.openapitools.client.model {


    [XmlRootNode(name="Category")]
    public class Category {
        /* Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au) */
        [XmlElement(name="domainId")]
        public var domainId: Number = 0;
        /* The category node id used by Amazon. Represents the identifier of the category. Also part of the Product object’s categories and rootCategory fields. Always a positive Long value. Note - The id 9223372036854775807 (max signed long value) denotes a blank category with the name “?”. We use this in cases where a product is listed in no or non-existent categories. */
        [XmlElement(name="catId")]
        public var catId: Number = 0;
        /* The name of the category. */
        [XmlElement(name="name")]
        public var name: String = null;
        /* List of all sub categories. null or [] (empty array) if the category has no sub categories. */
        // This declaration below of _children_obj_class is to force flash compiler to include this class
        private var _children_obj_class: Array = null;
        [XmlElementWrapper(name="children")]
        [XmlElements(name="children", type="Array")]
                public var children: Array = new Array();
        /* The parent category’s Id. Always a positive Long value. If it is 0 the category is a root category and has no parent category. */
        [XmlElement(name="parent")]
        public var parent: Number = 0;
        /* The highest (root category) sales rank we have observed of a product that is listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon. */
        [XmlElement(name="highestRank")]
        public var highestRank: Number = 0;
        /* Number of products that are listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon. */
        [XmlElement(name="productCount")]
        public var productCount: Number = 0;

    public function toString(): String {
        var str: String = "Category: ";
        str += " (domainId: " + domainId + ")";
        str += " (catId: " + catId + ")";
        str += " (name: " + name + ")";
        str += " (children: " + children + ")";
        str += " (parent: " + parent + ")";
        str += " (highestRank: " + highestRank + ")";
        str += " (productCount: " + productCount + ")";
        return str;
    }

}

}
