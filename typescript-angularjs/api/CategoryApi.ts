/**
 * Keepa API
 * The Keepa API offers numerous endpoints.  Every request requires your API access key as a parameter. You can find and change your key in the keepa portal. All requests must be issued as a HTTPS GET and accept gzip encoding. If possible, use a Keep-Alive connection.  Multiple requests can be made in parallel to increase throughput.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: info@keepa.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import * as models from '../model/models';

/* tslint:disable:no-unused-variable member-ordering */

export class CategoryApi {
    protected basePath = 'https://virtserver.swaggerhub.com/magicCashew/keepa/1.0.0';
    public defaultHeaders : any = {};

    static $inject: string[] = ['$http', '$httpParamSerializer', 'basePath'];

    constructor(protected $http: ng.IHttpService, protected $httpParamSerializer?: (d: any) => any, basePath?: string) {
        if (basePath !== undefined) {
            this.basePath = basePath;
        }
    }

    /**
     * Retrieve category objects using their node ids and (optional) their parent tree.
     * @summary Returns Amazon category information from Keepa API.
     * @param key Your private API key.
     * @param domain Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)
     * @param category The category node id of the category you want to request. For batch requests a comma separated list of ids (up to 10, the token cost stays the same). Alternatively you can specify the value 0, which will retrieve a list of all root categories.
     * @param parents Whether or not to include the category tree for each category. (1 &#x3D; include, 0 &#x3D; do not include.)
     */
    public category (key: string, domain: models.1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 | 13, category: number, parents: models.0 | 1, extraHttpRequestParams?: any ) : ng.IHttpPromise<Array<models.Category>> {
        const localVarPath = this.basePath + '/category';

        let queryParameters: any = {};
        let headerParams: any = (<any>Object).assign({}, this.defaultHeaders);
        // verify required parameter 'key' is not null or undefined
        if (key === null || key === undefined) {
            throw new Error('Required parameter key was null or undefined when calling category.');
        }

        // verify required parameter 'domain' is not null or undefined
        if (domain === null || domain === undefined) {
            throw new Error('Required parameter domain was null or undefined when calling category.');
        }

        // verify required parameter 'category' is not null or undefined
        if (category === null || category === undefined) {
            throw new Error('Required parameter category was null or undefined when calling category.');
        }

        // verify required parameter 'parents' is not null or undefined
        if (parents === null || parents === undefined) {
            throw new Error('Required parameter parents was null or undefined when calling category.');
        }

        if (key !== undefined) {
            queryParameters['key'] = key;
        }

        if (domain !== undefined) {
            queryParameters['domain'] = domain;
        }

        if (category !== undefined) {
            queryParameters['category'] = category;
        }

        if (parents !== undefined) {
            queryParameters['parents'] = parents;
        }

        let httpRequestParams: ng.IRequestConfig = {
            method: 'GET',
            url: localVarPath,
            params: queryParameters,
            headers: headerParams
        };

        if (extraHttpRequestParams) {
            httpRequestParams = (<any>Object).assign(httpRequestParams, extraHttpRequestParams);
        }

        return this.$http(httpRequestParams);
    }
}