from typing import List, Dict
from aiohttp import web

from openapi_server.models.category import Category
from openapi_server import util


async def product(request: web.Request, key, domain, asin=None, code=None) -> web.Response:
    """Retrieve the product for the specified ASIN and domain.

    Retrieves the product object for the specified ASIN and domain. If our last update is older than one hour it will be automatically refreshed before delivered to you to ensure you get near to real-time pricing data.  You can request products via either their ASIN (preferred) or via UPC and EAN codes. You can not use both parameters, asin and code, in the same request. Keepa can not track Amazon Fresh and eBooks.

    :param key: Your private API key.
    :type key: str
    :param domain: Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)
    :type domain: int
    :param asin: The ASIN of the product you want to request. For batch requests a comma separated list of ASINs (up to one hundred).
    :type asin: str
    :param code: The product code of the product you want to request. We currently allow UPC, EAN and ISBN-13 codes. For batch requests a comma separated list of codes (up to one hundred). Multiple ASINs can have the same product code, so requesting a product code can return multiple products.
    :type code: str

    """
    return web.Response(status=200)
