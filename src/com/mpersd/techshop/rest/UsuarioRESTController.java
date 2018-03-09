package com.mpersd.techshop.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mpersd.techshop.dominio.Usuario;
import com.mpersd.techshop.exceptions.RegistroException;
import com.mpersd.techshop.servicio.IUsuarioServicio;

@RestController
public class UsuarioRESTController {

	@Autowired
	IUsuarioServicio uServ;

	public UsuarioRESTController() {
		System.out.println("usuario REST");
	}

	@RequestMapping(value = "/api/usuario/", method = RequestMethod.POST)
	public ResponseEntity<Usuario> createUser(@RequestBody Usuario usuario) {
		System.out.println("Creating User " + usuario.toString());
		try{
			Usuario up = uServ.crear(usuario);
			return new ResponseEntity<Usuario>(up, HttpStatus.CREATED);
		}catch(RegistroException ex){
			ex.printStackTrace();
			System.out.println("el usuario "+ usuario.getEmail() + " ya existe");
			return new ResponseEntity<Usuario>(HttpStatus.CONFLICT);

		}
	}

	@RequestMapping(value = "/api/usuario/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> userById(@PathVariable("id") int id) {
		System.out.println(id);
		Usuario user = uServ.getUsuario(id);
		if (user == null) {
			return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Usuario>(user, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/api/usuario/", method = RequestMethod.PUT)
	public ResponseEntity<Usuario> updateUser(@RequestBody Usuario usuario) {
		System.out.println("actualizando usuario " + usuario.getEmail());
		Usuario user = uServ.getUsuario(usuario.getIdUsuario());
		if (user == null) {
			return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
		} else {
			uServ.actualizar(usuario);
			return new ResponseEntity<Usuario>(user, HttpStatus.OK);
		}
	}
	
}
