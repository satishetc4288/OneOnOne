'use strict';

angular.module('crudApp').controller('SchedulerController', ['$scope', '$q', 'urls', '$timeout', 'UserService', '$rootScope',
			function($scope, $q, urls, $timeout, UserService, $rootScope) {

			var availableTags = [
         "dipak.suryavanshi@cdk.com",
         "satish.rajput@cdk.com",
         "vedprakash.gupta@cdk.com",
         "punam.gaikwad@cdk.com",
         "sneha.varne@cdk.com"
	    ];

	    $( "#datepicker" ).datepicker();
	    $('#basicExample, #basicExample2').timepicker();
	    $( "#tags" ).autocomplete({
         source: availableTags
      });
      $( "#accordion" ).accordion({
          collapsible: true,
          active: 0,
          animate: false
      });

			$scope.users = [];
			$scope.allMeetings = [];
			$scope.defaultMeeting = {};
			$scope.errorMessageShow = false;
			$scope.usersAllFeedbacks = [];
			$scope.showSchedulingAlert= false;



			$scope.updateDefault = function(meeting) {
				$scope.defaultMeeting = meeting;
			}

			$scope.doGreeting = function() {
         $scope.showSchedulingAlert = true;
         $timeout(function(){
            $scope.showSchedulingAlert = false;
         }, 3000);
      };

      $scope.scheduleMeeting = function(meeting) {
          meeting.sender = $rootScope.loginUser.username;
          var deferred = $q.defer();
          UserService.postRequest(urls.INSERT_MEETING_API, meeting)
          .then(
              function (response) {
                  console.log("Got schedule meeting response: " + response.data);
                  $scope.meeting = {};
                  $scope.getAllMeetings();
                  $scope.doGreeting();
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
          UserService.getRequest(urls.USER_ALL_MEETINGS)
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
	          UserService.postRequest(urls.FEEDBACK_INSERT_API, feedback)
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

	      $scope.getUserAllFeedback = function(meeting) {
            console.log("Getting users all feedback")
            $scope.updateDefault(meeting);
            var deferred = $q.defer();
            UserService.postRequest(urls.USER_All_FEEDBACK_API, meeting)
            .then(
                function (response) {
                    console.log("Got users all feedback response: " + JSON.stringify(response.data));
                    $scope.usersAllFeedbacks = response.data;
                    deferred.resolve();
                },
                function (errResponse) {
                   console.error('Error while getting users all feedbacks : '+ errResponse);
                   $scope.usersAllFeedbacks = [];
                   deferred.reject();
                }
            );
            return deferred.promise;
        }

        $scope.loadAllUsers = function() {
            console.log('Fetching all users');
            var deferred = $q.defer();
            UserService.getRequest(urls.USER_All_API)
                .then(
                    function (response) {
                        console.log('Fetched successfully all users');
                        $scope.users = response.data;
                        deferred.resolve();
                    },
                    function (errResponse) {
                        console.error('Error while loading users');
                        deferred.reject();
                    }
                );
            return deferred.promise;
        }

        $scope.loadAllUsers();
        $scope.getAllMeetings();

}]);