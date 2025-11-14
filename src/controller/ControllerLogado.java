package controller;

import dao.Alimentodao; 
import dao.Conexao;
import model.Alimento;
import view.Logado;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class ControllerLogado {
    private Logado view;
    // --- NOSSOS DOIS MODELOS DE DADOS ---
    private DefaultListModel<Alimento> listModelVitrine;
    private DefaultListModel<Alimento> listModelCarrinho; 

    public ControllerLogado(Logado view) {
        this.view = view;
        this.listModelVitrine = new DefaultListModel<>();
        this.view.getListavitrine().setModel(this.listModelVitrine);
        this.listModelCarrinho = new DefaultListModel<>();
        this.view.getListacarrinho().setModel(this.listModelCarrinho); 
    }
    public void adicionarItemAoCarrinho() {
        Alimento itemSelecionado = view.getListavitrine().getSelectedValue();
        if (itemSelecionado != null) {
            listModelCarrinho.addElement(itemSelecionado);
        }
    }
    public void removerItemDoCarrinho() {
        Alimento itemSelecionado = view.getListacarrinho().getSelectedValue();
        if (itemSelecionado != null) {
            listModelCarrinho.removeElement(itemSelecionado);
        }
    }
    public void buscarAlimentos(String textoDaBusca) {
        if (textoDaBusca == null || textoDaBusca.trim().isEmpty()) {
            carregarTodosAlimentos();
        } else {
            carregarAlimentosFiltrados(textoDaBusca);
        }
    }
    public void carregarTodosAlimentos() {
        listModelVitrine.clear(); 
        SwingWorker<List<Alimento>, Void> worker = new SwingWorker<List
                                                       <Alimento>, Void>() {
            @Override
            protected List<Alimento> doInBackground() throws Exception {
                Connection conn = new Conexao().getConnection();
                Alimentodao dao = new Alimentodao(conn); 
                return dao.buscarTodos(); 
            }

            @Override
            protected void done() {
                try {
                    List<Alimento> alimentos = get(); 
                    for (Alimento al : alimentos) {
                        listModelVitrine.addElement(al);
                    }
                    view.pack();
                    view.setLocationRelativeTo(null);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(view, 
                            "Falha ao buscar alimentos! Verifique o console.", 
                            "Erro de Banco", 
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        worker.execute();
    }
    private void carregarAlimentosFiltrados(String texto) {
        listModelVitrine.clear(); 
        SwingWorker<List<Alimento>, Void> worker = new SwingWorker<List<Alimento>, Void>() {
            @Override
            protected List<Alimento> doInBackground() throws Exception {
                Connection conn = new Conexao().getConnection();
                Alimentodao dao = new Alimentodao(conn);
                return dao.buscarPorDescricao(texto); 
            }

            @Override
            protected void done() {
                try {
                    List<Alimento> alimentos = get(); 
                    for (Alimento al : alimentos) {
                        listModelVitrine.addElement(al);
                    }
                    view.pack();
                    view.setLocationRelativeTo(null);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(view, 
                            "Falha ao buscar alimentos filtrados! Verifique o console.", 
                            "Erro de Banco", 
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        worker.execute();
    }
}