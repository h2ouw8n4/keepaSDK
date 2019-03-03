part of openapi.api;



class ProductApi {
  final ApiClient apiClient;

  ProductApi([ApiClient apiClient]) : apiClient = apiClient ?? defaultApiClient;

  /// Retrieve the product for the specified ASIN and domain.
  ///
  /// Retrieves the product object for the specified ASIN and domain. If our last update is older than one hour it will be automatically refreshed before delivered to you to ensure you get near to real-time pricing data.  You can request products via either their ASIN (preferred) or via UPC and EAN codes. You can not use both parameters, asin and code, in the same request. Keepa can not track Amazon Fresh and eBooks.
  Future<List<Category>> product(String key, int domain, { String asin, String code }) async {
    Object postBody;

    // verify required params are set
    if(key == null) {
     throw new ApiException(400, "Missing required param: key");
    }
    if(domain == null) {
     throw new ApiException(400, "Missing required param: domain");
    }

    // create path and map variables
    String path = "/product".replaceAll("{format}","json");

    // query params
    List<QueryParam> queryParams = [];
    Map<String, String> headerParams = {};
    Map<String, String> formParams = {};
      queryParams.addAll(_convertParametersForCollectionFormat("", "key", key));
      queryParams.addAll(_convertParametersForCollectionFormat("", "domain", domain));
    if(asin != null) {
      queryParams.addAll(_convertParametersForCollectionFormat("", "asin", asin));
    }
    if(code != null) {
      queryParams.addAll(_convertParametersForCollectionFormat("", "code", code));
    }

    List<String> contentTypes = [];

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";
    List<String> authNames = [];

    if(contentType.startsWith("multipart/form-data")) {
      bool hasFields = false;
      MultipartRequest mp = new MultipartRequest(null, null);
      if(hasFields)
        postBody = mp;
    }
    else {
    }

    var response = await apiClient.invokeAPI(path,
                                             'GET',
                                             queryParams,
                                             postBody,
                                             headerParams,
                                             formParams,
                                             contentType,
                                             authNames);

    if(response.statusCode >= 400) {
      throw new ApiException(response.statusCode, _decodeBodyBytes(response));
    } else if(response.body != null) {
      return (apiClient.deserialize(_decodeBodyBytes(response), 'List<Category>') as List).map((item) => item as Category).toList();
    } else {
      return null;
    }
  }
}
