import 'package:jaguar_retrofit/annotations/annotations.dart';
import 'package:jaguar_retrofit/jaguar_retrofit.dart';
import 'package:jaguar_serializer/jaguar_serializer.dart';
import 'package:jaguar_serializer/src/repo/repo.dart';
import 'dart:async';

import 'package:openapi/model/category.dart';


part 'product_api.jretro.dart';

@GenApiClient()
class ProductApi extends _$ProductApiClient implements ApiClient {
    final Route base;
    final SerializerRepo serializers;
    final Duration timeout;

    ProductApi({this.base, this.serializers, this.timeout = const Duration(minutes: 2)});

    /// Retrieve the product for the specified ASIN and domain.
    ///
    /// Retrieves the product object for the specified ASIN and domain. If our last update is older than one hour it will be automatically refreshed before delivered to you to ensure you get near to real-time pricing data.  You can request products via either their ASIN (preferred) or via UPC and EAN codes. You can not use both parameters, asin and code, in the same request. Keepa can not track Amazon Fresh and eBooks.
    @GetReq(path: "/product")
    Future<List<Category>> product(
        
            @QueryParam("key") String key, 
        
            @QueryParam("domain") int domain, 
        
            @QueryParam("asin") String asin, 
        
            @QueryParam("code") String code
        ) {
        return super.product(
        
        key, 
        
        domain, 
        
        asin, 
        
        code

        ).timeout(timeout);
    }


}
