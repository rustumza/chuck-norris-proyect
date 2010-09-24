/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public class RangoAniosAgente implements RangoAnios{

    private RangoAniosImplementacion implementacion;

    public int getmaxAnios() {
        return implementacion.getmaxAnios();
    }

    public int getminAnios() {
        return implementacion.getminAnios();
    }

    public void setmaxAnios(int newVal) {
        implementacion.setmaxAnios(newVal);
    }

    public void setminAnios(int newVal) {
        implementacion.setminAnios(newVal);
    }

    /**
     * @return the implementacion
     */
    public RangoAniosImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(RangoAniosImplementacion implementacion) {
        this.implementacion = implementacion;
    }

}
