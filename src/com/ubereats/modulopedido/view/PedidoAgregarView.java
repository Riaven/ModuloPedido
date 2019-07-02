/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ubereats.modulopedido.view;
import com.ubereats.modulopedido.controller.modelcontroller.PedidoController;
//import com.ubereats.modulopedido.controller.modelcontroller.UsuarioController;
import com.ubereats.modulopedido.controller.modelcontroller.LocalController;
import com.ubereats.modulopedido.controller.modelcontroller.EstadoController;
import com.ubereats.modulopedido.controller.modelcontroller.CartaController;
import com.ubereats.modulopedido.controller.modelcontroller.FranquiciaController;
import com.ubereats.modulopedido.entities.Carta;
import com.ubereats.modulopedido.entities.Estado;
import com.ubereats.modulopedido.entities.Franquicia;
import com.ubereats.modulopedido.entities.Local;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Riaven
 */
public class PedidoAgregarView extends javax.swing.JFrame {

    /** Creates new form PedidoAgregarView */
    public PedidoAgregarView() throws Exception {
        initComponents();
        //rellenarComboUsuario(cbxUsuario);
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        rellenarComboLocal(cbxLocal);
        rellenarComboEstado(cbxEstado);
        rellenarComboFranquicia(cbxFranquicia);
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
        cbxLocal = new javax.swing.JComboBox<>();
        cbxEstado = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbxCarta = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbxFranquicia = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jtfCantidad = new javax.swing.JTextField();
        jtfIdPedido = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAgregarPedido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Local");

        cbxLocal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Estado");

        cbxCarta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Carta");

        cbxFranquicia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Franquicia");

        jLabel6.setText("IdPedido");

        jLabel7.setText("Cantidad");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("AGREGAR NUEVO PEDIDO");

        btnAgregarPedido.setText("Agregar Pedido");
        btnAgregarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel6)
                        .addGap(10, 10, 10)
                        .addComponent(jtfIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel7)
                        .addGap(10, 10, 10)
                        .addComponent(jtfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel3)
                        .addGap(10, 10, 10)
                        .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)
                        .addComponent(cbxLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(133, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(85, 85, 85))
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarPedido)
                    .addComponent(cbxFranquicia, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCarta, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6))
                    .addComponent(jtfIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel7))
                    .addComponent(jtfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(cbxLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(cbxFranquicia, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbxCarta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btnAgregarPedido)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPedidoActionPerformed
        // TODO add your handling code here:
        int exito = 0;
        if(jtfCantidad.getText().isEmpty()|| jtfIdPedido.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos");
        }else{
            //variables que toman lo que recibe el jTextField de id y cantidad
            int idPedido = Integer.parseInt(jtfIdPedido.getText());
            int cantidad = Integer.parseInt(jtfCantidad.getText());
            
           
            try {
                if(PedidoController.buscarPedidoPorID(idPedido) == null){
                    //se busca por el nombre del combo seleccionado y se crea un objeto de cada uno
                    Estado estadito = EstadoController.buscarEstadoPorNombre(cbxEstado.getSelectedItem().toString());
                    Carta cartita = CartaController.buscarCartaPorNombre(cbxCarta.getSelectedItem().toString());
                    Franquicia franquicia = FranquiciaController.buscarFranquiciaporNombre(cbxFranquicia.getSelectedItem().toString());
                    Local localcito = LocalController.buscarLocalporMenu(cbxLocal.getSelectedItem().toString());
                    //se llama al metodo agregar pedido y se le otorga el int que devuelve a la variable exito
                    exito = PedidoController.agregarPedido(idPedido, cantidad, estadito, cartita, franquicia, localcito);
                }else{
                    JOptionPane.showMessageDialog(null, "Id de pedido existe");
                }
                
            } catch (Exception ex) {
                Logger.getLogger(PedidoAgregarView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //comprueba que el pedido fuera exitosamente agregado a la bd
        if(exito == 1){
            JOptionPane.showMessageDialog(null, "Pedido agregado correctamente");
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "No se ha podido agregar el Pedido");
        }
    }//GEN-LAST:event_btnAgregarPedidoActionPerformed

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
    
    /**public void rellenarComboUsuario(JComboBox cbxUsuario)throws Exception{
        String descripcion;
        cbxUsuario.removeAllItems();//limpia el combobox
        try{
            for(int i = 0; i<UsuarioController.listarUsuarios().size(); i++){
                /**Se le da el valor sacado desde el Array listarUsuarios
                 * a la variable descripcion, la cual recibe la variable nombre
                 * almacenada en el array y se rellena el combobox
                 
                descripcion = UsuarioController.listarUsuarios().get(i).getNombre();
                cbxUsuario.addItem(descripcion);
            }
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null,"Error al cargar Usuarios" + sqle);
        }
    }*/
    
   //método que rellena el comboBox local 
    public void rellenarComboLocal(JComboBox cbxLocal)throws Exception{
        //variable para tomar la descripcion del local
        String descripcion;
        //se limpia el combo
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
     //método que rellena el comboBox Estado
    public void rellenarComboEstado(JComboBox cbxEstado) throws Exception{
        String descripcion;
        cbxEstado.removeAllItems();
        try{
            for(int i = 0; i<EstadoController.listarEstados().size(); i++){
                descripcion = EstadoController.listarEstados().get(i).getDescripcion();
                cbxEstado.addItem(descripcion);        
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error rellenar ComboBox Estado : " + e);
        }
    }
     //método que rellena el comboBox Carta
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
     //método que rellena el comboBox franquicia
    public void rellenarComboFranquicia(JComboBox cbxFranquicia)throws Exception{
        String nombre;
        cbxFranquicia.removeAllItems();
        try{
            for(int i = 0; i < FranquiciaController.listarFranquicias().size(); i++){
                nombre = FranquiciaController.listarFranquicias().get(i).getNombre();
                cbxFranquicia.addItem(nombre);
            }
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null,"Error rellenar ComboBox Franquicia : " + sqle);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarPedido;
    private javax.swing.JComboBox<String> cbxCarta;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox<String> cbxFranquicia;
    private javax.swing.JComboBox<String> cbxLocal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jtfCantidad;
    private javax.swing.JTextField jtfIdPedido;
    // End of variables declaration//GEN-END:variables

}
