package org.openapitools.api;

import org.openapitools.model.Category;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import org.apache.cxf.jaxrs.ext.multipart.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import io.swagger.jaxrs.PATCH;

/**
 * Keepa API
 *
 * <p>The Keepa API offers numerous endpoints.  Every request requires your API access key as a parameter. You can find and change your key in the keepa portal. All requests must be issued as a HTTPS GET and accept gzip encoding. If possible, use a Keep-Alive connection.  Multiple requests can be made in parallel to increase throughput.
 *
 */
@Path("/")
@Api(value = "/", description = "")
public interface ProductApi  {

    /**
     * Retrieve the product for the specified ASIN and domain.
     *
     * Retrieves the product object for the specified ASIN and domain. If our last update is older than one hour it will be automatically refreshed before delivered to you to ensure you get near to real-time pricing data.  You can request products via either their ASIN (preferred) or via UPC and EAN codes. You can not use both parameters, asin and code, in the same request. Keepa can not track Amazon Fresh and eBooks.
     *
     */
    @GET
    @Path("/product")
    @Produces({ "application/json" })
    @ApiOperation(value = "Retrieve the product for the specified ASIN and domain.", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = Category.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "bad input parameter") })
    public List<Category> product(@QueryParam("key") String key, @QueryParam("domain") Integer domain, @QueryParam("asin") String asin, @QueryParam("code") String code);
}

