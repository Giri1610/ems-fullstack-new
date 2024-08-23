package com.giri.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	
public static final long serialVersioUID = 1L;
	
	public ResourceNotFoundException(String massage) {
		super(massage);
		
	}

}
