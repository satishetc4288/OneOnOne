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
	    $( "#tags" ).autocomplete({
         source: availableTags
      });

      $scope.loginUser = {};
			$scope.users = [];
			$scope.allMeetings = [];
			$scope.defaultMeeting = {};

			$scope.updateDefault = function(meeting) {
				$scope.defaultMeeting = meeting;
			}

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
                  $scope.getAllMeetings();
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
          meeting.sender = $scope.loginUser.name;
          var deferred = $q.defer();
          $http.post(urls.INSERT_MEETING_API, meeting)
          .then(
              function (response) {
                  console.log("Got schedule meeting response: " + response.data);
                  $scope.meeting = {};
                  $scope.getAllMeetings();
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

      $scope.getAllMeetings = function() {
          var deferred = $q.defer();
          $http.get(urls.USER_ALL_MEETINGS)
          .then(
              function (response) {
                  console.log("Got users all meeting response: " + response.data);
                  $scope.allMeetings = response.data;
                  deferred.resolve();
              },
              function (errResponse) {
                 console.error('Error while getting all users meeting : '+ errResponse);
                 deferred.reject();
              }
          );
          return deferred.promise;
      }

       $scope.parseFeedback = function(feedback){
          console.log("feedback parsing called")
          feedback.performanceMatrices = [];
          feedback.performanceMatrices.push(feedback.perf1 + ":" + feedback.reveiw1);
          feedback.performanceMatrices.push(feedback.perf2 + ":" + feedback.reveiw2);
          return feedback;
       }

       $scope.submitFeedback = function(feedback) {
            console.log("Submit feedback has been called")
            feedback.meetingId = $scope.defaultMeeting.id;
            feedback =  $scope.parseFeedback(feedback);
	          var deferred = $q.defer();
	          $http.post(urls.FEEDBACK_INSERT_API, feedback)
	          .then(
	              function (response) {
	                  console.log("Got feedback insert response: " + response.data);
	                  $scope.feedback = {};
	                  deferred.resolve();
	              },
	              function (errResponse) {
	                 console.error('Error while inserting feedback : '+ errResponse);
	                 $scope.feedback = {};
	                 deferred.reject();
	              }
	          );
	          return deferred.promise;
	      }

}]);