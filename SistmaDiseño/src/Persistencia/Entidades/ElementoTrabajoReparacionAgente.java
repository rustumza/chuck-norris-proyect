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
public class ElementoTrabajoReparacionAgente extends ObjetoPersistente implements ElementoTrabajoReparacion {

    private ElementoTrabajoReparacionImplementacion implementacion;
    private String oidElementoTrabajo;
    private String oidEstadoElementoTrabajo;
    private String oidReparacionTareaRealizada;

    private boolean elementoTrabajoBuscado;
    private boolean estadoElementoTrabajoBuscado;

    public int getcantidad() {
        return implementacion.getcantidad();
    }

    public void setcantidad(int newVal) {
        implementacion.setcantidad(newVal);
    }

    public ElementoTrabajo getElementoTrabajo() {
        if (isElementoTrabajoBuscado()==false) {
            implementacion.setElementoTrabajo((ElementoTrabajo) FachadaInterna.getInstancia().buscar("ElementoTrabajo", oidElementoTrabajo));
        }
        return implementacion.getElementoTrabajo();
    }

    public void setElementoTrabajo(ElementoTrabajo elementoTrabajo) {
        implementacion.setElementoTrabajo(elementoTrabajo);
    }

    public EstadoElementoTrabajo getEstadoElementoTrabajo() {
        if (isEstadoElementoTrabajoBuscado()==false) {
            implementacion.setEstadoElementoTrabajo((EstadoElementoTrabajo) FachadaInterna.getInstancia().buscar("EstadoElementoTrabajo", oidEstadoElementoTrabajo));
        }
        return implementacion.getEstadoElementoTrabajo();
    }

    public void setEstadoElementoTrabajo(EstadoElementoTrabajo estadoElementoTrabajo) {
        implementacion.setEstadoElementoTrabajo(estadoElementoTrabajo);
    }

    /**
     * @return the implementacion
     */
    public ElementoTrabajoReparacionImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(ElementoTrabajoReparacionImplementacion implementacion) {
        this.implementacion = implementacion;
    }

    /**
     * @return the oidElementoTrabajo
     */
    public String getOidElementoTrabajo() {
        return oidElementoTrabajo;
    }

    /**
     * @param oidElementoTrabajo the oidElementoTrabajo to set
     */
    public void setOidElementoTrabajo(String oidElementoTrabajo) {
        this.oidElementoTrabajo = oidElementoTrabajo;
    }

    /**
     * @return the oidEstadoElementoTrabajo
     */
    public String getOidEstadoElementoTrabajo() {
        return oidEstadoElementoTrabajo;
    }

    /**
     * @param oidEstadoElementoTrabajo the oidEstadoElementoTrabajo to set
     */
    public void setOidEstadoElementoTrabajo(String oidEstadoElementoTrabajo) {
        this.oidEstadoElementoTrabajo = oidEstadoElementoTrabajo;
    }

    /**
     * @return the elementoTrabajoBuscado
     */
    public boolean isElementoTrabajoBuscado() {
        return elementoTrabajoBuscado;
    }

    /**
     * @param elementoTrabajoBuscado the elementoTrabajoBuscado to set
     */
    public void setElementoTrabajoBuscado(boolean elementoTrabajoBuscado) {
        this.elementoTrabajoBuscado = elementoTrabajoBuscado;
    }

    /**
     * @return the estadoElementoTrabajoBuscado
     */
    public boolean isEstadoElementoTrabajoBuscado() {
        return estadoElementoTrabajoBuscado;
    }

    /**
     * @param estadoElementoTrabajoBuscado the estadoElementoTrabajoBuscado to set
     */
    public void setEstadoElementoTrabajoBuscado(boolean estadoElementoTrabajoBuscado) {
        this.estadoElementoTrabajoBuscado = estadoElementoTrabajoBuscado;
    }

    /**
     * @return the oidReparacionTareaRealizada
     */
    public String getOidReparacionTareaRealizada() {
        return oidReparacionTareaRealizada;
    }

    /**
     * @param oidReparacionTareaRealizada the oidReparacionTareaRealizada to set
     */
    public void setOidReparacionTareaRealizada(String oidReparacionTareaRealizada) {
        this.oidReparacionTareaRealizada = oidReparacionTareaRealizada;
    }
}
