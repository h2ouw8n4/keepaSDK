//! Server implementation of openapi_client.

#![allow(unused_imports)]

use futures::{self, Future};
use chrono;
use std::collections::HashMap;
use std::marker::PhantomData;

use swagger;
use swagger::{Has, XSpanIdString};

use openapi_client::{Api, ApiError,
                      CategoryResponse,
                      ProductResponse
};
use openapi_client::models;

#[derive(Copy, Clone)]
pub struct Server<C> {
    marker: PhantomData<C>,
}

impl<C> Server<C> {
    pub fn new() -> Self {
        Server{marker: PhantomData}
    }
}

impl<C> Api<C> for Server<C> where C: Has<XSpanIdString>{

    /// Returns Amazon category information from Keepa API.
    fn category(&self, key: String, domain: i32, category: i32, parents: i32, context: &C) -> Box<Future<Item=CategoryResponse, Error=ApiError>> {
        let context = context.clone();
        println!("category(\"{}\", {}, {}, {}) - X-Span-ID: {:?}", key, domain, category, parents, context.get().0.clone());
        Box::new(futures::failed("Generic failure".into()))
    }

    /// Retrieve the product for the specified ASIN and domain.
    fn product(&self, key: String, domain: i32, asin: Option<String>, code: Option<String>, context: &C) -> Box<Future<Item=ProductResponse, Error=ApiError>> {
        let context = context.clone();
        println!("product(\"{}\", {}, {:?}, {:?}) - X-Span-ID: {:?}", key, domain, asin, code, context.get().0.clone());
        Box::new(futures::failed("Generic failure".into()))
    }

}
