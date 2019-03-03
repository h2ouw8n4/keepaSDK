# openapi-android-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>org.openapitools</groupId>
    <artifactId>openapi-android-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "org.openapitools:openapi-android-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/openapi-android-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import org.openapitools.client.api.CategoryApi;

public class CategoryApiExample {

    public static void main(String[] args) {
        CategoryApi apiInstance = new CategoryApi();
        String key = null; // String | Your private API key.
        Integer domain = null; // Integer | Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)
        Integer category = null; // Integer | The category node id of the category you want to request. For batch requests a comma separated list of ids (up to 10, the token cost stays the same). Alternatively you can specify the value 0, which will retrieve a list of all root categories.
        Integer parents = null; // Integer | Whether or not to include the category tree for each category. (1 = include, 0 = do not include.)
        try {
            List<Category> result = apiInstance.category(key, domain, category, parents);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling CategoryApi#category");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://virtserver.swaggerhub.com/magicCashew/keepa/1.0.0*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*CategoryApi* | [**category**](docs/CategoryApi.md#category) | **GET** /category | Returns Amazon category information from Keepa API.
*ProductApi* | [**product**](docs/ProductApi.md#product) | **GET** /product | Retrieve the product for the specified ASIN and domain.


## Documentation for Models

 - [Category](docs/Category.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

info@keepa.com

