/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Entidades;

import Persistencia.ExpertosPersistencia.FachadaInterna;
import java.util.Date;

/**
 *
 * @author diego
 */
public class OrdenTrabajoEstadoAgente extends ObjetoPersistente implements OrdenTrabajoEstado{

    private OrdenTrabajoEstadoImplementacion implementacion;
    private String oidEstadoOrdenTrabajo;
    //variable para saber si el objeto relacionado ha sido buscado en la BD
    private boolean estadoOrdenTrabajoBuscado;

    public Date getfechacambioestado() {
        return implementacion.getfechacambioestado();
    }

    public boolean isindicadorestadoactual() {
        return implementacion.isindicadorestadoactual();
    }

    public void setfechacambioestado(Date newVal) {
        implementacion.setfechacambioestado(newVal);
    }

    public void setindicadorestadoactual(boolean newVal) {
        implementacion.setindicadorestadoactual(newVal);
    }

    public EstadoOrdenTrabajo getEstadoOrdenTrabajo() {
        if (isEstadoOrdenTrabajoBuscado()==false)
            implementacion.setEstadoOrdenTrabajo((EstadoOrdenTrabajo)FachadaInterna.getInstancia().buscar("EstadoOrdenTrabajo", oidEstadoOrdenTrabajo));
        return implementacion.getEstadoOrdenTrabajo();
    }

    public void setEstadoOrdenTrabajo(EstadoOrdenTrabajo estadoOrdenTrabajo) {
        implementacion.setEstadoOrdenTrabajo(estadoOrdenTrabajo);
    }

    /**
     * @return the implementacion
     */
    public OrdenTrabajoEstadoImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(OrdenTrabajoEstadoImplementacion implementacion) {
        this.implementacion = implementacion;
    }

    /**
     * @return the oidEstadoOrdenTrabajo
     */
    public String getOidEstadoOrdenTrabajo() {
        return oidEstadoOrdenTrabajo;
    }

    /**
     * @param oidEstadoOrdenTrabajo the oidEstadoOrdenTrabajo to set
     */
    public void setOidEstadoOrdenTrabajo(String oidEstadoOrdenTrabajo) {
        this.oidEstadoOrdenTrabajo = oidEstadoOrdenTrabajo;
    }

    /**
     * @return the estadoOrdenTrabajoBuscado
     */
    public boolean isEstadoOrdenTrabajoBuscado() {
        return estadoOrdenTrabajoBuscado;
    }

    /**
     * @param estadoOrdenTrabajoBuscado the estadoOrdenTrabajoBuscado to set
     */
    public void setEstadoOrdenTrabajoBuscado(boolean estadoOrdenTrabajoBuscado) {
        this.estadoOrdenTrabajoBuscado = estadoOrdenTrabajoBuscado;
    }

}
