using System;
using Nancy;
using Nancy.ModelBinding;
using System.Collections.Generic;
using Sharpility.Base;
using Org.OpenAPITools.magicCashewkeepa1_0_0.Models;
using Org.OpenAPITools.magicCashewkeepa1_0_0.Utils;
using NodaTime;

namespace Org.OpenAPITools.magicCashewkeepa1_0_0.Modules
{ 
    /// <summary>
    /// Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)
    /// </summary>
    public enum ProductDomainEnum
    {
        1, 
        2, 
        3, 
        4, 
        5, 
        6, 
        7, 
        8, 
        9, 
        10, 
        11, 
        12, 
        13
    };


    /// <summary>
    /// Module processing requests of Product domain.
    /// </summary>
    public sealed class ProductModule : NancyModule
    {
        /// <summary>
        /// Sets up HTTP methods mappings.
        /// </summary>
        /// <param name="service">Service handling requests</param>
        public ProductModule(ProductService service) : base("/magicCashew/keepa/1.0.0")
        { 
            Get["/product"] = parameters =>
            {
                var key = Parameters.ValueOf<string>(parameters, Context.Request, "key", ParameterType.Query);
                var domain = Parameters.ValueOf<ProductDomainEnum?>(parameters, Context.Request, "domain", ParameterType.Query);
                var asin = Parameters.ValueOf<string>(parameters, Context.Request, "asin", ParameterType.Query);
                var code = Parameters.ValueOf<string>(parameters, Context.Request, "code", ParameterType.Query);
                Preconditions.IsNotNull(key, "Required parameter: 'key' is missing at 'Product'");
                
                Preconditions.IsNotNull(domain, "Required parameter: 'domain' is missing at 'Product'");
                
                return service.Product(Context, key, domain, asin, code).ToArray();
            };
        }
    }

    /// <summary>
    /// Service handling Product requests.
    /// </summary>
    public interface ProductService
    {
        /// <summary>
        /// Retrieves the product object for the specified ASIN and domain. If our last update is older than one hour it will be automatically refreshed before delivered to you to ensure you get near to real-time pricing data.  You can request products via either their ASIN (preferred) or via UPC and EAN codes. You can not use both parameters, asin and code, in the same request. Keepa can not track Amazon Fresh and eBooks.
        /// </summary>
        /// <param name="context">Context of request</param>
        /// <param name="key">Your private API key.</param>
        /// <param name="domain">Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)</param>
        /// <param name="asin">The ASIN of the product you want to request. For batch requests a comma separated list of ASINs (up to one hundred). (optional)</param>
        /// <param name="code">The product code of the product you want to request. We currently allow UPC, EAN and ISBN-13 codes. For batch requests a comma separated list of codes (up to one hundred). Multiple ASINs can have the same product code, so requesting a product code can return multiple products. (optional)</param>
        /// <returns>List&lt;Category&gt;</returns>
        List<Category> Product(NancyContext context, string key, ProductDomainEnum? domain, string asin, string code);
    }

    /// <summary>
    /// Abstraction of ProductService.
    /// </summary>
    public abstract class AbstractProductService: ProductService
    {
        public virtual List<Category> Product(NancyContext context, string key, ProductDomainEnum? domain, string asin, string code)
        {
            return Product(key, domain, asin, code);
        }

        protected abstract List<Category> Product(string key, ProductDomainEnum? domain, string asin, string code);
    }

}
