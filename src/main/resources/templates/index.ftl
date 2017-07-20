<!DOCTYPE html>

<html lang="en" ng-app="crudApp">
    <head>
        <title>${title}</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" type="text/css" href="css/jquery.timepicker.css" />
        <link href="css/app.css" rel="stylesheet"/>
    </head>
    <body>
        <div ui-view></div>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script src="js/lib/jquery.timepicker.min.js"></script>
        <script src="js/lib/angular.min.js" ></script>
        <script src="js/lib/angular-ui-router.min.js" ></script>
        <script src="js/lib/localforage.min.js" ></script>
        <script src="js/lib/ngStorage.min.js"></script>
        <script src="js/lib/bootstrap.min.js"></script>
        <script src="js/app/app.js"></script>
        <script src="js/app/UserService.js"></script>
        <script src="js/app/OneononeController.js"></script>
    </body>
</html>