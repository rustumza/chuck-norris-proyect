/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author LEIVA
 */
public class DTOTareaFichaMantenimiento {

    private String codigoTarea;
    private String nombreTarea;
    private String descripcionTarea;

    /**
     * @return the nombreTarea
     */
    public String getNombreTarea() {
        return nombreTarea;
    }

    /**
     * @param nombreTarea the nombreTarea to set
     */
    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcionTarea;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcionTarea = descripcion;
    }

    /**
     * @return the codigoTarea
     */
    public String getCodigoTarea() {
        return codigoTarea;
    }

    /**
     * @param codigoTarea the codigoTarea to set
     */
    public void setCodigoTarea(String codigoTarea) {
        this.codigoTarea = codigoTarea;
    }
}
