package com.mpersd.techshop.datos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mpersd.techshop.dominio.PerfilUsuario;
import com.mpersd.techshop.dominio.Usuario;

@Repository
public class UsuarioDAOJPA implements IUsuarioDAO{
	
	@PersistenceContext
	EntityManager em;
	public UsuarioDAOJPA() {
		System.out.println("usuario DAO JPA");
	}

	@Override
	public Usuario getUsuario(String email, String password) {
		Query q =  em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email and u.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		q.setFirstResult(0);
		q.setMaxResults(1);
		
		List<Usuario> userList = q.getResultList();
		if(userList.isEmpty()) {
			return null;
		}else{
			return userList.get(0);
		}		
	}

	@Override
	public Usuario getUsuario(String email) {
		Query q =  em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email");
		q.setParameter("email", email);
		q.setFirstResult(0);
		q.setMaxResults(1);
		
		List<Usuario> userList = q.getResultList();
		if(userList.isEmpty()) {
			return null;
		}else{
			return userList.get(0);
		}		
	}

	@Override
	public Usuario actualizar(Usuario usuario) {
		Usuario up = em.find(Usuario.class,usuario.getIdUsuario());
		up.setNombres(usuario.getNombres());
		up.setApellidoPaterno(usuario.getApellidoPaterno());
		up.setApellidoMaterno(usuario.getApellidoMaterno());
		up.setFechaNacimiento(usuario.getFechaNacimiento());
		up.setSexo(usuario.getSexo());
		up.setEmail(usuario.getEmail());
		up.setPassword(usuario.getPassword());
		
		em.merge(up);
		return up;
	}
	
	@Override
	public Usuario getUsuario(int id) {
		return em.find(Usuario.class, id);
	}

	@Override
	public Usuario crear(Usuario u) {
		PerfilUsuario pf = new PerfilUsuario();
		pf.setIdPerfil(1);
		pf.setType("USER");
		Set<PerfilUsuario> userProfiles = new HashSet<PerfilUsuario>();
		userProfiles.add(pf);
		u.setUserProfiles(userProfiles);
		em.persist(u);
		return u;
	}
}
