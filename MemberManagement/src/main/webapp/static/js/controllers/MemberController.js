'use strict';

/**
 * MemberController
 * @constructor
 */
var MemberController = function($scope, $http) {
    $scope.searchMember = {};
    $scope.editMode = false;
    
    $scope.loadAllMembers = function(searchStr) {
        $scope.resetError();

        $http.get('members/loadAllMembers').success(function(memberList) {
        	$scope.memberList = memberList;
        }).error(function() {
            $scope.setError('Could not load the member list');
        });
    };
    
    $scope.searchMember = function(searchStr) {
        $scope.resetError();

        $http.get('members/searchMember/' + searchStr).success(function(memberList) {
        	$scope.memberList = memberList;
        }).error(function() {
        	$scope.setError('Could not load the member list');
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
    
    $scope.loadAllMembers();

    $scope.predicate = 'id';
};