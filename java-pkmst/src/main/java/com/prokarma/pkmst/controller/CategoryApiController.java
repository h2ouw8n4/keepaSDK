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
public class CategoryApiController implements CategoryApi {
    private final ObjectMapper objectMapper;
@Autowired
    public CategoryApiController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ResponseEntity<List<Category>> category(@ApiParam(value = "Your private API key.", required = true)  @RequestParam(value = "key", required = true) String key,
        @ApiParam(value = "Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)", required = true, allowableValues = "1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13")  @RequestParam(value = "domain", required = true) Integer domain,
        @ApiParam(value = "The category node id of the category you want to request. For batch requests a comma separated list of ids (up to 10, the token cost stays the same). Alternatively you can specify the value 0, which will retrieve a list of all root categories.", required = true)  @RequestParam(value = "category", required = true) Integer category,
        @ApiParam(value = "Whether or not to include the category tree for each category. (1 = include, 0 = do not include.)", required = true, allowableValues = "0, 1")  @RequestParam(value = "parents", required = true) Integer parents,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
        // do some magic!

        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<List<Category>>(objectMapper.readValue("", List.class), HttpStatus.OK);
        }

        return new ResponseEntity<List<Category>>(HttpStatus.OK);
    }

}
