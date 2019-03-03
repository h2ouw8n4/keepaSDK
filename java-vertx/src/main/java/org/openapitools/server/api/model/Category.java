package org.openapitools.server.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL) 
public class Category   {
  


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

    private String value;

    DomainIdEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return value;
    }
  }

  private DomainIdEnum domainId;
  private Integer catId;
  private String name;
  private List<Integer> children = new ArrayList<>();
  private Integer parent;
  private Integer highestRank;
  private Integer productCount;

  public Category () {

  }

  public Category (DomainIdEnum domainId, Integer catId, String name, List<Integer> children, Integer parent, Integer highestRank, Integer productCount) {
    this.domainId = domainId;
    this.catId = catId;
    this.name = name;
    this.children = children;
    this.parent = parent;
    this.highestRank = highestRank;
    this.productCount = productCount;
  }

    
  @JsonProperty("domainId")
  public DomainIdEnum getDomainId() {
    return domainId;
  }
  public void setDomainId(DomainIdEnum domainId) {
    this.domainId = domainId;
  }

    
  @JsonProperty("catId")
  public Integer getCatId() {
    return catId;
  }
  public void setCatId(Integer catId) {
    this.catId = catId;
  }

    
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

    
  @JsonProperty("children")
  public List<Integer> getChildren() {
    return children;
  }
  public void setChildren(List<Integer> children) {
    this.children = children;
  }

    
  @JsonProperty("parent")
  public Integer getParent() {
    return parent;
  }
  public void setParent(Integer parent) {
    this.parent = parent;
  }

    
  @JsonProperty("highestRank")
  public Integer getHighestRank() {
    return highestRank;
  }
  public void setHighestRank(Integer highestRank) {
    this.highestRank = highestRank;
  }

    
  @JsonProperty("productCount")
  public Integer getProductCount() {
    return productCount;
  }
  public void setProductCount(Integer productCount) {
    this.productCount = productCount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Category category = (Category) o;
    return Objects.equals(domainId, category.domainId) &&
        Objects.equals(catId, category.catId) &&
        Objects.equals(name, category.name) &&
        Objects.equals(children, category.children) &&
        Objects.equals(parent, category.parent) &&
        Objects.equals(highestRank, category.highestRank) &&
        Objects.equals(productCount, category.productCount);
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
