package org.openapitools.api;

import org.openapitools.model.Category;
import org.openapitools.api.CategoryApiService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import io.swagger.annotations.*;
import java.io.InputStream;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import java.util.Map;
import java.util.List;
import javax.validation.constraints.*;
@Path("/category")
@RequestScoped

@Api(description = "the category API")


@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSCXFCDIServerCodegen", date = "2019-03-02T22:58:35.213Z[Etc/UTC]")

public class CategoryApi  {

  @Context SecurityContext securityContext;

  @Inject CategoryApiService delegate;


    @GET
    
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Returns Amazon category information from Keepa API.", notes = "Retrieve category objects using their node ids and (optional) their parent tree.", response = Category.class, responseContainer = "List", tags={ "category" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = Category.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "bad input parameter", response = Void.class) })
    public Response category( @NotNull @ApiParam(value = "Your private API key.",required=true)  @QueryParam("key") String key,  @NotNull @ApiParam(value = "Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)",required=true, allowableValues="1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13")  @QueryParam("domain") Integer domain,  @NotNull @ApiParam(value = "The category node id of the category you want to request. For batch requests a comma separated list of ids (up to 10, the token cost stays the same). Alternatively you can specify the value 0, which will retrieve a list of all root categories.",required=true)  @QueryParam("category") Integer category,  @NotNull @ApiParam(value = "Whether or not to include the category tree for each category. (1 = include, 0 = do not include.)",required=true, allowableValues="0, 1")  @QueryParam("parents") Integer parents) {
        return delegate.category(key, domain, category, parents, securityContext);
    }
}
