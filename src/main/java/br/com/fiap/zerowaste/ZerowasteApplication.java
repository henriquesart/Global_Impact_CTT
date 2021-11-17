package br.com.fiap.zerowaste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ZerowasteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZerowasteApplication.class, args);
	}
	
}
