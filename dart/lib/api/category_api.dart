part of openapi.api;



class CategoryApi {
  final ApiClient apiClient;

  CategoryApi([ApiClient apiClient]) : apiClient = apiClient ?? defaultApiClient;

  /// Returns Amazon category information from Keepa API.
  ///
  /// Retrieve category objects using their node ids and (optional) their parent tree.
  Future<List<Category>> category(String key, int domain, int category, int parents) async {
    Object postBody;

    // verify required params are set
    if(key == null) {
     throw new ApiException(400, "Missing required param: key");
    }
    if(domain == null) {
     throw new ApiException(400, "Missing required param: domain");
    }
    if(category == null) {
     throw new ApiException(400, "Missing required param: category");
    }
    if(parents == null) {
     throw new ApiException(400, "Missing required param: parents");
    }

    // create path and map variables
    String path = "/category".replaceAll("{format}","json");

    // query params
    List<QueryParam> queryParams = [];
    Map<String, String> headerParams = {};
    Map<String, String> formParams = {};
      queryParams.addAll(_convertParametersForCollectionFormat("", "key", key));
      queryParams.addAll(_convertParametersForCollectionFormat("", "domain", domain));
      queryParams.addAll(_convertParametersForCollectionFormat("", "category", category));
      queryParams.addAll(_convertParametersForCollectionFormat("", "parents", parents));

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
