app.controller('ProductController',['$scope','ProductService',
  function($scope,ProductService){
	var self = this;
	self.error = "";
	self.products = [];
	self.agregar = agregarProducto;
	fetchAllProducts();
		
	function fetchAllProducts(){
		ProductService.fetchAllProducts()
		.then(function(data){
			self.products = data;
			self.error = "";
		},
		function(data){
			self.error = data;
		});
	}
	
	function agregarProducto(p) {
		ProductService.agregarProducto(p.idProducto)
		.then(function(data){
			console.log(data);
			p.mensaje ="fa fa-shopping-cart";
			self.error = "";
		},
		function(data){
			p.mensaje ="";
			self.error = data;
		});
    }
	
}])