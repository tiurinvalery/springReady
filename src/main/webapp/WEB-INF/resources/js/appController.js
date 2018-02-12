(function () {
    'use strict';

    angular
        .module('app')
        .controller('ClientRestController', ClientRestController)

    ClientRestController.$inject= ['$http'];

    function ClientRestController($http) {
        var vm = this;

        vm.getAll = getAll();
        vm.clients = [];
        vm.deleteClient = deleteClient();
        init();

       function init()
        {
            getAll();
        }

        function getAll() {
            var url = "/api/all"
            
            var clients = $http.get(url);
                clients.then(function(response){
                    vm.clients=response.data;
                });
        }
    }
        function deleteClient(id) {
            var url = "api/delete/"+id;
            $http.post(url).then(function (response) {
                vm.clients = response.data;
            })
        }

})();