/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.loja.roupas.control;
import br.com.loja.roupas.dao.ConexaoDao;
import br.com.loja.roupas.model.ModelPedidos;
import br.com.loja.roupas.model.ModelProdutos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo Marcio
 */
public class ControlPedido {
    
    private Connection conexao;
    private PreparedStatement stmt;
    private String sql;
    private String dataAniversario;
 
    
    
    public ControlPedido() {
        this.conexao = ConexaoDao.conexaoDB();

    }
    
    
    public void confirmaPedido(ModelPedidos pedido) {

        Date dataCompra = null;
        
        try {
            dataCompra = new SimpleDateFormat("dd/MM/yyyy").parse(pedido.getDataPedido());
            
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex);
            Logger.getLogger(ControlFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        sql = "INSERT INTO lojaderoupa.pedidos("
                + "datapedido,valorpedido"
                + ",quantidade,nomeproduto"
                + ",nomecliente,nomefunc"
                + ",fkproduto,fkcliente,fkfunc)"
                + " VALUES(?,?,?,?,?,?,?,?,?)";


        try {
            dataAniversario = new SimpleDateFormat("yyyy-MM-dd").format(dataCompra);
          
            stmt = conexao.prepareStatement(sql);
            stmt.setDate(1, java.sql.Date.valueOf(dataAniversario));          
            stmt.setDouble(2, pedido.getValorPedido());
            stmt.setInt(3, pedido.getQuantidadePedido());
            stmt.setString(4, pedido.getNomeProduto());
            stmt.setString(5, pedido.getNomeCliente());
            stmt.setString(6, pedido.getNomeFunc());
            stmt.setInt(7, pedido.getFkProduto());
            stmt.setInt(8, pedido.getFkCliente());
            stmt.setInt(9, pedido.getFkFunc());
            
            
            stmt.execute();
            stmt.close();

        } catch (SQLException u) {
            JOptionPane.showMessageDialog(null, u);
        }
           
    }
    
    
    public void atualizarQuantidadeProduto (ModelProdutos atualizarProduto){
        
        sql = "UPDATE lojaderoupa.produtos SET "
                + "quantidade='" + atualizarProduto.getQuantidade()
                + "' WHERE idprodutos=" + atualizarProduto.getCodigoProdutos();

        try {

            stmt = conexao.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException u) {
            JOptionPane.showMessageDialog(null, u);
        }
        
    }
    
}
