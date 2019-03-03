# coding: utf-8

import pytest
import json
from aiohttp import web

from openapi_server.models.category import Category


async def test_product(client):
    """Test case for product

    Retrieve the product for the specified ASIN and domain.
    """
    params = [('key', 'key_example'),
                    ('domain', 56),
                    ('asin', 'asin_example'),
                    ('code', 'code_example')]
    headers = { 
        'Accept': 'application/json',
    }
    response = await client.request(
        method='GET',
        path='/magicCashew/keepa/1.0.0/product',
        headers=headers,
        params=params,
        )
    assert response.status == 200, 'Response body is : ' + (await response.read()).decode('utf-8')

