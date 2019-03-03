package org.openapitools.api;

import org.openapitools.model.Category;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import io.swagger.annotations.*;

import java.io.InputStream;
import java.util.Map;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/category")
@Api(description = "the category API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2019-03-02T22:58:42.301Z[Etc/UTC]")
public class CategoryApi {

    @GET
    @Produces({ "application/json" })
    @ApiOperation(value = "Returns Amazon category information from Keepa API.", notes = "Retrieve category objects using their node ids and (optional) their parent tree.", response = Category.class, responseContainer = "List", tags={ "category" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = Category.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "bad input parameter", response = Void.class)
    })
    public Response category(@QueryParam("key") @NotNull   @ApiParam("Your private API key.")  String key,@QueryParam("domain") @NotNull   @ApiParam("Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)")  Integer domain,@QueryParam("category") @NotNull   @ApiParam("The category node id of the category you want to request. For batch requests a comma separated list of ids (up to 10, the token cost stays the same). Alternatively you can specify the value 0, which will retrieve a list of all root categories.")  Integer category,@QueryParam("parents") @NotNull   @ApiParam("Whether or not to include the category tree for each category. (1 &#x3D; include, 0 &#x3D; do not include.)")  Integer parents) {
        return Response.ok().entity("magic!").build();
    }
}
