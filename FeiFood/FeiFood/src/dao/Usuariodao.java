package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import model.Usuario; 

public class Usuariodao { 
    private Connection conexao;
    
    public Usuariodao(Connection conexao) {
        this.conexao = conexao;
    }
    
    
    public ResultSet consultar(Usuario usuario) throws SQLException{
        
        
        String sql = "select * from tbusuario where usuario = ? and senha = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, usuario.getUsuario());
        statement.setString(2, usuario.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    public void adicionar(Usuario usuario) throws SQLException {
        
        String sql = "INSERT INTO tbusuario (\"Nome_usuario\", \"usuario\", \"senha\") VALUES (?, ?, ?)";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, usuario.getNome());
        statement.setString(2, usuario.getUsuario());
        statement.setString(3, usuario.getSenha());
        statement.execute();
    }
}
    
