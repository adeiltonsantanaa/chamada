package br.com.as.chamada.model.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.as.chamada.model.entities.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

	Optional<UserModel> findByUsername(String username);
}
