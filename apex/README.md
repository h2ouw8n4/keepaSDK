# Keepa API API Client

The Keepa API offers numerous endpoints.  Every request requires your API access key as a parameter. You can find and change your key in the keepa portal. All requests must be issued as a HTTPS GET and accept gzip encoding. If possible, use a Keep-Alive connection.  Multiple requests can be made in parallel to increase throughput.

## Requirements

- [Salesforce DX](https://www.salesforce.com/products/platform/products/salesforce-dx/)


If everything is set correctly:

- Running `sfdx version` in a command prompt should output something like:

  ```bash
  sfdx-cli/5.7.5-05549de (darwin-amd64) go1.7.5 sfdxstable
  ```


## Installation

1. Copy the output into your Salesforce DX folder - or alternatively deploy the output directly into the workspace.
2. Deploy the code via Salesforce DX to your Scratch Org

   ```bash
   $ sfdx force:source:push
   ```
3. If the API needs authentication update the Named Credential in Setup.
4. Run your Apex tests using

    ```bash
    $ sfdx sfdx force:apex:test:run
    ```
5. Retrieve the job id from the console and check the test results.

  ```bash
  $ sfdx force:apex:test:report -i theJobId
  ```


## Getting Started

Please follow the [installation](#installation) instruction and execute the following Apex code:

```java
OASCategoryApi api = new OASCategoryApi();

Map<String, Object> params = new Map<String, Object>{
    'key' => 'null',
    'domain' => Integer.getExample(),
    'category' => Integer.getExample(),
    'parents' => Integer.getExample()
};

try {
    // cross your fingers
    List<OASCategory> result = api.category(params);
    System.debug(result);
} catch (OAS.ApiException e) {
    // ...handle your exceptions
}
```

## Documentation for API Endpoints

All URIs are relative to *https://virtserver.swaggerhub.com/magicCashew/keepa/1.0.0*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*OASCategoryApi* | [**category**](OASCategoryApi.md#category) | **GET** /category | Returns Amazon category information from Keepa API.
*OASProductApi* | [**product**](OASProductApi.md#product) | **GET** /product | Retrieve the product for the specified ASIN and domain.


## Documentation for Models

 - [OASCategory](OASCategory.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Author

info@keepa.com

