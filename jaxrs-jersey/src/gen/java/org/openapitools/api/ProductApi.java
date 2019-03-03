package org.openapitools.api;

import org.openapitools.model.*;
import org.openapitools.api.ProductApiService;
import org.openapitools.api.factories.ProductApiServiceFactory;

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

@Path("/product")


@io.swagger.annotations.Api(description = "the product API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", date = "2019-03-02T22:58:36.983Z[Etc/UTC]")
public class ProductApi  {
   private final ProductApiService delegate;

   public ProductApi(@Context ServletConfig servletContext) {
      ProductApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("ProductApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (ProductApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = ProductApiServiceFactory.getProductApi();
      }

      this.delegate = delegate;
   }

    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve the product for the specified ASIN and domain.", notes = "Retrieves the product object for the specified ASIN and domain. If our last update is older than one hour it will be automatically refreshed before delivered to you to ensure you get near to real-time pricing data.  You can request products via either their ASIN (preferred) or via UPC and EAN codes. You can not use both parameters, asin and code, in the same request. Keepa can not track Amazon Fresh and eBooks.", response = Category.class, responseContainer = "List", tags={ "product", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria", response = Category.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "bad input parameter", response = Void.class) })
    public Response product(@ApiParam(value = "Your private API key.",required=true) @QueryParam("key") String key
,@ApiParam(value = "Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)",required=true, allowableValues="1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13") @QueryParam("domain") Integer domain
,@ApiParam(value = "The ASIN of the product you want to request. For batch requests a comma separated list of ASINs (up to one hundred).") @QueryParam("asin") String asin
,@ApiParam(value = "The product code of the product you want to request. We currently allow UPC, EAN and ISBN-13 codes. For batch requests a comma separated list of codes (up to one hundred). Multiple ASINs can have the same product code, so requesting a product code can return multiple products.") @QueryParam("code") String code
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.product(key,domain,asin,code,securityContext);
    }
}
