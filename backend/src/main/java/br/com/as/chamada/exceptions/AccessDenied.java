package br.com.as.chamada.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class AccessDenied extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AccessDenied(String msg) {
		super(msg);
	}

}
