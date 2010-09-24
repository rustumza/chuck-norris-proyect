/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public class PeriodicidadAgente implements Periodicidad{

    private PeriodicidadImplementacion implementacion;

    public int getdias() {
        return implementacion.getdias();
    }

    public String getperiodicidad() {
        return implementacion.getperiodicidad();
    }

    public void setdias(int newVal) {
        implementacion.setdias(newVal);
    }

    public void setperiodicidad(String newVal) {
        implementacion.setperiodicidad(newVal);
    }

    /**
     * @return the implementacion
     */
    public PeriodicidadImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(PeriodicidadImplementacion implementacion) {
        this.implementacion = implementacion;
    }

}
