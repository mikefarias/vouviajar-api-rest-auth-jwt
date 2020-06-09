package br.com.vouviajar.vouviajar.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vouviajar.vouviajar.dto.CredentialsDTO;
import br.com.vouviajar.vouviajar.model.User;
import br.com.vouviajar.vouviajar.repository.UserRepository;
import br.com.vouviajar.vouviajar.exception.PasswordInvalidException;
import br.com.vouviajar.vouviajar.exception.UsernameInvalidException;

@Service
public class UserService {

    private UserRepository loginRepository; 

    @Autowired
    public UserService(UserRepository loginRepository){
        this.loginRepository = loginRepository;
    }

    public Optional<User> login(CredentialsDTO credentials){
        Optional<User> user = loginRepository.findByUsername(credentials.getUsername());
        if(user.isEmpty()){
            throw new UsernameInvalidException();
        }
        User user_db = user.get();
        if(!user_db.getPassword().equals(credentials.getPassword())){
            throw new PasswordInvalidException(); 
        }
        return user;
    }

    public Optional<User> getUser(Long idUser){
        Optional<User> user = loginRepository.findById(idUser);
        return user;
    }
    
}