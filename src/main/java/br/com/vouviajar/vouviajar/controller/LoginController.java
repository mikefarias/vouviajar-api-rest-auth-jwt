package br.com.vouviajar.vouviajar.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import br.com.vouviajar.vouviajar.dto.AutheticatedUserDTO;
import br.com.vouviajar.vouviajar.dto.CredentialsDTO;
import br.com.vouviajar.vouviajar.model.User;
import br.com.vouviajar.vouviajar.service.LoginService;

@RestController 
public class LoginController {

    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }
        
    @PostMapping("/api/user/login")
    public ResponseEntity<AutheticatedUserDTO> autenticar(@RequestBody CredentialsDTO login, @RequestHeader String Authorization){
        Optional<User> user = loginService.login(login);
        return new ResponseEntity<AutheticatedUserDTO>(AutheticatedUserDTO.toDTO(user.get()), HttpStatus.ACCEPTED);
    }
}