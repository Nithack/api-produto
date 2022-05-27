package com.compras.apicompras.dto;

import javax.validation.constraints.NotBlank;

public class ProdutoDTO {

    @NotBlank()
    private String nome;

    @NotBlank()
    private String descricao;

    @NotBlank()
    private String codigo;

    @NotBlank()
    private double preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
