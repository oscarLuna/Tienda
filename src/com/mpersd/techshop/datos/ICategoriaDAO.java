package com.mpersd.techshop.datos;

import java.util.List;

import com.mpersd.techshop.dominio.Categoria;

public interface ICategoriaDAO {
	Categoria newCategory(Categoria categoria);
	Categoria updateCategory(Categoria categoria);
	Categoria getCategory(int idcategoria);
	void deleteCategory(int idCategoria);
	List<Categoria> getCategorias();
}
