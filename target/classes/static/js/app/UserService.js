'use strict';

angular.module('crudApp').factory('UserService',['$http', '$q',
        function ($http, $q) {

            var factory = {
                getRequest: getRequest,
                postRequest: postRequest
            };

            return factory;

            function getRequest(URL) {
                console.log('Making get request with URL: ' + URL);
                var deferred = $q.defer();
                $http.get(URL)
                    .then(
                        function (response) {
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function postRequest(URL, data) {
                console.log('Making post request with URL: ' + URL);
                var deferred = $q.defer();
                $http.post(URL, data)
                    .then(
                        function (response) {
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
        }
    ]);