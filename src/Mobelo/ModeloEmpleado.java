/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mobelo;

import Clases.Empleado;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author teenc
 */
public class ModeloEmpleado {
    
    Conexion cx;
    
    public ModeloEmpleado() {
        this.cx = new Conexion();
    }
    
    public boolean crearNuevoEmpleado(Empleado nE){
        try(Connection conn = DriverManager.getConnection(cx.getUrl(), cx.getUser(), cx.getPassword())){
            String query ="INSERT INTO Persona (tipoIdPersona,numeroIdPersona,nombre1,nombre2,apellido1,apellido2,"
                    + "fechaNacimiento,direccion,ciudad,telefono,eMail) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            String query1 = "INSERT INTO Empleado (numeroIdPersona,empleadoId,fechaIngreso,fechaRetiro,cargo,regional,"
                    + "salario,usuario,contraseña,correoEmpresarial) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stm = conn.prepareStatement(query);
            PreparedStatement stm1 = conn.prepareStatement(query1);
            stm.setString(1,nE.getTipoIdPersona());
            stm.setString(2,nE.getNumeroIdPersona());
            stm.setString(3,nE.getNombre1());
            stm.setString(4,nE.getNombre2());
            stm.setString(5,nE.getApellido1());
            stm.setString(6,nE.getApellido2());
            stm.setString(7,nE.getFechaNacimiento());
            stm.setString(8,nE.getDireccion());
            stm.setString(9,nE.getCiudad());
            stm.setString(10,nE.getTelefono());
            stm.setString(11,nE.geteMail());
            stm1.setString(1,nE.getNumeroIdPersona());
            stm1.setString(2,nE.getEmpleadoId());
            stm1.setString(3,nE.getFechaIngreso());
            stm1.setString(4,nE.getFechaRetiro());
            stm1.setString(5,nE.getCargo());
            stm1.setString(6,nE.getRegional());
            stm1.setString(7,nE.getSalario());
            stm1.setString(8,nE.getUsuario());
            stm1.setString(9,nE.getContraseña());
            stm1.setString(10,nE.getCorreoEmpresarial());
            int rI = stm.executeUpdate();
            int rI1 = stm1.executeUpdate();
            if(rI > 0 && rI1 > 0){
                System.out.println("creacion de empleado correcta");
            return true;
            }
        } catch (SQLException ex) {
            System.out.println("modelo " + ex);           
        }      
        return false;
    }   
}
