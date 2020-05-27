package br.com.vouviajar.vouviajar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import br.com.vouviajar.vouviajar.model.User;

@AllArgsConstructor @NoArgsConstructor 
public class LoginDTO {
    
    @Getter private String username;
    @Getter private String password;
    
    public static LoginDTO toDTO(User user){
        return new LoginDTO(user.getUsername(), user.getPassword());

    }
    
}