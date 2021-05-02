package com.produtos.apirest.resources;

import com.produtos.apirest.models.Produto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.produtos.apirest.repository.ProdutoRepository;

import java.io.IOException;
import java.util.List;

//Classe que irá receber as requisições http
@RestController
//URI padrão para nossa aplicação
@RequestMapping(value = "/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins = "*")//por exemplo pode ser um domínio no lugar do asterísco: /http://exemplo.com.br
public class ProdutoResource {

    @Autowired //(required = true)
    ProdutoRepository produtoRepository;

    //Criação metodo que lista todos produtos no Banco de Dados
    @GetMapping("/produtos")
    public List<Produto> listaProduto(){
        return produtoRepository.findAll();
    }

    //Criação metodo que lista um produto específico no Banco de Dados
    @GetMapping("/produto/{id}")
    @ApiOperation(value = "Retorna uma lista completa de produtos")
    public Produto listaProdutoUnico(@PathVariable(value = "id") long id){
        return produtoRepository.findById(id);
    }

    @PostMapping("/produto")
    @ApiOperation(value = "Retorna um produto único de uma lista de produtos")
    public Produto salvaProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/produto/{id}")
    @ApiOperation(value = "Apaga um produto único de uma lista de produtos")
    public void deletaProduto(@RequestBody Produto produto) {
        produtoRepository.delete(produto);
    }

    @PutMapping("/produto")
    @ApiOperation(value = "Atualiza um produto único de uma lista de produtos")
    public Produto atualizaProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

}