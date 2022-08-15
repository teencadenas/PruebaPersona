/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.Empleado;
import Mobelo.ModeloEmpleado;
import Vista.IFempleado;

/**
 *
 * @author teenc
 */
public class ControladorEmpleado {
    
    ModeloEmpleado modelo = new ModeloEmpleado();
    
    public boolean crearEmpleado(Empleado nuevo){ 
    try{    
//        Empleado nuevo = formulario.crearNuevoEmpleado();
        modelo.crearNuevoEmpleado(nuevo);
        return true;
        }catch(Exception e){
        System.out.println("Controlador a " +e.getMessage());    
        return false;
        }     
    }  
}
      