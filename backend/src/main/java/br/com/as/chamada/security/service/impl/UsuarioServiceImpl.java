package br.com.as.chamada.security.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.as.chamada.security.entities.Usuario;
import br.com.as.chamada.security.repository.UsuarioRepository;
import br.com.as.chamada.security.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Optional<Usuario> findByEmail(String email) {

        return usuarioRepository.findByEmail(email);
    }

    @Override
    public Usuario save(Usuario usuario) {

        return usuarioRepository.save(usuario);
    }
}
