# GraphQL express API server

The Keepa API offers numerous endpoints.  Every request requires your API access key as a parameter. You can find and change your key in the keepa portal. All requests must be issued as a HTTPS GET and accept gzip encoding. If possible, use a Keep-Alive connection.  Multiple requests can be made in parallel to increase throughput.

## Requirements

- node 10+

## Gettings started

    npm install
    npm run start

# TODOs

- use `ID`-type for unique identifiers instead of `Int` (detect UUID)
- add example responses to resolvers.mustache
- support for union types
