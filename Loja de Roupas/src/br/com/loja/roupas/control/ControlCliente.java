/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.roupas.control;

import br.com.loja.roupas.dao.ConexaoDao;
import br.com.loja.roupas.model.ModelCliente;
import static br.com.loja.roupas.view.InternalFrameCliente.Pesquisa;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Eduardo Marcio
 */
public class ControlCliente {

    private Connection conexao;
    private String sql;
    private PreparedStatement stmt;
    private ModelCliente cliente;
    private ResultSet rs;

    public ControlCliente()  {
        this.conexao = ConexaoDao.conexaoDB();//.getConnection();
      
    }

    public void adiciona(ModelCliente cliente) {

        sql = "INSERT INTO lojaderoupa.clientes("
                + "nome,email,telefone"
                + ",cpf"//datanascimento"
                + ",endereco,cep) "
                + "VALUES(?,?,?,?,?,?)";

        try {

            stmt = conexao.prepareStatement(sql);
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

    public void excluiCliente(ModelCliente cliente) throws Exception {

        sql = "DELETE FROM lojaderoupa.clientes"
                + " WHERE idclientes= ?";
        try {

            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, cliente.getIdCliente());
            stmt.execute();
            stmt.close();

        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

    }

    public ModelCliente pesquisaCliente() {
        cliente = new ModelCliente();
        sql = "SELECT  * FROM lojaderoupa.clientes WHERE nome LIKE ?";

        try {

            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, Pesquisa() + "%");
            rs = stmt.executeQuery();

            if (rs.next()) {

                cliente.setIdCliente(rs.getInt("idclientes"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setCep(rs.getString("cep"));

            }

            rs.close();
            stmt.close();

        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

        return cliente;
    }

    public void AtualizarCliente(ModelCliente cliente) {

        sql = "UPDATE lojaderoupa.clientes SET "
                + "nome='" + cliente.getNome()
                + "', email='" + cliente.getEmail()
                + "', telefone='" + cliente.getTelefone()
                + "', cpf='" + cliente.getCpf()
                + //"', datanascimento='"+cliente.getEnderco()+
                "', endereco='" + cliente.getEndereco()
                + "', cep='" + cliente.getCep()
                + "' WHERE idclientes=" + cliente.getIdCliente();

        try {

            stmt = conexao.prepareStatement(sql);

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

}
