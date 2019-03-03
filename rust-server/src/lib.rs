#![allow(missing_docs, trivial_casts, unused_variables, unused_mut, unused_imports, unused_extern_crates, non_camel_case_types)]
extern crate serde;
#[macro_use]
extern crate serde_derive;
extern crate serde_json;


extern crate futures;
extern crate chrono;
#[macro_use]
extern crate lazy_static;
#[macro_use]
extern crate log;

// Logically this should be in the client and server modules, but rust doesn't allow `macro_use` from a module.
#[cfg(any(feature = "client", feature = "server"))]
#[macro_use]
extern crate hyper;

extern crate swagger;

#[macro_use]
extern crate url;

use futures::Stream;
use std::io::Error;

#[allow(unused_imports)]
use std::collections::HashMap;

pub use futures::Future;

#[cfg(any(feature = "client", feature = "server"))]
mod mimetypes;

pub use swagger::{ApiError, ContextWrapper};

pub const BASE_PATH: &'static str = "/magicCashew/keepa/1.0.0";
pub const API_VERSION: &'static str = "1.0.0";


#[derive(Debug, PartialEq)]
pub enum CategoryResponse {
    /// search results matching criteria
    SearchResultsMatchingCriteria ( Vec<models::Category> ) ,
    /// bad input parameter
    BadInputParameter ,
}

#[derive(Debug, PartialEq)]
pub enum ProductResponse {
    /// search results matching criteria
    SearchResultsMatchingCriteria ( Vec<models::Category> ) ,
    /// bad input parameter
    BadInputParameter ,
}


/// API
pub trait Api<C> {

    /// Returns Amazon category information from Keepa API.
    fn category(&self, key: String, domain: i32, category: i32, parents: i32, context: &C) -> Box<Future<Item=CategoryResponse, Error=ApiError>>;

    /// Retrieve the product for the specified ASIN and domain.
    fn product(&self, key: String, domain: i32, asin: Option<String>, code: Option<String>, context: &C) -> Box<Future<Item=ProductResponse, Error=ApiError>>;

}

/// API without a `Context`
pub trait ApiNoContext {

    /// Returns Amazon category information from Keepa API.
    fn category(&self, key: String, domain: i32, category: i32, parents: i32) -> Box<Future<Item=CategoryResponse, Error=ApiError>>;

    /// Retrieve the product for the specified ASIN and domain.
    fn product(&self, key: String, domain: i32, asin: Option<String>, code: Option<String>) -> Box<Future<Item=ProductResponse, Error=ApiError>>;

}

/// Trait to extend an API to make it easy to bind it to a context.
pub trait ContextWrapperExt<'a, C> where Self: Sized {
    /// Binds this API to a context.
    fn with_context(self: &'a Self, context: C) -> ContextWrapper<'a, Self, C>;
}

impl<'a, T: Api<C> + Sized, C> ContextWrapperExt<'a, C> for T {
    fn with_context(self: &'a T, context: C) -> ContextWrapper<'a, T, C> {
         ContextWrapper::<T, C>::new(self, context)
    }
}

impl<'a, T: Api<C>, C> ApiNoContext for ContextWrapper<'a, T, C> {

    /// Returns Amazon category information from Keepa API.
    fn category(&self, key: String, domain: i32, category: i32, parents: i32) -> Box<Future<Item=CategoryResponse, Error=ApiError>> {
        self.api().category(key, domain, category, parents, &self.context())
    }

    /// Retrieve the product for the specified ASIN and domain.
    fn product(&self, key: String, domain: i32, asin: Option<String>, code: Option<String>) -> Box<Future<Item=ProductResponse, Error=ApiError>> {
        self.api().product(key, domain, asin, code, &self.context())
    }

}

#[cfg(feature = "client")]
pub mod client;

// Re-export Client as a top-level name
#[cfg(feature = "client")]
pub use self::client::Client;

#[cfg(feature = "server")]
pub mod server;

// Re-export router() as a top-level name
#[cfg(feature = "server")]
pub use self::server::Service;

pub mod models;
