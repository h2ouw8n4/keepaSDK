using System;
using System.Collections.Generic;
using RestSharp;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Org.OpenAPITools.Api
{
    /// <summary>
    /// Represents a collection of functions to interact with the API endpoints
    /// </summary>
    public interface ICategoryApi
    {
        /// <summary>
        /// Returns Amazon category information from Keepa API. Retrieve category objects using their node ids and (optional) their parent tree.
        /// </summary>
        /// <param name="key">Your private API key.</param>
        /// <param name="domain">Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)</param>
        /// <param name="category">The category node id of the category you want to request. For batch requests a comma separated list of ids (up to 10, the token cost stays the same). Alternatively you can specify the value 0, which will retrieve a list of all root categories.</param>
        /// <param name="parents">Whether or not to include the category tree for each category. (1 &#x3D; include, 0 &#x3D; do not include.)</param>
        /// <returns>List&lt;Category&gt;</returns>
        List<Category> Category (string key, int? domain, int? category, int? parents);
    }
  
    /// <summary>
    /// Represents a collection of functions to interact with the API endpoints
    /// </summary>
    public class CategoryApi : ICategoryApi
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="CategoryApi"/> class.
        /// </summary>
        /// <param name="apiClient"> an instance of ApiClient (optional)</param>
        /// <returns></returns>
        public CategoryApi(ApiClient apiClient = null)
        {
            if (apiClient == null) // use the default one in Configuration
                this.ApiClient = Configuration.DefaultApiClient; 
            else
                this.ApiClient = apiClient;
        }
    
        /// <summary>
        /// Initializes a new instance of the <see cref="CategoryApi"/> class.
        /// </summary>
        /// <returns></returns>
        public CategoryApi(String basePath)
        {
            this.ApiClient = new ApiClient(basePath);
        }
    
        /// <summary>
        /// Sets the base path of the API client.
        /// </summary>
        /// <param name="basePath">The base path</param>
        /// <value>The base path</value>
        public void SetBasePath(String basePath)
        {
            this.ApiClient.BasePath = basePath;
        }
    
        /// <summary>
        /// Gets the base path of the API client.
        /// </summary>
        /// <param name="basePath">The base path</param>
        /// <value>The base path</value>
        public String GetBasePath(String basePath)
        {
            return this.ApiClient.BasePath;
        }
    
        /// <summary>
        /// Gets or sets the API client.
        /// </summary>
        /// <value>An instance of the ApiClient</value>
        public ApiClient ApiClient {get; set;}
    
        /// <summary>
        /// Returns Amazon category information from Keepa API. Retrieve category objects using their node ids and (optional) their parent tree.
        /// </summary>
        /// <param name="key">Your private API key.</param> 
        /// <param name="domain">Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)</param> 
        /// <param name="category">The category node id of the category you want to request. For batch requests a comma separated list of ids (up to 10, the token cost stays the same). Alternatively you can specify the value 0, which will retrieve a list of all root categories.</param> 
        /// <param name="parents">Whether or not to include the category tree for each category. (1 &#x3D; include, 0 &#x3D; do not include.)</param> 
        /// <returns>List&lt;Category&gt;</returns>            
        public List<Category> Category (string key, int? domain, int? category, int? parents)
        {
            
            // verify the required parameter 'key' is set
            if (key == null) throw new ApiException(400, "Missing required parameter 'key' when calling Category");
            
            // verify the required parameter 'domain' is set
            if (domain == null) throw new ApiException(400, "Missing required parameter 'domain' when calling Category");
            
            // verify the required parameter 'category' is set
            if (category == null) throw new ApiException(400, "Missing required parameter 'category' when calling Category");
            
            // verify the required parameter 'parents' is set
            if (parents == null) throw new ApiException(400, "Missing required parameter 'parents' when calling Category");
            
    
            var path = "/category";
            path = path.Replace("{format}", "json");
                
            var queryParams = new Dictionary<String, String>();
            var headerParams = new Dictionary<String, String>();
            var formParams = new Dictionary<String, String>();
            var fileParams = new Dictionary<String, FileParameter>();
            String postBody = null;
    
             if (key != null) queryParams.Add("key", ApiClient.ParameterToString(key)); // query parameter
 if (domain != null) queryParams.Add("domain", ApiClient.ParameterToString(domain)); // query parameter
 if (category != null) queryParams.Add("category", ApiClient.ParameterToString(category)); // query parameter
 if (parents != null) queryParams.Add("parents", ApiClient.ParameterToString(parents)); // query parameter
                                        
            // authentication setting, if any
            String[] authSettings = new String[] {  };
    
            // make the HTTP request
            IRestResponse response = (IRestResponse) ApiClient.CallApi(path, Method.GET, queryParams, postBody, headerParams, formParams, fileParams, authSettings);
    
            if (((int)response.StatusCode) >= 400)
                throw new ApiException ((int)response.StatusCode, "Error calling Category: " + response.Content, response.Content);
            else if (((int)response.StatusCode) == 0)
                throw new ApiException ((int)response.StatusCode, "Error calling Category: " + response.ErrorMessage, response.ErrorMessage);
    
            return (List<Category>) ApiClient.Deserialize(response.Content, typeof(List<Category>), response.Headers);
        }
    
    }
}
