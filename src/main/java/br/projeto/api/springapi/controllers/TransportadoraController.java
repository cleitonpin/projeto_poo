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

import br.projeto.api.springapi.entity.Transportadora;
import br.projeto.api.springapi.repository.TransportadoraRepository;

@RestController
public class TransportadoraController {
    @Autowired
    private TransportadoraRepository _TransportadoraRepository;

    @RequestMapping(value = "/transportadora", method = RequestMethod.GET)
    public List<Transportadora> Get() {
        return _TransportadoraRepository.findAll();
    }

    @RequestMapping(value = "/transportadora/{id}", method = RequestMethod.GET)
    public ResponseEntity<Transportadora> GetById(@PathVariable(value = "id") Long id) {
        Optional<Transportadora> transportadora = _TransportadoraRepository.findById(id);

        if (transportadora.isPresent())
            return new ResponseEntity<Transportadora>(transportadora.get(), HttpStatus.OK);
        else   
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/transportadora", method = RequestMethod.POST)
    public Transportadora Post(@RequestBody Transportadora transportadora) {
        return _TransportadoraRepository.save(transportadora);
    }

    @RequestMapping(value = "/transportadora/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Transportadora> Put(@PathVariable(value = "id") Long id, @RequestBody Transportadora newTransportadora)
    {
        Optional<Transportadora> oldTransportadora = _TransportadoraRepository.findById(id);
        if(oldTransportadora.isPresent()){
            Transportadora transportadora = oldTransportadora.get();
            transportadora.setNome(newTransportadora.getNome());
            _TransportadoraRepository.save(transportadora);
            return new ResponseEntity<Transportadora>(transportadora, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/transportadora/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") Long id)
    {
        Optional<Transportadora> transportadora = _TransportadoraRepository.findById(id);
        if(transportadora.isPresent()){
            _TransportadoraRepository.delete(transportadora.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
