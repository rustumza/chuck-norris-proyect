/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public class NumeradorAgente implements Numerador{

    private NumeradorImplementacion implementacion;

    public String gettipodocumentacion() {
        return implementacion.gettipodocumentacion();
    }

    public int getultimonumeroregistrado() {
        return implementacion.getultimonumeroregistrado();
    }

    public void settipodocumentacion(String newVal) {
        implementacion.settipodocumentacion(newVal);
    }

    public void setultimonumeroregistrado(int newVal) {
        implementacion.setultimonumeroregistrado(newVal);
    }

    /**
     * @return the implementacion
     */
    public NumeradorImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(NumeradorImplementacion implementacion) {
        this.implementacion = implementacion;
    }

}
