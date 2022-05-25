package com.pacule.bookstore.resources.exceptions;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.pacule.bookstore.service.exceptions.DataIntegrityViolationExeption;
import com.pacule.bookstore.service.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExcepionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandartError>objectNotFoundException(ObjectNotFoundException e, ServletRequest request){
		StandartError error= new StandartError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(DataIntegrityViolationExeption.class)
	public ResponseEntity<StandartError>dataIntegrityViolationExeption(DataIntegrityViolationExeption e, ServletRequest request){
		StandartError error= new StandartError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandartError> validationException(MethodArgumentNotValidException e, ServletRequest request){
		ValidationError error= new ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Erro de Validacao de campos");
		for (FieldError x: e.getBindingResult().getFieldErrors() ) {
			error.addErrors(x.getField(), x.getDefaultMessage());	
		}
		
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(error);
	}
}
