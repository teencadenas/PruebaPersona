/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Mobelo.ModeloCiudad;
import java.util.LinkedList;

/**
 *
 * @author teen
 */
public class ControladorCiudad {
    
    ModeloCiudad modeloCiudad = new ModeloCiudad();
    
    public LinkedList<LinkedList> listadoCiudadesRegistradas(){
        try{
           LinkedList<LinkedList> ciudades = modeloCiudad.listaCiudadesRegistrdas();
           return ciudades;
       }catch(Exception e){
           System.out.println("Controlador a " +e.getMessage());    
           return null;
        }
    }    
}
