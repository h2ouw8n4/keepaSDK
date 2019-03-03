'use strict';


/**
 * Returns Amazon category information from Keepa API.
 * Retrieve category objects using their node ids and (optional) their parent tree.
 *
 * key String Your private API key.
 * domain Integer Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)
 * category Integer The category node id of the category you want to request. For batch requests a comma separated list of ids (up to 10, the token cost stays the same). Alternatively you can specify the value 0, which will retrieve a list of all root categories.
 * parents Integer Whether or not to include the category tree for each category. (1 = include, 0 = do not include.)
 * returns List
 **/
exports.category = function(key,domain,category,parents) {
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

