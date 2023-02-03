package com.ada.starWarsResistence.model.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ NullPointerException.class })
	public ResponseEntity<String> internalServerException(NullPointerException ex) {
		return error(INTERNAL_SERVER_ERROR, ex);
	}

	private ResponseEntity<String> error(HttpStatus status, Exception ex) {
		return ResponseEntity.status(status).body(ex.getMessage());
	}
}
