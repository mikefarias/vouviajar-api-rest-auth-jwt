package br.com.vouviajar.vouviajar.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import org.springframework.http.HttpStatus;
import org.springframework.web.util.WebUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse httpResponse = (HttpServletResponse)response;
        HttpServletRequest httpRequest = (HttpServletRequest)request;

        if (!httpRequest.getServletPath().startsWith("/api")) {
            // requisição para recurso estático
            chain.doFilter(request, response);
            return;
        }

        if (httpRequest.getServletPath().startsWith("/api/login")) {
            // o usuário está tentando se autenticar
            chain.doFilter(request, response);
            return;
        }

        Cookie token = WebUtils.getCookie(httpRequest, "token");
        if (token == null) {
            httpResponse.sendError(HttpStatus.UNAUTHORIZED.value());
            return;
        }

        try {

            String jwt = token.getValue();

            DecodedJWT decodedJwt = JWT.require(Algorithm.HMAC256("algosecretoaqui"))
                    .build()
                    .verify(jwt);

            Integer idUsuarioLogado = decodedJwt.getClaim("idUsuarioLogado").asInt();
            httpRequest.setAttribute("idUsuarioLogado", idUsuarioLogado);

            // chamada autenticada
            chain.doFilter(request, response);

        } catch (JWTVerificationException ex) {
            httpResponse.sendError(HttpStatus.UNAUTHORIZED.value());
            return;
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }

}