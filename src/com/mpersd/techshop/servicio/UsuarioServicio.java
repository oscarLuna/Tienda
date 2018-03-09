package com.mpersd.techshop.servicio;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpersd.techshop.datos.IUsuarioDAO;
import com.mpersd.techshop.dominio.Usuario;
import com.mpersd.techshop.exceptions.RegistroException;
import com.mpersd.techshop.exceptions.UsuarioException;

@Service("userService")
@Transactional
public class UsuarioServicio implements IUsuarioServicio{

	@Autowired
	IUsuarioDAO userDAO;
	
	@Override
	public Usuario getUsuario(String email) {
		return userDAO.getUsuario(email);
	}

	@Override @Transactional
	public Usuario actualizar(Usuario usuario) {
		Usuario up = userDAO.getUsuario(usuario.getIdUsuario());
		if(up==null){
			throw new UsuarioException("El usuario no existe");
		}else{
			userDAO.actualizar(usuario);
		}
		return usuario;
	}

	@Override
	public Usuario getUsuario(int id) {
		return userDAO.getUsuario(id);
	}

	@Override @Transactional
	public Usuario crear(Usuario u) {
		Usuario up = userDAO.getUsuario(u.getEmail());
		if(up != null){ // usuario existe
			throw new RegistroException("El usuario ya existe");
		}else{
			userDAO.crear(u);
		}
		return u;
	}

}
