@isTest
private class OASProductApiTest {
    /**
     * Retrieve the product for the specified ASIN and domain.
     *
     * Retrieves the product object for the specified ASIN and domain. If our last update is older than one hour it will be automatically refreshed before delivered to you to ensure you get near to real-time pricing data.  You can request products via either their ASIN (preferred) or via UPC and EAN codes. You can not use both parameters, asin and code, in the same request. Keepa can not track Amazon Fresh and eBooks.
     */
    @isTest
    private static void productTest() {
        HttpResponse res = new HttpResponse();
        res.setStatusCode(200);
        res.setStatus('OK');
        Test.setMock(HttpCalloutMock.class, new OASResponseMock(res));

        Map<String, Object> params = new Map<String, Object>{
            'key' => 'null',
            'domain' => Integer.getExample(),
            'asin' => 'null',
            'code' => 'null'
        };

        OASClient client;
        OASProductApi api;
        List<OASCategory> response;
        List<OASCategory> expectedResponse;
        String js = '';

        api = new OASProductApi(new OASClient());

        js = JSON.serialize(new List<OASCategory>{OASCategory.getExample()});
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = new List<OASCategory>{OASCategory.getExample()};
        response = (List<OASCategory>) api.product(params);
        System.assertEquals(expectedResponse, response);
    }
}