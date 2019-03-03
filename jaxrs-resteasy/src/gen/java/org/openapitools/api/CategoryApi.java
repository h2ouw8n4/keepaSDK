package org.openapitools.api;

import org.openapitools.model.*;
import org.openapitools.api.CategoryApiService;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import org.openapitools.model.Category;

import java.util.Map;
import java.util.List;
import org.openapitools.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.inject.Inject;

import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/category")


@io.swagger.annotations.Api(description = "the category API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2019-03-02T22:58:38.857Z[Etc/UTC]")
public class CategoryApi  {

    @Inject CategoryApiService service;

    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns Amazon category information from Keepa API.", notes = "Retrieve category objects using their node ids and (optional) their parent tree.", response = Category.class, responseContainer = "List", tags={ "category", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria", response = Category.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "bad input parameter", response = Void.class) })
    public Response category( @NotNull  @QueryParam("key") String key, @NotNull  @QueryParam("domain") Integer domain, @NotNull  @QueryParam("category") Integer category, @NotNull  @QueryParam("parents") Integer parents,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.category(key,domain,category,parents,securityContext);
    }
}
