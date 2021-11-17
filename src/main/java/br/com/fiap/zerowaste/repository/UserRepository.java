package br.com.fiap.zerowaste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.zerowaste.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByNameLike(String name);

}
