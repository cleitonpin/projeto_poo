package br.projeto.api.springapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.projeto.api.springapi.entity.Fornecedores;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedores, Long>{

    
}