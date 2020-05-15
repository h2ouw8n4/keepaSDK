/**
 * Keepa API
 * The Keepa API offers numerous endpoints.  Every request requires your API access key as a parameter. You can find and change your key in the keepa portal. All requests must be issued as a HTTPS GET and accept gzip encoding. If possible, use a Keep-Alive connection.  Multiple requests can be made in parallel to increase throughput.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: info@keepa.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 */


package org.openapitools.server.api

import org.openapitools.server.model.Category

import java.io.File

import org.scalatra.ScalatraServlet
import org.scalatra.swagger._
import org.json4s._
import org.json4s.JsonDSL._
import org.scalatra.json.{ JValueResult, JacksonJsonSupport }
import org.scalatra.servlet.{ FileUploadSupport, MultipartConfig, SizeConstraintExceededException }

import scala.collection.JavaConverters._

class ProductApi(implicit val swagger: Swagger) extends ScalatraServlet
  with FileUploadSupport
  with JacksonJsonSupport
  with SwaggerSupport {
  protected implicit val jsonFormats: Formats = DefaultFormats

  protected val applicationDescription: String = "ProductApi"

  before() {
    contentType = formats("json")
    response.headers += ("Access-Control-Allow-Origin" -> "*")
  }
  

  val productOperation = (apiOperation[List[Category]]("product")
    summary "Retrieve the product for the specified ASIN and domain."
    parameters(queryParam[String]("key").description(""), queryParam[Int]("domain").description(""), queryParam[String]("asin").description("").optional, queryParam[String]("code").description("").optional)
  )

  get("/product", operation(productOperation)) {
            val key = params.getAs[String]("key")

    //println("key: " + key)
            val domain = params.getAs[Int]("domain")

    //println("domain: " + domain)
            val asin = params.getAs[String]("asin")

    //println("asin: " + asin)
            val code = params.getAs[String]("code")

    //println("code: " + code)
  }

}