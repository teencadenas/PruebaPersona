/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mobelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 *
 * @author teenc
 */
public class ModeloCiudad {

    Conexion cx;

    public ModeloCiudad() {
        this.cx =  new Conexion();
    }

    public LinkedList<LinkedList> listaCiudadesRegistrdas(){
    LinkedList<LinkedList> ciudades = new LinkedList<>();
    try(Connection conn = DriverManager.getConnection(cx.getUrl(),cx.getUser(),cx.getPassword())){
        String query = "SELECT * FROM ciudadescolombia";
        PreparedStatement stm =conn.prepareStatement(query);
        ResultSet rs = stm.executeQuery();
        while (rs.next()){
            while(rs.next()){                
                    String numCiudad = rs.getString(4);
                    String ciudad = rs.getString(5);
                    String depto = rs.getString(3);
                    LinkedList<String> str = new LinkedList<>();
                    str.add(numCiudad);            
                    str.add(ciudad);
                    str.add(depto);
                    ciudades.add(str);                   
            }
        }     
        return ciudades;        
    }catch(Exception e){
        System.out.println("Mobelo" + e.getMessage());
        return ciudades;
        }
    }
}
