package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import model.Usuario; // MUDANÇA: Importa o model.Usuario

public class Usuariodao { // MUDANÇA: Nome da classe
    private Connection conexao;
    
    public Usuariodao(Connection conexao) {
        this.conexao = conexao;
    }
    
    // MUDANÇA: Método agora recebe um objeto Usuario
    public ResultSet consultar(Usuario usuario) throws SQLException{
        
        // MUDANÇA: SQL corrigido para "tbusuario" e "senha = ?"
        String sql = "select * from tbusuario where usuario = ? and senha = ?"; 
        
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, usuario.getUsuario());
        statement.setString(2, usuario.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    // (Mais tarde, adicionaremos o método de cadastrar aqui)
}