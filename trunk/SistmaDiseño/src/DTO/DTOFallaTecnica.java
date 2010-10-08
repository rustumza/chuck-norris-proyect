/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author diego
 * DTO contenedor de fallas tecnicas
 */
public class DTOFallaTecnica {

    private String codigoFalla;
    private String nombreFalla;
    private String descripcion;

    /**
     * @return the nombreFalla
     */
    public String getNombreFalla() {
        return nombreFalla;
    }

    /**
     * @param nombreFalla the nombreFalla to set
     */
    public void setNombreFalla(String nombreFalla) {
        this.nombreFalla = nombreFalla;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the codigoFalla
     */
    public String getCodigoFalla() {
        return codigoFalla;
    }

    /**
     * @param codigoFalla the codigoFalla to set
     */
    public void setCodigoFalla(String codigoFalla) {
        this.codigoFalla = codigoFalla;
    }
}
