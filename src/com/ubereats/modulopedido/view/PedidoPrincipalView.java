/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubereats.modulopedido.view;

import com.ubereats.modulopedido.controller.modelcontroller.PedidoController;
import com.ubereats.modulopedido.model.PedidoModel;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;


/**
 *
 * @author Riaven
 */
public class PedidoPrincipalView extends javax.swing.JFrame {
    //se crea un modelo que será usado para rellenar el JTale
    DefaultTableModel modelo = new DefaultTableModel();
    
    /**
     * Creates new form PedidoPrincipalView
     */
    public PedidoPrincipalView() throws Exception {
        initComponents();
        String ruta;
        ruta = "src/com/ubereats/modulopedido/view/staticfiles/";
        //ruta donde buscar la imagen
        Image icon = new ImageIcon(getClass().getResource( "/com/ubereats/modulopedido/view/staticfiles//ubereats-logo.png")).getImage();
        setIconImage(icon);
        
        //se cambia el nomnbre de la ventana
        setTitle("Mantenimiento Pedido - UberEats");
       
        //y se rellena la Tabla
        llenarJTablePedido(jtPedido);
        //no permite que ninguna de las filas o clumnas de la tabla sea editable por el usuario
        jtPedido.setDefaultEditor(Object.class, null);
        btnAgregar.setIcon(new ImageIcon(ruta + "icons8-agregar-propiedad-26.png"));
        btnActualizar.setIcon(new ImageIcon(ruta +"icons8-mostrar-propiedad-26.png"));
        btnEliminar.setIcon(new ImageIcon(ruta + "icons8-eliminar-propiedad-26.png"));
        btnModificar.setIcon(new ImageIcon(ruta + "icons8-editar-propiedad-26.png"));
        btnBuscar.setIcon(new ImageIcon(ruta + "icons8-búsqueda-de-propiedad-26.png"));
        jlLogo.setIcon(new ImageIcon(ruta + "ubereats-logo.png"));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBuscar = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jtxBuscarId = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtPedido = new javax.swing.JTable();
        jlLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Mantenedor Pedido");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jLabel2.setText("Buscar Pedido por Id :");

        jtPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jtPedido);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jlLogo)
                .addGap(112, 112, 112)
                .addComponent(jLabel1)
                .addContainerGap(461, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(28, 28, 28)
                        .addComponent(jtxBuscarId, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlLogo)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jtxBuscarId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(132, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        PedidoAgregarView ventanaNuevo;
        try {
            ventanaNuevo = new PedidoAgregarView();
            ventanaNuevo.setVisible(true);
            ventanaNuevo.setTitle("Nuevo Pedido");
            int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
            int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
            
            ventanaNuevo.setLocation((ancho / 2) - (ventanaNuevo.getWidth() / 2), (alto / 2) - (ventanaNuevo.getHeight()/ 2));
        } catch (Exception ex) {
            Logger.getLogger(PedidoPrincipalView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        try{
            
            modelo.setRowCount(0);
            modelo.setColumnCount(0);
            llenarJTablePedido(jtPedido);
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null , "Error : " + e);
        }
        
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int id;
        
        id =  obtenerIdFilaSeleccionada(jtPedido);
        try{
           abrirEliminar(id);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null , "Error : " + e);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        int id;
        id = obtenerIdFilaSeleccionada(jtPedido);
        try{
           abrirModificar(id); 
        }catch(Exception e){
           JOptionPane.showMessageDialog(null , "Error : " + e);
        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        int idPedido;
        int opcion;
        idPedido = Integer.parseInt(jtxBuscarId.getText());
        try{
            opcion =  JOptionPane.showOptionDialog(null, "Seleccione opcion", 
                                                   "Selector de opciones",
                                                   JOptionPane.YES_NO_CANCEL_OPTION,
                                                   JOptionPane.QUESTION_MESSAGE,
                                                   null,    // null para icono por defecto.
                                                   new Object[] { "Modificar", "Eliminar", "Cancelar" },   // null para YES, NO y CANCEL
                                                   "Modificar");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null , "Error : " + e);
        }
        
        
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(PedidoPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PedidoPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PedidoPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PedidoPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PedidoPrincipalView().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(PedidoPrincipalView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public void llenarJTablePedido(JTable jtPedido)throws Exception{
        try{
            //Se crea un array para llenar las columnas de la tabla
            ArrayList<Object> nombreColumna = new ArrayList<>();
            nombreColumna.removeAll(nombreColumna);
            nombreColumna.add("ID");
            nombreColumna.add("Cantidad");
            nombreColumna.add("Estado");
            nombreColumna.add("Carta");
            nombreColumna.add("Franquicia");
            nombreColumna.add("Local");
            //se rellena con cada una de las columnas al array
            for(Object columna : nombreColumna){
                modelo.addColumn(columna);
            }
            //Se rellena con el array de listar pedidos         
            for(PedidoModel DatoPedido : PedidoController.listarPedidos()){
                modelo.addRow(new Object[]{DatoPedido.getIdPedido(),
                                           DatoPedido.getCantidad(),
                                           DatoPedido.getEstado().getDescripcion(),
                                           DatoPedido.getCarta().getNombre(),
                                           DatoPedido.getFranquicia().getNombre(),
                                           DatoPedido.getLocal().getMenu()}); 
            }
            //se actualiza la Tabla
            jtPedido.setModel(modelo);
            //modelo.fireTableDataChanged();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null,"Error llevar JTable" + sqle);
        }
    }
    //Metodo para que saber la fila seleccionada de la Tabla
    public int obtenerIdFilaSeleccionada(JTable jtPedido){
        int fila;
        int id;
        //se inicializa el id en 0 por si lo se rellena
        id = 0;        
        fila = jtPedido.getSelectedRow();
        //obtiene el id que tiene la fila de la tabla
        if(fila>=0){
                id = Integer.parseInt(jtPedido.getValueAt(fila, 0).toString());
        }else{
            JOptionPane.showMessageDialog(null, "Debes de seleccionar una fila ");
        }
       return id;
    }
    
    public void abrirModificar(int id)throws Exception{
        try{
            
            if(id>0){
                PedidoModel p = PedidoController.buscarPedidoPorID(id);
                PedidoModificarView modi = new PedidoModificarView();
                
                modi.obtenerPedido(p);
                modi.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "No se puede modificar, pedido no seleccionado");
            }
            
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null , "Error al modificar : " + e);
        }
    }
    
    public void abrirEliminar(int id)throws Exception{
        int eliminado;
        int mensaje;
         try{
            mensaje = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar el Pedido id = " + id, "Eliminar pedido " + id , JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(mensaje == JOptionPane.YES_OPTION){
                
                eliminado = PedidoController.eliminarPedido(id);
                if(eliminado == 1){
                    JOptionPane.showMessageDialog(null , "Pedido " + id + " eliminado correctamente");
                }else{
                    JOptionPane.showMessageDialog(null , "Error al eliminar pedido");
                }
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null , "Error : " + e);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.ButtonGroup grupoBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlLogo;
    private javax.swing.JTable jtPedido;
    private javax.swing.JTextField jtxBuscarId;
    // End of variables declaration//GEN-END:variables
}
