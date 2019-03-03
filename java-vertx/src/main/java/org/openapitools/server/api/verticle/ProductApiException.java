package org.openapitools.server.api.verticle;

import org.openapitools.server.api.model.Category;
import org.openapitools.server.api.MainApiException;

public final class ProductApiException extends MainApiException {
    public ProductApiException(int statusCode, String statusMessage) {
        super(statusCode, statusMessage);
    }
    
    public static final ProductApiException Product_product_400_Exception = new ProductApiException(400, "bad input parameter");
    

}