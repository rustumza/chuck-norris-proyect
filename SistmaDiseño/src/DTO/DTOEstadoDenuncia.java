/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author LEIVA
 */
public class DTOEstadoDenuncia {

    private String fecha;
    private String nombreestado;

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setNombreEstadoDenuncia(String nombreestado) {
        this.nombreestado = nombreestado;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @return the nombreestado
     */
    public String getNombreestado() {
        return nombreestado;
    }
}
