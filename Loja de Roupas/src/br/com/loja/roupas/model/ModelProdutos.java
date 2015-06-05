/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.roupas.model;

/**
 *
 * @author Eduardo, Gustavo e Ludimila
 */
public class ModelProdutos {

    private int codigoProdutos;
    private int fkFuncionarios;
    private String nome;
    private String descricao;
    private double precounitario;
    private String cor;
    private String tamanho;
    private String marca;

    /**
     * @return the codigoProdutos
     */
    public int getCodigoProdutos() {
        return codigoProdutos;
        
    }

    /**
     * @param codigoProdutos the codigoProdutos to set
     */
    public void setCodigoProdutos(int codigoProdutos) {
        this.codigoProdutos = codigoProdutos;
    }

    /**
     * @return the fkFuncionarios
     */
    public int getFkFuncionarios() {
        return fkFuncionarios;
    }

    /**
     * @param fkFuncionarios the fkFuncionarios to set
     */
    public void setFkFuncionarios(int fkFuncionarios) {
        this.fkFuncionarios = fkFuncionarios;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the precounitario
     */
    public double getPrecounitario() {
        return precounitario;
    }

    /**
     * @param precounitario the precounitario to set
     */
    public void setPrecounitario(double precounitario) {
        this.precounitario = precounitario;
    }

    /**
     * @return the cor
     */
    public String getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * @return the tamanho
     */
    public String getTamanho() {
        return tamanho;
    }

    /**
     * @param tamanho the tamanho to set
     */
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

}
