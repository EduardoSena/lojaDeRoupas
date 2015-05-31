/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.roupas.control;

import br.com.loja.roupas.dao.ConexaoDao;
import br.com.loja.roupas.model.ModelCliente;
import br.com.loja.roupas.view.FmPrincipalMdi;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo Marcio
 */
public class ControlCliente {

    private Connection connection;

    public ControlCliente() {
        this.connection = new ConexaoDao().getConnection();
    }

    public void adiciona(ModelCliente cliente) {

        String sql = "INSERT INTO lojaderoupa.clientes("
                + "nome,email,telefone"
                + ",cpf"//datanascimento"
                + ",endereco,cep) "
                + "VALUES(?,?,?,?,?,?)";
      
  
        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getCpf());
           // stmt.setDate(5, cliente.getDatanasc());
            stmt.setString(5, cliente.getEndereco());
            stmt.setString(6, cliente.getCep());
            stmt.execute();
            stmt.close();

        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

    }
    
   
}
