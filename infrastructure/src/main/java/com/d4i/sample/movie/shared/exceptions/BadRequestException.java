package com.d4i.sample.movie.shared.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BadRequestException extends NetflixException{

	private static final long serialVersionUID = -5330068136795055851L;

	public BadRequestException(final String message) {
		super(HttpStatus.BAD_REQUEST.value(), message);
	}

}
