/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.roupas.control;

import br.com.loja.roupas.dao.ConexaoDao;
import br.com.loja.roupas.model.ModelProdutos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.loja.roupas.view.InternalFrameProdutos;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo Marcio, Ludimila e Gustavo
 */
public class ControlProduto {

    private Connection conexao;
    private ModelProdutos produto;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String sql;
    private String pesquisa;
/**
 * Método contrutor da classe ControlProduto abre conexão com o banco
 */
    public ControlProduto() {
        this.conexao = ConexaoDao.conexaoDB();

    }
/**
 * Método de cadastro de produto com referência a produto
 * @param produto 
 */
    public void adicionaProduto(ModelProdutos produto) {

        sql = "INSERT INTO lojaderoupa.produtos("
                + "fkfuncionarios,nome,descricao"
                + ",precounitario,cor,tamanho,marca,quantidade)"
                + " VALUES(?,?,?,?,?,?,?,?)";

        try {

            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, produto.getFkFuncionarios());
            stmt.setString(2, produto.getNome());
            stmt.setString(3, produto.getDescricao());
            stmt.setDouble(4, produto.getPrecounitario());
            stmt.setString(5, produto.getCor());
            stmt.setString(6, produto.getTamanho());
            stmt.setString(7, produto.getMarca());
            stmt.setInt(8, produto.getQuantidade());
            
            stmt.execute();
            stmt.close();

        } catch (SQLException u) {
           JOptionPane.showMessageDialog(null, u);
        }

    }
/**.
 * Método de exclusão do produto com parametro produto
 * @param produto
 * @throws Exception 
 */
    public void excluiProduto(ModelProdutos produto) throws Exception {

        sql = "DELETE FROM lojaderoupa.produtos"
                + " WHERE idprodutos='" + produto.getCodigoProdutos() + "'";
        try {

            stmt = conexao.prepareStatement(sql);
            stmt.execute();
            stmt.close();

        } catch (SQLException u) {
            JOptionPane.showMessageDialog(null, u);
        }

    }
/**
 * Método de pesquisa de produtos que retorna um produto pelo nome
 * @return 
 */
    public ModelProdutos pesquisaProduto() {

        produto = new ModelProdutos();
        sql = "SELECT  * FROM lojaderoupa.produtos WHERE nome LIKE ?";

        try {
            pesquisa = InternalFrameProdutos.pesquisaNome();
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pesquisa + "%");
            rs = stmt.executeQuery();

            if (rs.next()) {

                produto.setCodigoProdutos(rs.getInt("idprodutos"));
                produto.setFkFuncionarios(rs.getInt("fkfuncionarios"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPrecounitario(rs.getDouble("precounitario"));
                produto.setCor(rs.getString("cor"));
                produto.setTamanho(rs.getString("tamanho"));
                produto.setMarca(rs.getString("marca"));
                produto.setQuantidade(rs.getInt("quantidade"));
            }

            rs.close();
            stmt.close();

        } catch (SQLException u) {
            JOptionPane.showMessageDialog(null, u);
        }

        return produto;
    }
/**
 * Método de atualizar os produtos como parametro um produto
 * @param produto 
 */
    public void AtualizarProduto(ModelProdutos produto) {

        sql = "UPDATE lojaderoupa.produtos SET "
                + "fkfuncionarios=?,nome=?,descricao=?"
                + ",precounitario=?,cor=?,tamanho=?"
                + ",marca=?,quantidade WHERE idprodutos=?";

        try {

            stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, produto.getFkFuncionarios());
            stmt.setString(2, produto.getNome());
            stmt.setString(3, produto.getDescricao());
            stmt.setDouble(4, produto.getPrecounitario());
            stmt.setString(5, produto.getCor());
            stmt.setString(6, produto.getTamanho());
            stmt.setString(7, produto.getMarca());
            stmt.setInt(8, produto.getQuantidade());
            stmt.setInt(9, produto.getCodigoProdutos());
            
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException u) {
            JOptionPane.showMessageDialog(null, u);
        }
    }

}
