package net.hdiaz.alcancia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class HandleException {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGereralException(Exception e){
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(AlcanciaExceptions.class)
	public ResponseEntity<ErrorResponse> handleBancoException(AlcanciaExceptions e){
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
}
