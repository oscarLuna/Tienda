package com.mpersd.techshop.datos;

import com.mpersd.techshop.dominio.Usuario;

public interface IUsuarioDAO {
	Usuario getUsuario(String email, String password);
	Usuario getUsuario(String email);
	
	Usuario actualizar(Usuario usuario);
	
	Usuario getUsuario(int id);
		
	Usuario crear(Usuario u);
}
