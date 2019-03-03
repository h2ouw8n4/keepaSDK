package org.openapitools.api;

import groovyx.net.http.*
import static groovyx.net.http.ContentType.*
import static groovyx.net.http.Method.*
import org.openapitools.api.ApiUtils

import org.openapitools.model.Category

import java.util.*;

@Mixin(ApiUtils)
class ProductApi {
    String basePath = "https://virtserver.swaggerhub.com/magicCashew/keepa/1.0.0"
    String versionPath = "/api/v1"

    def product ( String key, Integer domain, String asin, String code, Closure onSuccess, Closure onFailure)  {
        // create path and map path parameters (TODO)
        String resourcePath = "/product"

        // query params
        def queryParams = [:]
        def headerParams = [:]

        // verify required params are set
        if (key == null) {
            throw new RuntimeException("missing required params key")
        }

        // verify required params are set
        if (domain == null) {
            throw new RuntimeException("missing required params domain")
        }

        if (!"null".equals(String.valueOf(key)))
            queryParams.put("key", String.valueOf(key))

        if (!"null".equals(String.valueOf(domain)))
            queryParams.put("domain", String.valueOf(domain))

        if (!"null".equals(String.valueOf(asin)))
            queryParams.put("asin", String.valueOf(asin))

        if (!"null".equals(String.valueOf(code)))
            queryParams.put("code", String.valueOf(code))

        // TODO: form params, body param not yet support

        invokeApi(onSuccess, onFailure, basePath, versionPath, resourcePath, queryParams, headerParams,
                    "GET", "array",
                    Category.class )

    }

}
