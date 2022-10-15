package br.com.as.chamada.security.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.as.chamada.security.enums.PerfilEnum;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

	public Usuario() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "email", nullable = false)
	private String email;

	@JsonIgnore
	@Column(name = "password", nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(name = "perfil", nullable = false)
	private PerfilEnum perfil;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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