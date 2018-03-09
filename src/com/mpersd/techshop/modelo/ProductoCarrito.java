package com.mpersd.techshop.modelo;

import com.mpersd.techshop.dominio.Producto;

public class ProductoCarrito {
	
	private Producto producto;
	private int cantidad;
	private double subtotal;
	
	public ProductoCarrito() {
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	
}
