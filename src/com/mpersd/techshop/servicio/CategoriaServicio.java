package com.mpersd.techshop.servicio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpersd.techshop.datos.ICategoriaDAO;
import com.mpersd.techshop.dominio.Categoria;

@Service
public class CategoriaServicio implements ICategoriaService{

	@Autowired
	ICategoriaDAO categoriaDAO;
	
	public CategoriaServicio() {
		System.out.println("Categoria Serv");
	}

	@Override @Transactional
	public Categoria newCategory(Categoria categoria) {
		categoriaDAO.newCategory(categoria);
		
		return categoria;
	}

	@Override @Transactional
	public Categoria updateCategory(Categoria categoria) {
		categoriaDAO.updateCategory(categoria);
		return categoria;
	}

	@Override @Transactional
	public void deleteCategory(int idCategoria) {
		categoriaDAO.deleteCategory(idCategoria);
	}

	@Override
	public List<Categoria> getCategorias() {
		return categoriaDAO.getCategorias();
	}

	@Override
	public Categoria getCategory(int idcategoria) {
		return categoriaDAO.getCategory(idcategoria);
	}

}
