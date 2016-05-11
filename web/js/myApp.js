var app = angular.module('myApp', ['ui.bootstrap', 'ngResource']);

app.filter('unsafe', function ($sce) {
    return $sce.trustAsHtml;
});

app.controller('myCtrl', ['$scope', '$resource', '$http', function ($scope, $resource, $http) {
    $scope.clientLevel = {
        levelOneID: 0,
        levelTwoID: 0,
        levelThreeID: 0,
        levelFourID: 0,
        listingName: '',
        listingDescription: '',
        versionID: 0,
        bookName: '',
        pageNumber: 0,
        levelTwo: [],
        levelThree: [],
        levelFour: []
    };

    $scope.displayView = 'GET';
    $scope.setLevel = '';
    $scope.headerTitle = '';

    $scope.getDataFromServer = function () {
        var dataFromServer = $resource('Level/One', {}, {query: {method: 'GET', isArray: true}})
        var response = dataFromServer.query();
        response.$promise.then(function (data) {
            $scope.serverData = angular.fromJson(data);
        })
    };

    $scope.sendLevelOne = function (method, node) {
        var dataFromServer = $resource('Level/One/' + node, {}, {'call': {method: method}});
        var response = dataFromServer.call({
            levelOneID: $scope.clientLevel.levelOneID,
            listingName: $scope.clientLevel.listingName,
            listingDescription: $scope.clientLevel.listingDescription,
            versionID: $scope.clientLevel.versionID,
            bookName: $scope.clientLevel.bookName,
            pageNumber: $scope.clientLevel.pageNumber,
            levelTwo: $scope.clientLevel.levelTwo
        });
        response.$promise.then(function (data) {
            $scope.serverData = angular.fromJson(data);
            if ($scope.serverData.status == 'FAIL') {
                alert(angular.fromJson($scope.serverData));
            }
            $scope.getDataFromServer();
        })
    };

    $scope.sendLevelTwo = function (method, node) {
        var dataFromServer = $resource('Level/Two/' + node, {}, {'call': {method: method}});
        var response = dataFromServer.call({
            levelTwoID: $scope.clientLevel.levelTwoID,
            levelOneID: $scope.clientLevel.levelOneID,
            listingName: $scope.clientLevel.listingName,
            listingDescription: $scope.clientLevel.listingDescription,
            versionID: $scope.clientLevel.versionID,
            bookName: $scope.clientLevel.bookName,
            pageNumber: $scope.clientLevel.pageNumber,
            levelThree: $scope.clientLevel.levelThree
        });
        response.$promise.then(function (data) {
            $scope.serverData = angular.fromJson(data);
            if ($scope.serverData.status == 'FAIL') {
                alert(angular.fromJson($scope.serverData));
            }
            $scope.getDataFromServer();
        })
    };

    $scope.sendLevelThree = function (method, node) {
        var dataFromServer = $resource('Level/Three/' + node, {}, {'call': {method: method}});
        var response = dataFromServer.call({
            levelThreeID: $scope.clientLevel.levelThreeID,
            levelTwoID: $scope.clientLevel.levelTwoID,
            listingName: $scope.clientLevel.listingName,
            listingDescription: $scope.clientLevel.listingDescription,
            versionID: $scope.clientLevel.versionID,
            bookName: $scope.clientLevel.bookName,
            pageNumber: $scope.clientLevel.pageNumber,
            levelFour: $scope.clientLevel.levelFour
        });
        response.$promise.then(function (data) {
            $scope.serverData = angular.fromJson(data);
            if ($scope.serverData.status == 'FAIL') {
                alert(angular.fromJson($scope.serverData));
            }
            $scope.getDataFromServer();
        })
    };

    $scope.sendLevelFour = function (method, node) {
        var dataFromServer = $resource('Level/Four/' + node, {}, {'call': {method: method}});
        var response = dataFromServer.call({
            levelFourID: $scope.clientLevel.levelFourID,
            levelThreeID: $scope.clientLevel.levelThreeID,
            listingName: $scope.clientLevel.listingName,
            listingDescription: $scope.clientLevel.listingDescription,
            versionID: $scope.clientLevel.versionID,
            bookName: $scope.clientLevel.bookName,
            pageNumber: $scope.clientLevel.pageNumber
        });
        response.$promise.then(function (data) {
            $scope.serverData = angular.fromJson(data);
            if ($scope.serverData.status == 'FAIL') {
                alert(angular.fromJson($scope.serverData));
            }
            $scope.getDataFromServer();
        })
    };

    $scope.resetForm = function () {

    };

    $scope.initClientLevel = function () {
        $scope.clientLevel.levelOneID = 0;
        $scope.clientLevel.levelTwoID = 0;
        $scope.clientLevel.levelThreeID = 0;
        $scope.clientLevel.levelFourID = 0;
        $scope.clientLevel.name = "";
        $scope.clientLevel.description = "";
        $scope.clientLevel.versionID = 0;
        $scope.clientLevel.bookName = "";
        $scope.clientLevel.pageNumber = 0;
        $scope.clientLevel.levelTwo = [];
        $scope.clientLevel.levelThree = [];
        $scope.clientLevel.levelFour = [];
    };

    $scope.setClientLevel = function (inLevel) {
        $scope.clientLevel = angular.fromJson(inLevel);
    }

    $scope.setDisplayView = function (view) {
        $scope.displayView = view.toString();
    }

}])
;