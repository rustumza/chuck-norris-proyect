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
public class TrabajoElementoNecesarioAgente implements TrabajoElementoNecesario {

    private TrabajoElementoNecesarioImplementacion implementacion;
    private String oidElementoTrabajo;
    //variable para saber si el objeto relacionado ya ha sido buscado en la BD
    private boolean elementoTrabajoBuscado;

    public int getcantidadNecesaria() {
        return implementacion.getcantidadNecesaria();
    }

    public void setcantidadNecesaria(int newVal) {
        implementacion.setcantidadNecesaria(newVal);
    }

    public ElementoTrabajo getElementoTrabajo() {
        if (isElementoTrabajoBuscado() == false) {
            implementacion.setElementoTrabajo((ElementoTrabajo) FachadaInterna.getInstancia().buscar("ElementoTrabajo", oidElementoTrabajo));
            elementoTrabajoBuscado = true;
        }
        return implementacion.getElementoTrabajo();
    }

    public void setElementoTrabajo(ElementoTrabajo elementoTrabajo) {
        implementacion.setElementoTrabajo(elementoTrabajo);
    }

    /**
     * @return the implementacion
     */
    public TrabajoElementoNecesarioImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(TrabajoElementoNecesarioImplementacion implementacion) {
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
}
