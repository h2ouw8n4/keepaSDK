# KeepaAPI

The Keepa API offers numerous endpoints.  Every request requires your API access key as a parameter. You can find and change your key in the keepa portal. All requests must be issued as a HTTPS GET and accept gzip encoding. If possible, use a Keep-Alive connection.  Multiple requests can be made in parallel to increase throughput.

## Installation

If [available in Hex](https://hex.pm/docs/publish), the package can be installed
by adding `keepa_api` to your list of dependencies in `mix.exs`:

```elixir
def deps do
  [{:keepa_api, "~> 0.1.0"}]
end
```

Documentation can be generated with [ExDoc](https://github.com/elixir-lang/ex_doc)
and published on [HexDocs](https://hexdocs.pm). Once published, the docs can
be found at [https://hexdocs.pm/keepa_api](https://hexdocs.pm/keepa_api).
