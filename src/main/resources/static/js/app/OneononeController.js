'use strict';

angular.module('crudApp').controller('OneononeController', ['UserService', '$scope',  function( UserService, $scope) {

			console.log("hahahahhahhhh");
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

      $scope.loginUser = function(login) {
          console.log('About to login user');
          UserService.loginUser(login)
              .then(
                  function (response) {
                      console.log('User created successfully' + response.data);
                      $('.login-form').addClass("hide");
                      $('.landing').removeClass("hide");
                  },
                  function (errResponse) {
                      console.error('Error while creating User');
                  }
              );
      }

}]);