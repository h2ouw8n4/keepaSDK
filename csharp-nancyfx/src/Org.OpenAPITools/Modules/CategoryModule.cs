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
    public enum CategoryDomainEnum
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
    /// Whether or not to include the category tree for each category. (1 &#x3D; include, 0 &#x3D; do not include.)
    /// </summary>
    public enum CategoryParentsEnum
    {
        0, 
        1
    };


    /// <summary>
    /// Module processing requests of Category domain.
    /// </summary>
    public sealed class CategoryModule : NancyModule
    {
        /// <summary>
        /// Sets up HTTP methods mappings.
        /// </summary>
        /// <param name="service">Service handling requests</param>
        public CategoryModule(CategoryService service) : base("/magicCashew/keepa/1.0.0")
        { 
            Get["/category"] = parameters =>
            {
                var key = Parameters.ValueOf<string>(parameters, Context.Request, "key", ParameterType.Query);
                var domain = Parameters.ValueOf<CategoryDomainEnum?>(parameters, Context.Request, "domain", ParameterType.Query);
                var category = Parameters.ValueOf<int?>(parameters, Context.Request, "category", ParameterType.Query);
                var parents = Parameters.ValueOf<CategoryParentsEnum?>(parameters, Context.Request, "parents", ParameterType.Query);
                Preconditions.IsNotNull(key, "Required parameter: 'key' is missing at 'Category'");
                
                Preconditions.IsNotNull(domain, "Required parameter: 'domain' is missing at 'Category'");
                
                Preconditions.IsNotNull(category, "Required parameter: 'category' is missing at 'Category'");
                
                Preconditions.IsNotNull(parents, "Required parameter: 'parents' is missing at 'Category'");
                
                return service.Category(Context, key, domain, category, parents).ToArray();
            };
        }
    }

    /// <summary>
    /// Service handling Category requests.
    /// </summary>
    public interface CategoryService
    {
        /// <summary>
        /// Retrieve category objects using their node ids and (optional) their parent tree.
        /// </summary>
        /// <param name="context">Context of request</param>
        /// <param name="key">Your private API key.</param>
        /// <param name="domain">Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)</param>
        /// <param name="category">The category node id of the category you want to request. For batch requests a comma separated list of ids (up to 10, the token cost stays the same). Alternatively you can specify the value 0, which will retrieve a list of all root categories.</param>
        /// <param name="parents">Whether or not to include the category tree for each category. (1 &#x3D; include, 0 &#x3D; do not include.)</param>
        /// <returns>List&lt;Category&gt;</returns>
        List<Category> Category(NancyContext context, string key, CategoryDomainEnum? domain, int? category, CategoryParentsEnum? parents);
    }

    /// <summary>
    /// Abstraction of CategoryService.
    /// </summary>
    public abstract class AbstractCategoryService: CategoryService
    {
        public virtual List<Category> Category(NancyContext context, string key, CategoryDomainEnum? domain, int? category, CategoryParentsEnum? parents)
        {
            return Category(key, domain, category, parents);
        }

        protected abstract List<Category> Category(string key, CategoryDomainEnum? domain, int? category, CategoryParentsEnum? parents);
    }

}
