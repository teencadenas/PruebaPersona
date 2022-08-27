/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.Ciudad;
import Mobelo.ModeloCiudad;
import java.util.LinkedList;

/**
 *
 * @author teen
 */
public class ControladorCiudad {
    
    ModeloCiudad modeloCiudad = new ModeloCiudad();
    
    public LinkedList<Ciudad> listadoCiudadesRegistradas(String str){
        try{
           LinkedList<Ciudad> ciudades = modeloCiudad.listaCiudadesRegistrdas(str);
           return ciudades;
        }catch(Exception e){
           System.out.println("Controlador a " +e.getMessage());    
           return null;
        }
    } 
    
    public Ciudad buscarCiudad(String str){
        try{
            Ciudad city = modeloCiudad.buscarCiudad(str);
            return city;
        }catch(Exception e){
            System.out.println("Control "+e);
            return null;
        }
    }    
}
