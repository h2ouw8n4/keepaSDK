package org.openapitools.server.api.verticle;

import org.openapitools.server.api.model.Category;
import org.openapitools.server.api.MainApiException;

public final class CategoryApiException extends MainApiException {
    public CategoryApiException(int statusCode, String statusMessage) {
        super(statusCode, statusMessage);
    }
    
    public static final CategoryApiException Category_category_400_Exception = new CategoryApiException(400, "bad input parameter");
    

}