'use strict';


/**
 * Retrieve the product for the specified ASIN and domain.
 * Retrieves the product object for the specified ASIN and domain. If our last update is older than one hour it will be automatically refreshed before delivered to you to ensure you get near to real-time pricing data.  You can request products via either their ASIN (preferred) or via UPC and EAN codes. You can not use both parameters, asin and code, in the same request. Keepa can not track Amazon Fresh and eBooks.
 *
 * key String Your private API key.
 * domain Integer Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)
 * asin String The ASIN of the product you want to request. For batch requests a comma separated list of ASINs (up to one hundred). (optional)
 * code String The product code of the product you want to request. We currently allow UPC, EAN and ISBN-13 codes. For batch requests a comma separated list of codes (up to one hundred). Multiple ASINs can have the same product code, so requesting a product code can return multiple products. (optional)
 * returns List
 **/
exports.product = function(key,domain,asin,code) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "catId" : 281052,
  "parent" : 502394,
  "children" : [ 3109924011, 7242008011, 3017941, 2476680011, 330405011, 2476681011, 3109925011 ],
  "highestRank" : 6549,
  "name" : "Digital Cameras",
  "productCount" : 1522,
  "domainId" : 1
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}

