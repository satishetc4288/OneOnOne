'use strict';

angular.module('crudApp').controller('LoginController', ['$scope', '$q', 'urls', '$rootScope', 'UserService', '$location',
			function($scope, $q, urls, $rootScope, UserService, $location) {

			$rootScope.loginUser = {};
      $scope.errorMessageShow = false;

      $scope.loginUser = function(login) {
          var deferred = $q.defer();
          UserService.postRequest(urls.USER_LOGIN_API, login)
          .then(
              function (response) {
                  console.log("Got user login response: " + response.data);
                  $rootScope.loginUser = response.data;
                  $location.path('/scheduler');
                  deferred.resolve();
              },
              function (errResponse) {
                 console.error('Error while creating User : '+ errResponse);
                 $scope.errorMessageShow = true;
                 deferred.reject();
              }
          );
          return deferred.promise;
      }
}]);