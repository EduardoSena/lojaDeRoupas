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
public class ModelPedidos {
    
    
private int codigoPedido;
private String dataPedido;
private double valorPedido;
private int quantidadePedido;
private  String nomeProduto ;
private  String nomeCliente ;
private  String nomeFunc ;
 private int fkProduto ;
private  int fkCliente ;
 private int fkFunc ;
    /**
     * @return the codigoPedido
     */
    public int getCodigoPedido()  {
        return codigoPedido;
    }

    /**
     * @param codigoPedido the codigoPedido to set
     */
    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    /**
     * @return the dataPedido
     */
    public String getDataPedido() {
        return dataPedido;
    }

    /**
     * @param dataPedido the dataPedido to set
     */
    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }



    /**
     * @return the valorPedido
     */
    public double getValorPedido() {
        return valorPedido;
    }

    /**
     * @param valorPedido the valorPedido to set
     */
    public void setValorPedido(double valorPedido) {
        this.valorPedido = valorPedido;
    }

    /**
     * @return the quantidadePedido
     */
    public int getQuantidadePedido() {
        return quantidadePedido;
    }

    /**
     * @param quantidadePedido the quantidadePedido to set
     */
    public void setQuantidadePedido(int quantidadePedido) {
        this.quantidadePedido = quantidadePedido;
        
    }

    /**
     * @return the nomeProduto
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     * @param nomeProduto the nomeProduto to set
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    /**
     * @return the nomeCliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * @param nomeCliente the nomeCliente to set
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * @return the nomeFunc
     */
    public String getNomeFunc() {
        return nomeFunc;
    }

    /**
     * @param nomeFunc the nomeFunc to set
     */
    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    /**
     * @return the fkProduto
     */
    public int getFkProduto() {
        return fkProduto;
    }

    /**
     * @param fkProduto the fkProduto to set
     */
    public void setFkProduto(int fkProduto) {
        this.fkProduto = fkProduto;
    }

    /**
     * @return the fkCliente
     */
    public int getFkCliente() {
        return fkCliente;
    }

    /**
     * @param fkCliente the fkCliente to set
     */
    public void setFkCliente(int fkCliente) {
        this.fkCliente = fkCliente;
    }

    /**
     * @return the fkFunc
     */
    public int getFkFunc() {
        return fkFunc;
    }

    /**
     * @param fkFunc the fkFunc to set
     */
    public void setFkFunc(int fkFunc) {
        this.fkFunc = fkFunc;
    }

 

    
}
