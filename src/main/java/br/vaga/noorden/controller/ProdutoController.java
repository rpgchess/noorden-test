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

import br.vaga.noorden.model.Produto;
import br.vaga.noorden.repository.ProdutoRepository;

@CrossOrigin
@RestController
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @RequestMapping(value = "/produtos", method = RequestMethod.GET)
    public List<Produto> Get() {
        return produtoRepository.findAll();
    }

    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.GET)
    public ResponseEntity<Produto> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isPresent())
            return new ResponseEntity<Produto>(produto.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/produtos", method =  RequestMethod.POST)
    public Produto Post(@Valid @RequestBody Produto produto)
    {
        return produtoRepository.save(produto);
    }

    @RequestMapping(value = "/produtos/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Produto> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Produto newProduto)
    {
        Optional<Produto> oldProduto = produtoRepository.findById(id);
        if(oldProduto.isPresent()){
            Produto produto = oldProduto.get();
            produto.setNome(newProduto.getNome());
            produto.setValor(newProduto.getValor());
            produtoRepository.save(produto);
            return new ResponseEntity<Produto>(produto, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isPresent()){
            produtoRepository.delete(produto.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}