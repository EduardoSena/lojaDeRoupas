/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.roupas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo Marcio, Ludimila e Gustavo
 */
public class ConexaoDao {

    private static String bancoDeDado = "jdbc:postgresql://localhost:5432/dbloja";
    private static String driver = "org.postgresql.Driver";
    private static String login = "postgres";
    private static String senha = "123456";
/**
 * Método construtor da classe conexaoDB
 * para fazer chamar o banco de dados PostgreSQL
 * @return 
 */
    public static Connection conexaoDB() {

        try {
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConexaoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection conexao;
            conexao = DriverManager.getConnection(bancoDeDado, login, senha);
            //JOptionPane.showMessageDialog(null, "Conexão efetuada com sucesso !");

            return conexao;
        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, erro);

        }
        return null;

    }   
}
