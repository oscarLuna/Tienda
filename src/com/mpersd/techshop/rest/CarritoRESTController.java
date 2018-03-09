package com.mpersd.techshop.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mpersd.techshop.dominio.Producto;
import com.mpersd.techshop.modelo.CarritoCompra;
import com.mpersd.techshop.servicio.ICarritoService;
import com.mpersd.techshop.servicio.IProductoServicio;

@RestController
public class CarritoRESTController {
	@Autowired
	IProductoServicio pServ;
	@Autowired
	ICarritoService cServ;
	
	public CarritoRESTController() {
		System.out.println("carrito REST");
	}
	
	@RequestMapping(value = "/api/carrito/{id}", method = RequestMethod.POST)
	public ResponseEntity<CarritoCompra> productoCart(@PathVariable("id") int id, HttpServletRequest request) {
		System.out.println("agregando desde carrito");
		CarritoCompra carrito = (CarritoCompra) request.getSession().getAttribute("carrito");
				
		Producto p = pServ.getProducto(id);

		carrito = cServ.agregarProductoCarrito(carrito, p);
		
		request.getSession().setAttribute("carrito", carrito);
		
		return new ResponseEntity<CarritoCompra>(carrito, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/carrito/{id}/{cantidad}", method = RequestMethod.POST)
	public ResponseEntity<CarritoCompra> productoCartCant(@PathVariable("id") int id, @PathVariable("cantidad") int cantidad, HttpServletRequest request) {
		System.out.println("agregando desde carrito" + id + cantidad);
		
		CarritoCompra carrito = (CarritoCompra) request.getSession().getAttribute("carrito");	
		Producto p = pServ.getProducto(id);
		
		carrito = cServ.agregarProductoCarrito(carrito, p, cantidad);
		
		request.getSession().setAttribute("carrito", carrito);
		
		return new ResponseEntity<CarritoCompra>(carrito, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/carrito/", method = RequestMethod.GET)
	public ResponseEntity<CarritoCompra> productoCart(HttpServletRequest request) {

		CarritoCompra carrito = (CarritoCompra) request.getSession().getAttribute("carrito");
		if(carrito == null){
			return new ResponseEntity<CarritoCompra>(carrito, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<CarritoCompra>(carrito, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/carrito/", method = RequestMethod.DELETE)
	public ResponseEntity<CarritoCompra> emptyCart(HttpServletRequest request) {
		CarritoCompra carrito = new CarritoCompra();
		request.getSession().setAttribute("carrito", carrito);
		
		return new ResponseEntity<CarritoCompra>(carrito, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/carrito/{id}/{cantidad}", method = RequestMethod.PUT)
	public ResponseEntity<CarritoCompra> updateProductCart(@PathVariable("id") int id,
														@PathVariable("cantidad") int cantidad, 
														HttpServletRequest request) {		
		CarritoCompra carrito = (CarritoCompra) request.getSession().getAttribute("carrito");
		Producto p = pServ.getProducto(id);

		carrito = cServ.actualizarProductoCarrito(carrito, p, cantidad);
		
		request.getSession().setAttribute("carrito", carrito);
		
		return new ResponseEntity<CarritoCompra>(carrito, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/carrito/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<CarritoCompra> removeProductoCart(@PathVariable("id") int id, HttpServletRequest request) {

		CarritoCompra carrito = (CarritoCompra) request.getSession().getAttribute("carrito");
		Producto p = pServ.getProducto(id);
		
		carrito = cServ.eliminarProductoCarrito(carrito, p);
		
		request.getSession().setAttribute("carrito", carrito);
		
		return new ResponseEntity<CarritoCompra>(carrito,HttpStatus.OK);
	}
	
}
