package br.projeto.api.springapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.projeto.api.springapi.entity.Carga;

@Repository
public interface CargaRepository extends JpaRepository<Carga, Long>{

    
}