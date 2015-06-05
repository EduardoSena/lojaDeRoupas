/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.roupas.control;

import br.com.loja.roupas.dao.ConexaoDao;
import br.com.loja.roupas.model.ModelFuncionarios;
import br.com.loja.roupas.view.InternalFrameFuncionario;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo Marcio
 */
public class ControlFuncionario {

    private Connection conexao;
    private String sql;
    private PreparedStatement stmt;
    private ModelFuncionarios funcionario;
    private ResultSet rs;
    private String pesquisa;
    private String dataAniversario;
    private String dataAdmissao;

    public ControlFuncionario() {
        this.conexao = ConexaoDao.conexaoDB();


    }

    public void adiciona(ModelFuncionarios funcionario) {

        Date dataAniv = null;
        Date dataAdmin = null;
        try {
            dataAniv = new SimpleDateFormat("dd/MM/yyyy").parse(funcionario.getDatanasc());
            dataAdmin = new SimpleDateFormat("dd/MM/yyyy").parse(funcionario.getDataAdmissao());
        } catch (ParseException ex) {
            Logger.getLogger(ControlFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }

        sql = "INSERT INTO lojaderoupa.funcionarios("
                + "nome,email,telefone"
                + ",cpf,salario,comissao"
                + ",endereco,bairro,cidade"
                + ",cep,estado,datanascimento,dataadmissao)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {

            dataAniversario = new SimpleDateFormat("yyyy-MM-dd").format(dataAniv);
            dataAdmissao = new SimpleDateFormat("yyyy-MM-dd").format(dataAdmin);
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getEmail());
            stmt.setString(3, funcionario.getTelefone());
            stmt.setString(4, funcionario.getCpf());
            stmt.setDouble(5, funcionario.getSalario());
            stmt.setDouble(6, funcionario.getComissao());
            stmt.setString(7, funcionario.getEndereco());
            stmt.setString(8, funcionario.getBairro());
            stmt.setString(9, funcionario.getCidade());
            stmt.setString(10, funcionario.getCep());
            stmt.setString(11, funcionario.getEstado());
            stmt.setDate(12, java.sql.Date.valueOf(dataAniversario));
            stmt.setDate(13, java.sql.Date.valueOf(dataAdmissao));
            stmt.execute();
            stmt.close();

        } catch (SQLException u) {
            // throw new RuntimeException(u);
            JOptionPane.showMessageDialog(null, u);
        }

    }

    public void excluiFuncionario(ModelFuncionarios funcionario) throws Exception {

        sql = "DELETE FROM lojaderoupa.funcionarios"
                + " WHERE idfuncionarios= ?";
        try {

            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, funcionario.getIdFuncionario());
            stmt.execute();
            stmt.close();

        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

    }

    public ModelFuncionarios pesquisaFuncionario() {
        funcionario = new ModelFuncionarios();

        sql = "SELECT  * FROM lojaderoupa.funcionarios WHERE nome LIKE ?";

        try {

            pesquisa = InternalFrameFuncionario.Pesquisa();
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pesquisa + "%");
            rs = stmt.executeQuery();

            if (rs.next()) {

                funcionario.setIdFuncionario(rs.getInt("idfuncionarios"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setSalario(rs.getDouble("salario"));
                funcionario.setComissao(rs.getDouble("comissao"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setBairro(rs.getString("bairro"));
                funcionario.setCidade(rs.getString("cidade"));
                funcionario.setCep(rs.getString("cep"));
                funcionario.setEstado(rs.getString("estado"));

                Date dataAniv = null;
                Date dataAdmin = null;
                try {
                    dataAniv = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("datanascimento"));
                    dataAdmin = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("dataadmissao"));
                } catch (ParseException ex) {
                    Logger.getLogger(ControlFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                }
                dataAniversario = new SimpleDateFormat("dd/MM/yyyy").format(dataAniv);
                dataAdmissao = new SimpleDateFormat("dd/MM/yyyy").format(dataAdmin);

                funcionario.setDatanasc(dataAniversario);
                funcionario.setDataAdmissao(dataAdmissao);

            }

            rs.close();
            stmt.close();

        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

        return funcionario;
    }

    public void AtualizarFuncionario(ModelFuncionarios funcionario) {

        Date dataAniv = null;
        Date dataAdmin = null;
        try {
            dataAniv = new SimpleDateFormat("dd/MM/yyyy").parse(funcionario.getDatanasc());
            dataAdmin = new SimpleDateFormat("dd/MM/yyyy").parse(funcionario.getDataAdmissao());
        } catch (ParseException ex) {
            Logger.getLogger(ControlFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        dataAniversario = new SimpleDateFormat("yyyy-MM-dd").format(dataAniv);
        dataAdmissao = new SimpleDateFormat("yyyy-MM-dd").format(dataAdmin);
        sql = "UPDATE lojaderoupa.funcionarios SET "
                + "nome='" + funcionario.getNome()
                + "', email='" + funcionario.getEmail()
                + "', telefone='" + funcionario.getTelefone()
                + "', cpf='" + funcionario.getCpf()
                + "', salario='" + funcionario.getSalario()
                + "', comissao='" + funcionario.getComissao()
                + "', endereco='" + funcionario.getEndereco()
                + "', bairro='" + funcionario.getBairro()
                + "', cidade='" + funcionario.getCidade()
                + "', cep='" + funcionario.getCep()
                + "', estado='" + funcionario.getEstado()
                + "', datanascimento='" + dataAniversario
                + "', dataadmissao='" + dataAdmissao
                + "' WHERE idfuncionarios=" + funcionario.getIdFuncionario();

        try {

            stmt = conexao.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

}
