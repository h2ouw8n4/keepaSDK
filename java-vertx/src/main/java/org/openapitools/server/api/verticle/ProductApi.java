package org.openapitools.server.api.verticle;

import org.openapitools.server.api.model.Category;
import org.openapitools.server.api.MainApiException;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

import java.util.List;
import java.util.Map;

public interface ProductApi  {
    //product
    void product(String key, Integer domain, String asin, String code, Handler<AsyncResult<List<Category>>> handler);
    
}
