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
public class DetalleInformeMantenimientoAgente implements DetalleInformeMantenimiento {

    private DetalleInformeMantenimientoImplementacion implementacion;
    private String oidTarea;
    private String oidElementoTrabajoMantenimiento;
    private boolean elementoTrabajoMantenimientoBuscado;
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

    public Date gethorafintarea() {
        return implementacion.gethorafintarea();
    }

    public Date gethorainiciotarea() {
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

    public void sethorafintarea(Date newVal) {
        implementacion.sethorafintarea(newVal);
    }

    public void sethorainiciotarea(Date newVal) {
        implementacion.sethorainiciotarea(newVal);
    }

    public Tarea getTarea() {
        if (isTareaBuscado() == false) {
            implementacion.setTarea((Tarea) FachadaInterna.getInstancia().buscar("Tarea", oidTarea));
        }
        return implementacion.getTarea();
    }

    public void setTarea(Tarea tarea) {
        implementacion.setTarea(tarea);
    }

    public ElementoTrabajoMantenimiento getElementoTrabajoMantenimiento() {
        if (isElementoTrabajoMantenimientoBuscado() == false) {
            implementacion.setElementoTrabajoMantenimiento((ElementoTrabajoMantenimiento) FachadaInterna.getInstancia().buscar("ElementoTrabajoMantenimiento", oidElementoTrabajoMantenimiento));
        }
        return implementacion.getElementoTrabajoMantenimiento();
    }

    public void setElementoTrabajoMantenimiento(ElementoTrabajoMantenimiento elementoTrabajoMantenimiento) {
        implementacion.setElementoTrabajoMantenimiento(elementoTrabajoMantenimiento);
    }

    /**
     * @return the implementacion
     */
    public DetalleInformeMantenimientoImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(DetalleInformeMantenimientoImplementacion implementacion) {
        this.implementacion = implementacion;
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
     * @return the oidElementoTrabajoMantenimiento
     */
    public String getOidElementoTrabajoMantenimiento() {
        return oidElementoTrabajoMantenimiento;
    }

    /**
     * @param oidElementoTrabajoMantenimiento the oidElementoTrabajoMantenimiento to set
     */
    public void setOidElementoTrabajoMantenimiento(String oidElementoTrabajoMantenimiento) {
        this.oidElementoTrabajoMantenimiento = oidElementoTrabajoMantenimiento;
    }

    /**
     * @return the elementoTrabajoMantenimientoBuscado
     */
    public boolean isElementoTrabajoMantenimientoBuscado() {
        return elementoTrabajoMantenimientoBuscado;
    }

    /**
     * @param elementoTrabajoMantenimientoBuscado the elementoTrabajoMantenimientoBuscado to set
     */
    public void setElementoTrabajoMantenimientoBuscado(boolean elementoTrabajoMantenimientoBuscado) {
        this.elementoTrabajoMantenimientoBuscado = elementoTrabajoMantenimientoBuscado;
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
}
