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

	    $( "#datepicker" ).datepicker();
	    $('#basicExample, #basicExample2').timepicker();

      $scope.loginUser = {};
			$scope.users = [];

      $scope.loginUser = function(login) {
          var deferred = $q.defer();
          $http.post(urls.USER_LOGIN_API, login)
          .then(
              function (response) {
                  console.log("Got user login response: " + response.data);
                  $('.login-form').addClass("hide");
                  $('.landing').removeClass("hide");

                  $scope.loginUser = response.data;
                  $scope.users = $localStorage.users;
                  deferred.resolve();
              },
              function (errResponse) {
                 console.error('Error while creating User : '+ errResponse);
                 deferred.reject();
              }
          );
          return deferred.promise;
      }

      $scope.scheduleMeeting = function(meeting) {
          meeting.sender = $scope.loginUser.sender;
          var deferred = $q.defer();
          $http.post(urls.INSERT_MEETING_API, meeting)
          .then(
              function (response) {
                  console.log("Got schedule meeting response: " + response.data);
                  $scope.meeting = {};
                  deferred.resolve();
              },
              function (errResponse) {
                 console.error('Error while scheduling meeting : '+ errResponse);
                 $scope.meeting = {};
                 deferred.reject();
              }
          );
          return deferred.promise;
      }

}]);