/**
 * Keepa API
 * The Keepa API offers numerous endpoints.  Every request requires your API access key as a parameter. You can find and change your key in the keepa portal. All requests must be issued as a HTTPS GET and accept gzip encoding. If possible, use a Keep-Alive connection.  Multiple requests can be made in parallel to increase throughput.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: info@keepa.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package org.openapitools.client.api;

import org.openapitools.client.ApiInvoker;
import org.openapitools.client.ApiException;
import org.openapitools.client.Pair;

import org.openapitools.client.model.*;

import java.util.*;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.openapitools.client.model.Category;

import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class CategoryApi {
  String basePath = "https://virtserver.swaggerhub.com/magicCashew/keepa/1.0.0";
  ApiInvoker apiInvoker = ApiInvoker.getInstance();

  public void addHeader(String key, String value) {
    getInvoker().addDefaultHeader(key, value);
  }

  public ApiInvoker getInvoker() {
    return apiInvoker;
  }

  public void setBasePath(String basePath) {
    this.basePath = basePath;
  }

  public String getBasePath() {
    return basePath;
  }

  /**
  * Returns Amazon category information from Keepa API.
  * Retrieve category objects using their node ids and (optional) their parent tree.
   * @param key Your private API key.
   * @param domain Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)
   * @param category The category node id of the category you want to request. For batch requests a comma separated list of ids (up to 10, the token cost stays the same). Alternatively you can specify the value 0, which will retrieve a list of all root categories.
   * @param parents Whether or not to include the category tree for each category. (1 &#x3D; include, 0 &#x3D; do not include.)
   * @return List<Category>
  */
  public List<Category> category (String key, Integer domain, Integer category, Integer parents) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
    Object postBody = null;
    // verify the required parameter 'key' is set
    if (key == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'key' when calling category",
        new ApiException(400, "Missing the required parameter 'key' when calling category"));
    }
    // verify the required parameter 'domain' is set
    if (domain == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'domain' when calling category",
        new ApiException(400, "Missing the required parameter 'domain' when calling category"));
    }
    // verify the required parameter 'category' is set
    if (category == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'category' when calling category",
        new ApiException(400, "Missing the required parameter 'category' when calling category"));
    }
    // verify the required parameter 'parents' is set
    if (parents == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'parents' when calling category",
        new ApiException(400, "Missing the required parameter 'parents' when calling category"));
    }

    // create path and map variables
    String path = "/category";

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();
    queryParams.addAll(ApiInvoker.parameterToPairs("", "key", key));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "domain", domain));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "category", category));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "parents", parents));
    String[] contentTypes = {
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
    } else {
      // normal form params
    }

    String[] authNames = new String[] {  };

    try {
      String localVarResponse = apiInvoker.invokeAPI (basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames);
      if (localVarResponse != null) {
         return (List<Category>) ApiInvoker.deserialize(localVarResponse, "array", Category.class);
      } else {
         return null;
      }
    } catch (ApiException ex) {
       throw ex;
    } catch (InterruptedException ex) {
       throw ex;
    } catch (ExecutionException ex) {
      if (ex.getCause() instanceof VolleyError) {
        VolleyError volleyError = (VolleyError)ex.getCause();
        if (volleyError.networkResponse != null) {
          throw new ApiException(volleyError.networkResponse.statusCode, volleyError.getMessage());
        }
      }
      throw ex;
    } catch (TimeoutException ex) {
      throw ex;
    }
  }

      /**
   * Returns Amazon category information from Keepa API.
   * Retrieve category objects using their node ids and (optional) their parent tree.
   * @param key Your private API key.   * @param domain Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)   * @param category The category node id of the category you want to request. For batch requests a comma separated list of ids (up to 10, the token cost stays the same). Alternatively you can specify the value 0, which will retrieve a list of all root categories.   * @param parents Whether or not to include the category tree for each category. (1 &#x3D; include, 0 &#x3D; do not include.)
  */
  public void category (String key, Integer domain, Integer category, Integer parents, final Response.Listener<List<Category>> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

    // verify the required parameter 'key' is set
    if (key == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'key' when calling category",
        new ApiException(400, "Missing the required parameter 'key' when calling category"));
    }
    // verify the required parameter 'domain' is set
    if (domain == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'domain' when calling category",
        new ApiException(400, "Missing the required parameter 'domain' when calling category"));
    }
    // verify the required parameter 'category' is set
    if (category == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'category' when calling category",
        new ApiException(400, "Missing the required parameter 'category' when calling category"));
    }
    // verify the required parameter 'parents' is set
    if (parents == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'parents' when calling category",
        new ApiException(400, "Missing the required parameter 'parents' when calling category"));
    }

    // create path and map variables
    String path = "/category".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.addAll(ApiInvoker.parameterToPairs("", "key", key));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "domain", domain));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "category", category));
    queryParams.addAll(ApiInvoker.parameterToPairs("", "parents", parents));


    String[] contentTypes = {
      
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
    } else {
      // normal form params
          }

    String[] authNames = new String[] {  };

    try {
      apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String localVarResponse) {
            try {
              responseListener.onResponse((List<Category>) ApiInvoker.deserialize(localVarResponse,  "array", Category.class));
            } catch (ApiException exception) {
               errorListener.onErrorResponse(new VolleyError(exception));
            }
          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
            errorListener.onErrorResponse(error);
          }
      });
    } catch (ApiException ex) {
      errorListener.onErrorResponse(new VolleyError(ex));
    }
  }
}