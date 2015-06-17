/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.loja.roupas.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
     *
     * @author Eduardo Marcio, Ludimila e Gustavo
     */
    
public class CriarDB {

    private static Connection conexao;
    private static String sql;
    private static Statement stmt;
    /**
     * Método que cria a conexão com o banco de dados Postgre
     */
    public CriarDB() {

        conexao = ConexaoDao.conexaoDB();
        
          executeSQL(conexao, sql);

    }
/**
 * Método que executa a comunicação SGBD e verifica se o banco já existe
 * @param conn
 * @param sql 
 */
    private static void executeSQL(Connection conn, String sql) {

        try {
           
                stmt = conn.createStatement();         
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null,ex);        
        }
        try {          
            stmt.execute(sql);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);          
        }
    }
/**
 * Método para criar um novo esquema no banco de dados postgreSQL
 * juntamente com as tabelas, caso não exista.
 */
    public static void criarBancoDeDados() {

        conexao = ConexaoDao.conexaoDB();
        for (String query : new String[]{
            "CREATE SCHEMA IF NOT EXISTS lojaderoupa ",
            "CREATE TABLE IF NOT EXISTS lojaderoupa.clientes\n"
                + "(\n"
                + "  idclientes serial NOT NULL,\n"
                + "  nome character varying(100) NOT NULL,\n"
                + "  email character varying(100) NOT NULL,\n"
                + "  telefone character varying(15) NOT NULL,\n"
                + "  cpf character varying(15) NOT NULL,\n"
                + "  endereco character varying(100) NOT NULL,\n"
                + "  cep character varying(15) NOT NULL,\n"
                + "  datanascimento date,\n"
                + "  CONSTRAINT clientes_pkey PRIMARY KEY (idclientes),\n"
                + "  CONSTRAINT clientes_cpf_key UNIQUE (cpf)\n"
                + ")",
            "CREATE TABLE IF NOT EXISTS lojaderoupa.funcionarios\n"
                + "(\n"
                + "  idfuncionarios serial NOT NULL,\n"
                + "  nome character varying(100) NOT NULL,\n"
                + "  email character varying(100) NOT NULL,\n"
                + "  telefone character varying(15) NOT NULL,\n"
                + "  cpf character varying(15) NOT NULL,\n"
                + "  salario numeric NOT NULL,\n"
                + "  comissao numeric NOT NULL,\n"
                + "  endereco character varying(100) NOT NULL,\n"
                + "  bairro character varying(50) NOT NULL,\n"
                + "  cidade character varying(50) NOT NULL,\n"
                + "  cep character varying(15) NOT NULL,\n"
                + "  estado character varying(50) NOT NULL,\n"
                + "  datanascimento date,\n"
                + "  dataadmissao date,\n"
                + "  CONSTRAINT funcionarios_pkey PRIMARY KEY (idfuncionarios),\n"
                + "  CONSTRAINT funcionarios_cpf_key UNIQUE (cpf)\n"
                + ")",
            "CREATE TABLE IF NOT EXISTS lojaderoupa.login\n"
                + "(\n"
                + "  idlogin serial NOT NULL,\n"
                + "  usuario character varying(50) NOT NULL,\n"
                + "  senha character varying(50) NOT NULL,\n"
                + "  CONSTRAINT login_pkey PRIMARY KEY (idlogin)\n"
                + ")",
            "CREATE TABLE IF NOT EXISTS lojaderoupa.produtos\n"
                + "(\n"
                + "  idprodutos serial NOT NULL,\n"
                + "  fkfuncionarios integer NOT NULL,\n"
                + "  nome character varying(100) NOT NULL,\n"
                + "  descricao character varying(100) NOT NULL,\n"
                + "  precounitario numeric NOT NULL,\n"
                + "  cor character varying(15) NOT NULL,\n"
                + "  tamanho character varying(50) NOT NULL,\n"
                + "  marca character varying(50) NOT NULL,\n"
                + "  quantidade integer,\n"
                + "  CONSTRAINT produtos_pkey PRIMARY KEY (idprodutos),\n"
                + "  CONSTRAINT produtos_fkfuncionarios_fkey FOREIGN KEY (fkfuncionarios)\n"
                + "      REFERENCES lojaderoupa.funcionarios (idfuncionarios) MATCH SIMPLE\n"
                + "      ON UPDATE NO ACTION ON DELETE NO ACTION\n"
                + ")",
            "CREATE TABLE IF NOT EXISTS lojaderoupa.pedidos\n"
                + "(\n"
                + "  idpedidos serial NOT NULL,\n"
                + "  datapedido date NOT NULL,\n"
                + "  valorpedido numeric NOT NULL,\n"
                + "  quantidade integer NOT NULL,\n"
                + "  nomeproduto character(50),\n"
                + "  nomecliente character(50),\n"
                + "  nomefunc character(50),\n"
                + "  fkproduto integer,\n"
                + "  fkcliente integer,\n"
                + "  fkfunc integer,\n"
                + "  CONSTRAINT pedidos_pkey PRIMARY KEY (idpedidos),\n"
                + "  CONSTRAINT fkcliente FOREIGN KEY (fkcliente)\n"
                + "      REFERENCES lojaderoupa.clientes (idclientes) MATCH SIMPLE\n"
                + "      ON UPDATE NO ACTION ON DELETE NO ACTION,\n"
                + "  CONSTRAINT fkfunc FOREIGN KEY (fkfunc)\n"
                + "      REFERENCES lojaderoupa.funcionarios (idfuncionarios) MATCH SIMPLE\n"
                + "      ON UPDATE NO ACTION ON DELETE NO ACTION,\n"
                + "  CONSTRAINT fkproduto FOREIGN KEY (fkproduto)\n"
                + "      REFERENCES lojaderoupa.produtos (idprodutos) MATCH SIMPLE\n"
                + "      ON UPDATE NO ACTION ON DELETE NO ACTION\n"
                + ")",
            "CREATE TABLE IF NOT EXISTS lojaderoupa.vendas\n"
                + "(\n"
                + "  idvendas serial NOT NULL,\n"
                + "  quantidadeestoque integer,\n"
                + "  valortotalprodutos numeric,\n"
                + "  quantidadepedidos integer,\n"
                + "  valortotalpedidos numeric,\n"
                + "  data timestamp without time zone DEFAULT now(),\n"
                + "  CONSTRAINT vendas_pkey PRIMARY KEY (idvendas)\n"
                + ")"
        }) {
            
            executeSQL(conexao, query);
            
        }

    }
    
}
