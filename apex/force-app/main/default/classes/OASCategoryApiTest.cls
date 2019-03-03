@isTest
private class OASCategoryApiTest {
    /**
     * Returns Amazon category information from Keepa API.
     *
     * Retrieve category objects using their node ids and (optional) their parent tree.
     */
    @isTest
    private static void categoryTest() {
        HttpResponse res = new HttpResponse();
        res.setStatusCode(200);
        res.setStatus('OK');
        Test.setMock(HttpCalloutMock.class, new OASResponseMock(res));

        Map<String, Object> params = new Map<String, Object>{
            'key' => 'null',
            'domain' => Integer.getExample(),
            'category' => Integer.getExample(),
            'parents' => Integer.getExample()
        };

        OASClient client;
        OASCategoryApi api;
        List<OASCategory> response;
        List<OASCategory> expectedResponse;
        String js = '';

        api = new OASCategoryApi(new OASClient());

        js = JSON.serialize(new List<OASCategory>{OASCategory.getExample()});
        res.setHeader('Content-Type', 'application/json');
        res.setBody(js);
        expectedResponse = new List<OASCategory>{OASCategory.getExample()};
        response = (List<OASCategory>) api.category(params);
        System.assertEquals(expectedResponse, response);
    }
}