app.service('elasticSearchService',function ($http) {
    this.searchItemList = function (map) {
        return $http.post('/findEntry.do',map);
    }

});
