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

import br.vaga.noorden.model.Venda;
import br.vaga.noorden.repository.VendaRepository;

@CrossOrigin
@RestController
public class VendaController {
    @Autowired
    private VendaRepository vendaRepository;

    @RequestMapping(value = "/vendas", method = RequestMethod.GET)
    public List<Venda> Get() {
        return vendaRepository.findAll();
    }

    @RequestMapping(value = "/vendas/{id}", method = RequestMethod.GET)
    public ResponseEntity<Venda> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Venda> venda = vendaRepository.findById(id);
        if(venda.isPresent())
            return new ResponseEntity<Venda>(venda.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/vendas", method =  RequestMethod.POST)
    public Venda Post(@Valid @RequestBody Venda venda)
    {
        return vendaRepository.save(venda);
    }

    @RequestMapping(value = "/vendas/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Venda> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Venda newVenda)
    {
        Optional<Venda> oldVenda = vendaRepository.findById(id);
        if(oldVenda.isPresent()){
            Venda venda = oldVenda.get();
            venda.setCodCliente(newVenda.getCodCliente());
            venda.setCodProduto(newVenda.getCodProduto());
            venda.setValorTotal(newVenda.getValorTotal());
            vendaRepository.save(venda);
            return new ResponseEntity<Venda>(venda, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/vendas/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Venda> venda = vendaRepository.findById(id);
        if(venda.isPresent()){
            vendaRepository.delete(venda.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}