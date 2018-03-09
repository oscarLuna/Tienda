package com.mpersd.techshop.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mpersd.techshop.modelo.TipoPerfilUsuario;

@Entity
@Table(name="perfilusuario")
public class PerfilUsuario {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPerfil;	

	@Column(name="tipo", length=6, unique=true, nullable=false)
	private String type = TipoPerfilUsuario.USER.getUserProfileType();

	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPerfil;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PerfilUsuario))
			return false;
		PerfilUsuario other = (PerfilUsuario) obj;
		if (idPerfil != other.idPerfil)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserProfile [id=" + idPerfil + ",  type=" + type	+ "]";
	}

}
