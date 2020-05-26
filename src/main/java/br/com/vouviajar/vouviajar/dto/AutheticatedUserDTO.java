package br.com.vouviajar.vouviajar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import br.com.vouviajar.vouviajar.model.User;

@AllArgsConstructor @NoArgsConstructor 
public class AutheticatedUserDTO {
    
    @Getter private String username;
    @Getter private String email;  
    @Getter private String password;
    
    public static AutheticatedUserDTO toDTO(User user){
        return new AutheticatedUserDTO(user.getUsername(), user.getEmail(), user.getPassword());

    }
    
}