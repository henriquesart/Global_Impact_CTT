package br.com.fiap.zerowaste.controller.advice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationControllerAdvice {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public List<ValidationFieldErro> handler(MethodArgumentNotValidException e) {
		List<ValidationFieldErro> lista = new ArrayList<ValidationFieldErro>();
		
		List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
		fieldErrors.forEach(error -> {
			lista.add(new ValidationFieldErro(error.getField(), error.getDefaultMessage()) );
		});
		
		return lista;
	}

}
