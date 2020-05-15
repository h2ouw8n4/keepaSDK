<?php
/**
 * SlimRouter
 *
 * PHP version 7
 *
 * @package OpenAPIServer
 * @author  OpenAPI Generator team
 * @link    https://github.com/openapitools/openapi-generator
 */

/**
 * Keepa API
 *
 * The Keepa API offers numerous endpoints.  Every request requires your API access key as a parameter. You can find and change your key in the keepa portal. All requests must be issued as a HTTPS GET and accept gzip encoding. If possible, use a Keep-Alive connection.  Multiple requests can be made in parallel to increase throughput.
 * OpenAPI spec version: 1.0.0
 * Contact: info@keepa.com
 * Generated by: https://github.com/openapitools/openapi-generator.git
 */

/**
 * NOTE: This class is auto generated by the openapi generator program.
 * https://github.com/openapitools/openapi-generator
 * Do not edit the class manually.
 */
namespace OpenAPIServer;

use Slim\App;
use Slim\Interfaces\RouteInterface;
use Psr\Container\ContainerInterface;
use InvalidArgumentException;
use Dyorg\TokenAuthentication;
use Dyorg\TokenAuthentication\TokenSearch;
use Psr\Http\Message\ServerRequestInterface;
use Exception;

/**
 * SlimRouter Class Doc Comment
 *
 * @package OpenAPIServer
 * @author  OpenAPI Generator team
 * @link    https://github.com/openapitools/openapi-generator
 */
class SlimRouter
{

    /** @var App instance */
    private $slimApp;

    /** @var array[] list of all api operations */
    private $operations = [
        [
            'httpMethod' => 'GET',
            'basePathWithoutHost' => '/magicCashew/keepa/1.0.0',
            'path' => '/category',
            'apiPackage' => 'OpenAPIServer\Api',
            'classname' => 'AbstractCategoryApi',
            'userClassname' => 'CategoryApi',
            'operationId' => 'category',
            'authMethods' => [
            ],
        ],
        [
            'httpMethod' => 'GET',
            'basePathWithoutHost' => '/magicCashew/keepa/1.0.0',
            'path' => '/product',
            'apiPackage' => 'OpenAPIServer\Api',
            'classname' => 'AbstractProductApi',
            'userClassname' => 'ProductApi',
            'operationId' => 'product',
            'authMethods' => [
            ],
        ],
    ];

    /**
     * Class constructor
     *
     * @param ContainerInterface|array $container Either a ContainerInterface or an associative array of app settings
     *
     * @throws InvalidArgumentException When no container is provided that implements ContainerInterface
     * @throws Exception When implementation class doesn't exists
     */
    public function __construct($container = [])
    {
        $this->slimApp = new App($container);


        foreach ($this->operations as $operation) {
            $callback = function ($request, $response, $arguments) use ($operation) {
                $message = "How about extending {$operation['classname']} by {$operation['apiPackage']}\\{$operation['userClassname']} class implementing {$operation['operationId']} as a {$operation['httpMethod']} method?";
                throw new Exception($message);
                return $response->withStatus(501)->write($message);
            };
            $middlewares = [];

            if (class_exists("\\{$operation['apiPackage']}\\{$operation['userClassname']}")) {
                $callback = "\\{$operation['apiPackage']}\\{$operation['userClassname']}:{$operation['operationId']}";
            }


            $this->addRoute(
                [$operation['httpMethod']],
                "{$operation['basePathWithoutHost']}{$operation['path']}",
                $callback,
                $middlewares
            )->setName($operation['operationId']);
        }
    }

    /**
     * Merges user defined options with dynamic params
     *
     * @param array $options Params which need to merge into user options
     *
     * @return array Merged array
     */
    private function getTokenAuthenticationOptions(array $options)
    {
        if (is_array($this->slimApp->getContainer()['tokenAuthenticationOptions']) === false) {
            return $options;
        }

        return array_merge($this->slimApp->getContainer()['tokenAuthenticationOptions'], $options);
    }

    /**
     * Add route with multiple methods
     *
     * @param string[]        $methods     Numeric array of HTTP method names
     * @param string          $pattern     The route URI pattern
     * @param callable|string $callable    The route callback routine
     * @param array|null      $middlewares List of middlewares
     *
     * @return RouteInterface
     *
     * @throws InvalidArgumentException If the route pattern isn't a string
     */
    public function addRoute(array $methods, string $pattern, $callable, $middlewares = [])
    {
        $route = $this->slimApp->map($methods, $pattern, $callable);
        foreach ($middlewares as $middleware) {
            $route->add($middleware);
        }
        return $route;
    }

    /**
     * Returns Slim Framework instance
     *
     * @return App
     */
    public function getSlimApp()
    {
        return $this->slimApp;
    }
}