'use strict';

/**
 * @ngdoc function
 * @name staticApp.controller:BooklistCtrl
 * @description
 * # BooklistCtrl
 * Controller of the staticApp
 */

angular
    .module('staticApp')
    .controller('BookListCtrl', ['$scope', '$location', 'ServicesRestBook',
        function ($scope, $location, ServicesRestBook) {
            $scope.page = 0;
            /**
             * find elements
             */
            $scope.loadElements = function () {
                ServicesRestBook.getBookList($scope.page, 10)
                    .then(function (response) {
                        $scope.books = response.data.content;
                        $scope.totalPages = response.data.totalPages;
                    }, function (response) {
                        console.log(response);
                    });
            };

            $scope.nextPage = function () {
                $scope.page++;
                if ($scope.page == $scope.totalPages)
                    $scope.page--;

                $scope.loadElements();
            };

            $scope.returnPage = function () {
                $scope.page--;
                if ($scope.page < 0)
                    $scope.page = 0;
                $scope.loadElements();
            };


            $scope.loadElements();

        }])
    .controller('BookViewCtrl', ['$scope', '$routeParams', '$location', 'ServicesRestBook',
        function ($scope, $routeParams, $location, ServicesRestBook) {
            /**
             * find element for the id
             * @param id
             */
            ServicesRestBook.getBook($routeParams.id)
                .then(function (book) {
                    $scope.book = book.data;
                }, function (err) {
                    console.log(err);
                });
        }])
    .controller('BookDeleteCtrl', ['$scope', '$routeParams', '$location', 'ServicesRestBook',
        function ($scope, $routeParams, $location, ServicesRestBook) {
            /**
             * Remove the element
             * @param id
             */
            ServicesRestBook.deleteBook($routeParams.id)
                .then(function (data) {
                        console.log("Se elimino");
                        $location.path("#/book/list");
                    },
                    function (err) {
                        console.log(err);
                    }
                );

        }])
    .controller('BookSaveEditCtrl', ['$scope', '$location', '$routeParams', 'ServicesRestBook',
        function ($scope, $location, $routeParams, ServicesRestBook) {
            $scope.form = {};
            $scope.message = 'Guardar';

            /**
             * Save the new or edited element
             */
            $scope.postElement = function () {
                $scope.getValuesOfPaperElements();
                ServicesRestBook.saveBook($scope.form)
                    .then(function (response) {
                        $location.path("/book/" + response.data.id_book);
                    }, function (err) {
                        console.log(err);
                    });
            };

            /**
             * Get values of the elements Paper-input
             */
            $scope.getValuesOfPaperElements = function () {
                $scope.form.book_name = $('paper-input[name=book_name]').val();
                $scope.form.book_editorial = $('paper-input[name=book_editorial]').val();
                $scope.form.book_author = $('paper-input[name=book_author]').val();
                $scope.form.id_book = $('input[name=id_book]').val();
            };

            /**
             * Get element for edit
             * @param id
             */
            $scope.editElement = function (id) {
                ServicesRestBook.getBook(id)
                    .then(function (response) {
                        $scope.form = response.data;
                        $scope.setValuesOfPaperElements()
                    }, function (err) {
                        console.log(err);
                    });
            };
            $scope.setValuesOfPaperElements = function () {
                $('paper-input[name=book_name]').val($scope.form.book_name);
                $('paper-input[name=book_editorial]').val($scope.form.book_editorial);
                $('paper-input[name=book_author]').val($scope.form.book_author);
                $('input[name=id_book]').val($scope.form.id_book);
            };
            /**
             * Save the elements edited
             */
            $scope.saveEdit = function () {
                $scope.form = {};
                $scope.getValuesOfPaperElements();
                ServicesRestBook.editBook($scope.form.id_book, $scope.form)
                    .then(function (response) {
                        $location.path("/book/" + response.data.id_book);
                    }, function (err) {
                        console.log(err);
                    })
            };

            $scope.identifyFunction = function () {
                if ($routeParams.id != null)
                    $scope.saveEdit();
                else
                    $scope.postElement();
            };

            if ($routeParams.id != null) {
                $scope.message = 'Editar';
                $scope.editElement($routeParams.id);
            }
        }]);
