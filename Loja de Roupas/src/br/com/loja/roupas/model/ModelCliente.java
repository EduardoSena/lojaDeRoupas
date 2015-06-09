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
public class ModelCliente extends ModelUsuario {
/**
 * atributos privados declarados
 */
    private int idCliente;
    private double desconto;
/**
 * métodos que recebem e enviam informações que existem apenas na classe ModelCliente
 * @return 
 */
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idcliente) {
        this.idCliente = idcliente;
    }

    public double getDesconto() {
        return this.desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
/**
 * métodos que recebem e enviam informações
 * @return 
 */
    @Override
    public String getNome() {
        return super.getNome(); 
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome); 
    }

    @Override
    public String getEmail() {
        return super.getEmail(); 
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email); 
    }

    @Override
    public String getTelefone() {
        return super.getTelefone(); 
    }

    @Override
    public void setTelefone(String telefone) {
        super.setTelefone(telefone); 
    }

    @Override
    public String getCpf() {
        return super.getCpf(); 
    }

    @Override
    public void setCpf(String cpf) {
        super.setCpf(cpf); 
    }

 
    @Override
    public  String getDatanasc() {
        return super.getDatanasc(); 
    }

   


    @Override
    public void setDatanasc( String datanasc) {
        super.setDatanasc(datanasc); 
    }

    @Override
    public String getEndereco() {
        return super.getEndereco(); 
    }

    @Override
    public void setEndereco(String endereco) {
        super.setEndereco(endereco); 
    }

    @Override
    public String getCep() {
        return super.getCep(); 
    }

    @Override
    public void setCep(String cep) {
        super.setCep(cep);
    }

}
