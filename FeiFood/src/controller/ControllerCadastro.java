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

import dao.Conexao;
import dao.Usuariodao;
import model.Usuario;
import view.Cadastro;
/**
 *
 * @author Yllan
 */
public class ControllerCadastro {
    private Cadastro view;
    public ControllerCadastro(Cadastro view) {
        this.view = view;
    }
    public void salvarUsuario() {
        String nome = view.getTextNomeCadastro().getText();
        String usuario = view.getTextUsuarioCadastro().getText(); 
        String senha = view.getTextSenhaCadastro().getText();
    Usuario novoUsuario = new Usuario(nome, usuario, senha);
    try {
            Connection conn = new Conexao().getConnection();
            Usuariodao dao = new Usuariodao(conn);
            dao.adicionar(novoUsuario);
            JOptionPane.showMessageDialog(view, 
                    "Usuário salvo com sucesso!", 
                    "Sucesso", 
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {            
            JOptionPane.showMessageDialog(view, 
                    "Falha ao salvar usuário! Verifique o console.", 
                    "Erro", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}


