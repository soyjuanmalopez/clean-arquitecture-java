package com.d4i.sample.movie.shared.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends NetflixException {
	private static final long serialVersionUID = -6870732210014274010L;

	public NotFoundException(final String message) {
		super(HttpStatus.NOT_FOUND.value(), message);
	}

}
