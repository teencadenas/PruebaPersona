/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.Empleado;
import javax.swing.JOptionPane;




/**
 *
 * @author teenc
 */
public class MensajesConfirmacion {
   

    public boolean mensajeConfirmacionEmpleado(Empleado em) {
        
        int mensaje = JOptionPane.showConfirmDialog(null,"""
                                                         Se a creado un nuevo empleado: 
                                                         """+
                em.getNombre1()+" - "+em.getNombre2()+"\n"+em.getApellido1()+" - "+em.getApellido2()+
                "\n"+em.geteMail()+" - "+em.getTipoIdPersona()+"\n"+em.getNumeroIdPersona()+" - "+
                em.getTelefono()+"\n"+ em.getFechaNacimiento()+" - "+em.getDireccion()+"\n"+em.getCiudad()+" - "+
                em.getRegional()+"\n"+em.getCargo()+" - "+em.getSalario()+"\n"+em.getFechaIngreso()+" - "+
                em.getEmpleadoId()+"\n"+em.getUsuario()+" - "+em.getCorreoEmpresarial());
        
        return mensaje == 0;
    }
    
}
