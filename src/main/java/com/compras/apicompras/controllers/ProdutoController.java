package com.compras.apicompras.controllers;

import com.compras.apicompras.models.ProdutoModel;
import com.compras.apicompras.services.ProdutoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/produto")
public class ProdutoController {

    final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // create produto
    @PostMapping()
    public ResponseEntity<Object> salvarProduto(@RequestBody @Valid ProdutoModel produtoDTO){
        ProdutoModel produtoModel = new ProdutoModel();
        BeanUtils.copyProperties(produtoDTO, produtoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produtoModel));
    }

    // get all produtos
    @GetMapping(value = "/")
    public ResponseEntity<Object> getAllProdutos(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.getAllProdutos());
    }

    // delete produto by id
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteProdutoById(@PathVariable("id") UUID id){
        produtoService.deleteProdutoById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso!");
    }

    // get produto by nome
    @GetMapping(value = "/nome/{nome}")
    public ResponseEntity<Object> getProdutoByNome(@PathVariable("nome") String nome){
        System.out.println("nome: " + nome);
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.getProdutoByNome(nome));
    }

    // get produto by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getProdutoById(@PathVariable("id") UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.getProdutoById(id));
    }

    // update produto
    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateProduto(@PathVariable("id") UUID id, @RequestBody @Valid ProdutoModel produtoDTO){
        ProdutoModel produtoModel = new ProdutoModel();
        BeanUtils.copyProperties(produtoDTO, produtoModel);
        produtoModel.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.save(produtoModel));
    }

    // get all produto precos
    @GetMapping(value = "/preco")
    public ResponseEntity<Object> getAllProdutoPrecos(@RequestBody @Valid List<String> listaDeProdutos){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.getAllProdutoPrecos(listaDeProdutos));
    }

}
