package com.mpersd.techshop.servicio;

import java.util.List;
import com.mpersd.techshop.dominio.Producto;

public interface IProductoServicio {
	Producto newProduct(Producto producto);
	Producto updateProduct(Producto producto);
	void deleteProducto(int idProducto);
	
	
	Producto getProducto(int id);
	List<Producto>getProductoBusqueda(String search);
	List<Producto> getProductos();
	List<Producto> getProductosByCategory(String idCategoria);
	
}
