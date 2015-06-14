/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.roupas.control;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author Eduardo Marcio
 */
public class ComponenteTelaApresentacao extends JPanel {
/**
 * Método construtor que inicia sem fundo no JPanel
 */
    public ComponenteTelaApresentacao() {
        //Força a visisbilidade 
        setOpaque(false);
   
    }
/**
 * Método gráfico de controle de intensidade  da visibilidade do background
 * @param g 
 */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        //Controle de invisibilidade
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.0f));
        g2d.setColor(getBackground());
        g2d.fill(getBounds());
        g2d.dispose();
    }
}
