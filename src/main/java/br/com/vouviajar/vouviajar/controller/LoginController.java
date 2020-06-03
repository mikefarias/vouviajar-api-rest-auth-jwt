package br.com.vouviajar.vouviajar.controller;

import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<AutheticatedUserDTO> login(@RequestBody CredentialsDTO login, HttpServletResponse response){
        Optional<User> maybe_user = loginService.login(login);
        User user = maybe_user.get();
        String jwt = JWT.create()
                .withClaim("idUsuarioLogado", user.getId())
                .sign(Algorithm.HMAC256("algosecretoaqui"));

        Cookie cookie = new Cookie("token", jwt);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(60 * 30); // 30 minutos
        response.addCookie(cookie);

        return new ResponseEntity<AutheticatedUserDTO>(AutheticatedUserDTO.toDTO(user), HttpStatus.ACCEPTED);
    }

}