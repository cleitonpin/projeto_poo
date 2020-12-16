package br.projeto.api.springapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.projeto.api.springapi.entity.Transportadora;

@Repository
public interface TransportadoraRepository extends JpaRepository<Transportadora, Long>{

    
}