/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.loja.roupas.view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Eduardo Marcio
 */
@Entity
@Table(name = "produtos", catalog = "dbloja", schema = "lojaderoupa")
@NamedQueries({
    @NamedQuery(name = "Produtos.findAll", query = "SELECT p FROM Produtos p"),
    @NamedQuery(name = "Produtos.findByIdprodutos", query = "SELECT p FROM Produtos p WHERE p.idprodutos = :idprodutos"),
    @NamedQuery(name = "Produtos.findByFkfuncionarios", query = "SELECT p FROM Produtos p WHERE p.fkfuncionarios = :fkfuncionarios"),
    @NamedQuery(name = "Produtos.findByNome", query = "SELECT p FROM Produtos p WHERE p.nome = :nome"),
    @NamedQuery(name = "Produtos.findByDescricao", query = "SELECT p FROM Produtos p WHERE p.descricao = :descricao"),
    @NamedQuery(name = "Produtos.findByPrecounitario", query = "SELECT p FROM Produtos p WHERE p.precounitario = :precounitario"),
    @NamedQuery(name = "Produtos.findByCor", query = "SELECT p FROM Produtos p WHERE p.cor = :cor"),
    @NamedQuery(name = "Produtos.findByTamanho", query = "SELECT p FROM Produtos p WHERE p.tamanho = :tamanho"),
    @NamedQuery(name = "Produtos.findByMarca", query = "SELECT p FROM Produtos p WHERE p.marca = :marca")})
public class Produtos implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprodutos")
    private Integer idprodutos;
    @Basic(optional = false)
    @Column(name = "fkfuncionarios")
    private int fkfuncionarios;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "precounitario")
    private double precounitario;
    @Basic(optional = false)
    @Column(name = "cor")
    private String cor;
    @Basic(optional = false)
    @Column(name = "tamanho")
    private String tamanho;
    @Basic(optional = false)
    @Column(name = "marca")
    private String marca;

    public Produtos() {
    }

    public Produtos(Integer idprodutos) {
        this.idprodutos = idprodutos;
    }

    public Produtos(Integer idprodutos, int fkfuncionarios, String nome, String descricao, double precounitario, String cor, String tamanho, String marca) {
        this.idprodutos = idprodutos;
        this.fkfuncionarios = fkfuncionarios;
        this.nome = nome;
        this.descricao = descricao;
        this.precounitario = precounitario;
        this.cor = cor;
        this.tamanho = tamanho;
        this.marca = marca;
    }

    public Integer getIdprodutos() {
        return idprodutos;
    }

    public void setIdprodutos(Integer idprodutos) {
        Integer oldIdprodutos = this.idprodutos;
        this.idprodutos = idprodutos;
        changeSupport.firePropertyChange("idprodutos", oldIdprodutos, idprodutos);
    }

    public int getFkfuncionarios() {
        return fkfuncionarios;
    }

    public void setFkfuncionarios(int fkfuncionarios) {
        int oldFkfuncionarios = this.fkfuncionarios;
        this.fkfuncionarios = fkfuncionarios;
        changeSupport.firePropertyChange("fkfuncionarios", oldFkfuncionarios, fkfuncionarios);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
    }

    public double getPrecounitario() {
        return precounitario;
    }

    public void setPrecounitario(double precounitario) {
        double oldPrecounitario = this.precounitario;
        this.precounitario = precounitario;
        changeSupport.firePropertyChange("precounitario", oldPrecounitario, precounitario);
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        String oldCor = this.cor;
        this.cor = cor;
        changeSupport.firePropertyChange("cor", oldCor, cor);
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        String oldTamanho = this.tamanho;
        this.tamanho = tamanho;
        changeSupport.firePropertyChange("tamanho", oldTamanho, tamanho);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        String oldMarca = this.marca;
        this.marca = marca;
        changeSupport.firePropertyChange("marca", oldMarca, marca);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprodutos != null ? idprodutos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtos)) {
            return false;
        }
        Produtos other = (Produtos) object;
        if ((this.idprodutos == null && other.idprodutos != null) || (this.idprodutos != null && !this.idprodutos.equals(other.idprodutos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.loja.roupas.view.Produtos[ idprodutos=" + idprodutos + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
