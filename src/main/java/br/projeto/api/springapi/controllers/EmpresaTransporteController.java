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

import br.projeto.api.springapi.entity.EmpresaTransporte;
import br.projeto.api.springapi.repository.EmpresaTransporteRepository;

@CrossOrigin
@RestController
public class EmpresaTransporteController {
    @Autowired
    private EmpresaTransporteRepository _EmpresaTransporteRepository;

    @RequestMapping(value = "/empresa/transporte", method = RequestMethod.GET)
    public List<EmpresaTransporte> Get() {
        return _EmpresaTransporteRepository.findAll();
    }

    @RequestMapping(value = "/empresa/transporte/{id}", method = RequestMethod.GET)
    public ResponseEntity<EmpresaTransporte> GetById(@PathVariable(value = "id") long id) {
        Optional<EmpresaTransporte> empresaTransporte = _EmpresaTransporteRepository.findById(id);

        if (empresaTransporte.isPresent())
            return new ResponseEntity<EmpresaTransporte>(empresaTransporte.get(), HttpStatus.OK);
        else   
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/empresa/transporte", method = RequestMethod.POST)
    public EmpresaTransporte Post(@RequestBody EmpresaTransporte empresaTransporte) {
        return _EmpresaTransporteRepository.save(empresaTransporte);
    }

    @RequestMapping(value = "/empresa/transporte/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<EmpresaTransporte> Put(@PathVariable(value = "id") long id, @RequestBody EmpresaTransporte newEmpresaTransporte)
    {
        Optional<EmpresaTransporte> oldEmpresaTransporte = _EmpresaTransporteRepository.findById(id);
        if(oldEmpresaTransporte.isPresent()){
            EmpresaTransporte empresaTransporte = oldEmpresaTransporte.get();
            empresaTransporte.setPais(newEmpresaTransporte.getPais());
            _EmpresaTransporteRepository.save(empresaTransporte);
            return new ResponseEntity<EmpresaTransporte>(empresaTransporte, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/empresa/transporte/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<EmpresaTransporte> empresaTransporte = _EmpresaTransporteRepository.findById(id);
        if(empresaTransporte.isPresent()){
            _EmpresaTransporteRepository.delete(empresaTransporte.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}