package com.mpersd.techshop.datos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mpersd.techshop.dominio.Categoria;

@Repository
public class CategoriaDAOJPA implements ICategoriaDAO{
	
	@PersistenceContext
	EntityManager em;	

	public CategoriaDAOJPA() {
		System.out.println("categoria JPA");
	}

	@Override
	public Categoria newCategory(Categoria categoria) {
		em.persist(categoria);
		return categoria;
	}

	@Override
	public Categoria updateCategory(Categoria categoria) {
		Categoria c =em.find(Categoria.class, categoria.getIdCategoria());
		if(c!=null){
			c.setCategoria(categoria.getCategoria());
			em.merge(categoria);
		}else{
			System.out.println("no se encontro categoria");
		}
		return categoria;
	}

	@Override
	public List<Categoria> getCategorias() {
		return em.createQuery("SELECT c FROM Categoria c").getResultList();
	}

	@Override
	public void deleteCategory(int idCategoria) {
		Categoria c = em.find(Categoria.class, idCategoria);
		em.remove(c);		
	}

	@Override
	public Categoria getCategory(int idcategoria) {
		Query q =  em.createQuery("SELECT c FROM Categoria c WHERE c.idCategoria= :idcategoria");
		q.setParameter("idcategoria", idcategoria);
		q.setFirstResult(0);
		q.setMaxResults(1);
		
		List<Categoria> catList = q.getResultList();
		if(catList.isEmpty()) {
			return null;
		}else{
			return catList.get(0);
		}		
	}

}
