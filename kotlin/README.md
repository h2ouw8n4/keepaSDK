# org.openapitools.client - Kotlin client library for Keepa API

## Requires

* Kotlin 1.1.2
* Gradle 3.3

## Build

First, create the gradle wrapper script:

```
gradle wrapper
```

Then, run:

```
./gradlew check assemble
```

This runs all tests and packages the library.

## Features/Implementation Notes

* Supports JSON inputs/outputs, File inputs, and Form inputs.
* Supports collection formats for query parameters: csv, tsv, ssv, pipes.
* Some Kotlin and Java types are fully qualified to avoid conflicts with types defined in OpenAPI definitions.
* Implementation of ApiClient is intended to reduce method counts, specifically to benefit Android targets.

<a name="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *https://virtserver.swaggerhub.com/magicCashew/keepa/1.0.0*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*CategoryApi* | [**category**](docs/CategoryApi.md#category) | **GET** /category | Returns Amazon category information from Keepa API.
*ProductApi* | [**product**](docs/ProductApi.md#product) | **GET** /product | Retrieve the product for the specified ASIN and domain.


<a name="documentation-for-models"></a>
## Documentation for Models

 - [org.openapitools.client.models.Category](docs/Category.md)


<a name="documentation-for-authorization"></a>
## Documentation for Authorization

All endpoints do not require authorization.
