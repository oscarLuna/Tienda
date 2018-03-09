var app = angular.module("springapp",[]);

app.config(['$httpProvider', function($httpProvider) {
	  $httpProvider.interceptors.push('AuthInterceptor');
	}]);