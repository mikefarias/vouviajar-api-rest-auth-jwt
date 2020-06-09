package br.com.vouviajar.vouviajar.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class JwtResponseDTO implements Serializable {

    private static final long serialVersionUID = 3504383838317852241L;
    private final String jwttoken;
}
