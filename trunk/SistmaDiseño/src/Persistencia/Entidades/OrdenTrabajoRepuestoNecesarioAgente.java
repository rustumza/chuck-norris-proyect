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
public class OrdenTrabajoRepuestoNecesarioAgente implements OrdenTrabajoRepuestoNecesario{

    private OrdenTrabajoRepuestoNecesarioImplementacion implementacion;
    private String oidRepuesto;
    //variable para saber si el objeto relacionado ya ha sido buscado en la BD
    private boolean repuestoBuscado;

    public int getcantidadNecesaria() {
        return implementacion.getcantidadNecesaria();
    }

    public void setcantidadNecesaria(int newVal) {
        implementacion.setcantidadNecesaria(newVal);
    }

    public Repuesto getRepuesto() {
        if(isRepuestoBuscado()==false)
            implementacion.setRepuesto((Repuesto)FachadaInterna.getInstancia().buscar("Repuesto", oidRepuesto));
        return implementacion.getRepuesto();
    }

    public void setRepuesto(Repuesto repuesto) {
        implementacion.setRepuesto(repuesto);
    }

    /**
     * @return the implementacion
     */
    public OrdenTrabajoRepuestoNecesarioImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(OrdenTrabajoRepuestoNecesarioImplementacion implementacion) {
        this.implementacion = implementacion;
    }

    /**
     * @return the repuestoBuscado
     */
    public boolean isRepuestoBuscado() {
        return repuestoBuscado;
    }

    /**
     * @param repuestoBuscado the repuestoBuscado to set
     */
    public void setRepuestoBuscado(boolean repuestoBuscado) {
        this.repuestoBuscado = repuestoBuscado;
    }

}
