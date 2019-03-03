package org.openapitools.api;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import java.util.Set;
import java.util.HashSet;

import org.openapitools.api.impl.CategoryApiServiceImpl;
import org.openapitools.api.impl.ProductApiServiceImpl;

@ApplicationPath("/magicCashew/keepa/1.0.0")
public class RestApplication extends Application {


    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<Class<?>>();
        resources.add(CategoryApiServiceImpl.class);
        resources.add(ProductApiServiceImpl.class);

        return resources;
    }




}