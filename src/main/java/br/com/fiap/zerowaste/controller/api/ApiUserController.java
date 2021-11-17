package br.com.fiap.zerowaste.controller.api;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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

import br.com.fiap.zerowaste.model.User;
import br.com.fiap.zerowaste.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class ApiUserController {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping()
	@Cacheable("users")
	public List<User> index(@RequestParam(required = false) String name) {

		if (name == null) {
			return repository.findAll();
		}
		return repository.findByNameLike("%" + name + "%");

	}
	
	@PostMapping()
	public ResponseEntity<User> create(@RequestBody User user, UriComponentsBuilder uriBuilder) {
		repository.save(user);
		URI uri = uriBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<User> get(@PathVariable Long id) {
		 return ResponseEntity.of(repository.findById(id));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<User> delete(@PathVariable Long id){
		Optional<User> user = repository.findById(id);
		
		if(user.isEmpty()) return ResponseEntity.notFound().build();
		
		repository.deleteById(id);
		
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("{id}")
	@CacheEvict(value = "users", allEntries = true)
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody @Valid User newUser) {
		Optional<User> optional = repository.findById(id);

		if (optional.isEmpty())
			return ResponseEntity.notFound().build();

		User user = optional.get();
		user.setName(newUser.getName());
		user.setEmail(newUser.getEmail());
		user.setPassword(newUser.getPassword());

		repository.save(user);

		return ResponseEntity.ok(user);
	}
	
}
