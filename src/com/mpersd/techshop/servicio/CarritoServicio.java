package com.mpersd.techshop.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mpersd.techshop.dominio.Producto;
import com.mpersd.techshop.modelo.CarritoCompra;
import com.mpersd.techshop.modelo.ProductoCarrito;

@Service
public class CarritoServicio implements ICarritoService {

	public CarritoServicio() {
	}

	@Override
	public CarritoCompra agregarProductoCarrito(CarritoCompra carrito, Producto p) {
		if (carrito == null) {
			carrito = new CarritoCompra();
			ProductoCarrito productoCarrito = new ProductoCarrito();
			productoCarrito.setProducto(p);
			productoCarrito.setCantidad(1);
			productoCarrito.setSubtotal(p.getPrecio());
			
			carrito.setProducto(productoCarrito);
			
		} else {
			ProductoCarrito producto = existeProducto(carrito, p);

			if (producto == null) {
				producto = new ProductoCarrito();
				producto.setProducto(p);
				producto.setCantidad(1);
				producto.setSubtotal(producto.getProducto().getPrecio());
				carrito.setProducto(producto);
			} else {
				producto.setCantidad(producto.getCantidad() + 1);
				producto.setSubtotal(producto.getCantidad() * producto.getProducto().getPrecio());
				carrito.calcularCantidadTotal();
				carrito.calcularPrecioTotal();
			}

		}
		return carrito;
	}

	@Override
	public CarritoCompra eliminarProductoCarrito(CarritoCompra carrito, Producto p) {
		if (carrito == null) {
			carrito = new CarritoCompra();
		}else{
			ProductoCarrito producto = existeProducto(carrito, p);
			if(producto!=null){
				List<ProductoCarrito> productos = carrito.getProductos();
				productos.remove(producto);
				carrito.setProductos(productos);
			}
		}
		return carrito;
	}
	
	@Override
	public CarritoCompra actualizarProductoCarrito(CarritoCompra carrito, Producto p, int cantidad) {
		ProductoCarrito producto = existeProducto(carrito, p);
		producto.setCantidad(cantidad);
		producto.setSubtotal(producto.getCantidad() * producto.getProducto().getPrecio());
		carrito.calcularCantidadTotal();
		carrito.calcularPrecioTotal();
		return carrito;
	}

	@Override
	public ProductoCarrito existeProducto(CarritoCompra carrito, Producto p) {
		List<ProductoCarrito> productos = carrito.getProductos();

		for (ProductoCarrito pCarrito : productos) {
			if (pCarrito.getProducto().getIdProducto() == p.getIdProducto()) {
				return pCarrito;
			}
		}
		return null;
	}

	@Override
	public CarritoCompra agregarProductoCarrito(CarritoCompra carrito, Producto p, int cantidad) {
		if (carrito == null) {
			carrito = new CarritoCompra();
			ProductoCarrito productoCarrito = new ProductoCarrito();
			productoCarrito.setProducto(p);
			productoCarrito.setCantidad(cantidad);
			productoCarrito.setSubtotal(p.getPrecio());
			
			carrito.setProducto(productoCarrito);
			
		} else {
			ProductoCarrito producto = existeProducto(carrito, p);

			if (producto == null) {
				producto = new ProductoCarrito();
				producto.setProducto(p);
				producto.setCantidad(cantidad);
				producto.setSubtotal(producto.getProducto().getPrecio());
				carrito.setProducto(producto);
			} else {
				producto.setCantidad(producto.getCantidad() + cantidad);
				producto.setSubtotal(producto.getCantidad() * producto.getProducto().getPrecio());
				carrito.calcularCantidadTotal();
				carrito.calcularPrecioTotal();
			}

		}
		return carrito;
	}
}
