/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demo;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eduardo Marcio
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdcliente", query = "SELECT c FROM Cliente c WHERE c.idcliente = :idcliente"),
    @NamedQuery(name = "Cliente.findByNome", query = "SELECT c FROM Cliente c WHERE c.nome = :nome"),
    @NamedQuery(name = "Cliente.findByEmail", query = "SELECT c FROM Cliente c WHERE c.email = :email"),
    @NamedQuery(name = "Cliente.findByTelefone", query = "SELECT c FROM Cliente c WHERE c.telefone = :telefone"),
    @NamedQuery(name = "Cliente.findByCpf", query = "SELECT c FROM Cliente c WHERE c.cpf = :cpf")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcliente")
    private Integer idcliente;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "telefone")
    private String telefone;
    @Basic(optional = false)
    @Column(name = "cpf")
    private String cpf;

    public Cliente() {
    }

    public Cliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Cliente(Integer idcliente, String nome, String email, String telefone, String cpf) {
        this.idcliente = idcliente;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcliente != null ? idcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "demo.Cliente[ idcliente=" + idcliente + " ]";
    }
    
}
