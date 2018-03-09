package com.mpersd.techshop.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mpersd.techshop.dominio.Producto;
import com.mpersd.techshop.servicio.IProductoServicio;

@RestController
public class ProductosRESTController {

	@Autowired
	IProductoServicio pServ;

	public ProductosRESTController() {
		System.out.println("producto rest");
	}

	@RequestMapping(value = "/api/producto/", method = RequestMethod.POST)
	public ResponseEntity<Producto> createUser(@RequestBody Producto producto) {
		System.out.println("Creating User " + producto.toString());

		Producto p = pServ.newProduct(producto);
		return new ResponseEntity<Producto>(p, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/api/producto/{id}", method = RequestMethod.GET)
	public ResponseEntity<Producto> productById(@PathVariable("id") int id) {
		System.out.println(id);
		Producto producto = pServ.getProducto(id);
		if (producto == null) {
			return new ResponseEntity<Producto>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Producto>(producto, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/api/productos/{search}", method = RequestMethod.GET)
	public ResponseEntity<List<Producto>> productById(@PathVariable("search") String search) {
		List<Producto> productos = pServ.getProductoBusqueda(search);
		if (productos == null) {
			return new ResponseEntity<List<Producto>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/api/producto/", method = RequestMethod.GET)
	public ResponseEntity<List<Producto>> getAllProducts() {
		List<Producto> productos = pServ.getProductos();
		if (productos.isEmpty()) {
			return new ResponseEntity<List<Producto>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/api/producto/", method = RequestMethod.PUT)
	public ResponseEntity<Producto> updateProducto(@RequestBody Producto producto) {
		Producto p = pServ.getProducto(producto.getIdProducto());
		if (p == null) {
			return new ResponseEntity<Producto>(HttpStatus.NO_CONTENT);
		} else {
			pServ.updateProduct(producto);
			return new ResponseEntity<Producto>(producto, HttpStatus.OK);
		}
	}
}
