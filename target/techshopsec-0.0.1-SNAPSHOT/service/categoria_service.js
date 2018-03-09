app.factory('CategoriaService',['$http','$q',function($http,$q){

var REST_SERVICE_URI = "/techshopsec/api/categoria/";
	
	var factory = {
		listarCategorias : categorias,
		agregarCategoria : agregar
	};
	return factory;
	
	function categorias(){
		var deferred = $q.defer();
		$http.get(REST_SERVICE_URI)
		.then(function(response){
			deferred.resolve(response.data);
		},function(errResponse, status){
			console.log("Error recuperando categorias " + status + " " + errResponse);
			deferred.reject(errResponse)
		});
		return deferred.promise;
	};
	
	function agregar(idProducto){
		var deferred = $q.defer();
		$http.post(REST_SERVICE_URI+idProducto)
		.then(function(response){
			deferred.resolve(response.data);
		},function(errResponse, status){
			console.log("Error recuperando categorias " + status + " " + errResponse);
			deferred.reject(errResponse)
		});
		return deferred.promise;
	};
	
}]);