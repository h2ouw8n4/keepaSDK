# OpenAPI generated server

## Overview
This server was generated by the [OpenAPI Generator](https://openapi-generator.tech) project. By using the
[OpenAPI-Spec](https://openapis.org) from a remote server, you can easily generate a server stub.  This
is an example of building a OpenAPI-enabled aiohtpp server.

This example uses the [Connexion](https://github.com/zalando/connexion) library on top of aiohtpp.

## Requirements
Python 3.5.2+

## Usage
To run the server, please execute the following from the root directory:

```
pip3 install -r requirements.txt
python3 -m openapi_server
```

and open your browser to here:

```
http://localhost:8080/magicCashew/keepa/1.0.0/ui/
```

Your OpenAPI definition lives here:

```
http://localhost:8080/magicCashew/keepa/1.0.0/openapi.json
```

To launch the integration tests, use pytest:
```
sudo pip install -r test-requirements.txt
pytest
```

## Prevent file overriding

After first generation, add edited files to _.openapi-generator-ignore_ to prevent generator to overwrite them. Typically:
```
server/controllers/*
test/*
*.txt
```