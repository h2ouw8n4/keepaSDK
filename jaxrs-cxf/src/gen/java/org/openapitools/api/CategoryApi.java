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
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Keepa API
 *
 * <p>The Keepa API offers numerous endpoints.  Every request requires your API access key as a parameter. You can find and change your key in the keepa portal. All requests must be issued as a HTTPS GET and accept gzip encoding. If possible, use a Keep-Alive connection.  Multiple requests can be made in parallel to increase throughput.
 *
 */
@Path("/")
@Api(value = "/", description = "")
public interface CategoryApi  {

    /**
     * Returns Amazon category information from Keepa API.
     *
     * Retrieve category objects using their node ids and (optional) their parent tree.
     *
     */
    @GET
    @Path("/category")
    @Produces({ "application/json" })
    @ApiOperation(value = "Returns Amazon category information from Keepa API.", tags={ "category" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = Category.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "bad input parameter") })
    public List<Category> category(@QueryParam("key") @NotNull  String key, @QueryParam("domain") @NotNull  Integer domain, @QueryParam("category") @NotNull  Integer category, @QueryParam("parents") @NotNull  Integer parents);
}

