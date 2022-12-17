angular.module('app',[]).controller('showController',function ($scope, $http){
    const contextPath = "http://localhost:8181/app/products";

    $scope.displayProduct = function () {
        $http.get(contextPath + "/all")
            .then(function(response) {
                 $scope.ProductList = response.data;
            });
    };

    $scope.displayProduct();
});
