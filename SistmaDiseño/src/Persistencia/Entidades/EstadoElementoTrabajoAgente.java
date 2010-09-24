/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public class EstadoElementoTrabajoAgente implements EstadoElementoTrabajo {

    private EstadoElementoTrabajoImplementacion implementacion;

    public int getcodigoestadoelementotrabajo() {
        return implementacion.getcodigoestadoelementotrabajo();
    }

    public String getnombreEstado() {
        return implementacion.getnombreEstado();
    }

    public void setcodigoestadoelementotrabajo(int newVal) {
        implementacion.setcodigoestadoelementotrabajo(newVal);
    }

    public void setnombreEstado(String newVal) {
        implementacion.setnombreEstado(newVal);
    }

    /**
     * @return the implementacion
     */
    public EstadoElementoTrabajoImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(EstadoElementoTrabajoImplementacion implementacion) {
        this.implementacion = implementacion;
    }
}
