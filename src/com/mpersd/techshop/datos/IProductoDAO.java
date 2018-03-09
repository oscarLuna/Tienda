package com.mpersd.techshop.datos;

import java.util.List;

import com.mpersd.techshop.dominio.Producto;

public interface IProductoDAO {
	
	Producto newProduct(Producto producto);
	Producto updateProduct(Producto producto);
	void deleteProducto(int idProducto);
	
	Producto getProducto(int id);
	List<Producto> getProductos();
	List<Producto>getProductoBusqueda(String search);
	List<Producto> getProductosByCategory(String idCategoria);
		
}
