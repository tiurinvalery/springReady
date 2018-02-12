<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Client</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="${ContextPath}/resources/js/app.js"></script>
    <script src="${ContextPath}/resources/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${ContextPath}/resources/css/bootstrap.min.css">
</head>
<body>
<div class="container" ng-app="app">
    <h1>AngularJS - Spring JPA - MySQL</h1>

    <div class="row">
        <div ng-controller="postController" class="col-md-3">
            <form name="customerForm" ng-submit="submitForm()">
                <label>ClientName</label>
                <input type="text" name="firstname"	class="form-control" ng-model="clientname" />

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
            <p>{{postResultMessage}}</p>
        </div>
    </div>
    <div class="row">
        <div ng-controller="getallclientController" class="col-md-3">
            <h3>All Clients</h3>

            <button ng-click="">Get All Clients</button>

            <div ng-show="showAllClients">
                <ul class="list-group">
                    <li ng-repeat="client in allclient.data"><h4 class="list-group-item">
                        <strong>Client {{$index}}</strong><br />
                        Id: {{client.id}}<br />
                        Client Name: {{client.name}}
                    </h4></li>
                </ul>
            </div>
            <p>{{getResultMessage}}</p>
        </div>


    </div>
</div>
</body>
</html>