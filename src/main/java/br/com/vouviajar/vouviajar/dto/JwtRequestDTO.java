package br.com.vouviajar.vouviajar.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class JwtRequestDTO implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	
	private String username;
	private String password;
	
	//need default constructor for JSON Parsing
	public JwtRequestDTO()
	{
		
	}

	public JwtRequestDTO(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}
}
