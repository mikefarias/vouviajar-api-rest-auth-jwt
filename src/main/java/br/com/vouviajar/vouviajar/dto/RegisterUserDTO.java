package br.com.vouviajar.vouviajar.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import br.com.vouviajar.vouviajar.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.ANY)
@AllArgsConstructor @NoArgsConstructor
public class RegisterUserDTO extends User{
    
    @Getter @Setter private String username;
    @Getter @Setter private String email;
    @Getter @Setter private String password;

    public User toUser(){
        return new User(getUsername(), getEmail(), getPassword());
    }

}