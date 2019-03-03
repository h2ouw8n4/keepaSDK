package org.openapitools.api;

import groovyx.net.http.*
import static groovyx.net.http.ContentType.*
import static groovyx.net.http.Method.*
import org.openapitools.api.ApiUtils

import org.openapitools.model.Category

import java.util.*;

@Mixin(ApiUtils)
class CategoryApi {
    String basePath = "https://virtserver.swaggerhub.com/magicCashew/keepa/1.0.0"
    String versionPath = "/api/v1"

    def category ( String key, Integer domain, Integer category, Integer parents, Closure onSuccess, Closure onFailure)  {
        // create path and map path parameters (TODO)
        String resourcePath = "/category"

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

        // verify required params are set
        if (category == null) {
            throw new RuntimeException("missing required params category")
        }

        // verify required params are set
        if (parents == null) {
            throw new RuntimeException("missing required params parents")
        }

        if (!"null".equals(String.valueOf(key)))
            queryParams.put("key", String.valueOf(key))

        if (!"null".equals(String.valueOf(domain)))
            queryParams.put("domain", String.valueOf(domain))

        if (!"null".equals(String.valueOf(category)))
            queryParams.put("category", String.valueOf(category))

        if (!"null".equals(String.valueOf(parents)))
            queryParams.put("parents", String.valueOf(parents))

        // TODO: form params, body param not yet support

        invokeApi(onSuccess, onFailure, basePath, versionPath, resourcePath, queryParams, headerParams,
                    "GET", "array",
                    Category.class )

    }

}
