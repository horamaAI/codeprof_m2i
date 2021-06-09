package fr.formation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "L'identifiant doit être > 0.")
public class IdMustBePositiveException extends RuntimeException {
	private static final long serialVersionUID = 1L;
}