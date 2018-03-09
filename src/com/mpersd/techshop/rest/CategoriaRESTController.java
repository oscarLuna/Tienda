package com.mpersd.techshop.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mpersd.techshop.dominio.Categoria;
import com.mpersd.techshop.servicio.ICategoriaService;

@RestController
public class CategoriaRESTController {

	@Autowired
	ICategoriaService cServ;
	
	public CategoriaRESTController() {
		System.out.println("Categoria REST");
	}
	
	@RequestMapping(value = "/api/categoria/", method = RequestMethod.POST)
	public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria) {
		System.out.println("Creating categoria " + categoria.toString());
			Categoria c = cServ.newCategory(categoria);
			return new ResponseEntity<Categoria>(c, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/api/categoria/", method = RequestMethod.GET)
	public ResponseEntity<List<Categoria>> getCategorias() {
		List<Categoria> categorias = cServ.getCategorias();
		return new ResponseEntity<List<Categoria>>(categorias, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/categoria/", method = RequestMethod.PUT)
	public ResponseEntity<Categoria> updateCategory(@RequestBody Categoria categoria) {
		System.out.println("actualizando categoria " + categoria.getCategoria());
		
		Categoria c = cServ.getCategory(categoria.getIdCategoria());
		cServ.updateCategory(categoria);
		
		return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
	}
	

}
