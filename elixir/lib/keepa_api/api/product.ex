# NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
# https://openapi-generator.tech
# Do not edit the class manually.

defmodule KeepaAPI.Api.Product do
  @moduledoc """
  API calls for all endpoints tagged `Product`.
  """

  alias KeepaAPI.Connection
  import KeepaAPI.RequestBuilder


  @doc """
  Retrieve the product for the specified ASIN and domain.
  Retrieves the product object for the specified ASIN and domain. If our last update is older than one hour it will be automatically refreshed before delivered to you to ensure you get near to real-time pricing data.  You can request products via either their ASIN (preferred) or via UPC and EAN codes. You can not use both parameters, asin and code, in the same request. Keepa can not track Amazon Fresh and eBooks.

  ## Parameters

  - connection (KeepaAPI.Connection): Connection to server
  - key (String.t): Your private API key.
  - domain (integer()): Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)
  - opts (KeywordList): [optional] Optional parameters
    - :asin (String.t): The ASIN of the product you want to request. For batch requests a comma separated list of ASINs (up to one hundred).
    - :code (String.t): The product code of the product you want to request. We currently allow UPC, EAN and ISBN-13 codes. For batch requests a comma separated list of codes (up to one hundred). Multiple ASINs can have the same product code, so requesting a product code can return multiple products.
  ## Returns

  {:ok, [%Category{}, ...]} on success
  {:error, info} on failure
  """
  @spec product(Tesla.Env.client, String.t, integer(), keyword()) :: {:ok, list(KeepaAPI.Model.Category.t)} | {:error, Tesla.Env.t}
  def product(connection, key, domain, opts \\ []) do
    optional_params = %{
      :"asin" => :query,
      :"code" => :query
    }
    %{}
    |> method(:get)
    |> url("/product")
    |> add_param(:query, :"key", key)
    |> add_param(:query, :"domain", domain)
    |> add_optional_params(optional_params, opts)
    |> Enum.into([])
    |> (&Connection.request(connection, &1)).()
    |> decode([%KeepaAPI.Model.Category{}])
  end
end