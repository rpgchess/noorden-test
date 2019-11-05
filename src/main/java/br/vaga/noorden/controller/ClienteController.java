package br.vaga.noorden.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.vaga.noorden.model.Cliente;
import br.vaga.noorden.repository.ClienteRepository;

@CrossOrigin
@RestController
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @RequestMapping(value = "/clientes", method = RequestMethod.GET)
    public List<Cliente> Get() {
        return clienteRepository.findAll();
    }

    @RequestMapping(value = "/clientes/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isPresent())
            return new ResponseEntity<Cliente>(cliente.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/clientes", method =  RequestMethod.POST)
    public Cliente Post(@Valid @RequestBody Cliente cliente)
    {
        return clienteRepository.save(cliente);
    }

    @RequestMapping(value = "/clientes/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Cliente> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Cliente newCliente)
    {
        Optional<Cliente> oldCliente = clienteRepository.findById(id);
        if(oldCliente.isPresent()){
            Cliente cliente = oldCliente.get();
            cliente.setNome(newCliente.getNome());
            cliente.setCpf(newCliente.getCpf());
            cliente.setDataNasc(newCliente.getDataNasc());
            cliente.setSexo(newCliente.getSexo());
            clienteRepository.save(cliente);
            return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/clientes/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isPresent()){
            clienteRepository.delete(cliente.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}