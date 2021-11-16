package br.com.fiap.zerowaste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.zerowaste.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
