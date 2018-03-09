var app = angular.module("springapp", []);

app.controller("validarController", [
		'$scope',
		'$http',
		'$q',
		function($scope, $http, $q) {
			
			$scope.registroUsuario = registro;

			function buscarAsync(usuario) {
				var defered = $q.defer();
				var promise = defered.promise;

				$http.post("/techshopsec/api/usuario/",
						$scope.usuario).then(function(response) {
					console.log("promesa resuelta en $http");
					defered.resolve(response);
				}, function(response, status) {
					console.log("error en $http");
					defered.reject(response);
				});
				return promise;
			}

			function registro() {
				var futuro = buscarAsync($scope.usuario);
				futuro.then(function(response, status, header, config) {
					console.log(JSON.stringify(response));
					window.location = "login";
				}, function(data, status, header, config) {
					$scope.mensaje = "Error al crear usuario";
					console.log(status);
				});
			}

			function reset() {
				$scope.usuario = {};
			}
		} ]);