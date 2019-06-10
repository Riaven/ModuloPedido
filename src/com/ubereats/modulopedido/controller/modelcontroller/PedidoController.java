/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubereats.modulopedido.controller.modelcontroller;
import com.ubereats.modulopedido.model.PedidoModel;
import com.ubereats.modulopedido.controller.Controlador;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Riaven
 */
public class PedidoController {
    private static Connection con = null;
    private static Statement st;
    private static ResultSet rs;
    private static ArrayList<PedidoModel> alPedido = new ArrayList<>();
    
    
}
