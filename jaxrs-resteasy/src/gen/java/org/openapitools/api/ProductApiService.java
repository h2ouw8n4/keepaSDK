package org.openapitools.api;

import org.openapitools.api.*;
import org.openapitools.model.*;


import org.openapitools.model.Category;

import java.util.List;
import org.openapitools.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2019-03-02T22:58:38.857Z[Etc/UTC]")
public interface ProductApiService {
      Response product(String key,Integer domain,String asin,String code,SecurityContext securityContext)
      throws NotFoundException;
}
