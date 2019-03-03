package controllers;

import apimodels.Category;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import java.io.File;
import openapitools.OpenAPIUtils;
import com.fasterxml.jackson.core.type.TypeReference;

import javax.validation.constraints.*;
import play.Configuration;

import openapitools.OpenAPIUtils.ApiAction;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaPlayFrameworkCodegen", date = "2019-03-02T22:58:28.211Z[Etc/UTC]")

public class ProductApiController extends Controller {

    private final ProductApiControllerImpInterface imp;
    private final ObjectMapper mapper;
    private final Configuration configuration;

    @Inject
    private ProductApiController(Configuration configuration, ProductApiControllerImpInterface imp) {
        this.imp = imp;
        mapper = new ObjectMapper();
        this.configuration = configuration;
    }


    @ApiAction
    public Result product() throws Exception {
        String valuekey = request().getQueryString("key");
        String key;
        if (valuekey != null) {
            key = valuekey;
        } else {
            throw new IllegalArgumentException("'key' parameter is required");
        }
        String valuedomain = request().getQueryString("domain");
        Integer domain;
        if (valuedomain != null) {
            domain = Integer.parseInt(valuedomain);
        } else {
            throw new IllegalArgumentException("'domain' parameter is required");
        }
        String valueasin = request().getQueryString("asin");
        String asin;
        if (valueasin != null) {
            asin = valueasin;
        } else {
            asin = null;
        }
        String valuecode = request().getQueryString("code");
        String code;
        if (valuecode != null) {
            code = valuecode;
        } else {
            code = null;
        }
        List<Category> obj = imp.product(key, domain, asin, code);
        if (configuration.getBoolean("useOutputBeanValidation")) {
            for (Category curItem : obj) {
                OpenAPIUtils.validate(curItem);
            }
        }
        JsonNode result = mapper.valueToTree(obj);
        return ok(result);
    }
}
