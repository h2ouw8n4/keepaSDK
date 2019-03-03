package org.openapitools.models

import io.circe._
import io.finch.circe._
import io.circe.generic.semiauto._
import io.circe.java8.time._
import org.openapitools._
import scala.collection.immutable.Seq

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
case class Category(domainId: Int,
                catId: Int,
                name: String,
                children: Seq[Int],
                parent: Int,
                highestRank: Int,
                productCount: Int
                )

object Category {
    /**
     * Creates the codec for converting Category from and to JSON.
     */
    implicit val decoder: Decoder[Category] = deriveDecoder
    implicit val encoder: ObjectEncoder[Category] = deriveEncoder
}
