package br.com.vouviajar.vouviajar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UsernameInvalidException extends RuntimeException {

    private static final long serialVersionUID = 2988421993118399867L;
}