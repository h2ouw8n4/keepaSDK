package org.openapitools.api.factories;

import org.openapitools.api.ProductApiService;
import org.openapitools.api.impl.ProductApiServiceImpl;

public class ProductApiServiceFactory {
    private final static ProductApiService service = new ProductApiServiceImpl();

    public static ProductApiService getProductApi() {
        return service;
    }
}
