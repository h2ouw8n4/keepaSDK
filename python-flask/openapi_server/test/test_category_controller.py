# coding: utf-8

from __future__ import absolute_import
import unittest

from flask import json
from six import BytesIO

from openapi_server.models.category import Category  # noqa: E501
from openapi_server.test import BaseTestCase


class TestCategoryController(BaseTestCase):
    """CategoryController integration test stubs"""

    def test_category(self):
        """Test case for category

        Returns Amazon category information from Keepa API.
        """
        query_string = [('key', 'key_example'),
                        ('domain', 56),
                        ('category', 56),
                        ('parents', 56)]
        headers = { 
            'Accept': 'application/json',
        }
        response = self.client.open(
            '/magicCashew/keepa/1.0.0/category',
            method='GET',
            headers=headers,
            query_string=query_string)
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))


if __name__ == '__main__':
    unittest.main()
