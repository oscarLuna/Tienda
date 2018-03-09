package com.mpersd.techshop.datos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mpersd.techshop.dominio.Producto;

@Repository
public class ProductoDAOJPA implements IProductoDAO{
	
	@PersistenceContext
	EntityManager em;	
	
	public ProductoDAOJPA() {
		System.out.println("Producto DAO JPA");
	}

	@Override
	public Producto newProduct(Producto producto) {
		em.persist(producto);
		return producto;
	}

	@Override
	public Producto updateProduct(Producto producto) {
		Producto p = em.find(Producto.class, producto.getIdProducto());
		
		if(p!=null){
			p.setNombre(producto.getNombre());
			p.setMarca(producto.getMarca());
			p.setPrecio(producto.getPrecio());
			p.setDescripcion(producto.getDescripcion());
			p.setDimensiones(producto.getDimensiones());
			p.setPeso(producto.getPeso());
			p.setImagenURL(producto.getImagenURL());
			
			em.merge(producto);
		}else{
			System.out.println("no se encontro");
		}
		return producto;
	}

	@Override
	public void deleteProducto(int idProducto) {
		Producto p = em.find(Producto.class, idProducto);
		em.remove(p);
		}

	@Override
	public Producto getProducto(int id) {
		Query q =  em.createQuery("SELECT p FROM Producto p WHERE p.idProducto = :id");
		q.setParameter("id", id);
		q.setFirstResult(0);
		q.setMaxResults(1);
		
		List<Producto> productList = q.getResultList();
		if(productList.isEmpty()){
			return null;
		}else{
			return productList.get(0);
		}
	}

	@Override
	public List<Producto> getProductos() {
		return em.createQuery("SELECT p FROM Producto p").getResultList();
	}

	@Override
	public List<Producto> getProductosByCategory(String idCategoria) {
		Query q =  em.createQuery("SELECT p FROM Producto p where p.categoria = :categoria");
		q.setParameter("categoria", idCategoria);
		
		List<Producto> productos = q.getResultList();
		return productos;
		
	}
	//jpql
	@Override
	public List<Producto> getProductoBusqueda(String search) {
		Query q =  em.createQuery("SELECT p FROM Producto p where "
								+ "p.nombre like :search or "
								+ "p.marca like :search or "
								+ "p.descripcion like :search or "
								+ "p.categoria.categoria like :search");
		String parametro="%"+search+"%";
		q.setParameter("search", parametro);
		
		List<Producto> productos = q.getResultList();
		return productos;
	}

	
}
