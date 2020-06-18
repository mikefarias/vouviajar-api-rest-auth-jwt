package br.com.vouviajar.vouviajar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import br.com.vouviajar.vouviajar.model.User;

@AllArgsConstructor @NoArgsConstructor 
public class CredentialsDTO {
    
    @Getter private String email;
    @Getter private String password;
    
    public static CredentialsDTO toDTO(User user){
        return new CredentialsDTO(user.getEmail(), user.getPassword());

    }
    
}