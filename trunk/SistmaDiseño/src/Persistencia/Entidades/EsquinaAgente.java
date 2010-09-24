/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public class EsquinaAgente extends ObjetoPersistente implements Esquina{

    private EsquinaImplementacion implementacion;

    public int getcodigoEsquina() {
        return implementacion.getcodigoEsquina();
    }

    public String getdescripcion() {
        return implementacion.getdescripcion();
    }

    public void setcodigoEsquina(int newVal) {
        implementacion.setcodigoEsquina(newVal);
    }

    public void setdescripcion(String newVal) {
        implementacion.setdescripcion(newVal);
    }

    /**
     * @return the implementacion
     */
    public EsquinaImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(EsquinaImplementacion implementacion) {
        this.implementacion = implementacion;
    }

}
