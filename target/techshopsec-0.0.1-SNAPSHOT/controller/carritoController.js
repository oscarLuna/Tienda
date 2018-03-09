app.controller('CarritoController',['$scope','CarritoService',
    function($scope,CarritoService){  
		var self = this;
		self.error = "";
		self.carrito;
		self.numeroItems;
		self.precioTotal;
		self.deleteItem = deleteItem;
		self.updateItem = updateItem;
		self.deleteCart = deleteCart;
		self.pedido = pedido;
		$scope.cantidad;
		fetchAllItemsCart();
		
		function pedido(){
			console.log("pedido");
			window.location="orden";
		}
		function fetchAllItemsCart(){
			CarritoService.fetchAllItems()
			.then(function(data){
				self.carrito = data;
				self.error = "";
				console.log(data.cantidadTotal);
				self.numeroItems = self.carrito.cantidadTotal;
				self.precioTotal = self.carrito.precioTotal;
			},
			function(data){
				self.error = data;
			});
		}
		
		function deleteItem(id){
			CarritoService.deleteItem(id)
			.then(
			fetchAllItemsCart,
			function(data){
				self.error = data;
			});
		}
		
		function deleteCart(){
			console.log("borrando");
			CarritoService.deleteCart()
			.then(
			fetchAllItemsCart,
			function(data){
				self.error = data;
			});
		}
		
		
		function updateItem(c){
			CarritoService.updateItem(c.producto.idProducto,c.cantidad)
			.then(
			fetchAllItemsCart,
			function(data){
				self.error = data;
			});
		}
}])