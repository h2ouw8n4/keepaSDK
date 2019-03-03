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

object CategoryApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def category(host: String, key: String, domain: Integer, category: Integer, parents: Integer)(implicit keyQuery: QueryParam[String], domainQuery: QueryParam[Integer], categoryQuery: QueryParam[Integer], parentsQuery: QueryParam[Integer]): Task[List[Category]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Category]] = jsonOf[List[Category]]

    val path = "/category"
    
    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("key", Some(keyQuery.toParamString(key))), ("domain", Some(domainQuery.toParamString(domain))), ("category", Some(categoryQuery.toParamString(category))), ("parents", Some(parentsQuery.toParamString(parents))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[Category]](req)

    } yield resp
  }
  
}

class HttpServiceCategoryApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def category(key: String, domain: Integer, category: Integer, parents: Integer)(implicit keyQuery: QueryParam[String], domainQuery: QueryParam[Integer], categoryQuery: QueryParam[Integer], parentsQuery: QueryParam[Integer]): Task[List[Category]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[Category]] = jsonOf[List[Category]]

    val path = "/category"
    
    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("key", Some(keyQuery.toParamString(key))), ("domain", Some(domainQuery.toParamString(domain))), ("category", Some(categoryQuery.toParamString(category))), ("parents", Some(parentsQuery.toParamString(parents))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[Category]](req)

    } yield resp
  }
  
}
