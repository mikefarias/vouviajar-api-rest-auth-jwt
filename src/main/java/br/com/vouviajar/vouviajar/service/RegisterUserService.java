package br.com.vouviajar.vouviajar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vouviajar.vouviajar.model.User;
import br.com.vouviajar.vouviajar.repository.RegisterUserRepository;


@Service
public class RegisterUserService {

    private RegisterUserRepository registerUserRepository; 

    @Autowired
    public RegisterUserService(RegisterUserRepository registerUserRepository){
        this.registerUserRepository = registerUserRepository;
    }

    public User registrate(User user){
        return registerUserRepository.save(user);
    }


}