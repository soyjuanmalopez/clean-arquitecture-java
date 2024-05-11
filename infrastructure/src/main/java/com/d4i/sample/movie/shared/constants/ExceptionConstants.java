package com.d4i.sample.movie.shared.constants;

public class ExceptionConstants {

	public static final String ERROR = "ERROR";

	public static final String BAD_REQUEST_DEFAULT_MESSAGE = "There are unaccepted parameters";
	public static final String BAD_REQUEST_EXISTS_CATEGORY_MESSAGE = "This category already exists";

	private ExceptionConstants() {
		throw new IllegalStateException("Utility Class");
	}

}
