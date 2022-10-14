package br.com.as.chamada.security.response;

import lombok.Builder;

@Builder
public class UsuarioJwtResponse {

	private String token;
	private String email;

	public UsuarioJwtResponse() {
	}

	public UsuarioJwtResponse(String token, String email) {
		this.token = token;
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}