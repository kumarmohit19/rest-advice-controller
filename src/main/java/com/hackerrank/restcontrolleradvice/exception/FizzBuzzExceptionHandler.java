package com.hackerrank.restcontrolleradvice.exception;

import com.hackerrank.restcontrolleradvice.dto.BuzzException;
import com.hackerrank.restcontrolleradvice.dto.FizzBuzzException;
import com.hackerrank.restcontrolleradvice.dto.FizzException;
import com.hackerrank.restcontrolleradvice.dto.GlobalError;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class FizzBuzzExceptionHandler extends ResponseEntityExceptionHandler {

	// TODO:: implement handler methods for FizzException, BuzzException and
	// FizzBuzzException

	@ExceptionHandler(FizzException.class)
	public ResponseEntity<Object> handleFizzException(FizzException ex) {
		GlobalError err = new GlobalError(ex.getMessage(), ex.getErrorReason());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
	}

	@ExceptionHandler(BuzzException.class)
	public ResponseEntity<Object> handleBuzzException(BuzzException ex) {
		GlobalError err = new GlobalError(ex.getMessage(), ex.getErrorReason());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

	@ExceptionHandler(FizzBuzzException.class)
	public ResponseEntity<Object> handleFizzBuzzException(FizzBuzzException ex) {
		GlobalError err = new GlobalError(ex.getMessage(), ex.getErrorReason());
		return ResponseEntity.status(HttpStatus.INSUFFICIENT_STORAGE).body(err);
	}
}
