'use strict';

/**
 * @ngdoc overview
 * @name staticApp
 * @description
 * # staticApp
 *
 * Main module of the application.
 */
angular
    .module('staticApp', [
        'ngAnimate',
        'ngAria',
        'ngCookies',
        'ngMessages',
        'ngResource',
        'ngRoute',
        'ngSanitize',
        'ngTouch'
    ])
    .config(function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'views/booklist.html',
                controller: 'BookListCtrl',
                controllerAs: 'book_controller'
            })
            .when('/book/list', {
                templateUrl: 'views/booklist.html',
                controller: 'BookListCtrl',
                controllerAs: 'book_controller'
            })
            .when('/book/add', {
                templateUrl: 'views/addbook.html',
                controller: 'BookSaveEditCtrl',
                controllerAs: 'book_controller'
            })
            .when('/book/:id', {
                templateUrl: 'views/viewbook.html',
                controller: 'BookViewCtrl',
                controllerAs: 'book_controller'
            })
            .when('/book/delete/:id', {
                templateUrl: 'views/booklist.html',
                controller: 'BookDeleteCtrl',
                controllerAs: 'book_controller'
            })
            .when('/book/edit/:id',{
                templateUrl: 'views/addbook.html',
                controller: 'BookSaveEditCtrl',
                controllerAs: 'book_controller'
            })
            .otherwise({
                redirectTo: '/'
            });
    });
