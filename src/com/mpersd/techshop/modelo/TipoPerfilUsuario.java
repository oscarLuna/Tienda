package com.mpersd.techshop.modelo;

public enum TipoPerfilUsuario {
	USER("USER"),
	ADMIN("ADMIN");
	
	String tipoPerfilUsuario;
	
	private TipoPerfilUsuario(String tipoPerfilUsuario){
		this.tipoPerfilUsuario = tipoPerfilUsuario;
	}
	
	public String getUserProfileType(){
		return tipoPerfilUsuario;
	}
}
