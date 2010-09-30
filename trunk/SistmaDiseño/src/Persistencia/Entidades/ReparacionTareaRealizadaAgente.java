/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

import Persistencia.ExpertosPersistencia.FachadaInterna;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author diego
 */
public class ReparacionTareaRealizadaAgente implements ReparacionTareaRealizada {

    private ReparacionTareaRealizadaImplementacion implementacion;
    private String oidElementoTrabajoReparacion;
    private String oidTarea;
    //variable para saber si el objeto relacionado ha sido buscado en la BD
    private boolean elementoTrabajoReparacionBuscado;
    private boolean tareaBuscado;

    public String getcomentario() {
        return implementacion.getcomentario();
    }

    public Date getfechafinrealizaciontarea() {
        return implementacion.getfechafinrealizaciontarea();
    }

    public Date getfechainiciorealizaciontarea() {
        return implementacion.getfechainiciorealizaciontarea();
    }

    public Time gethorafintarea() {
        return implementacion.gethorafintarea();
    }

    public Time gethorainiciotarea() {
        return implementacion.gethorainiciotarea();
    }

    public void setcomentario(String newVal) {
        implementacion.setcomentario(newVal);
    }

    public void setfechafinrealizaciontarea(Date newVal) {
        implementacion.setfechafinrealizaciontarea(newVal);
    }

    public void setfechainiciorealizaciontarea(Date newVal) {
        implementacion.setfechainiciorealizaciontarea(newVal);
    }

    public void sethorafintarea(Time newVal) {
        implementacion.sethorafintarea(newVal);
    }

    public void sethorainiciotarea(Time newVal) {
        implementacion.sethorainiciotarea(newVal);
    }

    public ElementoTrabajoReparacion getElementoTrabajoReparacion() {
        if (isElementoTrabajoReparacionBuscado() == false) {
            implementacion.setElementoTrabajoReparacion((ElementoTrabajoReparacion) FachadaInterna.getInstancia().buscar("ElementoTrabajoReparacion", oidElementoTrabajoReparacion));
            elementoTrabajoReparacionBuscado = true;
        }
        return implementacion.getElementoTrabajoReparacion();
    }

    public void setElementoTrabajoReparacion(ElementoTrabajoReparacion elementoTrabajoReparacion) {
        implementacion.setElementoTrabajoReparacion(elementoTrabajoReparacion);
    }

    public Tarea getTarea() {
        if (isTareaBuscado() == false) {
            implementacion.setTarea((Tarea) FachadaInterna.getInstancia().buscar("Tarea", oidTarea));
            tareaBuscado = true;
        }
        return implementacion.getTarea();
    }

    public void setTarea(Tarea tarea) {
        implementacion.setTarea(tarea);
    }

    /**
     * @return the elementoTrabajoReparacionBuscado
     */
    public boolean isElementoTrabajoReparacionBuscado() {
        return elementoTrabajoReparacionBuscado;
    }

    /**
     * @param elementoTrabajoReparacionBuscado the elementoTrabajoReparacionBuscado to set
     */
    public void setElementoTrabajoReparacionBuscado(boolean elementoTrabajoReparacionBuscado) {
        this.elementoTrabajoReparacionBuscado = elementoTrabajoReparacionBuscado;
    }

    /**
     * @return the oidElementoTrabajoReparacion
     */
    public String getOidElementoTrabajoReparacion() {
        return oidElementoTrabajoReparacion;
    }

    /**
     * @param oidElementoTrabajoReparacion the oidElementoTrabajoReparacion to set
     */
    public void setOidElementoTrabajoReparacion(String oidElementoTrabajoReparacion) {
        this.oidElementoTrabajoReparacion = oidElementoTrabajoReparacion;
    }

    /**
     * @return the oidTarea
     */
    public String getOidTarea() {
        return oidTarea;
    }

    /**
     * @param oidTarea the oidTarea to set
     */
    public void setOidTarea(String oidTarea) {
        this.oidTarea = oidTarea;
    }

    /**
     * @return the tareaBuscado
     */
    public boolean isTareaBuscado() {
        return tareaBuscado;
    }

    /**
     * @param tareaBuscado the tareaBuscado to set
     */
    public void setTareaBuscado(boolean tareaBuscado) {
        this.tareaBuscado = tareaBuscado;
    }

    public void setImplementacion(ReparacionTareaRealizadaImplementacion implementacion) {
        this.implementacion = implementacion;

    }
}
