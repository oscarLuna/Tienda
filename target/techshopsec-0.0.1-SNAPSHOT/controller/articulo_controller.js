app.controller('ArticuloController',['$scope','CarritoService',

  function($scope,CarritoService){
	$scope.cantidad = 1;
    var self = this;
	self.products = [];
    self.error = "";
    self.mensaje = "";
    self.addItem = addItem;
    self.addICant = addICant;
    
  function addItem(idProducto) {
	    CarritoService.addItem(idProducto)
		.then(function(data){
			console.log(data);
			self.error = "";
			self.mensaje = "agregado al carrito";
		},
		function(data){
			self.error = data;
		});
    }
  
  function addICant(idProducto) {
	    CarritoService.addICant(idProducto, $scope.cantidad)
		.then(function(data){
			console.log(data);
			self.mensaje = "agregado al carrito";
			self.error = "";
		},
		function(data){
			self.error = data;
		});
  }
}])