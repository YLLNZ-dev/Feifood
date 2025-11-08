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
    
    
}