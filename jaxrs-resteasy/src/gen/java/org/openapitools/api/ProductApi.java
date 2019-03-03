package org.openapitools.api;

import org.openapitools.model.*;
import org.openapitools.api.ProductApiService;

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

@Path("/product")


@io.swagger.annotations.Api(description = "the product API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2019-03-02T22:58:38.857Z[Etc/UTC]")
public class ProductApi  {

    @Inject ProductApiService service;

    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve the product for the specified ASIN and domain.", notes = "Retrieves the product object for the specified ASIN and domain. If our last update is older than one hour it will be automatically refreshed before delivered to you to ensure you get near to real-time pricing data.  You can request products via either their ASIN (preferred) or via UPC and EAN codes. You can not use both parameters, asin and code, in the same request. Keepa can not track Amazon Fresh and eBooks.", response = Category.class, responseContainer = "List", tags={ "product", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria", response = Category.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "bad input parameter", response = Void.class) })
    public Response product( @NotNull  @QueryParam("key") String key, @NotNull  @QueryParam("domain") Integer domain,  @QueryParam("asin") String asin,  @QueryParam("code") String code,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.product(key,domain,asin,code,securityContext);
    }
}
