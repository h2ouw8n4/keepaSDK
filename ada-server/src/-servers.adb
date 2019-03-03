--  Keepa API
--  The Keepa API offers numerous endpoints.  Every request requires your API access key as a parameter. You can find and change your key in the keepa portal. All requests must be issued as a HTTPS GET and accept gzip encoding. If possible, use a Keep_Alive connection.  Multiple requests can be made in parallel to increase throughput.
--  ------------ EDIT NOTE ------------
--  This file was generated with openapi-generator.  You can modify it to implement
--  the server.  After you modify this file, you should add the following line
--  to the .openapi-generator-ignore file:
--
--  src/-servers.adb
--
--  Then, you can drop this edit note comment.
--  ------------ EDIT NOTE ------------
package body .Servers is


   --  Returns Amazon category information from Keepa API.
   --  Retrieve category objects using their node ids and (optional) their parent tree.
   overriding
   procedure Category
      (Server : in out Server_Type;
       Key : in Swagger.UString;
       Domain : in Integer;
       Category : in Integer;
       Parents : in Integer;
       Result  : out .Models.CategoryType_Vectors.Vector;
       Context : in out Swagger.Servers.Context_Type) is
   begin
      null;
   end Category;

   --  Retrieve the product for the specified ASIN and domain.
   --  Retrieves the product object for the specified ASIN and domain. If our last update is older than one hour it will be automatically refreshed before delivered to you to ensure you get near to real-time pricing data.  You can request products via either their ASIN (preferred) or via UPC and EAN codes. You can not use both parameters, asin and code, in the same request. Keepa can not track Amazon Fresh and eBooks.
   overriding
   procedure Product
      (Server : in out Server_Type;
       Key : in Swagger.UString;
       Domain : in Integer;
       Asin : in Swagger.Nullable_UString;
       Code : in Swagger.Nullable_UString;
       Result  : out .Models.CategoryType_Vectors.Vector;
       Context : in out Swagger.Servers.Context_Type) is
   begin
      null;
   end Product;

end .Servers;
