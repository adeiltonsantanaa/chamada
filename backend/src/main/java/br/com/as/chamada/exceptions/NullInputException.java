package br.com.as.chamada.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NullInputException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NullInputException(String msg) {
		super(msg);
	}

}
