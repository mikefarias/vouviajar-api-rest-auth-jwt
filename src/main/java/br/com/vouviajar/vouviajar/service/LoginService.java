package br.com.vouviajar.vouviajar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vouviajar.vouviajar.dto.LoginDTO;
import br.com.vouviajar.vouviajar.model.User;
import br.com.vouviajar.vouviajar.repository.LoginRepository;

@Service
public class LoginService {

    private LoginRepository loginRepository; 

    @Autowired
    public LoginService(LoginRepository loginRepository){
        this.loginRepository = loginRepository;
    }

    public User login(LoginDTO login){
        User user_get = loginRepository.findByUsername(login.getUsername()).get();
        return user_get;
    }
    
}