(defproject keepa-api "1.0.0"
  :description "The Keepa API offers numerous endpoints.  Every request requires your API access key as a parameter. You can find and change your key in the keepa portal. All requests must be issued as a HTTPS GET and accept gzip encoding. If possible, use a Keep-Alive connection.  Multiple requests can be made in parallel to increase throughput."
  :url "https://keepa.com/#!api"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [metosin/spec-tools "0.7.0"]
                 [clj-http "3.8.0"]
                 [orchestra "2017.11.12-1"]
                 [cheshire "5.8.0"]])