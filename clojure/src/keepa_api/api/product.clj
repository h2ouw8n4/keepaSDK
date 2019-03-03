(ns keepa-api.api.product
  (:require [keepa-api.core :refer [call-api check-required-params with-collection-format *api-context*]]
            [clojure.spec.alpha :as s]
            [spec-tools.core :as st]
            [orchestra.core :refer [defn-spec]]
            [keepa-api.specs.category :refer :all]
            )
  (:import (java.io File)))


(defn-spec product-with-http-info any?
  "Retrieve the product for the specified ASIN and domain.
  Retrieves the product object for the specified ASIN and domain. If our last update is older than one hour it will be automatically refreshed before delivered to you to ensure you get near to real-time pricing data.  You can request products via either their ASIN (preferred) or via UPC and EAN codes. You can not use both parameters, asin and code, in the same request. Keepa can not track Amazon Fresh and eBooks."
  ([key string?, domain int?, ] (product-with-http-info key domain nil))
  ([key string?, domain int?, {:keys [asin code]} (s/map-of keyword? any?)]
   (check-required-params key domain)
   (call-api "/product" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"key" key "domain" domain "asin" asin "code" code }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec product (s/coll-of category-spec)
  "Retrieve the product for the specified ASIN and domain.
  Retrieves the product object for the specified ASIN and domain. If our last update is older than one hour it will be automatically refreshed before delivered to you to ensure you get near to real-time pricing data.  You can request products via either their ASIN (preferred) or via UPC and EAN codes. You can not use both parameters, asin and code, in the same request. Keepa can not track Amazon Fresh and eBooks."
  ([key string?, domain int?, ] (product key domain nil))
  ([key string?, domain int?, optional-params any?]
   (let [res (:data (product-with-http-info key domain optional-params))]
     (if (:decode-models *api-context*)
        (st/decode (s/coll-of category-spec) res st/string-transformer)
        res))))


