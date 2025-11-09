/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

import view.Login;
import model.Usuario;
import dao.Usuariodao;
import dao.Conexao;
import view.Logado;

public class ControllerLogin {
    private Login tela1;
    
    public ControllerLogin (Login tela1){
        this.tela1 = tela1;
    }
    
    public void loginUsuario(){ // <-- Nome novo
    Usuario usuario = new Usuario(null, // <-- Nome novo
                           tela1.getTxtUsuario().getText(),
                           tela1.getTxtSenha().getText());
       Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            Usuariodao dao = new Usuariodao (conn);
            ResultSet res = dao.consultar(usuario);
        if(res.next()){
            JOptionPane.showMessageDialog(tela1,
                                      "Login efetuado com suceso",
                                       "Aviso",
                                       JOptionPane.INFORMATION_MESSAGE);
        Logado tela2 = new Logado();
        tela2.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(tela1,
                                      "Login não efetuado",
                                      "Erro",
                                      JOptionPane.ERROR_MESSAGE);
    }
}
 catch (SQLException e){
    JOptionPane.showMessageDialog(tela1,
                                  "Erro de conexão!",
                                  "Erro",
                                  JOptionPane.ERROR_MESSAGE);
                                  

}  
}}
