/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.roupas.control;

import br.com.loja.roupas.dao.ConexaoDao;
import br.com.loja.roupas.model.ModelVendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo Marcio, Ludimila e Gustavo
 */
public class ControlVenda {

     private Connection conexao;
    private PreparedStatement stmt;
    private String sql;
    private String dataAniversario;
/**
 * Método construtor da classe CotroleVendas faz conexão com o banco
 */
    public ControlVenda() {
        this.conexao = ConexaoDao.conexaoDB();

    }
/**
 * Método de ccontrole de vendas
 * @param vendas 
 */
    public void confirmaPedido(ModelVendas vendas) {

        sql = "INSERT INTO lojaderoupa.vendas("
                + "quantidadeestoque,valortotalprodutos,quantidadepedidos,valortotalpedidos)"
                + " VALUES(?,?,?,?)";

        try {
          

            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, vendas.getQuantidadeEstoque());
            stmt.setDouble(2, vendas.getValortotalProdutos());
            stmt.setInt(3, vendas.getQuantidadePedidos());
            stmt.setDouble(4, vendas.getValorTotalPedidos());

            stmt.execute();
            stmt.close();

        } catch (SQLException u) {
            JOptionPane.showMessageDialog(null, u);
        }

    }
    
}
