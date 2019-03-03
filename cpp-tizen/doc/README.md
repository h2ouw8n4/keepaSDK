# Documentation for Keepa API 1.0.0 Tizen Client SDK

## How do I get the doc files?
First generate source code by running `openapi-generator`
Then run `doc/generateDocumentation.sh` from the output folder. It will generate all the doc files and put them in the `doc/SDK` directory.
To successfully generate documentation it needs `Doxygen` installed in the path.
*Note* - Before generating the documentation, put the logo of the project as the file `doc/logo.png` before running `doxygen`.


## How do I use this?
This is the structure of the doc folder:

```
.
├── logo.png                  \\Logo of the project
├── Doxyfile                  \\Doxygen config files
├── generateDocumentation.sh  \\Script to run to generate documentation
├── README.md                 \\This file
├── SDK                       \\Documentation for all classes in Keepa API Tizen Client SDK. See ./html/index.html
│   └── html

```

## *tl;dr* run this:

```
doc/generateDocumentation.sh
```

The above SDK folder will be generated. See the index.html inside the SDK folder.


## What's Doxygen?
Doxygen is the de facto standard tool for generating/extracting documentation from annotated/unannotated C++ sources, but it also supports other popular programming languages such as C, Objective-C, C#, PHP, Java, Python, IDL (Corba, Microsoft, and UNO/OpenOffice flavors), Fortran, VHDL, Tcl, and to some extent D.

Check out [Doxygen](https://www.doxygen.org/) for additional information about the Doxygen project.

## I Don't want to run Doxygen. What are the API files for accessing the REST endpoints?
All URIs are relative to https://virtserver.swaggerhub.comhttps://virtserver.swaggerhub.com/magicCashew/keepa/1.0.0

### CategoryManager
Method | HTTP request | Description
------------- | ------------- | -------------
*categorySync* | *GET* /category | Returns Amazon category information from Keepa API..
*categoryASync* | *GET* /category | Returns Amazon category information from Keepa API..

### ProductManager
Method | HTTP request | Description
------------- | ------------- | -------------
*productSync* | *GET* /product | Retrieve the product for the specified ASIN and domain..
*productASync* | *GET* /product | Retrieve the product for the specified ASIN and domain..


## What are the Model files for the data structures/objects?
Class | Description
------------- | -------------
 *Category* | 

