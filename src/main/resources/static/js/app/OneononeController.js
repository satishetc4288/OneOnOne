'use strict';

angular.module('crudApp').controller('OneononeController', ['$scope', '$localStorage', '$http', '$q', 'urls',
			function($scope, $localStorage, $http, $q, urls) {

			var availableTags = [
         "ActionScript",
         "AppleScript",
         "Asp",
         "BASIC",
         "C",
         "C++",
         "Clojure",
         "COBOL",
         "ColdFusion",
         "Erlang",
         "Fortran",
         "Groovy",
         "Haskell",
         "Java",
         "JavaScript",
         "Lisp",
         "Perl",
         "PHP",
         "Python",
         "Ruby",
         "Scala",
         "Scheme"
	    ];

			$scope.user = {};
			$scope.users = [];

      $scope.loginUser = function(login) {
          var deferred = $q.defer();
          $http.post(urls.USER_LOGIN_API, login)
          .then(
              function (response) {
                  console.log("Got user login response: " + response.data);
                  $('.login-form').addClass("hide");
                  $('.landing').removeClass("hide");
                  $localStorage.loginUser = response.data;
                  $scope.getAllUsers();
                  deferred.resolve();
              },
              function (errResponse) {
                 console.error('Error while creating User : '+ errResponse);
                 deferred.reject();
              }
          );
          return deferred.promise;
      }

      $scope.getAllUsers = function() {
          var deferred = $q.defer();
          $http.get(urls.USER_All_API)
          .then(
              function (response) {
                  console.log("Got all the users: " + response.data);
                  $scope.users = response.data;
                  deferred.resolve();
              },
              function (errResponse) {
                 console.error('Error while creating User : '+ errResponse);
                 deferred.reject();
              }
          );
          return deferred.promise;
      }

}]);