/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.roupas.control;

import br.com.loja.roupas.dao.ConexaoDao;
import br.com.loja.roupas.model.ModelCliente;
import br.com.loja.roupas.view.InternalFrameCliente;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo Marcio, Ludimila e Gustavo
 */
public class ControlCliente {

    private Connection conexao;
    private String sql;
    private PreparedStatement stmt;
    private ModelCliente cliente;
    private ResultSet rs;
    private String pesquisa;
    private String dataAniversario;
/**
 * Método construtor da classe cliente que faz conexão com o banco
 * 
 */
    public ControlCliente() {
        this.conexao = ConexaoDao.conexaoDB();

    }
/**
 * Médoto cadastra cliente passando com referência cliente
 * @param cliente 
 */
    public void adiciona(ModelCliente cliente) {

        Date dataAniv = null;
        try {
            dataAniv = new SimpleDateFormat("dd/MM/yyyy").parse(cliente.getDatanasc());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex);
            Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql = "INSERT INTO lojaderoupa.clientes("
                + "nome,email,telefone"
                + ",cpf,endereco,cep,datanascimento) "
                + "VALUES(?,?,?,?,?,?,?)";

        try {

            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getCpf());
            stmt.setString(5, cliente.getEndereco());
            stmt.setString(6, cliente.getCep());

            dataAniversario = new SimpleDateFormat("yyyy-MM-dd").format(dataAniv);
            stmt.setDate(7, java.sql.Date.valueOf(dataAniversario));

            stmt.execute();
            stmt.close();

        } catch (SQLException u) {
            JOptionPane.showMessageDialog(null, u);

        }

    }
/**
 * Método que Exclui um clinte 
 * @param cliente
 * @throws Exception 
 */
    public void excluiCliente(ModelCliente cliente) throws Exception {

        sql = "DELETE FROM lojaderoupa.clientes"
                + " WHERE idclientes= ?";
        try {

            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, cliente.getIdCliente());
            stmt.execute();
            stmt.close();

        } catch (SQLException u) {
           JOptionPane.showMessageDialog(null, u);
        }

    }
/**
 * Método de pesquisa de um cliente
 * @return 
 */
    public ModelCliente pesquisaCliente() {
        cliente = new ModelCliente();
        sql = "SELECT  * FROM lojaderoupa.clientes WHERE nome LIKE ?";

        try {
            pesquisa = InternalFrameCliente.Pesquisa();
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pesquisa + "%");
            rs = stmt.executeQuery();

            if (rs.next()) {

                cliente.setIdCliente(rs.getInt("idclientes"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setCep(rs.getString("cep"));

                Date dataAniv = null;
                try {
                    dataAniv = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("datanascimento"));

                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                    Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                dataAniversario = new SimpleDateFormat("dd/MM/yyyy").format(dataAniv);
                cliente.setDatanasc(dataAniversario);

            }

            rs.close();
            stmt.close();

        } catch (SQLException u) {
            JOptionPane.showMessageDialog(null, u);
            throw new RuntimeException(u);
        }

        return cliente;
    }
/**
 * Método de Atualização dos clientes cadastrados
 * @param cliente 
 */
    public void AtualizarCliente(ModelCliente cliente) {

        Date dataAniv = null;

        try {
            dataAniv = new SimpleDateFormat("dd/MM/yyyy").parse(cliente.getDatanasc());

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex);
            Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        dataAniversario = new SimpleDateFormat("yyyy-MM-dd").format(dataAniv);

        sql = "UPDATE lojaderoupa.clientes SET "
                + "nome='" + cliente.getNome()
                + "', email='" + cliente.getEmail()
                + "', telefone='" + cliente.getTelefone()
                + "', cpf='" + cliente.getCpf()
                + "', endereco='" + cliente.getEndereco()
                + "', cep='" + cliente.getCep()
                + "', datanascimento='" + dataAniversario
                + "' WHERE idclientes=" + cliente.getIdCliente();

        try {

            stmt = conexao.prepareStatement(sql);

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException u) {
            JOptionPane.showMessageDialog(null, u);
        }
    }

}
