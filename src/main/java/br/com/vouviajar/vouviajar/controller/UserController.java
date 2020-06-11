package br.com.vouviajar.vouviajar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.vouviajar.vouviajar.dto.AutheticatedUserDTO;
import br.com.vouviajar.vouviajar.dto.RegisterUserDTO;
import br.com.vouviajar.vouviajar.model.User;
import br.com.vouviajar.vouviajar.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    
    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public ResponseEntity<AutheticatedUserDTO> register(@RequestBody RegisterUserDTO registerUserDTO){
        User user = userService.register(registerUserDTO.toUser());
        return  new ResponseEntity<AutheticatedUserDTO>(AutheticatedUserDTO.toDTO(user), HttpStatus.CREATED);
    }

}