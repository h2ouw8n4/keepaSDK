package org.openapitools.api.factories;

import org.openapitools.api.ProductApiService;
import org.openapitools.api.impl.ProductApiServiceImpl;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", date = "2019-03-02T22:58:36.983Z[Etc/UTC]")
public class ProductApiServiceFactory {
    private final static ProductApiService service = new ProductApiServiceImpl();

    public static ProductApiService getProductApi() {
        return service;
    }
}
