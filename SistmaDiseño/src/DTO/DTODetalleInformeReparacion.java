/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

/**
 *
 * @author diego
 */
public class DTODetalleInformeReparacion {

    private String Falla;
    private String EstadoFalla;

    /**
     * @return the Falla
     */
    public String getFalla() {
        return Falla;
    }

    /**
     * @param Falla the Falla to set
     */
    public void setFalla(String Falla) {
        this.Falla = Falla;
    }

    /**
     * @return the EstadoFalla
     */
    public String getEstadoFalla() {
        return EstadoFalla;
    }

    /**
     * @param EstadoFalla the EstadoFalla to set
     */
    public void setEstadoFalla(String EstadoFalla) {
        this.EstadoFalla = EstadoFalla;
    }

}
