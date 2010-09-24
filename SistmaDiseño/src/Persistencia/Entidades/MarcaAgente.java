/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public class MarcaAgente extends ObjetoPersistente implements Marca{

    private MarcaImplementacion implementacion;

    public int getcodigomarca() {
        return implementacion.getcodigomarca();
    }

    public String getnombremarca() {
        return implementacion.getnombremarca();
    }

    public void setcodigomarca(int newVal) {
        implementacion.setcodigomarca(newVal);
    }

    public void setnombremarca(String newVal) {
        implementacion.setnombremarca(newVal);
    }

    /**
     * @return the implementacion
     */
    public MarcaImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(MarcaImplementacion implementacion) {
        this.implementacion = implementacion;
    }

}
