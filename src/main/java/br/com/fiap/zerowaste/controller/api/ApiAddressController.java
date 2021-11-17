package br.com.fiap.zerowaste.controller.api;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fiap.zerowaste.model.Address;
import br.com.fiap.zerowaste.repository.AddressRepository;

@RestController
@RequestMapping("/api/address")
public class ApiAddressController {
	
	@Autowired
	private AddressRepository repository;
	
	@GetMapping()
	public List<Address> index(@RequestParam(required = false) String endereco) {

		if (endereco == null) {
			return repository.findAll();
		}
		return repository.findByEnderecoLike("%" + endereco + "%");

	}
	
	@PostMapping()
	public ResponseEntity<Address> create(@RequestBody Address address, UriComponentsBuilder uriBuilder) {
		repository.save(address);
		URI uri = uriBuilder.path("/api/user/{id}").buildAndExpand(address.getId()).toUri();
		return ResponseEntity.created(uri).body(address);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Address> get(@PathVariable Long id) {
		 Optional<Address> address = repository.findById(id);
		 if (address.isPresent()) 
			 return ResponseEntity.ok(address.get());
		 return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Address> delete(@PathVariable Long id){
		Optional<Address> address = repository.findById(id);
		
		if(address.isEmpty()) return ResponseEntity.notFound().build();
		
		repository.deleteById(id);
		
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("{id}")
	@CacheEvict(value = "addressess", allEntries = true)
	public ResponseEntity<Address> update(@PathVariable Long id, @RequestBody @Valid Address newAddress) {
		Optional<Address> optional = repository.findById(id);

		if (optional.isEmpty())
			return ResponseEntity.notFound().build();

		Address address = optional.get();
		address.setEndereco(newAddress.getEndereco());
		address.setEmail(newAddress.getEmail());
		address.setCEP(newAddress.getCEP());
		address.setCidade(newAddress.getCidade());
		address.setNumero(newAddress.getNumero());

		repository.save(address);

		return ResponseEntity.ok(address);
	}
	
}
