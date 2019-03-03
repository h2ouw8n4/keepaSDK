<?php
require_once __DIR__ . '/vendor/autoload.php';

use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Silex\Application;

$app = new Silex\Application();


$app->GET('/magicCashew/keepa/1.0.0/category', function(Application $app, Request $request) {
            $key = $request->get('key');
            $domain = $request->get('domain');
            $category = $request->get('category');
            $parents = $request->get('parents');
            return new Response('How about implementing category as a GET method ?');
            });


$app->GET('/magicCashew/keepa/1.0.0/product', function(Application $app, Request $request) {
            $key = $request->get('key');
            $domain = $request->get('domain');
            $asin = $request->get('asin');
            $code = $request->get('code');
            return new Response('How about implementing product as a GET method ?');
            });


$app->run();
