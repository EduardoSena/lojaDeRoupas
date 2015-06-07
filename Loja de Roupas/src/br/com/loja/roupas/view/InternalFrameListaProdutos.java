/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.roupas.view;

import br.com.loja.roupas.dao.ConexaoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Eduardo Marcio
 */
public class InternalFrameListaProdutos extends javax.swing.JInternalFrame {

    private Connection conexao;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String sql;
  

    /**
     * Creates new form NewJInternalFrame
     */
    public InternalFrameListaProdutos() {
        initComponents();
        this.setLocation(150, 99);
        this.conexao = ConexaoDao.conexaoDB();
        listaDeProdutos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelListarProduto = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtPesquisaProdutosLista = new javax.swing.JTextField();
        btnPesquisarNomeP = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListaProdutos = new javax.swing.JTable();
        btnSairProdutolLista1 = new javax.swing.JButton();
        btnAtuTabela = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));
        setIconifiable(true);

        jPanelListarProduto.setBackground(new java.awt.Color(204, 204, 255));
        jPanelListarProduto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Produtos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        jPanelListarProduto.setPreferredSize(new java.awt.Dimension(680, 430));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Produto Nome: ");

        txtPesquisaProdutosLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaProdutosListaActionPerformed(evt);
            }
        });

        btnPesquisarNomeP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPesquisarNomeP.setText("Pesquisar");
        btnPesquisarNomeP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarNomePActionPerformed(evt);
            }
        });

        jTableListaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableListaProdutos);

        btnSairProdutolLista1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSairProdutolLista1.setText("Sair");
        btnSairProdutolLista1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairProdutolLista1ActionPerformed(evt);
            }
        });

        btnAtuTabela.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAtuTabela.setText("Atualizar Tabela");
        btnAtuTabela.setToolTipText("Atualiza os dados da tabela");
        btnAtuTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtuTabelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelListarProdutoLayout = new javax.swing.GroupLayout(jPanelListarProduto);
        jPanelListarProduto.setLayout(jPanelListarProdutoLayout);
        jPanelListarProdutoLayout.setHorizontalGroup(
            jPanelListarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListarProdutoLayout.createSequentialGroup()
                .addGroup(jPanelListarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelListarProdutoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelListarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelListarProdutoLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPesquisaProdutosLista, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnPesquisarNomeP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelListarProdutoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAtuTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSairProdutolLista1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(113, 113, 113))
        );
        jPanelListarProdutoLayout.setVerticalGroup(
            jPanelListarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListarProdutoLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanelListarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPesquisaProdutosLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarNomeP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanelListarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSairProdutolLista1)
                    .addComponent(btnAtuTabela))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelListarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelListarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisaProdutosListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaProdutosListaActionPerformed
        // TODO add your handling code here:
        pesquisaProdutoLista();
    }//GEN-LAST:event_txtPesquisaProdutosListaActionPerformed

    private void btnPesquisarNomePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarNomePActionPerformed

        pesquisaProdutoLista();

        txtPesquisaProdutosLista.setText("");
    }//GEN-LAST:event_btnPesquisarNomePActionPerformed

    private void btnSairProdutolLista1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairProdutolLista1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btnSairProdutolLista1ActionPerformed

    private void btnAtuTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtuTabelaActionPerformed
        // TODO add your handling code here:
        listaDeProdutos();
    }//GEN-LAST:event_btnAtuTabelaActionPerformed

    

    
    public void listaDeProdutos() {

        sql = "SELECT  * FROM lojaderoupa.produtos";

        try {
            this.stmt = conexao.prepareStatement(sql);
            this.rs = stmt.executeQuery();
            listaTable(this.rs);
            
        } catch (SQLException u) {

            JOptionPane.showMessageDialog(null, u);
        }
    }

    public void pesquisaProdutoLista() {

        sql = "SELECT  * FROM lojaderoupa.produtos WHERE nome like ?";

        try {

            this.stmt = conexao.prepareStatement(sql);
            this.stmt.setString(1, txtPesquisaProdutosLista.getText() + "%");
            this.rs = stmt.executeQuery();
            listaTable(this.rs);
 

        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

    }

    
    private void listaTable(ResultSet rs){
        
     DefaultTableModel tabela = new DefaultTableModel();

            jTableListaProdutos.setModel(tabela);

            tabela.addColumn("Código do Produto");
            tabela.addColumn("Código do Funcionario");
            tabela.addColumn("Nome");
            tabela.addColumn("Descricao");
            tabela.addColumn("Preço Unitário");
            tabela.addColumn("Cor");
            tabela.addColumn("Tamanho");
            tabela.addColumn("Marca");

            jTableListaProdutos.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableListaProdutos.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTableListaProdutos.getColumnModel().getColumn(2).setPreferredWidth(50);
            jTableListaProdutos.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTableListaProdutos.getColumnModel().getColumn(4).setPreferredWidth(50);
            jTableListaProdutos.getColumnModel().getColumn(5).setPreferredWidth(50);
            jTableListaProdutos.getColumnModel().getColumn(6).setPreferredWidth(50);
            jTableListaProdutos.getColumnModel().getColumn(7).setPreferredWidth(50);

        try {
            while (this.rs.next()) {
                String idprodutos = rs.getString("idprodutos");
                String fkfunc = rs.getString("fkfuncionarios");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                String preUnitario = rs.getString("precounitario");
                String cor = rs.getString("cor");
                String tamanho = rs.getString("tamanho");
                String marca = rs.getString("marca");

                tabela.addRow(new Object[]{idprodutos,fkfunc,nome, descricao, preUnitario, cor, tamanho, marca});
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(InternalFrameListaProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtuTabela;
    private javax.swing.JButton btnPesquisarNomeP;
    private javax.swing.JButton btnSairProdutolLista1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelListarProduto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListaProdutos;
    private javax.swing.JTextField txtPesquisaProdutosLista;
    // End of variables declaration//GEN-END:variables
}
