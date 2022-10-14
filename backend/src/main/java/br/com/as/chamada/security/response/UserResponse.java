package br.com.as.chamada.security.response;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.as.chamada.security.enums.PerfilEnum;

public class UserResponse {

	private String email;

	@Enumerated(EnumType.STRING)
	@Column(name = "perfil", nullable = false)
	private PerfilEnum perfil;

	public UserResponse() {
	}

	public UserResponse(String email, PerfilEnum perfil) {
		this.email = email;
		this.perfil = perfil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PerfilEnum getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}

}