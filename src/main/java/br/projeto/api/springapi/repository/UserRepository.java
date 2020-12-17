package br.projeto.api.springapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.projeto.api.springapi.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

    Optional<Users> findByUsernameAndSenha(String username, String senha);
}