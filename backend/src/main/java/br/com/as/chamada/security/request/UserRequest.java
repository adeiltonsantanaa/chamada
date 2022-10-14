package br.com.as.chamada.security.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;

import br.com.as.chamada.security.enums.PerfilEnum;
import lombok.Builder;

@Builder
public class UserRequest {

	@NotEmpty(message = "Campo Email é Obrigatório.")
	private String email;

	@NotEmpty(message = "Campo Password é Obrigatório.")
	private String password;

	@Enumerated(EnumType.STRING)
	private PerfilEnum perfil;

	public UserRequest() {
	}

	public UserRequest(String email, String password, PerfilEnum perfil) {
		this.email = email;
		this.password = password;
		this.perfil = perfil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PerfilEnum getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}

}