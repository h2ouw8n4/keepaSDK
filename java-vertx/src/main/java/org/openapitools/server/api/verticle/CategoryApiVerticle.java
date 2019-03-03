package org.openapitools.server.api.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

import org.openapitools.server.api.model.Category;
import org.openapitools.server.api.MainApiException;

import java.util.List;
import java.util.Map;

public class CategoryApiVerticle extends AbstractVerticle {
    final static Logger LOGGER = LoggerFactory.getLogger(CategoryApiVerticle.class); 
    
    final static String CATEGORY_SERVICE_ID = "category";
    
    final CategoryApi service;

    public CategoryApiVerticle() {
        try {
            Class serviceImplClass = getClass().getClassLoader().loadClass("org.openapitools.server.api.verticle.CategoryApiImpl");
            service = (CategoryApi)serviceImplClass.newInstance();
        } catch (Exception e) {
            logUnexpectedError("CategoryApiVerticle constructor", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void start() throws Exception {
        
        //Consumer for category
        vertx.eventBus().<JsonObject> consumer(CATEGORY_SERVICE_ID).handler(message -> {
            try {
                // Workaround for #allParams section clearing the vendorExtensions map
                String serviceId = "category";
                String keyParam = message.body().getString("key");
                if(keyParam == null) {
                    manageError(message, new MainApiException(400, "key is required"), serviceId);
                    return;
                }
                String key = keyParam;
                String domainParam = message.body().getString("domain");
                if(domainParam == null) {
                    manageError(message, new MainApiException(400, "domain is required"), serviceId);
                    return;
                }
                Integer domain = Json.mapper.readValue(domainParam, Integer.class);
                String categoryParam = message.body().getString("category");
                if(categoryParam == null) {
                    manageError(message, new MainApiException(400, "category is required"), serviceId);
                    return;
                }
                Integer category = Json.mapper.readValue(categoryParam, Integer.class);
                String parentsParam = message.body().getString("parents");
                if(parentsParam == null) {
                    manageError(message, new MainApiException(400, "parents is required"), serviceId);
                    return;
                }
                Integer parents = Json.mapper.readValue(parentsParam, Integer.class);
                service.category(key, domain, category, parents, result -> {
                    if (result.succeeded())
                        message.reply(new JsonArray(Json.encode(result.result())).encodePrettily());
                    else {
                        Throwable cause = result.cause();
                        manageError(message, cause, "category");
                    }
                });
            } catch (Exception e) {
                logUnexpectedError("category", e);
                message.fail(MainApiException.INTERNAL_SERVER_ERROR.getStatusCode(), MainApiException.INTERNAL_SERVER_ERROR.getStatusMessage());
            }
        });
        
    }
    
    private void manageError(Message<JsonObject> message, Throwable cause, String serviceName) {
        int code = MainApiException.INTERNAL_SERVER_ERROR.getStatusCode();
        String statusMessage = MainApiException.INTERNAL_SERVER_ERROR.getStatusMessage();
        if (cause instanceof MainApiException) {
            code = ((MainApiException)cause).getStatusCode();
            statusMessage = ((MainApiException)cause).getStatusMessage();
        } else {
            logUnexpectedError(serviceName, cause); 
        }
            
        message.fail(code, statusMessage);
    }
    
    private void logUnexpectedError(String serviceName, Throwable cause) {
        LOGGER.error("Unexpected error in "+ serviceName, cause);
    }
}
