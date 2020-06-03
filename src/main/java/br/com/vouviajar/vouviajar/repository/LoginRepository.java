package br.com.vouviajar.vouviajar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vouviajar.vouviajar.model.User;

@Repository
public interface LoginRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String login);

    Optional<User> findById(Long idUser);
} 