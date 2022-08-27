/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author teenc
 */
public class Ciudad {
    
    private String region,numDepto,departamento,numCiudad,ciudad;

    public Ciudad(String region, String numDepto, String departamento, String numCiudad, String ciudad) {
        this.region = region;
        this.numDepto = numDepto;
        this.departamento = departamento;
        this.numCiudad = numCiudad;
        this.ciudad = ciudad;
    }


    /**
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * @return the numDepto
     */
    public String getNumDepto() {
        return numDepto;
    }

    /**
     * @param numDepto the numDepto to set
     */
    public void setNumDepto(String numDepto) {
        this.numDepto = numDepto;
    }

    /**
     * @return the departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * @return the numCiudad
     */
    public String getNumCiudad() {
        return numCiudad;
    }

    /**
     * @param numCiudad the numCiudad to set
     */
    public void setNumCiudad(String numCiudad) {
        this.numCiudad = numCiudad;
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
}
