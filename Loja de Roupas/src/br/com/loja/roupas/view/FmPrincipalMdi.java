/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.roupas.view;

/**
 *
 * @author Eduardo Marcio
 */
public class FmPrincipalMdi extends javax.swing.JFrame {

    private static boolean controleAcesso;

    /**
     * Creates new form fmPrincipal
     */
    public FmPrincipalMdi() {
        initComponents();
        setLocationRelativeTo(null);
        FmPrincipalMdi.controleAcesso = true;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DesktopPanePrincipal = new javax.swing.JDesktopPane();
        subMenuListaVendas = new javax.swing.JMenuBar();
        menuCliente = new javax.swing.JMenu();
        subMenuCliente = new javax.swing.JMenuItem();
        menuFuncionario = new javax.swing.JMenu();
        subMenuFuncionario = new javax.swing.JMenuItem();
        menuProduto = new javax.swing.JMenu();
        subMenuCadProd = new javax.swing.JMenu();
        subMenuVenda = new javax.swing.JMenuItem();
        subMenuCadPedido = new javax.swing.JMenu();
        menuVenda = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Loja de Roupas");
        setMinimumSize(new java.awt.Dimension(850, 700));

        DesktopPanePrincipal.setBackground(new java.awt.Color(240, 240, 240));

        menuCliente.setText("Clientes");

        subMenuCliente.setText("Cadastrar Cliente");
        subMenuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuClienteActionPerformed(evt);
            }
        });
        menuCliente.add(subMenuCliente);

        subMenuListaVendas.add(menuCliente);

        menuFuncionario.setText("Funcionários");

        subMenuFuncionario.setText("Cadastrar Funcionário");
        subMenuFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuFuncionarioActionPerformed(evt);
            }
        });
        menuFuncionario.add(subMenuFuncionario);

        subMenuListaVendas.add(menuFuncionario);

        menuProduto.setText("Produtos");

        subMenuCadProd.setText("Cadastrar Produtos");
        menuProduto.add(subMenuCadProd);

        subMenuVenda.setText("Lista de Produtos");
        subMenuVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuVendaActionPerformed(evt);
            }
        });
        menuProduto.add(subMenuVenda);

        subMenuCadPedido.setText("Pedidos");
        menuProduto.add(subMenuCadPedido);

        subMenuListaVendas.add(menuProduto);

        menuVenda.setText("Vendas");

        jMenuItem1.setText("Lista de Vendas");
        menuVenda.add(jMenuItem1);

        subMenuListaVendas.add(menuVenda);

        setJMenuBar(subMenuListaVendas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DesktopPanePrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DesktopPanePrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

/**
 * Botão que abre o cadasstro de Clientes
 * @param evt 
 */
    
    private void subMenuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuClienteActionPerformed
        // TODO add your handling code here: 

        InternalFrameCliente internoFrameCliente = new InternalFrameCliente();
        if (FmPrincipalMdi.controleAcesso == true) {
            DesktopPanePrincipal.add(internoFrameCliente);
            internoFrameCliente.setVisible(true);
            FmPrincipalMdi.controleAcesso = false;
        }

    }//GEN-LAST:event_subMenuClienteActionPerformed

    private void subMenuFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuFuncionarioActionPerformed
        // TODO add your handling code here:
        InternalFrameFuncionario internoFuncionario = new InternalFrameFuncionario();
        if (FmPrincipalMdi.controleAcesso == true) {
            DesktopPanePrincipal.add(internoFuncionario);
            internoFuncionario.setVisible(true);
            FmPrincipalMdi.controleAcesso = false;
        }

    }//GEN-LAST:event_subMenuFuncionarioActionPerformed

    private void subMenuVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuVendaActionPerformed
        // TODO add your handling code here:
        InternalFrameListarProdutos internoListaProdutos=new InternalFrameListarProdutos();
        if (FmPrincipalMdi.controleAcesso == true) {
        DesktopPanePrincipal.add(internoListaProdutos);
         internoListaProdutos.setVisible(true);
         FmPrincipalMdi.controleAcesso=false;
        }
    }//GEN-LAST:event_subMenuVendaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FmPrincipalMdi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FmPrincipalMdi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FmPrincipalMdi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FmPrincipalMdi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FmPrincipalMdi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DesktopPanePrincipal;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu menuCliente;
    private javax.swing.JMenu menuFuncionario;
    private javax.swing.JMenu menuProduto;
    private javax.swing.JMenu menuVenda;
    private javax.swing.JMenu subMenuCadPedido;
    private javax.swing.JMenu subMenuCadProd;
    private javax.swing.JMenuItem subMenuCliente;
    private javax.swing.JMenuItem subMenuFuncionario;
    private javax.swing.JMenuBar subMenuListaVendas;
    private javax.swing.JMenuItem subMenuVenda;
    // End of variables declaration//GEN-END:variables

    public static void Acesso(boolean acesso) {
        FmPrincipalMdi.controleAcesso = acesso;
    }
 
}
