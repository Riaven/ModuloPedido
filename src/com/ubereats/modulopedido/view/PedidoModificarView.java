/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubereats.modulopedido.view;
import com.ubereats.modulopedido.controller.modelcontroller.EstadoController;
import com.ubereats.modulopedido.controller.modelcontroller.PedidoController;
import com.ubereats.modulopedido.entities.Pedido;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author DuocUC
 */
public class PedidoModificarView extends javax.swing.JFrame {
    private int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
    private int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
   
    
    /**
     * Creates new form PedidoModificarView
     */
    public PedidoModificarView() throws Exception {
        initComponents();
        this.setLocation((ancho / 2) - (this.getWidth() / 2), (alto / 2) - (this.getHeight()/ 2));
        rellenarComboEstado(cbxEstado);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cbxCarta.removeAllItems();
        cbxFranquicia.removeAllItems();
        cbxLocal.removeAllItems();
        jtfIdPedido.setEnabled(false);
        jtfCantidad.setEnabled(false);
        cbxCarta.setEnabled(false);
        cbxFranquicia.setEnabled(false);
        cbxLocal.setEnabled(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfIdPedido = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbxLocal = new javax.swing.JComboBox<>();
        cbxEstado = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbxCarta = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbxFranquicia = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jtfCantidad = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtfIdPedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfIdPedidoKeyTyped(evt);
            }
        });

        jLabel6.setText("IdPedido");

        jLabel7.setText("Cantidad");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("MODIFICAR PEDIDO");

        jLabel1.setText("Local");

        cbxLocal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Estado");

        cbxCarta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Carta");

        cbxFranquicia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Franquicia");

        jtfCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCantidadKeyTyped(evt);
            }
        });

        jButton1.setText("Modificar Pedido");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
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
                            .addComponent(cbxLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(108, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxFranquicia, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCarta, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(143, 143, 143))
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
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int id;
        String nombreEstado;
        int modificado;
        id = 0;
        nombreEstado = "";
        modificado = 0;
        id = Integer.parseInt(jtfIdPedido.getText());
        nombreEstado = cbxEstado.getSelectedItem().toString();
        try{
            if(PedidoController.buscarPedidoPorID(id) != null){
                modificado = PedidoController.modificarEstadoPedido(nombreEstado, id);
                if(modificado == 1){
                    JOptionPane.showMessageDialog(null, "Pedido "+ id +" modificado");
                    dispose();  
                }else{
                    JOptionPane.showMessageDialog(null, "Pedido no modificado");
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "Pedido a modificar no encontrado");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al encontrar pedido a modificar " + e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtfIdPedidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfIdPedidoKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         evt.consume();  // ignorar el evento de teclado
      }
    }//GEN-LAST:event_jtfIdPedidoKeyTyped

    private void jtfCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCantidadKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         evt.consume();  // ignorar el evento de teclado
      }
    }//GEN-LAST:event_jtfCantidadKeyTyped

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
            java.util.logging.Logger.getLogger(PedidoModificarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PedidoModificarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PedidoModificarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PedidoModificarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PedidoModificarView().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(PedidoModificarView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public void obtenerPedido(Pedido pedido)throws Exception{
        //cargar datos del pedido
        jtfIdPedido.setText(Integer.toString(pedido.getIdPedido()));
        jtfCantidad.setText(Integer.toString(pedido.getCantidad()));
        //Para cargar el estado que tiene el pedido
        cbxEstado.setSelectedItem(pedido.getIdEstado().getDescripcion());
        //cargar carta
        cbxCarta.addItem(pedido.getIdCarta().getNombre());
        //cargar franquicia
        cbxFranquicia.addItem(pedido.getIdFranquicia().getNombre());
        //cargar local
        cbxLocal.addItem(pedido.getIdLocal().getMenu());
        
    }
    
    
    
    public void rellenarComboEstado(JComboBox cbxEstado) throws Exception{
        try{
            cbxEstado.removeAllItems();
            for (int i = 0; i < EstadoController.listarEstados().size(); i++){
                cbxEstado.addItem(EstadoController.listarEstados().get(i).getDescripcion());
            }
            
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error rellenar estados " + sqle);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxCarta;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox<String> cbxFranquicia;
    private javax.swing.JComboBox<String> cbxLocal;
    private javax.swing.JButton jButton1;
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
