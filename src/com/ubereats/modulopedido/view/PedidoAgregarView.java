/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ubereats.modulopedido.view;
import com.ubereats.modulopedido.controller.modelcontroller.UsuarioController;
import com.ubereats.modulopedido.controller.modelcontroller.LocalController;
import com.ubereats.modulopedido.controller.modelcontroller.EstadoController;
import com.ubereats.modulopedido.controller.modelcontroller.CartaController;
import com.ubereats.modulopedido.controller.modelcontroller.FranquiciaController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Riaven
 */
public class PedidoAgregarView extends javax.swing.JFrame {

    /** Creates new form PedidoAgregarView */
    public PedidoAgregarView() throws Exception {
        initComponents();
        rellenarComboUsuario(cbxUsuario);
        rellenarComboLocal(cbxLocal);
        rellenarComboEstado(cbxEstado);
        rellenarComboCarta(cbxCarta);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxLocal = new javax.swing.JComboBox<>();
        cbxUsuario = new javax.swing.JComboBox<>();
        cbxEstado = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbxCarta = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbxFranquicia = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Local");

        jLabel2.setText("Usuario");

        cbxLocal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Estado");

        cbxCarta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Carta");

        cbxFranquicia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Franquicia");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(119, 119, 119)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbxFranquicia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbxCarta, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbxEstado, 0, 84, Short.MAX_VALUE)
                                    .addComponent(cbxLocal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(cbxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(97, 97, 97)))))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxFranquicia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxCarta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PedidoAgregarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PedidoAgregarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PedidoAgregarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PedidoAgregarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PedidoAgregarView().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(PedidoAgregarView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public void rellenarComboUsuario(JComboBox cbxUsuario)throws Exception{
        String descripcion;
        cbxUsuario.removeAllItems();//limpia el combobox
        try{
            for(int i = 0; i<UsuarioController.listarUsuarios().size(); i++){
                /**Se le da el valor sacado desde el Array listarUsuarios
                 * a la variable descripcion, la cual recibe la variable nombre
                 * almacenada en el array y se rellena el combobox
                 */
                descripcion = UsuarioController.listarUsuarios().get(i).getNombre();
                cbxUsuario.addItem(descripcion);
            }
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null,"Error al cargar Usuarios" + sqle);
        }
    }
    
    public void rellenarComboLocal(JComboBox cbxLocal)throws Exception{
        String descripcion;
        cbxLocal.removeAllItems();//limpia el combobox
        try{
            for(int i = 0; i<LocalController.listarLocales().size(); i++){
                /**Se le da el valor sacado desde el Array listarlocales
                 * a la variable descripcion, la cual recibe la variable nombre
                 * almacenada en el array y se rellena el combobox
                 */
                descripcion = LocalController.listarLocales().get(i).getMenu();
                cbxLocal.addItem(descripcion);
            }
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null,"Error al cargar Locales" + sqle);
        }
    }
    
    public void rellenarComboEstado(JComboBox cbxEstado) throws Exception{
        String descripcion;
        cbxEstado.removeAllItems();
        try{
            for(int i = 0; i<EstadoController.listarEstados().size(); i++){
                descripcion = EstadoController.listarEstados().get(i).getDescripcion();
                cbxEstado.addItem(descripcion);        
            }
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null,"Error rellenar ComboBox Estado : " + sqle);
        }
    }
    
    public void rellenarComboCarta(JComboBox cbxCarta)throws Exception{
        String nombre;
        cbxCarta.removeAllItems();
        try{
            for(int i = 0; i<CartaController.listarCartas().size(); i++){
                nombre = CartaController.listarCartas().get(i).getNombre();
                cbxCarta.addItem(nombre);
            }
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null,"Error rellenar ComboBox Carta : " + sqle);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxCarta;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox<String> cbxFranquicia;
    private javax.swing.JComboBox<String> cbxLocal;
    private javax.swing.JComboBox<String> cbxUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables

}
