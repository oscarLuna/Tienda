package com.mpersd.techshop.servicio;

import com.mpersd.techshop.dominio.Usuario;

public interface IUsuarioServicio {	
	Usuario getUsuario(String email);
	
	Usuario actualizar(Usuario usuario);
	
	Usuario getUsuario(int id);
		
	Usuario crear(Usuario u);
}
