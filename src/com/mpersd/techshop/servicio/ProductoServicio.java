package com.mpersd.techshop.servicio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpersd.techshop.datos.IProductoDAO;
import com.mpersd.techshop.dominio.Producto;

@Service
public class ProductoServicio implements IProductoServicio{
	
	@Autowired
	IProductoDAO pServ;
	
	public ProductoServicio() {
		System.out.println("producto servicio");
	}

	@Override @Transactional
	public Producto newProduct(Producto producto) {
		Producto p = pServ.newProduct(producto);
		return p;
	}

	@Override @Transactional
	public Producto updateProduct(Producto producto) {
		Producto p = pServ.updateProduct(producto);
		return p;
	}

	@Override @Transactional
	public void deleteProducto(int idProducto) {
		pServ.deleteProducto(idProducto);
	}

	@Override
	public Producto getProducto(int id) {
		Producto p = pServ.getProducto(id);
		return p;
	}

	@Override
	public List<Producto> getProductos() {
		List<Producto> productos = pServ.getProductos();
		return productos;
	}

	@Override
	public List<Producto> getProductosByCategory(String idCategoria) {
		List<Producto> productos = pServ.getProductosByCategory(idCategoria);
		return productos;
	}

	@Override
	public List<Producto> getProductoBusqueda(String search) {
		List<Producto> productos = pServ.getProductoBusqueda(search);
		return productos;
	}
}
