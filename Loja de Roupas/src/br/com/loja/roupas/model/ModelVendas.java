/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.loja.roupas.model;

/**
 *
 * @author Eduardo Marcio
 */
public class ModelVendas {
    private int quantidadeEstoque;
    private double valortotalProdutos;
    private int quantidadePedidos;
    private double valorTotalPedidos;

    /**
     * @return the quantidadeEstoque
     */
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    /**
     * @param quantidadeEstoque the quantidadeEstoque to set
     */
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    /**
     * @return the valortotalProdutos
     */
    public double getValortotalProdutos() {
        return valortotalProdutos;
    }

    /**
     * @param valortotalProdutos the valortotalProdutos to set
     */
    public void setValortotalProdutos(double valortotalProdutos) {
        this.valortotalProdutos = valortotalProdutos;
    }

    /**
     * @return the quantidadePedidos
     */
    public int getQuantidadePedidos() {
        return quantidadePedidos;
    }

    /**
     * @param quantidadePedidos the quantidadePedidos to set
     */
    public void setQuantidadePedidos(int quantidadePedidos) {
        this.quantidadePedidos = quantidadePedidos;
    }

    /**
     * @return the valorTotalPedidos
     */
    public double getValorTotalPedidos() {
        return valorTotalPedidos;
    }

    /**
     * @param valorTotalPedidos the valorTotalPedidos to set
     */
    public void setValorTotalPedidos(double valorTotalPedidos) {
        this.valorTotalPedidos = valorTotalPedidos;
    }
    
    
}
