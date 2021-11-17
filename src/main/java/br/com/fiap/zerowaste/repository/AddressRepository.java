package br.com.fiap.zerowaste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.zerowaste.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
	
	List<Address> findByEnderecoLike(String endereco);
}
