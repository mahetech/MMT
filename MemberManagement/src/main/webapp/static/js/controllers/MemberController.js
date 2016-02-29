'use strict';

/**
 * MemberController
 * @constructor
 */
var MemberController = function($scope, $http) {
    $scope.searchMember = {};
    $scope.editMode = false;
    
    $scope.searchMember = function(searchStr) {
        $scope.resetError();

        $http.get('members/searchMember/' + searchStr).success(function(member) {
        	$scope.mem = member;
        }).error(function() {
            $scope.setError('Could not find the member');
        });
    };

    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };
    
    $scope.searchMember('abcd');

    $scope.predicate = 'id';
};