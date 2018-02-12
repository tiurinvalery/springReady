<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Client create</title>

    <style type="text/css">
        span.error{
            color: red;
            margin-left: 5px;
        }
    </style>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="${ContextPath}/resources/js/appController.js"></script>
    <script src="${ContextPath}/resources/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${ContextPath}/resources/css/bootstrap.min.css">

</head>
<body>
<h1>Client Input Form</h1>
<div>
    <div class = "row">
        <div class="col-lg-offset-2 col-lg-8">
            <div class="btn-group" role="group">
                <button ng-click="vm.getAll()" type="button" class="btn btn-default">All</button>
            </div>
            <table class="table">
                <thead>
                <tr>
                    <th>Client name</th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="clients in vm.clients">
                    <td>{{client.name}}</td>
                    <td>
                        <button class="btn btn-danger" ng-click="vm.deleteClient(client.id)">Delete</button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>


<!-- Result Container  -->
    <div id="resultContainer" style="display: none;">
        <hr/>
        <h4 style="color: green;">JSON Response From Server</h4>
        <pre style="color: green;">
        <code></code>
        </pre>
    </div>
</div>
</body>
</html>