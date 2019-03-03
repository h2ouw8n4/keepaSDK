'use strict';

var utils = require('../utils/writer.js');
var Product = require('../service/ProductService');

module.exports.product = function product (req, res, next) {
  var key = req.swagger.params['key'].value;
  var domain = req.swagger.params['domain'].value;
  var asin = req.swagger.params['asin'].value;
  var code = req.swagger.params['code'].value;
  Product.product(key,domain,asin,code)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};
