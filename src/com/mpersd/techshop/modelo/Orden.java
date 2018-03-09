package com.mpersd.techshop.modelo;

import com.mpersd.techshop.dominio.Usuario;

public class Orden {
	private Usuario usuario;
	private String domicilio="domicilio conocido";
	private CarritoCompra carrito;
	
	public Orden() {
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public CarritoCompra getCarrito() {
		return carrito;
	}

	public void setCarrito(CarritoCompra carrito) {
		this.carrito = carrito;
	}
	
	

}
