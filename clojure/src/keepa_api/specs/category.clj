(ns keepa-api.specs.category
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def category-data
  {
   (ds/req :domainId) int?
   (ds/req :catId) int?
   (ds/req :name) string?
   (ds/req :children) (s/coll-of int?)
   (ds/req :parent) int?
   (ds/req :highestRank) int?
   (ds/req :productCount) int?
   })

(def category-spec
  (ds/spec
    {:name ::category
     :spec category-data}))
