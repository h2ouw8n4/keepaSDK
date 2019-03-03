use std::rc::Rc;

use hyper;
use super::configuration::Configuration;

pub struct APIClient<C: hyper::client::Connect> {
  configuration: Rc<Configuration<C>>,
  category_api: Box<::apis::CategoryApi>,
  product_api: Box<::apis::ProductApi>,
}

impl<C: hyper::client::Connect> APIClient<C> {
  pub fn new(configuration: Configuration<C>) -> APIClient<C> {
    let rc = Rc::new(configuration);

    APIClient {
      configuration: rc.clone(),
      category_api: Box::new(::apis::CategoryApiClient::new(rc.clone())),
      product_api: Box::new(::apis::ProductApiClient::new(rc.clone())),
    }
  }

  pub fn category_api(&self) -> &::apis::CategoryApi{
    self.category_api.as_ref()
  }

  pub fn product_api(&self) -> &::apis::ProductApi{
    self.product_api.as_ref()
  }


}
