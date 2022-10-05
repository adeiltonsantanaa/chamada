package br.com.as.chamada.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.as.chamada.model.entities.UserModel;
import br.com.as.chamada.model.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel userModel = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
		return new User(userModel.getUsername(), userModel.getPassword(), true, true, true, true,
				userModel.getAuthorities());
	}

}
