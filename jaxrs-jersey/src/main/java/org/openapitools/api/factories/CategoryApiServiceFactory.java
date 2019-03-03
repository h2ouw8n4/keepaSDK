package org.openapitools.api.factories;

import org.openapitools.api.CategoryApiService;
import org.openapitools.api.impl.CategoryApiServiceImpl;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", date = "2019-03-02T22:58:36.983Z[Etc/UTC]")
public class CategoryApiServiceFactory {
    private final static CategoryApiService service = new CategoryApiServiceImpl();

    public static CategoryApiService getCategoryApi() {
        return service;
    }
}
