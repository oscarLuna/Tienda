package com.mpersd.techshop.servicio;

import com.mpersd.techshop.dominio.Producto;
import com.mpersd.techshop.modelo.CarritoCompra;
import com.mpersd.techshop.modelo.ProductoCarrito;

public interface ICarritoService {
	public CarritoCompra agregarProductoCarrito(CarritoCompra carrito, Producto p);
	public CarritoCompra agregarProductoCarrito(CarritoCompra carrito, Producto p, int cantidad);
	public CarritoCompra eliminarProductoCarrito(CarritoCompra carrito, Producto p);
	public CarritoCompra actualizarProductoCarrito(CarritoCompra carrito, Producto p, int cantidad);
	
	public ProductoCarrito existeProducto(CarritoCompra carrito, Producto p);
	
	
}
