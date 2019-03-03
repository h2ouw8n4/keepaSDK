import * as api from './api/api';
import * as angular from 'angular';

const apiModule = angular.module('api', [])
.service('CategoryApi', api.CategoryApi)
.service('ProductApi', api.ProductApi)

export default apiModule;
