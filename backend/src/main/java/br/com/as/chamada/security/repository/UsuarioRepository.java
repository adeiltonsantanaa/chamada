package br.com.as.chamada.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.as.chamada.security.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByEmail(String email);
}