package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime
import Category._

case class Category (
  /* Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au) */
  domainId: DomainId,
/* The category node id used by Amazon. Represents the identifier of the category. Also part of the Product object’s categories and rootCategory fields. Always a positive Long value. Note - The id 9223372036854775807 (max signed long value) denotes a blank category with the name “?”. We use this in cases where a product is listed in no or non-existent categories. */
  catId: Integer,
/* The name of the category. */
  name: String,
/* List of all sub categories. null or [] (empty array) if the category has no sub categories. */
  children: List[Integer],
/* The parent category’s Id. Always a positive Long value. If it is 0 the category is a root category and has no parent category. */
  parent: Integer,
/* The highest (root category) sales rank we have observed of a product that is listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon. */
  highestRank: Integer,
/* Number of products that are listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon. */
  productCount: Integer)

object Category {
  import DateTimeCodecs._
  sealed trait DomainId
  case object `1` extends DomainId
  case object `2` extends DomainId
  case object `3` extends DomainId
  case object `4` extends DomainId
  case object `5` extends DomainId
  case object `6` extends DomainId
  case object `7` extends DomainId
  case object `8` extends DomainId
  case object `9` extends DomainId
  case object `10` extends DomainId
  case object `11` extends DomainId
  case object `12` extends DomainId
  case object `13` extends DomainId

  object DomainId {
    def toDomainId(s: String): Option[DomainId] = s match {
      case "`1`" => Some(`1`)
      case "`2`" => Some(`2`)
      case "`3`" => Some(`3`)
      case "`4`" => Some(`4`)
      case "`5`" => Some(`5`)
      case "`6`" => Some(`6`)
      case "`7`" => Some(`7`)
      case "`8`" => Some(`8`)
      case "`9`" => Some(`9`)
      case "`10`" => Some(`10`)
      case "`11`" => Some(`11`)
      case "`12`" => Some(`12`)
      case "`13`" => Some(`13`)
      case _ => None
    }

    def fromDomainId(x: DomainId): String = x match {
      case `1` => "`1`"
      case `2` => "`2`"
      case `3` => "`3`"
      case `4` => "`4`"
      case `5` => "`5`"
      case `6` => "`6`"
      case `7` => "`7`"
      case `8` => "`8`"
      case `9` => "`9`"
      case `10` => "`10`"
      case `11` => "`11`"
      case `12` => "`12`"
      case `13` => "`13`"
    }
  }

  implicit val DomainIdEnumEncoder: EncodeJson[DomainId] =
    EncodeJson[DomainId](is => StringEncodeJson(DomainId.fromDomainId(is)))

  implicit val DomainIdEnumDecoder: DecodeJson[DomainId] =
    DecodeJson.optionDecoder[DomainId](n => n.string.flatMap(jStr => DomainId.toDomainId(jStr)), "DomainId failed to de-serialize")

  implicit val CategoryCodecJson: CodecJson[Category] = CodecJson.derive[Category]
  implicit val CategoryDecoder: EntityDecoder[Category] = jsonOf[Category]
  implicit val CategoryEncoder: EntityEncoder[Category] = jsonEncoderOf[Category]
}
