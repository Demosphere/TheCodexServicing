var app = angular.module('myApp', ['ui.bootstrap', 'ngResource']);

app.filter('unsafe', function ($sce) {
    return $sce.trustAsHtml;
});

app.controller('myCtrl', ['$scope', '$resource', '$http', function ($scope, $resource, $http) {
    $scope.clientLevel = {};
    $scope.displayView = 'GET';
    $scope.setLevel = '';
    $scope.headerTitle = '';

    $scope.getDataFromServer = function () {
        var dataFromServer = $resource('/Level/One', {}, {query: {method: 'GET',isArray: true}})
        var response = dataFromServer.query();
        response.$promise.then(function (data) {
            $scope.serverData = angular.fromJson(data);
        })
    };

    $scope.sendLevelOne = function (method) {
        var dataFromServer = $resource('/Level/One', {},{'call': {method: method}});
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
            if($scope.serverData.status == 'FAIL') {
                alert(angular.fromJson($scope.serverData));
            }
            $scope.getDataFromServer();
        })
    };

    $scope.sendLevelTwo = function (method) {
        var dataFromServer = $resource('/Level/Two', {}, {'call': {method: method}});
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
            if($scope.serverData.status == 'FAIL') {
                alert(angular.fromJson($scope.serverData));
            }
            $scope.getDataFromServer();
        })
    };

    $scope.sendLevelThree = function (method) {
        var dataFromServer = $resource('/Level/Three', {}, {'call': {method: method}});
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
            if($scope.serverData.status == 'FAIL') {
                alert(angular.fromJson($scope.serverData));
            }
            $scope.getDataFromServer();
        })
    };

    $scope.sendLevelFour = function (method) {
        var dataFromServer = $resource('/Level/Four', {}, {'call': {method: method}});
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
            if($scope.serverData.status == 'FAIL') {
                alert(angular.fromJson($scope.serverData));
            }
            $scope.getDataFromServer();
        })
    };

    $scope.resetForm = function () {
        $scope.child.level = "Two";
        $scope.child.parent = null;
        $scope.child.name = "No";
        $scope.child.description = "";
        $scope.child.bookName = "";
        $scope.child.pageNumber = "";
        $scope.children = "True";
    };

    $scope.initClientLevel = function () {
        clientLevel.levelOneID = 0;
        clientLevel.levelTwoID = 0;
        clientLevel.levelThreeID = 0;
        clientLevel.levelFourID = 0;
        clientLevel.name = "";
        clientLevel.description = "";
        clientLevel.versionID = 0;
        clientLevel.bookName = "";
        clientLevel.pageNumber = 0;
        clientLevel.levelTwo = [];
        clientLevel.levelThree = [];
        clientLevel.levelFour = [];
    };

    $scope.setClientLevel = function (inLevel) {
        $scope.clientLevel = angular.fromJson(inLevel);
    }

    $scope.setDisplayView = function (view) {
        $scope.displayView = view.toString();
    }

    $scope.sendLevelOneDelete = function (method) {
        $http({
            method: method,
            url: '/Level/One',
            data: {
                'levelOneID': $scope.clientLevel.levelOneID,
                'listingName': $scope.clientLevel.listingName,
                'listingDescription': $scope.clientLevel.listingDescription,
                'versionID': $scope.clientLevel.versionID,
                'bookName': $scope.clientLevel.bookName,
                'pageNumber': $scope.clientLevel.pageNumber,
                'levelTwo': $scope.clientLevel.levelTwo
            }
        }).success(function (response) {
            $scope.serverData = angular.fromJson(response);
            $scope.getDataFromServer();
        }).error(function (response) {
            alert("Error:\n " + (angular.fromJson(response)));
        });
    }

    $scope.sendLevelTwoDelete = function (method) {
        $http({
            method: method,
            url: '/Level/Two',
            data: {
                'levelTwoID': $scope.clientLevel.levelTwoID,
                'levelOneID': $scope.clientLevel.levelOneID,
                'listingName': $scope.clientLevel.listingName,
                'listingDescription': $scope.clientLevel.listingDescription,
                'versionID': $scope.clientLevel.versionID,
                'bookName': $scope.clientLevel.bookName,
                'pageNumber': $scope.clientLevel.pageNumber,
                'levelThree': $scope.clientLevel.levelThree
            }
        }).success(function (response) {
            $scope.serverData = angular.fromJson(response);
            $scope.getDataFromServer();
        }).error(function (response) {
            alert("Error:\n " + (angular.fromJson(response)));
        });
    }

    $scope.sendLevelThreeDelete = function (method) {
        $http({
            method: method,
            url: '/Level/Three',
            data: {
                'levelThreeID': $scope.clientLevel.levelThreeID,
                'levelTwoID': $scope.clientLevel.levelTwoID,
                'listingName': $scope.clientLevel.listingName,
                'listingDescription': $scope.clientLevel.listingDescription,
                'versionID': $scope.clientLevel.versionID,
                'bookName': $scope.clientLevel.bookName,
                'pageNumber': $scope.clientLevel.pageNumber,
                'levelFour': $scope.clientLevel.levelFour
            }
        }).success(function (response) {
            $scope.serverData = angular.fromJson(response);
            $scope.getDataFromServer();
        }).error(function (response) {
            alert("Error:\n " + (angular.fromJson(response)));
        });
    }

    $scope.sendLevelFourDelete = function (method) {
        $http({
            method: method,
            url: '/Level/Four',
            data: {
                'levelFourID': $scope.clientLevel.levelFourID,
                'levelThreeID': $scope.clientLevel.levelThreeID,
                'listingName': $scope.clientLevel.listingName,
                'listingDescription': $scope.clientLevel.listingDescription,
                'versionID': $scope.clientLevel.versionID,
                'bookName': $scope.clientLevel.bookName,
                'pageNumber': $scope.clientLevel.pageNumber,
            }
        }).success(function (response) {
            $scope.parsedData = angular.fromJson(response);
            $scope.getDataFromServer();
        }).error(function (response) {
            alert("Error:\n " + (angular.fromJson(response)));
        });
    }

}])
;