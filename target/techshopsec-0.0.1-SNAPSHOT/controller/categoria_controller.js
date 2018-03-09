app.controller('CategoriaController',['$scope','CategoriaService',
  function($scope,CategoriaService){
    var self = this;
    self.categorias = [];
    listarCategorias();
    
    function listarCategorias(){
      CategoriaService.listarCategorias()
      .then(function(data){
        self.categorias = data;
      },
      function(data){
        console.log(data);
      });
    }
    
}])