package com.nelioalves.cursomc.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.nelioalves.cursomc.servicies.exceptions.ObjectNotFoundException;

// Classe responsável por capturar os erros da classe de REST para não ficar fazendo try/catch nela.
@ControllerAdvice
public class ResourceExceptionHandler {

	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException objectNotFoundException, HttpServletRequest httpServletRequest){
	
		StandardError standardError = new StandardError(HttpStatus.NOT_FOUND.value(), objectNotFoundException.getMessage(), System.currentTimeMillis());
		
		// Retonar o status de not found, junto do corpo da mensagem que foi criado agora, que é os valores da classe StandardError: 
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
		
	}
	
}
