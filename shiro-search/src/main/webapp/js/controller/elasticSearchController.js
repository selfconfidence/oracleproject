app.controller("elasticSearchController",function ($scope,elasticSearchService) {

    $scope.map={'pagenum':0,'size':40,'title':''};

    $scope.searchItemList=function () {
        elasticSearchService.searchItemList($scope.map).success(
            function (response) {
                $scope.totocount=response;
            }
            
        )};

});