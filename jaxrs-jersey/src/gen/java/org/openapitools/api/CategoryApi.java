package org.openapitools.api;

import org.openapitools.model.*;
import org.openapitools.api.CategoryApiService;
import org.openapitools.api.factories.CategoryApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import org.openapitools.model.Category;

import java.util.Map;
import java.util.List;
import org.openapitools.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/category")


@io.swagger.annotations.Api(description = "the category API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", date = "2019-03-02T22:58:36.983Z[Etc/UTC]")
public class CategoryApi  {
   private final CategoryApiService delegate;

   public CategoryApi(@Context ServletConfig servletContext) {
      CategoryApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("CategoryApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (CategoryApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = CategoryApiServiceFactory.getCategoryApi();
      }

      this.delegate = delegate;
   }

    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns Amazon category information from Keepa API.", notes = "Retrieve category objects using their node ids and (optional) their parent tree.", response = Category.class, responseContainer = "List", tags={ "category", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria", response = Category.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "bad input parameter", response = Void.class) })
    public Response category(@ApiParam(value = "Your private API key.",required=true) @QueryParam("key") String key
,@ApiParam(value = "Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)",required=true, allowableValues="1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13") @QueryParam("domain") Integer domain
,@ApiParam(value = "The category node id of the category you want to request. For batch requests a comma separated list of ids (up to 10, the token cost stays the same). Alternatively you can specify the value 0, which will retrieve a list of all root categories.",required=true) @QueryParam("category") Integer category
,@ApiParam(value = "Whether or not to include the category tree for each category. (1 = include, 0 = do not include.)",required=true, allowableValues="0, 1") @QueryParam("parents") Integer parents
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.category(key,domain,category,parents,securityContext);
    }
}
