var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080',
    USER_SERVICE_API : 'http://localhost:8080/api/user/',
    USER_All_API : 'http://localhost:8080/api/get/all/users/',
    USER_LOGIN_API : 'http://localhost:8080/api/login/',
    INSERT_MEETING_API : 'http://localhost:8080/api/insert/meeting/',
    USER_ALL_MEETINGS : 'http://localhost:8080/api/get/all/meetings/',
    FEEDBACK_INSERT_API : 'http://localhost:8080/api/insert/feedback/',
    USER_All_FEEDBACK_API : 'http://localhost:8080/api/get/user/feedbacks/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/oneonone',
                controller:'OneononeController',
                controllerAs:'ctrl',
                resolve: {
                    users: function ($q, UserService) {
                        console.log('Load all users');
                        var deferred = $q.defer();
                        UserService.loadAllUsers().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);

