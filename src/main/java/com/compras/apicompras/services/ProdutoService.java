package com.compras.apicompras.services;

import com.compras.apicompras.models.ProdutoModel;
import com.compras.apicompras.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutoService {

    final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoModel save(ProdutoModel produto) {
        return produtoRepository.save(produto);
    }

    // get all produtos
    public Iterable<ProdutoModel> getAllProdutos() {
        return produtoRepository.findAll();
    }

    // delete produto by id
    public void deleteProdutoById(UUID id) {
        produtoRepository.deleteById(id);
    }

    //get by id
    public ProdutoModel getProdutoById(UUID id) {
        return produtoRepository.findById(id).get();
    }

    // get produto by nome
    public ProdutoModel getProdutoByNome(String nome) {
        return produtoRepository.findByNome(nome);
    }

   public double getAllProdutoPrecos(List<String> listaDecompras) {

        double precoTotal = 0f;
        for (String nome : listaDecompras) {
            ProdutoModel produto = produtoRepository.findByNome(nome);
            precoTotal += produto.getPreco();
        }
        return precoTotal;
    }

}
