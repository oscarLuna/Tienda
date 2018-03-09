package com.mpersd.techshop.modelo;

import java.util.ArrayList;
import java.util.List;

public class CarritoCompra {
	private List<ProductoCarrito> productos;
	private double precioTotal;
	private int cantidadTotal;
	
	public CarritoCompra() {
		this.productos = new ArrayList<>();
		this.precioTotal = 0;
		this.cantidadTotal = 0;
	}

	public List<ProductoCarrito> getProductos() {
		return productos;
	}
	
	public void setProductos(List<ProductoCarrito> productos) {
		this.productos = productos;
		this.calcularCantidadTotal();
		this.calcularPrecioTotal();	
	}

	public void setProducto(ProductoCarrito producto) {
		this.productos.add(producto);
		this.calcularCantidadTotal();
		this.calcularPrecioTotal();	
	}
	
	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public int getCantidadTotal() {
		return cantidadTotal;
	}

	public void setCantidadTotal(int cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}

	public void calcularPrecioTotal(){
		double total=0;
		for(ProductoCarrito p : this.productos){
			total += p.getProducto().getPrecio() * p.getCantidad();
		}
		this.precioTotal = total;
	}
	
	public void calcularCantidadTotal(){
		int total = 0;
		for(ProductoCarrito p : this.productos){
			System.out.println(p.getProducto().getNombre()+" "+p.getCantidad());
			total += p.getCantidad();
		}
		this.cantidadTotal = total;
		System.out.println(this.cantidadTotal);
	}
}
