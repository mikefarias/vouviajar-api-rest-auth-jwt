package br.com.vouviajar.vouviajar.service;

import org.springframework.stereotype.Service;

import br.com.vouviajar.vouviajar.model.User;

@Service
public class UserService {

    private User user;

    public User createUser() {
		if(user == null) {
           user = new User();
           user.setName("mike farias");
           user.setId(1);
		}
		return user;
    }
    
    public User find() {
		createUser();
		return user;
	}
	
	public boolean delete() {
		return user == null;
	}

	public User createUserBD(){
		
		return null;
	}
}