package org.openapitools.api.impl;

import org.openapitools.api.*;
import org.openapitools.model.Category;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import org.apache.cxf.jaxrs.model.wadl.Description;
import org.apache.cxf.jaxrs.model.wadl.DocTarget;

import org.apache.cxf.jaxrs.ext.multipart.*;

import io.swagger.annotations.Api;

/**
 * Keepa API
 *
 * <p>The Keepa API offers numerous endpoints.  Every request requires your API access key as a parameter. You can find and change your key in the keepa portal. All requests must be issued as a HTTPS GET and accept gzip encoding. If possible, use a Keep-Alive connection.  Multiple requests can be made in parallel to increase throughput.
 *
 */
public class CategoryApiServiceImpl implements CategoryApi {
    /**
     * Returns Amazon category information from Keepa API.
     *
     * Retrieve category objects using their node ids and (optional) their parent tree.
     *
     */
    public List<Category> category(String key, Integer domain, Integer category, Integer parents) {
        // TODO: Implement...
        
        return null;
    }
    
}

