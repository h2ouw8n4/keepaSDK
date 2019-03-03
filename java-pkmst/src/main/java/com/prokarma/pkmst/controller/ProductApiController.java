package com.prokarma.pkmst.controller;

import com.prokarma.pkmst.model.Category;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
/**
 * Api implemention
 * @author pkmst
 *
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaPKMSTServerCodegen", date = "2019-03-02T22:58:26.278Z[Etc/UTC]")

@Controller
public class ProductApiController implements ProductApi {
    private final ObjectMapper objectMapper;
@Autowired
    public ProductApiController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ResponseEntity<List<Category>> product(@ApiParam(value = "Your private API key.", required = true)  @RequestParam(value = "key", required = true) String key,
        @ApiParam(value = "Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)", required = true, allowableValues = "1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13")  @RequestParam(value = "domain", required = true) Integer domain,
        @ApiParam(value = "The ASIN of the product you want to request. For batch requests a comma separated list of ASINs (up to one hundred).")  @RequestParam(value = "asin", required = false) String asin,
        @ApiParam(value = "The product code of the product you want to request. We currently allow UPC, EAN and ISBN-13 codes. For batch requests a comma separated list of codes (up to one hundred). Multiple ASINs can have the same product code, so requesting a product code can return multiple products.")  @RequestParam(value = "code", required = false) String code,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
        // do some magic!

        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<List<Category>>(objectMapper.readValue("", List.class), HttpStatus.OK);
        }

        return new ResponseEntity<List<Category>>(HttpStatus.OK);
    }

}
