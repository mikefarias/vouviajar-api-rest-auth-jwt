package br.com.vouviajar.vouviajar.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.vouviajar.vouviajar.repository.UserRepository;
import br.com.vouviajar.vouviajar.model.User;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;


	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> maybe_user = userRepository.findByUsername(email);
		if (maybe_user.isEmpty()) {
			throw new UsernameNotFoundException("Usuário não encontrado com o username: " + email);
        }
        User user = maybe_user.get();
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				new ArrayList<>());
	}
	
	//public UserDao save(UserDTO user) {
	public User save(User user) {
		User newUser = new User();
		newUser.setEmail(user.getEmail());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepository.save(newUser);
	}
}
