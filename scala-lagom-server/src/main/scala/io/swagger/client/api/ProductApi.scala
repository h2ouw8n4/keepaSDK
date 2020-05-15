/**
 * Keepa API
 * The Keepa API offers numerous endpoints.  Every request requires your API access key as a parameter. You can find and change your key in the keepa portal. All requests must be issued as a HTTPS GET and accept gzip encoding. If possible, use a Keep-Alive connection.  Multiple requests can be made in parallel to increase throughput.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: info@keepa.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package io.swagger.client.api

import akka.{Done, NotUsed}
import com.lightbend.lagom.scaladsl.api.transport.Method
import com.lightbend.lagom.scaladsl.api.{Service, ServiceCall}
import play.api.libs.json._
import com.lightbend.lagom.scaladsl.api.deser.PathParamSerializer

import io.swagger.client.model.Category

trait ProductApi extends Service {


  final override def descriptor = {
    import Service._
    named("ProductApi").withCalls(
      restCall(Method.GET, "/product?key&domain&asin&code", product _)
    ).withAutoAcl(true)
  }

      
  /**
    * Retrieve the product for the specified ASIN and domain.
    * Retrieves the product object for the specified ASIN and domain. If our last update is older than one hour it will be automatically refreshed before delivered to you to ensure you get near to real-time pricing data.  You can request products via either their ASIN (preferred) or via UPC and EAN codes. You can not use both parameters, asin and code, in the same request. Keepa can not track Amazon Fresh and eBooks.
    *  
    * @param key Your private API key.  
    * @param domain Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)  
    * @param asin The ASIN of the product you want to request. For batch requests a comma separated list of ASINs (up to one hundred). (optional) 
    * @param code The product code of the product you want to request. We currently allow UPC, EAN and ISBN-13 codes. For batch requests a comma separated list of codes (up to one hundred). Multiple ASINs can have the same product code, so requesting a product code can return multiple products. (optional)
    * @return Seq[Category]
    */
  def product(key:String          ,domain: Option[ProductApiDomainEnum.ProductApiDomainEnum]asin:           Option[String] = None,code:           Option[String] = None): ServiceCall[NotUsed ,Seq[Category]]
  

        object ProductApiDomainEnum extends Enumeration {
        val   1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 = Value     
        type ProductApiDomainEnum = Value
        implicit val format: Format[Value] = Format(Reads.enumNameReads(this), Writes.enumNameWrites[ProductApiDomainEnum.type])
        implicit val pathParamSerializer: PathParamSerializer[ProductApiDomainEnum] = PathParamSerializer.required("ProductApiDomainEnum")(withName)(_.toString)
        }
  }
