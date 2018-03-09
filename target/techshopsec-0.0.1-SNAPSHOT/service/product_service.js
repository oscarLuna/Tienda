app.factory('ProductService',['$http','$q',function($http,$q){
	
	var REST_SERVICE_URI = "/techshopsec/api/producto/";
	
	var factory = {
		fetchAllProducts : allProducts,
		agregarProducto : agregar
	};
	return factory;
	
	function allProducts(){
		var deferred = $q.defer();
		$http.get(REST_SERVICE_URI)
		.then(function(response){
			deferred.resolve(response.data);
		},function(errResponse, status){
			console.log("Error recuperando datos " + status + " " + errResponse);
			deferred.reject(errResponse)
		});
		return deferred.promise;
	};
	
	function agregar(idProducto){
		var deferred = $q.defer();
		$http.post("/techshopsec/api/carrito/"+idProducto)
		.then(function(response){
			deferred.resolve(response.data);
		},function(errResponse, status){
			console.log("Error recuperando datos " + status + " " + errResponse);
			deferred.reject(errResponse)
		});
		return deferred.promise;
	};
	
}]);