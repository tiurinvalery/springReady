<!DOCTYPE html ng-app="myApp">
<html ng-controller="UsersController">
<!-- header code -->
<body>

<div ng-repeat="user in users">{{client.name}}</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${ContextPath}/resources/js/clientList.js"></script>
<script src="${ContextPath}/resources/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${ContextPath}/resources/css/bootstrap.min.css">
</body>
</html>