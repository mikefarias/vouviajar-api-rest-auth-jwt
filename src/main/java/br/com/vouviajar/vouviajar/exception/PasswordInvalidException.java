package br.com.vouviajar.vouviajar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class PasswordInvalidException extends RuntimeException {

    private static final long serialVersionUID = -1715153107275742840L;
}