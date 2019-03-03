package org.openapitools.api

import org.openapitools.model.Category
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.validation.annotation.Validated
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.multipart.MultipartFile
import org.springframework.beans.factory.annotation.Autowired

import javax.validation.Valid
import javax.validation.constraints.*

import kotlin.collections.List
import kotlin.collections.Map

@Controller
@Validated
@RequestMapping("\${api.base-path:/magicCashew/keepa/1.0.0}")
class ProductApiController() {


    @RequestMapping(
            value = ["/product"],
            produces = ["application/json"], 
            method = [RequestMethod.GET])
    fun product(@NotNull  @RequestParam(value = "key", required = true, defaultValue="null") key: String,@NotNull  @RequestParam(value = "domain", required = true, defaultValue="null") domain: Int, @RequestParam(value = "asin", required = false, defaultValue="null") asin: String, @RequestParam(value = "code", required = false, defaultValue="null") code: String): ResponseEntity<List<Category>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }
}
