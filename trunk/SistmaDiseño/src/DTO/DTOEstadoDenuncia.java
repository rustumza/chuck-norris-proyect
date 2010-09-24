/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

import java.util.Date;

/**
 *
 * @author LEIVA
 */
public class DTOEstadoDenuncia {
       private int fecha;
    private String nombreestado;
public void setFecha(int fecha){
    this.fecha = fecha;
}

    public void setNombreEstadoDenuncia(String nombreestado) {
      this.nombreestado=nombreestado;
    }

    /**
     * @return the fecha
     */
    public int getFecha() {
        return fecha;
    }

    /**
     * @return the nombreestado
     */
    public String getNombreestado() {
        return nombreestado;
    }

}
