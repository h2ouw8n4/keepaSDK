package org.openapitools.server.api.verticle;

import org.openapitools.server.api.model.Category;
import org.openapitools.server.api.MainApiException;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

import java.util.List;
import java.util.Map;

public interface CategoryApi  {
    //category
    void category(String key, Integer domain, Integer category, Integer parents, Handler<AsyncResult<List<Category>>> handler);
    
}
