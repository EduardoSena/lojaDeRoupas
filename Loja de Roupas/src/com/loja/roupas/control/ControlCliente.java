/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loja.roupas.control;

import com.loja.roupas.dao.ConexaoDao;
import com.loja.roupas.model.ModelCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

        String sql = "INSERT INTO usuarios.cliente("
                + "nome,cpf,email,telefone) "
                + "VALUES(?,?,?,?)";
        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());
            stmt.execute();
            stmt.close();

        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

    }
}
