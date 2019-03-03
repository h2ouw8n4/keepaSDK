package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Category
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-03-02T22:59:41.539Z[Etc/UTC]")

public class Category   {
  /**
   * Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)
   */
  public enum DomainIdEnum {
    NUMBER_1(1),
    
    NUMBER_2(2),
    
    NUMBER_3(3),
    
    NUMBER_4(4),
    
    NUMBER_5(5),
    
    NUMBER_6(6),
    
    NUMBER_7(7),
    
    NUMBER_8(8),
    
    NUMBER_9(9),
    
    NUMBER_10(10),
    
    NUMBER_11(11),
    
    NUMBER_12(12),
    
    NUMBER_13(13);

    private Integer value;

    DomainIdEnum(Integer value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static DomainIdEnum fromValue(String text) {
      for (DomainIdEnum b : DomainIdEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }
  }

  @JsonProperty("domainId")
  private DomainIdEnum domainId;

  @JsonProperty("catId")
  private Integer catId;

  @JsonProperty("name")
  private String name;

  @JsonProperty("children")
  @Valid
  private List<Integer> children = new ArrayList<>();

  @JsonProperty("parent")
  private Integer parent;

  @JsonProperty("highestRank")
  private Integer highestRank;

  @JsonProperty("productCount")
  private Integer productCount;

  public Category domainId(DomainIdEnum domainId) {
    this.domainId = domainId;
    return this;
  }

  /**
   * Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)
   * @return domainId
  */
  @ApiModelProperty(example = "1", required = true, value = "Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)")
  @NotNull


  public DomainIdEnum getDomainId() {
    return domainId;
  }

  public void setDomainId(DomainIdEnum domainId) {
    this.domainId = domainId;
  }

  public Category catId(Integer catId) {
    this.catId = catId;
    return this;
  }

  /**
   * The category node id used by Amazon. Represents the identifier of the category. Also part of the Product object’s categories and rootCategory fields. Always a positive Long value. Note - The id 9223372036854775807 (max signed long value) denotes a blank category with the name “?”. We use this in cases where a product is listed in no or non-existent categories.
   * @return catId
  */
  @ApiModelProperty(example = "281052", required = true, value = "The category node id used by Amazon. Represents the identifier of the category. Also part of the Product object’s categories and rootCategory fields. Always a positive Long value. Note - The id 9223372036854775807 (max signed long value) denotes a blank category with the name “?”. We use this in cases where a product is listed in no or non-existent categories.")
  @NotNull


  public Integer getCatId() {
    return catId;
  }

  public void setCatId(Integer catId) {
    this.catId = catId;
  }

  public Category name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the category.
   * @return name
  */
  @ApiModelProperty(example = "Digital Cameras", required = true, value = "The name of the category.")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Category children(List<Integer> children) {
    this.children = children;
    return this;
  }

  public Category addChildrenItem(Integer childrenItem) {
    this.children.add(childrenItem);
    return this;
  }

  /**
   * List of all sub categories. null or [] (empty array) if the category has no sub categories.
   * @return children
  */
  @ApiModelProperty(example = "[3109924011,7242008011,3017941,2476680011,330405011,2476681011,3109925011]", required = true, value = "List of all sub categories. null or [] (empty array) if the category has no sub categories.")
  @NotNull


  public List<Integer> getChildren() {
    return children;
  }

  public void setChildren(List<Integer> children) {
    this.children = children;
  }

  public Category parent(Integer parent) {
    this.parent = parent;
    return this;
  }

  /**
   * The parent category’s Id. Always a positive Long value. If it is 0 the category is a root category and has no parent category.
   * @return parent
  */
  @ApiModelProperty(example = "502394", required = true, value = "The parent category’s Id. Always a positive Long value. If it is 0 the category is a root category and has no parent category.")
  @NotNull


  public Integer getParent() {
    return parent;
  }

  public void setParent(Integer parent) {
    this.parent = parent;
  }

  public Category highestRank(Integer highestRank) {
    this.highestRank = highestRank;
    return this;
  }

  /**
   * The highest (root category) sales rank we have observed of a product that is listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.
   * @return highestRank
  */
  @ApiModelProperty(example = "6549", required = true, value = "The highest (root category) sales rank we have observed of a product that is listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.")
  @NotNull


  public Integer getHighestRank() {
    return highestRank;
  }

  public void setHighestRank(Integer highestRank) {
    this.highestRank = highestRank;
  }

  public Category productCount(Integer productCount) {
    this.productCount = productCount;
    return this;
  }

  /**
   * Number of products that are listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.
   * @return productCount
  */
  @ApiModelProperty(example = "1522", required = true, value = "Number of products that are listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.")
  @NotNull


  public Integer getProductCount() {
    return productCount;
  }

  public void setProductCount(Integer productCount) {
    this.productCount = productCount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Category category = (Category) o;
    return Objects.equals(this.domainId, category.domainId) &&
        Objects.equals(this.catId, category.catId) &&
        Objects.equals(this.name, category.name) &&
        Objects.equals(this.children, category.children) &&
        Objects.equals(this.parent, category.parent) &&
        Objects.equals(this.highestRank, category.highestRank) &&
        Objects.equals(this.productCount, category.productCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(domainId, catId, name, children, parent, highestRank, productCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Category {\n");
    
    sb.append("    domainId: ").append(toIndentedString(domainId)).append("\n");
    sb.append("    catId: ").append(toIndentedString(catId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    children: ").append(toIndentedString(children)).append("\n");
    sb.append("    parent: ").append(toIndentedString(parent)).append("\n");
    sb.append("    highestRank: ").append(toIndentedString(highestRank)).append("\n");
    sb.append("    productCount: ").append(toIndentedString(productCount)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

