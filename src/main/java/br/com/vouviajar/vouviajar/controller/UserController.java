package br.com.vouviajar.vouviajar.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import br.com.vouviajar.vouviajar.service.UserService;
import net.minidev.json.JSONObject;
import br.com.vouviajar.vouviajar.model.User;
import br.com.vouviajar.vouviajar.repository.UserRepository;

@RestController
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class.getName());

	private UserRepository repository;

	UserController(UserRepository userRepository){
		this.repository = userRepository;
	}

    @Autowired
    private UserService userService;

    @GetMapping(path = "/user")
	public ResponseEntity<User> find() {
		if(userService.find() == null) {
			return ResponseEntity.notFound().build(); 
		}
		logger.info("Usuário Mike Farias encontrado");
		return ResponseEntity.ok(userService.find());
	}

	@PostMapping(path = "/user/post")
	@ResponseBody
	public User post(@RequestBody JSONObject user){

		User user_created = userService.createUser();
		return repository.save(user_created);
	}
    
}