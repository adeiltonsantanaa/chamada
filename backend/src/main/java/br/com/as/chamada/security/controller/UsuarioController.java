package br.com.as.chamada.security.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.as.chamada.security.entities.Usuario;
import br.com.as.chamada.security.request.UserRequest;
import br.com.as.chamada.security.request.UsuarioJwtRequest;
import br.com.as.chamada.security.response.UserResponse;
import br.com.as.chamada.security.response.UsuarioJwtResponse;
import br.com.as.chamada.security.service.UsuarioService;
import br.com.as.chamada.security.service.impl.UserDetailsServiceImpl;
import br.com.as.chamada.security.utils.JwtUtil;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

	private final UsuarioService usuarioService;
	private final PasswordEncoder passwordEncoder;

	public UsuarioController(UsuarioService usuarioService, PasswordEncoder passwordEncoder) {
		this.usuarioService = usuarioService;
		this.passwordEncoder = passwordEncoder;
		this.userDetailsServiceImpl = new UserDetailsServiceImpl();
	}

	@Autowired
	private final UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAnyRole('ADMINISTRADOR')")
	public UserResponse save(@RequestBody @Valid UserRequest userRequest) {

		Usuario usuario = new Usuario();
		BeanUtils.copyProperties(userRequest, usuario);
		usuario.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		usuarioService.save(usuario);

		UserResponse userResponse = new UserResponse();
		BeanUtils.copyProperties(usuario, userResponse);

		return userResponse;
	}

	@PostMapping("/autenticacao")
	@ResponseStatus(HttpStatus.OK)
	public UsuarioJwtResponse getAutenticacao(@RequestBody UsuarioJwtRequest usuarioJwtRequest) {
		try {
			UserDetails userDetails = userDetailsServiceImpl.autenticar(usuarioJwtRequest);
			String token = jwtUtil.obterToken(usuarioJwtRequest);
			return new UsuarioJwtResponse(token, userDetails.getUsername());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
		}
	}
	
	@PostMapping("/valida")
	public boolean validaToken(@RequestHeader(value = "Authorization") String token) {
		return true;
	}

}
