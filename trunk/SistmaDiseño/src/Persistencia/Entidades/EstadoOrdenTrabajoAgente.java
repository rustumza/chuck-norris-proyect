/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

import Persistencia.ExpertosPersistencia.FachadaInterna;

/**
 *
 * @author diego
 */
public class EstadoOrdenTrabajoAgente extends ObjetoPersistente implements EstadoOrdenTrabajo {

    private EstadoOrdenTrabajoImplementacion implementacion;
    private String oidOrdenTrabajoEstado;
    private boolean ordenTrabajoEstadoBuscado;

    public int getcodigoestadoordentrabajo() {
        return implementacion.getcodigoestadoordentrabajo();
    }

    public void setcodigoestadoordentrabajo(int newVal) {
        implementacion.setcodigoestadoordentrabajo(newVal);
    }

    public OrdenTrabajoEstado getOrdenTrabajoEstado() {
        if (isOrdenTrabajoEstadoBuscado() == false) {
            implementacion.setOrdenTrabajoEstado((OrdenTrabajoEstado) FachadaInterna.getInstancia().buscar("OrdenTrabajoEstado", oidOrdenTrabajoEstado));
            setOrdenTrabajoEstadoBuscado(true);
        }
        return implementacion.getOrdenTrabajoEstado();
    }

    public void setOrdenTrabajoEstado(OrdenTrabajoEstado ordenTrabajoEstado) {
        implementacion.setOrdenTrabajoEstado(ordenTrabajoEstado);
    }

    public String getNombreestado() {
        return implementacion.getNombreestado();
    }

    public void setNombreestado(String nombreestado) {
        implementacion.setNombreestado(nombreestado);
    }

    /**
     * @return the implementacion
     */
    public EstadoOrdenTrabajoImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(EstadoOrdenTrabajoImplementacion implementacion) {
        this.implementacion = implementacion;
    }

    /**
     * @return the oidOrdenTrabajoEstado
     */
    public String getOidOrdenTrabajoEstado() {
        return oidOrdenTrabajoEstado;
    }

    /**
     * @param oidOrdenTrabajoEstado the oidOrdenTrabajoEstado to set
     */
    public void setOidOrdenTrabajoEstado(String oidOrdenTrabajoEstado) {
        this.oidOrdenTrabajoEstado = oidOrdenTrabajoEstado;
    }

    /**
     * @return the ordenTrabajoEstadoBuscado
     */
    public boolean isOrdenTrabajoEstadoBuscado() {
        return ordenTrabajoEstadoBuscado;
    }

    /**
     * @param ordenTrabajoEstadoBuscado the ordenTrabajoEstadoBuscado to set
     */
    public void setOrdenTrabajoEstadoBuscado(boolean ordenTrabajoEstadoBuscado) {
        this.ordenTrabajoEstadoBuscado = ordenTrabajoEstadoBuscado;
    }
}
