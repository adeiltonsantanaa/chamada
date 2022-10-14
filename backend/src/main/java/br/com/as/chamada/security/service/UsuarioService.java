package br.com.as.chamada.security.service;

import java.util.Optional;

import br.com.as.chamada.security.entities.Usuario;

public interface UsuarioService {

    Optional<Usuario> findByEmail(String email);

    Usuario save(Usuario usuario);
}
