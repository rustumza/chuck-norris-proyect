/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public class TipoSemaforoAgente extends ObjetoPersistente implements TipoSemaforo{

    private TipoSemaforoImplementacion  implementacion;

    public int getcodigoTipoSemaforo() {
        return implementacion.getcodigoTipoSemaforo();
    }

    public String getdescripciontiposemaforo() {
        return implementacion.getdescripciontiposemaforo();
    }

    public void setcodigoTipoSemaforo(int newVal) {
        implementacion.setcodigoTipoSemaforo(newVal);
    }

    public void setdescripciontiposemaforo(String newVal) {
        implementacion.setdescripciontiposemaforo(newVal);
    }

    /**
     * @return the implementacion
     */
    public TipoSemaforoImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(TipoSemaforoImplementacion implementacion) {
        this.implementacion = implementacion;
    }

}
