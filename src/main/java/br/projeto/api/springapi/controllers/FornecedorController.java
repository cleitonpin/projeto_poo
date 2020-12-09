package br.projeto.api.springapi.controllers;

import java.util.List;
import java.util.Optional;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.projeto.api.springapi.entity.Fornecedores;
import br.projeto.api.springapi.repository.FornecedorRepository;

@RestController
public class FornecedorController {
    @Autowired
    private FornecedorRepository _FornecedorRepository;

    @RequestMapping(value = "/fornecedor", method = RequestMethod.GET)
    public List<Fornecedores> Get() {
        return _FornecedorRepository.findAll();
    }

    @RequestMapping(value = "/fornecedor/{id}", method = RequestMethod.GET)
    public ResponseEntity<Fornecedores> GetById(@PathVariable(value = "id") Long id) {
        Optional<Fornecedores> fornecedor = _FornecedorRepository.findById(id);

        if (fornecedor.isPresent())
            return new ResponseEntity<Fornecedores>(fornecedor.get(), HttpStatus.OK);
        else   
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/forn", method = RequestMethod.POST)
    public Fornecedores Post(@RequestBody Fornecedores fornecedor) {
        return _FornecedorRepository.save(fornecedor);
    }

    @RequestMapping(value = "/fornecedor/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Fornecedores> Put(@PathVariable(value = "id") Long id, @RequestBody Fornecedores newFornecedor)
    {
        Optional<Fornecedores> oldFornecedor = _FornecedorRepository.findById(id);
        if(oldFornecedor.isPresent()){
            Fornecedores fornecedor = oldFornecedor.get();
            fornecedor.setNome(newFornecedor.getNome());
            _FornecedorRepository.save(fornecedor);
            return new ResponseEntity<Fornecedores>(fornecedor, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/fornecedor/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") Long id)
    {
        Optional<Fornecedores> fornecedor = _FornecedorRepository.findById(id);
        if(fornecedor.isPresent()){
            _FornecedorRepository.delete(fornecedor.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}