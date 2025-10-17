/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import model.Aluno;

public class Alunodao {
    private Connection conexao;
    
    
    public Alunodao(Connection conexao) {
        this.conexao = conexao;
    }
    
    public ResultSet consultar(Aluno aluno) throws SQLException{
        //String sql = "select * from aluno where usuario = '" 
        //       + aluno.getUsuario() +"' and senha = '"  
        //      + aluno.getSenha() +"'";
        String sql = "select * from tbaluno where usuario = ? and senha igual =?"; 
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, aluno.getUsuario());
        statement.setString(2, aluno.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
}
