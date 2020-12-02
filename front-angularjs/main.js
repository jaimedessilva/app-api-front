var app = angular.module("usuarioApp", []);

//Controller
app.controller("usuarioController", function($scope, $http){
    
    //Usuario Form
    $scope.usuarioForm = { 
        nome: "", 
        idade: 18 
    };
    
    // Now load the data from server
    //_refreshEmployeeData();
    _listAll();
    
    //Create
    $scope.create = function (usuarioForm){
        $http({
            method: 'POST',
            url: 'http://localhost:8080/api-rest/rest/api/',
            data: angular.toJson($scope.usuarioForm),
            headers: {
                'Content-Type': 'application/json'
            }}).then(_success, _error);
    };
    
    // HTTP POST/PUT methods for add/edit  
    // Call: http://localhost:8080/api-rest/rest/api/listar
    $scope.createUpdate = function(usuarioForm) {
 
        var method = "PUT";
        var url = 'http://localhost:8080/api-rest/rest/api/';

        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.usuarioForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };
 
    $scope.formClear = function() {
        _clearFormData();
    }
 
    // HTTP DELETE- delete employee by Id
    // Call: http://localhost:8080/employee/{empId}
    $scope.deleteUser = function(usuario) {
        $http({
            method: 'DELETE',
            url: 'http://localhost:8080/api-rest/rest/api/' + usuario.id
        }).then(_success, _error);
    };
    // In case of edit
    $scope.editForm = function(usuario) {
        $scope.usuarioForm.id = usuario.id;
        $scope.usuarioForm.nome = usuario.nome;
        $scope.usuarioForm.idade = usuario.idade;
    };
 
    // Private Method  
    // HTTP GET- get all Users collection
    // Call: http://localhost:8080/api-rest/rest/listar
    function _listAll() {
        $http({
            method: 'GET',
            url: 'http://localhost:8080/api-rest/rest/api/listar'
        }).then(
            function(res) { // success
                $scope.usuarios = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }
    function _success(res) {
        _listAll();
        _clearFormData();
    }
 
    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }
 
    // Clear the form
    function _clearFormData() {
        $scope.usuarioForm.id = 0;
        $scope.usuarioForm.nome = "";
        $scope.usuarioForm.idade = ""
    };

});
