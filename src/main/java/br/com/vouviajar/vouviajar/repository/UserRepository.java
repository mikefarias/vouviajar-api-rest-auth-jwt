package br.com.vouviajar.vouviajar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vouviajar.vouviajar.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {} 