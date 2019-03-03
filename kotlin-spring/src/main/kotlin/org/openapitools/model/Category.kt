package org.openapitools.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import javax.validation.Valid
import javax.validation.constraints.*

/**
 * 
 * @param domainId Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)
 * @param catId The category node id used by Amazon. Represents the identifier of the category. Also part of the Product object’s categories and rootCategory fields. Always a positive Long value. Note - The id 9223372036854775807 (max signed long value) denotes a blank category with the name “?”. We use this in cases where a product is listed in no or non-existent categories.
 * @param name The name of the category.
 * @param children List of all sub categories. null or [] (empty array) if the category has no sub categories.
 * @param parent The parent category’s Id. Always a positive Long value. If it is 0 the category is a root category and has no parent category.
 * @param highestRank The highest (root category) sales rank we have observed of a product that is listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.
 * @param productCount Number of products that are listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.
 */
data class Category (

        @get:NotNull 
        @JsonProperty("domainId") val domainId: Category.DomainId,

        @get:NotNull 
        @JsonProperty("catId") val catId: Int,

        @get:NotNull 
        @JsonProperty("name") val name: String,

        @get:NotNull 
        @JsonProperty("children") val children: List<Int>,

        @get:NotNull 
        @JsonProperty("parent") val parent: Int,

        @get:NotNull 
        @JsonProperty("highestRank") val highestRank: Int,

        @get:NotNull 
        @JsonProperty("productCount") val productCount: Int
) {

    /**
    * Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)
    * Values: _1,_2,_3,_4,_5,_6,_7,_8,_9,_10,_11,_12,_13
    */
    enum class DomainId(val value: Int) {
    
        @JsonProperty("1") _1("1"),
    
        @JsonProperty("2") _2("2"),
    
        @JsonProperty("3") _3("3"),
    
        @JsonProperty("4") _4("4"),
    
        @JsonProperty("5") _5("5"),
    
        @JsonProperty("6") _6("6"),
    
        @JsonProperty("7") _7("7"),
    
        @JsonProperty("8") _8("8"),
    
        @JsonProperty("9") _9("9"),
    
        @JsonProperty("10") _10("10"),
    
        @JsonProperty("11") _11("11"),
    
        @JsonProperty("12") _12("12"),
    
        @JsonProperty("13") _13("13");
    
    }

}

