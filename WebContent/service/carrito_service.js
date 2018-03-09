app.factory('CarritoService',['$http','$q',function($http,$q){

	var REST_SERVICE_URI = "/techshopsec/api/carrito/";
	
	var factory = {
		fetchAllItems : allItems,
		addItem : addI,
		deleteItem : deleteI,
		updateItem : updateI,
		addICant : addICantidad,
		deleteCart : deleteC
		};
	return factory;

	function allItems(){
		var deferred = $q.defer();
		$http.get(REST_SERVICE_URI)
		.then(function(response){
			deferred.resolve(response.data);
		},function(errResponse, status){
			console.log("Error recuperando datos del carrito" + status + " " + errResponse);
			deferred.reject(errResponse)
		});
		return deferred.promise;
	};
	
	function addI(idProducto){
		var deferred = $q.defer();
		$http.post(REST_SERVICE_URI+idProducto)
		.then(function(response){
			deferred.resolve(response.data);
		},function(errResponse, status){
			console.log("Error recuperando datos carrito" + status + " " + errResponse);
			deferred.reject(errResponse)
		});
		return deferred.promise;
	};
	
	function addICantidad(idProducto,cantidad){
		var deferred = $q.defer();
		$http.post(REST_SERVICE_URI+idProducto+"/"+cantidad)
		.then(function(response){
			deferred.resolve(response.data);
		},function(errResponse, status){
			console.log("Error recuperando datos carrito" + status + " " + errResponse);
			deferred.reject(errResponse)
		});
		return deferred.promise;
	};
	
	function deleteI(idProducto){
		var deferred = $q.defer();
		$http.delete(REST_SERVICE_URI+idProducto)
		.then(function(response){
			deferred.resolve(response.data);
		},function(errResponse, status){
			console.log("Error recuperando datos carrito" + status + " " + errResponse);
			deferred.reject(errResponse)
		});
		return deferred.promise;
	};
	
	function deleteC(){
		var deferred = $q.defer();
		$http.delete(REST_SERVICE_URI)
		.then(function(response){
			deferred.resolve(response.data);
		},function(errResponse, status){
			console.log("Error recuperando datos carrito" + status + " " + errResponse);
			deferred.reject(errResponse)
		});
		return deferred.promise;
	};
	
	function updateI(idProducto,cantidad){
		var deferred = $q.defer();
		$http.put(REST_SERVICE_URI+idProducto+"/"+cantidad)
		.then(function(response){
			deferred.resolve(response.data);
		},function(errResponse, status){
			console.log("Error recuperando datos carrito" + status + " " + errResponse);
			deferred.reject(errResponse)
		});
		return deferred.promise;
	};
	
}]);