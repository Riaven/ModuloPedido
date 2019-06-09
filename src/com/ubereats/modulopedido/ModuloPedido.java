/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubereats.modulopedido;
import com.ubereats.modulopedido.controller.modelcontroller.LocalController;

import com.ubereats.modulopedido.view.PedidoPrincipalView;
import java.sql.SQLException;
import javax.swing.JFrame;
/**
 *
 * @author Riaven
 */
public class ModuloPedido {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        //se crea la instancia de la ventana a mostrar
        PedidoPrincipalView ventanaPrincipal = new PedidoPrincipalView();
        ventanaPrincipal.setVisible(true);//se hace visible
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    
    }
}
    

