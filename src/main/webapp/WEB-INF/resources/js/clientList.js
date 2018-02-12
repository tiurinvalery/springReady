angular
    .module('webapp',['ngResourse'])
    .service('ClientService', function($log,$resource){
        return {
            getAll: function () {
                var clientRes = $resource('clients', {}, {
                    query: {method: 'GET', params: {}, isArray: true}
                });
                return clientRes.query();
            }
        }
    })
        .controller('ClientController',function($scope,$log,ClientService) {
            $scope.clients.getAll();
        });

