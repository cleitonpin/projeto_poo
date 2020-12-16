package br.projeto.api.springapi.controllers;

import java.util.List;
import java.util.Optional;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.projeto.api.springapi.entity.Ambiente;
import br.projeto.api.springapi.repository.AmbienteRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AmbienteController {
    @Autowired
    private AmbienteRepository _AmbienteRepository;

    @RequestMapping(value = "/empresa/ambiente", method = RequestMethod.GET)
    public List<Ambiente> Get() {
        return _AmbienteRepository;.findAll();
    }

    @RequestMapping(value = "/empresa/ambiente/{id}", method = RequestMethod.GET)
    public ResponseEntity<Ambiente> GetById(@PathVariable(value = "id") long id) {
        Optional<Ambiente> ambiente = _AmbienteRepository;.findById(id);

        if (ambiente.isPresent())
            return new ResponseEntity<Ambiente>(ambiente.get(), HttpStatus.OK);
        else   
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/empresa/ambiente", method = RequestMethod.POST)
    public Ambiente Post(@RequestBody Ambiente ambiente) {
        return _AmbienteRepository;.save(ambiente);
    }

    @RequestMapping(value = "/empresa/ambiente/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Ambiente> Put(@PathVariable(value = "id") long id, @RequestBody Ambiente newAmbiente)
    {
        Optional<Ambiente> oldAmbiente = _AmbienteRepository;.findById(id);
        if(oldAmbiente.isPresent()){
            Ambiente ambiente = oldAmbiente.get();
            ambiente.setNome(newAmbiente.getNome());
            ambiente.setCnpj(newAmbiente.getCnpj());
            _AmbienteRepository;.save(ambiente);
            return new ResponseEntity<Ambiente>(ambiente, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/empresa/ambiente/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Ambiente> ambiente = _AmbienteRepository;.findById(id);
        if(ambiente.isPresent()){
            _AmbienteRepository;.delete(ambiente.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}