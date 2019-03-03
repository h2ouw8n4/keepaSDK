'use strict';

var utils = require('../utils/writer.js');
var Category = require('../service/CategoryService');

module.exports.category = function category (req, res, next) {
  var key = req.swagger.params['key'].value;
  var domain = req.swagger.params['domain'].value;
  var category = req.swagger.params['category'].value;
  var parents = req.swagger.params['parents'].value;
  Category.category(key,domain,category,parents)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};
