package br.com.fiap.zerowaste.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.zerowaste.model.Address;
import br.com.fiap.zerowaste.model.User;
import br.com.fiap.zerowaste.repository.AddressRepository;
import br.com.fiap.zerowaste.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository repositoryUser;
	
	@Autowired
	private AddressRepository repositoryAddress;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/register-user")
	public ModelAndView newUser() {
		ModelAndView modelAndView = new ModelAndView("user-form");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}
	
	@GetMapping("/users")
	public ModelAndView users() {
		ModelAndView modelAndView = new ModelAndView("users");
		List<User> users = repositoryUser.findAll();
		modelAndView.addObject("users", users);
		return modelAndView;
	}
	
	@PostMapping("/")
	public String saveUser(@Valid User user, BindingResult result) {
		if(result.hasErrors()) return "user-form";
		repositoryUser.save(user);
		return "index";
	}
	
	
	
	@RequestMapping("/register-address")
	public ModelAndView newAddress() {
		ModelAndView modelAndView = new ModelAndView("address-form");
		modelAndView.addObject("address", new Address());
		return modelAndView;
	}
	
	@GetMapping("/addresses")
	public ModelAndView addresses() {
		ModelAndView modelAndView = new ModelAndView("addresses");
		List<Address> addresses = repositoryAddress.findAll();
		modelAndView.addObject("addresses", addresses);
		return modelAndView;
	}
	
	@PostMapping("/certification")
	public String saveAddress(@Valid Address address, BindingResult result) {
		if(result.hasErrors()) return "address-form";
		repositoryAddress.save(address);
		return "certification";
	}
	
	
	@GetMapping("/banana")
	public String productBanana(){
		return "banana";
	}
	
	@GetMapping("/laranja")
	public String productLaranja(){
		return "laranja";
	}

	@GetMapping("/melancia")
	public String productMelancia(){
		return "melancia";
	}
	
	@GetMapping("/abacaxi")
	public String productAbacaxi(){
		return "abacaxi";
	}

}
