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

public class CategoryApiController extends Controller {

    private final CategoryApiControllerImpInterface imp;
    private final ObjectMapper mapper;
    private final Configuration configuration;

    @Inject
    private CategoryApiController(Configuration configuration, CategoryApiControllerImpInterface imp) {
        this.imp = imp;
        mapper = new ObjectMapper();
        this.configuration = configuration;
    }


    @ApiAction
    public Result category() throws Exception {
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
        String valuecategory = request().getQueryString("category");
        Integer category;
        if (valuecategory != null) {
            category = Integer.parseInt(valuecategory);
        } else {
            throw new IllegalArgumentException("'category' parameter is required");
        }
        String valueparents = request().getQueryString("parents");
        Integer parents;
        if (valueparents != null) {
            parents = Integer.parseInt(valueparents);
        } else {
            throw new IllegalArgumentException("'parents' parameter is required");
        }
        List<Category> obj = imp.category(key, domain, category, parents);
        if (configuration.getBoolean("useOutputBeanValidation")) {
            for (Category curItem : obj) {
                OpenAPIUtils.validate(curItem);
            }
        }
        JsonNode result = mapper.valueToTree(obj);
        return ok(result);
    }
}
