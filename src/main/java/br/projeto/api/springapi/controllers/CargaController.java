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

import br.projeto.api.springapi.entity.Carga;
import br.projeto.api.springapi.repository.CargaRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CargaController {
    @Autowired
    private CargaRepository _CargaRepository;

    @RequestMapping(value = "/carga", method = RequestMethod.GET)
    public List<Carga> Get() {
        return _CargaRepository.findAll();
    }

    @RequestMapping(value = "/carga/{id}", method = RequestMethod.GET)
    public ResponseEntity<Carga> GetById(@PathVariable(value = "id") long id) {
        Optional<Carga> carga = _CargaRepository.findById(id);

        if (carga.isPresent())
            return new ResponseEntity<Carga>(carga.get(), HttpStatus.OK);
        else   
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/carga", method = RequestMethod.POST)
    public Carga Post(@RequestBody Carga carga) {
        return _CargaRepository.save(carga);
    }

    @RequestMapping(value = "/carga/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Carga> Put(@PathVariable(value = "id") long id, @RequestBody Carga newCarga)
    {
        Optional<Carga> oldCarga = _CargaRepository.findById(id);
        if(oldCarga.isPresent()){
            Carga carga = oldCarga.get();
            carga.setValor(newCarga.getValor());
            _CargaRepository.save(carga);
            return new ResponseEntity<Carga>(carga, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/carga/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Carga> carga = _CargaRepository.findById(id);
        if(carga.isPresent()){
            _CargaRepository.delete(carga.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}