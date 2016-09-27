'use strict';

/**
 * Created by Tomas on 23/09/2016.
 */
angular
    .module("staticApp")
    .factory("ServicesRestBook", ["$http", function ($http) {
        //Get host window.location.host
        var servicesRestBook = {};

        servicesRestBook.getBook = function (id) {
            return $http.get("http://localhost:8080/rest/book/" + id);
        };

        servicesRestBook.getBookList = function (numberList, sizeList) {
            return $http.get("http://localhost:8080/rest/book/" + numberList + "/" + sizeList);
        };

        servicesRestBook.deleteBook = function (id) {
            return $http.delete("http://localhost:8080/rest/book/" + id);
        };

        servicesRestBook.editBook = function (id, form) {
            return $http.put("http://localhost:8080/rest/book/" + id, form);
        };

        servicesRestBook.saveBook = function (form) {
            return $http.post("http://localhost:8080/rest/book", form);
        };

        return servicesRestBook;
    }]);
