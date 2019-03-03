package org.openapitools

// TODO: properly handle custom imports
import java.io._
import java.util.UUID
import java.time._
import com.twitter.finagle.http.exp.Multipart.{FileUpload, InMemoryFileUpload, OnDiskFileUpload}

import org.openapitools.models._

trait DataAccessor {
    // TODO: apiInfo -> apis -> operations = TODO error
    private object TODO extends CommonError("Not implemented") {
        def message = "Not implemented"
    }

        /**
        * 
        * @return A Seq[Category]
        */
        def Category_category(key: String, domain: Int, category: Int, parents: Int): Either[CommonError,Seq[Category]] = Left(TODO)

        /**
        * 
        * @return A Seq[Category]
        */
        def Product_product(key: String, domain: Int, asin: Option[String], code: Option[String]): Either[CommonError,Seq[Category]] = Left(TODO)

}