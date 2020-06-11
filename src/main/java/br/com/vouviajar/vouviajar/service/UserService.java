package br.com.vouviajar.vouviajar.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.vouviajar.vouviajar.dto.CredentialsDTO;
import br.com.vouviajar.vouviajar.model.User;
import br.com.vouviajar.vouviajar.repository.UserRepository;
import br.com.vouviajar.vouviajar.exception.PasswordInvalidException;
import br.com.vouviajar.vouviajar.exception.UsernameInvalidException;

@Service
public class UserService {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
    private UserRepository userRepository; 

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Optional<User> login(CredentialsDTO credentials){
        Optional<User> user = userRepository.findByUsername(credentials.getUsername());
        if(user.isEmpty()){
            throw new UsernameInvalidException();
        }
        User user_db = user.get();
        if(!user_db.getPassword().equals(credentials.getPassword())){
            throw new PasswordInvalidException(); 
        }
        return user;
    }

    public User register(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Optional<User> getUser(Long idUser){
        Optional<User> user = userRepository.findById(idUser);
        return user;
    }
    
}