/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public class OrientacionAgente extends ObjetoPersistente implements Orientacion {

    private OrientacionImplementacion implementacion;

    public int getcodigoOrientacion() {
        return implementacion.getcodigoOrientacion();
    }

    public String getdescripcion() {
        return implementacion.getdescripcion();
    }

    public void setcodigoOrientacion(int newVal) {
        implementacion.setcodigoOrientacion(newVal);
    }

    public void setdescripcion(String newVal) {
        implementacion.setdescripcion(newVal);
    }

    /**
     * @return the implementacion
     */
    public OrientacionImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(OrientacionImplementacion implementacion) {
        this.implementacion = implementacion;
    }
}
