using System;
using System.Collections.Generic;
using System.IO;
using System.Text;
using Sharpility.Extensions;
using NodaTime;

namespace Org.OpenAPITools.magicCashewkeepa1_0_0.Models
{
    /// <summary>
    /// Category
    /// </summary>
    public sealed class Category:  IEquatable<Category>
    { 
        /// <summary>
        /// Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)
        /// </summary>
        public DomainIdEnum? DomainId { get; private set; }

        /// <summary>
        /// The category node id used by Amazon. Represents the identifier of the category. Also part of the Product object’s categories and rootCategory fields. Always a positive Long value. Note - The id 9223372036854775807 (max signed long value) denotes a blank category with the name “?”. We use this in cases where a product is listed in no or non-existent categories.
        /// </summary>
        public int? CatId { get; private set; }

        /// <summary>
        /// The name of the category.
        /// </summary>
        public string Name { get; private set; }

        /// <summary>
        /// List of all sub categories. null or [] (empty array) if the category has no sub categories.
        /// </summary>
        public List<int?> Children { get; private set; }

        /// <summary>
        /// The parent category’s Id. Always a positive Long value. If it is 0 the category is a root category and has no parent category.
        /// </summary>
        public int? Parent { get; private set; }

        /// <summary>
        /// The highest (root category) sales rank we have observed of a product that is listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.
        /// </summary>
        public int? HighestRank { get; private set; }

        /// <summary>
        /// Number of products that are listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.
        /// </summary>
        public int? ProductCount { get; private set; }


        /// <summary>
        /// Empty constructor required by some serializers.
        /// Use Category.Builder() for instance creation instead.
        /// </summary>
        [Obsolete]
        public Category()
        {
        }

        private Category(DomainIdEnum? DomainId, int? CatId, string Name, List<int?> Children, int? Parent, int? HighestRank, int? ProductCount)
        {
            
            this.DomainId = DomainId;
            
            this.CatId = CatId;
            
            this.Name = Name;
            
            this.Children = Children;
            
            this.Parent = Parent;
            
            this.HighestRank = HighestRank;
            
            this.ProductCount = ProductCount;
            
        }

        /// <summary>
        /// Returns builder of Category.
        /// </summary>
        /// <returns>CategoryBuilder</returns>
        public static CategoryBuilder Builder()
        {
            return new CategoryBuilder();
        }

        /// <summary>
        /// Returns CategoryBuilder with properties set.
        /// Use it to change properties.
        /// </summary>
        /// <returns>CategoryBuilder</returns>
        public CategoryBuilder With()
        {
            return Builder()
                .DomainId(DomainId)
                .CatId(CatId)
                .Name(Name)
                .Children(Children)
                .Parent(Parent)
                .HighestRank(HighestRank)
                .ProductCount(ProductCount);
        }

        public override string ToString()
        {
            return this.PropertiesToString();
        }

        public override bool Equals(object obj)
        {
            return this.EqualsByProperties(obj);
        }

        public bool Equals(Category other)
        {
            return Equals((object) other);
        }

        public override int GetHashCode()
        {
            return this.PropertiesHash();
        }

        /// <summary>
        /// Implementation of == operator for (Category.
        /// </summary>
        /// <param name="left">Compared (Category</param>
        /// <param name="right">Compared (Category</param>
        /// <returns>true if compared items are equals, false otherwise</returns>
        public static bool operator == (Category left, Category right)
        {
            return Equals(left, right);
        }

        /// <summary>
        /// Implementation of != operator for (Category.
        /// </summary>
        /// <param name="left">Compared (Category</param>
        /// <param name="right">Compared (Category</param>
        /// <returns>true if compared items are not equals, false otherwise</returns>
        public static bool operator != (Category left, Category right)
        {
            return !Equals(left, right);
        }

        /// <summary>
        /// Builder of Category.
        /// </summary>
        public sealed class CategoryBuilder
        {
            private DomainIdEnum? _DomainId;
            private int? _CatId;
            private string _Name;
            private List<int?> _Children;
            private int? _Parent;
            private int? _HighestRank;
            private int? _ProductCount;

            internal CategoryBuilder()
            {
                SetupDefaults();
            }

            private void SetupDefaults()
            {
            }

            /// <summary>
            /// Sets value for Category.DomainId property.
            /// </summary>
            /// <param name="value">Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)</param>
            public CategoryBuilder DomainId(DomainIdEnum? value)
            {
                _DomainId = value;
                return this;
            }

            /// <summary>
            /// Sets value for Category.CatId property.
            /// </summary>
            /// <param name="value">The category node id used by Amazon. Represents the identifier of the category. Also part of the Product object’s categories and rootCategory fields. Always a positive Long value. Note - The id 9223372036854775807 (max signed long value) denotes a blank category with the name “?”. We use this in cases where a product is listed in no or non-existent categories.</param>
            public CategoryBuilder CatId(int? value)
            {
                _CatId = value;
                return this;
            }

            /// <summary>
            /// Sets value for Category.Name property.
            /// </summary>
            /// <param name="value">The name of the category.</param>
            public CategoryBuilder Name(string value)
            {
                _Name = value;
                return this;
            }

            /// <summary>
            /// Sets value for Category.Children property.
            /// </summary>
            /// <param name="value">List of all sub categories. null or [] (empty array) if the category has no sub categories.</param>
            public CategoryBuilder Children(List<int?> value)
            {
                _Children = value;
                return this;
            }

            /// <summary>
            /// Sets value for Category.Parent property.
            /// </summary>
            /// <param name="value">The parent category’s Id. Always a positive Long value. If it is 0 the category is a root category and has no parent category.</param>
            public CategoryBuilder Parent(int? value)
            {
                _Parent = value;
                return this;
            }

            /// <summary>
            /// Sets value for Category.HighestRank property.
            /// </summary>
            /// <param name="value">The highest (root category) sales rank we have observed of a product that is listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.</param>
            public CategoryBuilder HighestRank(int? value)
            {
                _HighestRank = value;
                return this;
            }

            /// <summary>
            /// Sets value for Category.ProductCount property.
            /// </summary>
            /// <param name="value">Number of products that are listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.</param>
            public CategoryBuilder ProductCount(int? value)
            {
                _ProductCount = value;
                return this;
            }


            /// <summary>
            /// Builds instance of Category.
            /// </summary>
            /// <returns>Category</returns>
            public Category Build()
            {
                Validate();
                return new Category(
                    DomainId: _DomainId,
                    CatId: _CatId,
                    Name: _Name,
                    Children: _Children,
                    Parent: _Parent,
                    HighestRank: _HighestRank,
                    ProductCount: _ProductCount
                );
            }

            private void Validate()
            { 
                if (_DomainId == null)
                {
                    throw new ArgumentException("DomainId is a required property for Category and cannot be null");
                } 
                if (_CatId == null)
                {
                    throw new ArgumentException("CatId is a required property for Category and cannot be null");
                } 
                if (_Name == null)
                {
                    throw new ArgumentException("Name is a required property for Category and cannot be null");
                } 
                if (_Children == null)
                {
                    throw new ArgumentException("Children is a required property for Category and cannot be null");
                } 
                if (_Parent == null)
                {
                    throw new ArgumentException("Parent is a required property for Category and cannot be null");
                } 
                if (_HighestRank == null)
                {
                    throw new ArgumentException("HighestRank is a required property for Category and cannot be null");
                } 
                if (_ProductCount == null)
                {
                    throw new ArgumentException("ProductCount is a required property for Category and cannot be null");
                } 
            }
        }

        
        public enum DomainIdEnum { _1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13 };
    }
}