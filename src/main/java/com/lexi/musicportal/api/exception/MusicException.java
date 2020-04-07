package com.lexi.musicportal.api.exception;

import org.springframework.http.HttpStatus;

public class MusicException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MusicException(String message) {
		super(message);
	}

	public MusicException(String message, Throwable cause) {
		super(message, cause);
	}

	public MusicException(String message, Error error, HttpStatus httpStatus) {
		super(message);
	}

	public MusicException(Throwable cause) {
		super(cause);
	}

}
