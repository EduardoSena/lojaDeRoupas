/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.loja.roupas.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Eduardo Marcio
 */
public class ConexaoDao {
    private String bancoDeDados="jdbc:postgresql://localhost:5432/dbloja";
    private String login = "postgres";
    private String senha="181977dudu";
    
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(bancoDeDados,login,senha);
                   // "jdbc:mysql://localhost/projetojava",
                           
        }
        
        
        //instalar na biblioteca
        //http://jdbc.postgresql.org/
       //http://dev.mysql.com/downloads/file.php?id=404191#mirrors
        catch(SQLException excecao) {
            throw new RuntimeException(excecao);
        }
        
        
    }
}

    

// class TestaConexao {
//
//    public static void main(String[] args) throws SQLException {
//        Connection connection = new ConexaoDao().getConnection();
//        System.out.println("Conexão aberta!");
//        connection.close();
//    }
//}
    

