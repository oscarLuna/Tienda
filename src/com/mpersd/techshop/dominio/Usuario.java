package com.mpersd.techshop.dominio;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.mpersd.techshop.util.PasswordUtil;

@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idUsuario;
	@Column
	private String nombres;
	@Column
	private String apellidoPaterno;
	@Column
	private String apellidoMaterno;
	@Column
	private Date fechaNacimiento;
	@Column
	private String sexo;
	@Column
	private String email;
	@Column
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "perfilesusarios", 
             joinColumns = { @JoinColumn(name = "idUsuario") }, 
             inverseJoinColumns = { @JoinColumn(name = "idPerfil") })
	private Set<PerfilUsuario> userProfiles = new HashSet<PerfilUsuario>();
	
	
	public Usuario() {
		
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password){
		this.password = password;
	}
	
	public Set<PerfilUsuario> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(Set<PerfilUsuario> userProfiles) {
		this.userProfiles = userProfiles;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idUsuario;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		if (idUsuario != other.idUsuario)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + idUsuario + ", ssoId=" + email + ", password=" + password
				+ ", firstName=" + nombres + ", lastName=" + apellidoMaterno
				+ ", email=" + email + ", userProfiles=" + userProfiles +"]";
	}
	
}
