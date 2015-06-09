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
abstract public class ModelUsuario {
/**
 * atributos da classe ModelUsuario
 */
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String datanasc;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
/**
 * método que recebe o nome do usuário
 * @return 
 */
    public String getNome() {
        return nome;
    }
/**
 * método que envia o nome do usuário
 * @param nome 
 */
    public void setNome(String nome) {
        this.nome = nome;
    }
/**
 * método que recebe o email do usuário
 * @return 
 */
    public String getEmail() {
        return email;
    }
/**
 * método que envia o email do usuário
 * @param email 
 */
    public void setEmail(String email) {
        this.email = email;
    }
/**
 * método que recebe o telefone do usuário
 * @return 
 */
    public String getTelefone() {
        return telefone;
    }
/**
 * método que envia o telefone do usuário
 * @param telefone 
 */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
/**
 * método que recebe o cpf do usuário
 * @return 
 */
    public String getCpf() {
        return cpf;
    }
/**
 * método que envia o cpf do usuário
 * @param cpf 
 */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
/**
 * método que recebe a data de nascimento do usuário
 * @return 
 */
    public String  getDatanasc() {
        return datanasc;
    }
    /**
     * método que envia a data de nascimento do usuário
     * @param datanasc 
     */
    public void setDatanasc( String datanasc) {
        this.datanasc = datanasc;
    }
    /**
     * método que recebe o endereço do usuário
     * @return 
     */
    public String getEndereco() {
        return endereco;
    }
/**
 * método que envia o endereço do usuário
 * @param endereco 
 */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
/**
 * método que envia o bairro do usuário
 * @param bairro 
 */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
/**
 * método que recebe o bairro do usuário
 * @return 
 */
    public String getBairro() {
        return bairro;
    }
/**
 * método que envia a cidade do usuário
 * @param cidade 
 */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
/**
 * método que recebe a cidade do usuário
 * @return 
 */
    public String getCidade() {
        return cidade;
    }
/**
 * método que envia o estado do usuário
 * @param estado 
 */
    public void setEstado(String estado) {
        this.estado = estado;
    }
/**
 * método que recebe o estado do usuário
 * @return 
 */
    public String getEstado() {
        return estado;
    }
/**
 * método que recebe o cep do usuário
 * @return 
 */
    public String getCep() {
        return cep;
    }
/**
 * método que envia o cep do usuário
 * @param cep 
 */
    public void setCep(String cep) {
        this.cep = cep;
    }
}
