/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author teenc
 */
public class Empleado extends Persona{
    private String empleadoId;
    private String fechaIngreso;
    private String fechaRetiro;
    private String cargo;
    private String regional;
    private String salario;
    private String usuario;
    private String contraseña;
    private String correoEmpresarial;

    public Empleado(String empleadoId, String fechaIngreso, String fechaRetiro, String cargo, String regional, String salario, String usuario, String contraseña, String correoEmpresarial, String tipoIdPersona, String numeroIdPersona, String nombre1, String nombre2, String apellido1, String apellido2, String fechaNacimiento, String direccion, String ciudad, String telefono, String eMail) {
        super(tipoIdPersona, numeroIdPersona, nombre1, nombre2, apellido1, apellido2, fechaNacimiento, direccion, ciudad, telefono, eMail);
        this.empleadoId = empleadoId;
        this.fechaIngreso = fechaIngreso;
        this.fechaRetiro = fechaRetiro;
        this.cargo = cargo;
        this.regional = regional;
        this.salario = salario;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.correoEmpresarial = correoEmpresarial;
        
        
    }

    /**
     * @return the empleadoId
     */
    public String getEmpleadoId() {
        return empleadoId;
    }

    /**
     * @param empleadoId the empleadoId to set
     */
    public void setEmpleadoId(String empleadoId) {
        this.empleadoId = empleadoId;
    }

    /**
     * @return the fechaIngreso
     */
    public String getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * @param fechaIngreso the fechaIngreso to set
     */
    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * @return the fechaRetiro
     */
    public String getFechaRetiro() {
        return fechaRetiro;
    }

    /**
     * @param fechaRetiro the fechaRetiro to set
     */
    public void setFechaRetiro(String fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the regional
     */
    public String getRegional() {
        return regional;
    }

    /**
     * @param regional the regional to set
     */
    public void setRegional(String regional) {
        this.regional = regional;
    }

    /**
     * @return the salario
     */
    public String getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(String salario) {
        this.salario = salario;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * @return the correoEmpresarial
     */
    public String getCorreoEmpresarial() {
        return correoEmpresarial;
    }

    /**
     * @param correoEmpresarial the correoEmpresarial to set
     */
    public void setCorreoEmpresarial(String correoEmpresarial) {
        this.correoEmpresarial = correoEmpresarial;
    }
     
    
}
