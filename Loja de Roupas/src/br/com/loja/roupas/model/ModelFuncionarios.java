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

public class ModelFuncionarios extends ModelUsuario{
/**
 * atributos que existem apenas na classe ModelFuncionarios
 */
    private double salario;
    private double comissao;
    private String dataAdmissao;
    private int idFuncionario;
    
     public int getIdFuncionario() {
        return idFuncionario;
    }
       public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    /**
     * métodos que enviam e recebem informações
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

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
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
    public String getBairro() {
        return super.getBairro(); 
    }

    @Override
    public void setBairro(String bairro) {
        super.setBairro(bairro); 
    }

    @Override
    public String getCidade() {
        return super.getCidade(); 
    }

    @Override
    public void setCidade(String cidade) {
        super.setCidade(cidade); 
    }

    @Override
    public String getEstado() {
        return super.getEstado(); 
    }

    @Override
    public void setEstado(String estado) {
        super.setEstado(estado); 
    }

      
     
    
    @Override
    public String getCep() {
        return super.getCep(); 
    }

    @Override
    public void setCep(String cep) {
        super.setCep(cep);
    }

    /**
     * @return the salario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * @return the comissao
     */
    public double getComissao() {
        return comissao;
    }

    /**
     * @param comissao the comissao to set
     */
    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    
    
    
}
