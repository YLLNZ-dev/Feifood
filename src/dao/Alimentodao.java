/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Alimento;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import model.Usuario; 
import java.util.ArrayList; 
import java.util.List;      


public class Alimentodao {
    
    private Connection conexao;

    public Alimentodao(Connection conexao) {
        this.conexao = conexao;
    }
    
    
  
    public List<Alimento> buscarTodos() throws SQLException {
        String sql = "SELECT * FROM \"TB_alimentos\"";
        PreparedStatement statement = conexao.prepareStatement(sql);
        ResultSet resultado = statement.executeQuery();
        List<Alimento> listaDeAlimentos = new ArrayList<>();
        
        while(resultado.next()) {
            int id = resultado.getInt("ID_alimentos");
            String descricao = resultado.getString("Desc_alimentos");
            String tipo = resultado.getString("Tipo_alimento");
            double preco = resultado.getDouble("Preco_alimento");
            Alimento alimento = new Alimento(id, descricao, tipo, preco);
            listaDeAlimentos.add(alimento);
        }
        return listaDeAlimentos;
    } 
    public List<Alimento> buscarPorDescricao(String descricao) throws SQLException {
        String sql = "SELECT * FROM \"TB_alimentos\" WHERE \"Desc_alimentos\" ILIKE ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, "%" + descricao + "%");
        ResultSet resultado = statement.executeQuery();
        List<Alimento> listaDeAlimentos = new ArrayList<>();
        while(resultado.next()) {
            int id = resultado.getInt("ID_alimentos");
            String desc = resultado.getString("Desc_alimentos");
            String tipo = resultado.getString("Tipo_alimento");
            double preco = resultado.getDouble("Preco_alimento");
            Alimento alimento = new Alimento(id, desc, tipo, preco);
            listaDeAlimentos.add(alimento);
        }
        
       
        return listaDeAlimentos;
    }
}