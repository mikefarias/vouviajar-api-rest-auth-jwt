package br.com.vouviajar.vouviajar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.vouviajar.vouviajar.dto.AutheticatedUserDTO;
import br.com.vouviajar.vouviajar.dto.RegisterUserDTO;
import br.com.vouviajar.vouviajar.model.User;
import br.com.vouviajar.vouviajar.service.RegisterUserService;

@RestController
public class RegisterUserController {

    private RegisterUserService registerUserService;

    @Autowired
    public RegisterUserController(RegisterUserService registerUserService){
        this.registerUserService = registerUserService;
    }
    
    @PostMapping("/api/user/register")
    public ResponseEntity<AutheticatedUserDTO> registrate(@RequestBody RegisterUserDTO registerUserDTO){
        User user = registerUserService.registrate(registerUserDTO.toUser());
        return  new ResponseEntity<AutheticatedUserDTO>(AutheticatedUserDTO.toDTO(user), HttpStatus.CREATED);
    }
}