using System;
using System.Text;
using System.Collections;
using System.Collections.Generic;
using System.Runtime.Serialization;
using Newtonsoft.Json;

namespace Org.OpenAPITools.Model {

  /// <summary>
  /// 
  /// </summary>
  [DataContract]
  public class Category {
    /// <summary>
    /// Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)
    /// </summary>
    /// <value>Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)</value>
    [DataMember(Name="domainId", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "domainId")]
    public int? DomainId { get; set; }

    /// <summary>
    /// The category node id used by Amazon. Represents the identifier of the category. Also part of the Product object’s categories and rootCategory fields. Always a positive Long value. Note - The id 9223372036854775807 (max signed long value) denotes a blank category with the name “?”. We use this in cases where a product is listed in no or non-existent categories.
    /// </summary>
    /// <value>The category node id used by Amazon. Represents the identifier of the category. Also part of the Product object’s categories and rootCategory fields. Always a positive Long value. Note - The id 9223372036854775807 (max signed long value) denotes a blank category with the name “?”. We use this in cases where a product is listed in no or non-existent categories.</value>
    [DataMember(Name="catId", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "catId")]
    public int? CatId { get; set; }

    /// <summary>
    /// The name of the category.
    /// </summary>
    /// <value>The name of the category.</value>
    [DataMember(Name="name", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "name")]
    public string Name { get; set; }

    /// <summary>
    /// List of all sub categories. null or [] (empty array) if the category has no sub categories.
    /// </summary>
    /// <value>List of all sub categories. null or [] (empty array) if the category has no sub categories.</value>
    [DataMember(Name="children", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "children")]
    public List<int?> Children { get; set; }

    /// <summary>
    /// The parent category’s Id. Always a positive Long value. If it is 0 the category is a root category and has no parent category.
    /// </summary>
    /// <value>The parent category’s Id. Always a positive Long value. If it is 0 the category is a root category and has no parent category.</value>
    [DataMember(Name="parent", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "parent")]
    public int? Parent { get; set; }

    /// <summary>
    /// The highest (root category) sales rank we have observed of a product that is listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.
    /// </summary>
    /// <value>The highest (root category) sales rank we have observed of a product that is listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.</value>
    [DataMember(Name="highestRank", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "highestRank")]
    public int? HighestRank { get; set; }

    /// <summary>
    /// Number of products that are listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.
    /// </summary>
    /// <value>Number of products that are listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.</value>
    [DataMember(Name="productCount", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "productCount")]
    public int? ProductCount { get; set; }


    /// <summary>
    /// Get the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()  {
      var sb = new StringBuilder();
      sb.Append("class Category {\n");
      sb.Append("  DomainId: ").Append(DomainId).Append("\n");
      sb.Append("  CatId: ").Append(CatId).Append("\n");
      sb.Append("  Name: ").Append(Name).Append("\n");
      sb.Append("  Children: ").Append(Children).Append("\n");
      sb.Append("  Parent: ").Append(Parent).Append("\n");
      sb.Append("  HighestRank: ").Append(HighestRank).Append("\n");
      sb.Append("  ProductCount: ").Append(ProductCount).Append("\n");
      sb.Append("}\n");
      return sb.ToString();
    }

    /// <summary>
    /// Get the JSON string presentation of the object
    /// </summary>
    /// <returns>JSON string presentation of the object</returns>
    public string ToJson() {
      return JsonConvert.SerializeObject(this, Formatting.Indented);
    }

}
}
