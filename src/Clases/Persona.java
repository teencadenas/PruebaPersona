/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author teenc
 */
public class Persona {
    private String tipoIdPersona;
    private String numeroIdPersona;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String fechaNacimiento;
    private String direccion;
    private String ciudad;
    private String telefono;
    private String eMail;

    public Persona(String tipoIdPersona, String numeroIdPersona, String nombre1, String nombre2, String apellido1, String apellido2, String fechaNacimiento, String direccion, String ciudad, String telefono, String eMail) {
        this.tipoIdPersona = tipoIdPersona;
        this.numeroIdPersona = numeroIdPersona;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.eMail = eMail;
    
    
    
    }   

    /**
     * @return the tipoIdPersona
     */
    public String getTipoIdPersona() {
        return tipoIdPersona;
    }

    /**
     * @param tipoIdPersona the tipoIdPersona to set
     */
    public void setTipoIdPersona(String tipoIdPersona) {
        this.tipoIdPersona = tipoIdPersona;
    }

    /**
     * @return the numeroIdPersona
     */
    public String getNumeroIdPersona() {
        return numeroIdPersona;
    }

    /**
     * @param numeroIdPersona the numeroIdPersona to set
     */
    public void setNumeroIdPersona(String numeroIdPersona) {
        this.numeroIdPersona = numeroIdPersona;
    }

    /**
     * @return the nombre1
     */
    public String getNombre1() {
        return nombre1;
    }

    /**
     * @param nombre1 the nombre1 to set
     */
    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    /**
     * @return the nombre2
     */
    public String getNombre2() {
        return nombre2;
    }

    /**
     * @param nombre2 the nombre2 to set
     */
    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    /**
     * @return the apellido1
     */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * @param apellido1 the apellido1 to set
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * @return the apellido2
     */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * @param apellido2 the apellido2 to set
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

     /**
     * @return the fechaNacimiento
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the eMail
     */
    public String geteMail() {
        return eMail;
    }

    /**
     * @param eMail the eMail to set
     */
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
        
}
