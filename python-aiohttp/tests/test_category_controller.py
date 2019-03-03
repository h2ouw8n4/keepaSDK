# coding: utf-8

import pytest
import json
from aiohttp import web

from openapi_server.models.category import Category


async def test_category(client):
    """Test case for category

    Returns Amazon category information from Keepa API.
    """
    params = [('key', 'key_example'),
                    ('domain', 56),
                    ('category', 56),
                    ('parents', 56)]
    headers = { 
        'Accept': 'application/json',
    }
    response = await client.request(
        method='GET',
        path='/magicCashew/keepa/1.0.0/category',
        headers=headers,
        params=params,
        )
    assert response.status == 200, 'Response body is : ' + (await response.read()).decode('utf-8')

