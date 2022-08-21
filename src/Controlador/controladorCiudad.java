/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.ciudad;
import Mobelo.ModeloCiudad;
import java.util.LinkedList;

/**
 *
 * @author teen
 */
public class ControladorCiudad {
    
    ModeloCiudad modeloCiudad = new ModeloCiudad();
    
    public LinkedList<ciudad> listadoCiudadesRegistradas(){
        try{
           LinkedList<ciudad> ciudades = modeloCiudad.listaCiudadesRegistrdas();
           return ciudades;
        }catch(Exception e){
           System.out.println("Controlador a " +e.getMessage());    
           return null;
        }
    } 
    
    public ciudad buscarCiudad(String num){
        try{
            ciudad city = modeloCiudad.buscarCiudad(num);
            return city;
        }catch(Exception e){
            System.out.println("Control "+e);
            return null;
        }
    }
    
}
