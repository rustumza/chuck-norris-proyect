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

    private String falla;
    private String estadoFalla;
    private String comentario;

    /**
     * @return the Falla
     */
    public String getFalla() {
        return falla;
    }

    /**
     * @param Falla the Falla to set
     */
    public void setFalla(String Falla) {
        this.falla = Falla;
    }

    /**
     * @return the EstadoFalla
     */
    public String getEstadoFalla() {
        return estadoFalla;
    }

    /**
     * @param EstadoFalla the EstadoFalla to set
     */
    public void setEstadoFalla(String EstadoFalla) {
        this.estadoFalla = EstadoFalla;
    }

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

}
