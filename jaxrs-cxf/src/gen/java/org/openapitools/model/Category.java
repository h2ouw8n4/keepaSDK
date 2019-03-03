package org.openapitools.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

import io.swagger.annotations.ApiModelProperty;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Category  {
  
@XmlType(name="DomainIdEnum")
@XmlEnum(Integer.class)
public enum DomainIdEnum {

@XmlEnumValue("1") NUMBER_1(Integer.valueOf(1)), @XmlEnumValue("2") NUMBER_2(Integer.valueOf(2)), @XmlEnumValue("3") NUMBER_3(Integer.valueOf(3)), @XmlEnumValue("4") NUMBER_4(Integer.valueOf(4)), @XmlEnumValue("5") NUMBER_5(Integer.valueOf(5)), @XmlEnumValue("6") NUMBER_6(Integer.valueOf(6)), @XmlEnumValue("7") NUMBER_7(Integer.valueOf(7)), @XmlEnumValue("8") NUMBER_8(Integer.valueOf(8)), @XmlEnumValue("9") NUMBER_9(Integer.valueOf(9)), @XmlEnumValue("10") NUMBER_10(Integer.valueOf(10)), @XmlEnumValue("11") NUMBER_11(Integer.valueOf(11)), @XmlEnumValue("12") NUMBER_12(Integer.valueOf(12)), @XmlEnumValue("13") NUMBER_13(Integer.valueOf(13));


    private Integer value;

    DomainIdEnum (Integer v) {
        value = v;
    }

    public Integer value() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static DomainIdEnum fromValue(String v) {
        for (DomainIdEnum b : DomainIdEnum.values()) {
            if (String.valueOf(b.value).equals(v)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + v + "'");
    }
}

  @ApiModelProperty(example = "1", required = true, value = "Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)")
 /**
   * Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)
  **/
  private DomainIdEnum domainId;

  @ApiModelProperty(example = "281052", required = true, value = "The category node id used by Amazon. Represents the identifier of the category. Also part of the Product object’s categories and rootCategory fields. Always a positive Long value. Note - The id 9223372036854775807 (max signed long value) denotes a blank category with the name “?”. We use this in cases where a product is listed in no or non-existent categories.")
 /**
   * The category node id used by Amazon. Represents the identifier of the category. Also part of the Product object’s categories and rootCategory fields. Always a positive Long value. Note - The id 9223372036854775807 (max signed long value) denotes a blank category with the name “?”. We use this in cases where a product is listed in no or non-existent categories.
  **/
  private Integer catId;

  @ApiModelProperty(example = "Digital Cameras", required = true, value = "The name of the category.")
 /**
   * The name of the category.
  **/
  private String name;

  @ApiModelProperty(example = "[3109924011,7242008011,3017941,2476680011,330405011,2476681011,3109925011]", required = true, value = "List of all sub categories. null or [] (empty array) if the category has no sub categories.")
 /**
   * List of all sub categories. null or [] (empty array) if the category has no sub categories.
  **/
  private List<Integer> children = new ArrayList<Integer>();

  @ApiModelProperty(example = "502394", required = true, value = "The parent category’s Id. Always a positive Long value. If it is 0 the category is a root category and has no parent category.")
 /**
   * The parent category’s Id. Always a positive Long value. If it is 0 the category is a root category and has no parent category.
  **/
  private Integer parent;

  @ApiModelProperty(example = "6549", required = true, value = "The highest (root category) sales rank we have observed of a product that is listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.")
 /**
   * The highest (root category) sales rank we have observed of a product that is listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.
  **/
  private Integer highestRank;

  @ApiModelProperty(example = "1522", required = true, value = "Number of products that are listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.")
 /**
   * Number of products that are listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.
  **/
  private Integer productCount;
 /**
   * Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)
   * @return domainId
  **/
  @JsonProperty("domainId")
  @NotNull
  public Integer getDomainId() {
    if (domainId == null) {
      return null;
    }
    return domainId.value();
  }

  public void setDomainId(DomainIdEnum domainId) {
    this.domainId = domainId;
  }

  public Category domainId(DomainIdEnum domainId) {
    this.domainId = domainId;
    return this;
  }

 /**
   * The category node id used by Amazon. Represents the identifier of the category. Also part of the Product object’s categories and rootCategory fields. Always a positive Long value. Note - The id 9223372036854775807 (max signed long value) denotes a blank category with the name “?”. We use this in cases where a product is listed in no or non-existent categories.
   * @return catId
  **/
  @JsonProperty("catId")
  @NotNull
  public Integer getCatId() {
    return catId;
  }

  public void setCatId(Integer catId) {
    this.catId = catId;
  }

  public Category catId(Integer catId) {
    this.catId = catId;
    return this;
  }

 /**
   * The name of the category.
   * @return name
  **/
  @JsonProperty("name")
  @NotNull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Category name(String name) {
    this.name = name;
    return this;
  }

 /**
   * List of all sub categories. null or [] (empty array) if the category has no sub categories.
   * @return children
  **/
  @JsonProperty("children")
  @NotNull
  public List<Integer> getChildren() {
    return children;
  }

  public void setChildren(List<Integer> children) {
    this.children = children;
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
   * The parent category’s Id. Always a positive Long value. If it is 0 the category is a root category and has no parent category.
   * @return parent
  **/
  @JsonProperty("parent")
  @NotNull
  public Integer getParent() {
    return parent;
  }

  public void setParent(Integer parent) {
    this.parent = parent;
  }

  public Category parent(Integer parent) {
    this.parent = parent;
    return this;
  }

 /**
   * The highest (root category) sales rank we have observed of a product that is listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.
   * @return highestRank
  **/
  @JsonProperty("highestRank")
  @NotNull
  public Integer getHighestRank() {
    return highestRank;
  }

  public void setHighestRank(Integer highestRank) {
    this.highestRank = highestRank;
  }

  public Category highestRank(Integer highestRank) {
    this.highestRank = highestRank;
    return this;
  }

 /**
   * Number of products that are listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.
   * @return productCount
  **/
  @JsonProperty("productCount")
  @NotNull
  public Integer getProductCount() {
    return productCount;
  }

  public void setProductCount(Integer productCount) {
    this.productCount = productCount;
  }

  public Category productCount(Integer productCount) {
    this.productCount = productCount;
    return this;
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
  private static String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

