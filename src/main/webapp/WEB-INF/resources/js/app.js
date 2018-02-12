var app = angular.module('app',[]);

app.controller('postController', function ($scope,$http) {
    var url = '/api/client';

    var config = {
        headers: {
            'Content-Type': 'application/json; charset=utf-8;'
        }
    }

    var data = {
        name: $scope.name
    };

    $http.post(url,data,config).then(function (response) {
        $scope.postResultMessage = "Successful!";
    }, function (response) {
        $scope.postResultMessage= 'Fail!';
    });

    $scope.name="";

});

app.controller('getallclientController',function($scope,$http){
    $scope.showAllClients = false;

    var url = '/api/clients';

    var config = {
        headers: {
            'Content-Type' : 'application/json; charset=utf-8;'
        }
    }

    $http.get(url,config).then(function (response) {
        if(response.data.status=='Done'){
            $scope.allclients=response.data;
            $scope.showAllClients = true;
        } else {
            $scope.getResultMessage = "Error finding all"
        }
        
    } , function (response) {
        $scope.getResultMessage="Fail";
    });
});
