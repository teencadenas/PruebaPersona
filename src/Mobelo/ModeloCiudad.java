/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mobelo;

import Clases.ciudad;
import com.mysql.cj.xdevapi.Statement;
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

    public LinkedList<ciudad> listaCiudadesRegistrdas(){
    LinkedList<ciudad> ciudades = new LinkedList<>();
    try(Connection conn = DriverManager.getConnection(cx.getUrl(),cx.getUser(),cx.getPassword())){
        String query = "SELECT * FROM ciudadescolombia";
        PreparedStatement stm =conn.prepareStatement(query);
        ResultSet rs = stm.executeQuery();
        while (rs.next()){
            String region =rs.getString(1);
            String numDepto = rs.getString(2);
            String depto = rs.getString(3);
            String numCiudad = rs.getString(4);
            String ciudad = rs.getString(5);
            ciudad city = new ciudad(region,numDepto,depto,numCiudad,ciudad);
            ciudades.add(city);
        }
        return ciudades;        
    }catch(Exception e){
        System.out.println("Mobelo" + e.getMessage());
        return ciudades;
        }
    }
    
    public ciudad buscarCiudad(String num){
        try(Connection conn = DriverManager.getConnection(cx.getUrl(),cx.getUser(),cx.getPassword())){
            String query = "SELECT * FROM ciudadescolombia WHERE NumeroCiudad = ?";
            PreparedStatement stm =conn.prepareStatement(query);
            stm.setString(1, num);
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                String region =rs.getString(1);
                String numDepto = rs.getString(2);
                String depto = rs.getString(3);
                String numCiudad = rs.getString(4);
                String city = rs.getString(5);
                ciudad ciudad = new ciudad(region,numDepto,depto,numCiudad,city);
                return ciudad;
            }
        }catch(Exception e){
                System.out.println("Modelo error buscar"+e);
        }
        return null;    
        }
}
    

