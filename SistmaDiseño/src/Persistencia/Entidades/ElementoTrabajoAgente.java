/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public class ElementoTrabajoAgente extends ObjetoPersistente implements ElementoTrabajo{

    private ElementoTrabajoImplementacion implementacion;

    public short getcodigosistemaexterno() {
        return implementacion.getcodigosistemaexterno();
    }

    public String gettipoelemento() {
       return implementacion.gettipoelemento();
    }

    public void setcodigosistemaexterno(short newVal) {
        implementacion.setcodigosistemaexterno(newVal);
    }

    public void settipoelemento(String newVal) {
        implementacion.settipoelemento(newVal);
    }

    /**
     * @return the implementacion
     */
    public ElementoTrabajoImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(ElementoTrabajoImplementacion implementacion) {
        this.implementacion = implementacion;
    }

}
