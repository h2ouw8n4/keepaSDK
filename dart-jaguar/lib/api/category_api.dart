import 'package:jaguar_retrofit/annotations/annotations.dart';
import 'package:jaguar_retrofit/jaguar_retrofit.dart';
import 'package:jaguar_serializer/jaguar_serializer.dart';
import 'package:jaguar_serializer/src/repo/repo.dart';
import 'dart:async';

import 'package:openapi/model/category.dart';


part 'category_api.jretro.dart';

@GenApiClient()
class CategoryApi extends _$CategoryApiClient implements ApiClient {
    final Route base;
    final SerializerRepo serializers;
    final Duration timeout;

    CategoryApi({this.base, this.serializers, this.timeout = const Duration(minutes: 2)});

    /// Returns Amazon category information from Keepa API.
    ///
    /// Retrieve category objects using their node ids and (optional) their parent tree.
    @GetReq(path: "/category")
    Future<List<Category>> category(
        
            @QueryParam("key") String key, 
        
            @QueryParam("domain") int domain, 
        
            @QueryParam("category") int category, 
        
            @QueryParam("parents") int parents
        ) {
        return super.category(
        
        key, 
        
        domain, 
        
        category, 
        
        parents

        ).timeout(timeout);
    }


}
