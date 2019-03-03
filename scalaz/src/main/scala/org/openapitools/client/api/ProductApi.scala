package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import java.io.File
import java.net.URLEncoder
import java.util.UUID

import org.http4s._
import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.http4s.client._
import org.http4s.client.blaze.PooledHttp1Client
import org.http4s.headers._

import org.joda.time.DateTime

import scalaz.concurrent.Task

import HelperCodecs._

object ProductApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def product(host: String, key: String, domain: Integer, asin: String, code: String)(implicit keyQuery: QueryParam[String], domainQuery: QueryParam[Integer], asinQuery: QueryParam[String], codeQuery: QueryParam[String]): Task[List[Category]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Category]] = jsonOf[List[Category]]

    val path = "/product"
    
    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("key", Some(keyQuery.toParamString(key))), ("domain", Some(domainQuery.toParamString(domain))), ("asin", Some(asinQuery.toParamString(asin))), ("code", Some(codeQuery.toParamString(code))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[Category]](req)

    } yield resp
  }
  
}

class HttpServiceProductApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def product(key: String, domain: Integer, asin: String, code: String)(implicit keyQuery: QueryParam[String], domainQuery: QueryParam[Integer], asinQuery: QueryParam[String], codeQuery: QueryParam[String]): Task[List[Category]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Category]] = jsonOf[List[Category]]

    val path = "/product"
    
    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("key", Some(keyQuery.toParamString(key))), ("domain", Some(domainQuery.toParamString(domain))), ("asin", Some(asinQuery.toParamString(asin))), ("code", Some(codeQuery.toParamString(code))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[Category]](req)

    } yield resp
  }
  
}
