/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ControllerLogin;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

/**
 *
 * @author unifysouza
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        c = new ControllerLogin (this);
    }

    public JToggleButton getBtCadastrar() {
        return BtCadastrar;
    }

    public void setBtCadastrar(JToggleButton BtCadastrar) {
        this.BtCadastrar = BtCadastrar;
    }

    public JButton getBtEntrar() {
        return BtEntrar;
    }

    public void setBtEntrar(JButton BtEntrar) {
        this.BtEntrar = BtEntrar;
    }

    public JLabel getLblSenha() {
        return LblSenha;
    }

    public void setLblSenha(JLabel LblSenha) {
        this.LblSenha = LblSenha;
    }

    public JLabel getLblusuario() {
        return Lblusuario;
    }

    public void setLblusuario(JLabel Lblusuario) {
        this.Lblusuario = Lblusuario;
    }

    public JTextField getTxtSenha() {
        return TxtSenha;
    }

    public void setTxtSenha(JTextField TxtSenha) {
        this.TxtSenha = TxtSenha;
    }

    public JTextField getTxtUsuario() {
        return TxtUsuario;
    }

    public void setTxtUsuario(JTextField TxtUsuario) {
        this.TxtUsuario = TxtUsuario;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Lblusuario = new javax.swing.JLabel();
        TxtUsuario = new javax.swing.JTextField();
        LblSenha = new javax.swing.JLabel();
        TxtSenha = new javax.swing.JTextField();
        BtEntrar = new javax.swing.JButton();
        BtCadastrar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AppAluno");

        Lblusuario.setText("Usuario:");

        TxtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtUsuarioActionPerformed(evt);
            }
        });

        LblSenha.setText("Senha");

        TxtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtSenhaActionPerformed(evt);
            }
        });

        BtEntrar.setText("Entrar");
        BtEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEntrarActionPerformed(evt);
            }
        });

        BtCadastrar.setText("Cadastrar");
        BtCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Lblusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LblSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BtEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lblusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(BtEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtUsuarioActionPerformed

    private void TxtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtSenhaActionPerformed

    private void BtEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEntrarActionPerformed
     c.loginAluno();
    }//GEN-LAST:event_BtEntrarActionPerformed

    private void BtCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCadastrarActionPerformed
     Cadastro tela3 = new Cadastro();
     tela3.setVisible(true);
    }//GEN-LAST:event_BtCadastrarActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Login().setVisible(true);
//            }
//        });
//    }
    private ControllerLogin c;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BtCadastrar;
    private javax.swing.JButton BtEntrar;
    private javax.swing.JLabel LblSenha;
    private javax.swing.JLabel Lblusuario;
    private javax.swing.JTextField TxtSenha;
    private javax.swing.JTextField TxtUsuario;
    // End of variables declaration//GEN-END:variables
}
