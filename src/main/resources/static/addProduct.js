angular.module('app',[]).controller('addController',function ($scope, $http){
    const contextPath = "http://localhost:8181/app/products/add";


    $scope.addProduct = function(){
    $scope.var1 = $scope.title;
     $scope.var2 = $scope.price;
        $http.get(contextPath +"?title=" +var1+"&cost=" +var2)
        .then(function(response) {
                     });
    };

    $scope.showProductList = function(){
        $http.get(contextPath + "/allProducts")
        .then(function(response) {
         });
    }

   // $scope.addProduct();
    //$scope.showProductList();
});