/// mime types for requests and responses

pub mod responses {
    use hyper::mime::*;

    // The macro is called per-operation to beat the recursion limit
    /// Create Mime objects for the response content types for Category
    lazy_static! {
        pub static ref CATEGORY_SEARCH_RESULTS_MATCHING_CRITERIA: Mime = "application/json".parse().unwrap();
    }
    /// Create Mime objects for the response content types for Product
    lazy_static! {
        pub static ref PRODUCT_SEARCH_RESULTS_MATCHING_CRITERIA: Mime = "application/json".parse().unwrap();
    }

}

pub mod requests {
    use hyper::mime::*;

}
