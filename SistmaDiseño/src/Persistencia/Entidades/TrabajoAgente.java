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
public class TrabajoAgente extends ObjetoPersistente implements Trabajo {

    private TrabajoImplementacion implementacion;
    private String oidTrabajoElementoNecesario;
    private String oidOrdenTrabajo;
    //variables para saber si el atributo se busco en la BD
    private boolean trabajoElementoNecesarioBuscado;
    private boolean ordenTrabajoBuscado;


    public int gettiempoEstimadoTrabajo() {
        return getImplementacion().gettiempoEstimadoTrabajo();
    }

    public String gettipotrabajo() {
        return getImplementacion().gettipotrabajo();
    }


    public void settiempoEstimadoTrabajo(int newVal) {
        getImplementacion().settiempoEstimadoTrabajo(newVal);
    }

    public void settipotrabajo(String newVal) {
        getImplementacion().settipotrabajo(newVal);
    }

    public TrabajoElementoNecesario getTrabajoElementoNecesario() {
        if (isTrabajoElementoNecesarioBuscado() == false) {
            getImplementacion().setTrabajoElementoNecesario((TrabajoElementoNecesario) FachadaInterna.getInstancia().buscar("TrabajoElementoNecesario", oidTrabajoElementoNecesario));
        }
        return getImplementacion().getTrabajoElementoNecesario();
    }

    public void setTrabajoElementoNecesario(TrabajoElementoNecesario trabajoElementoNecesario) {
        getImplementacion().setTrabajoElementoNecesario(trabajoElementoNecesario);
    }

    public OrdenTrabajo getOrdenTrabajo() {
        if (isOrdenTrabajoBuscado() == false) {
            getImplementacion().setOrdenTrabajo((OrdenTrabajo) FachadaInterna.getInstancia().buscar("OrdenTrabajo", oidOrdenTrabajo));
        }
        return getImplementacion().getOrdenTrabajo();
    }

    public void setOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
        getImplementacion().setOrdenTrabajo(ordenTrabajo);
    }

    /**
     * @return the oidTrabajoElementoNecesario
     */
    public String getOidTrabajoElementoNecesario() {
        return oidTrabajoElementoNecesario;
    }

    /**
     * @param oidTrabajoElementoNecesario the oidTrabajoElementoNecesario to set
     */
    public void setOidTrabajoElementoNecesario(String oidTrabajoElementoNecesario) {
        this.oidTrabajoElementoNecesario = oidTrabajoElementoNecesario;
    }

    /**
     * @return the trabajoElementoNecesarioBuscado
     */
    public boolean isTrabajoElementoNecesarioBuscado() {
        return trabajoElementoNecesarioBuscado;
    }

    /**
     * @param trabajoElementoNecesarioBuscado the trabajoElementoNecesarioBuscado to set
     */
    public void setTrabajoElementoNecesarioBuscado(boolean trabajoElementoNecesarioBuscado) {
        this.trabajoElementoNecesarioBuscado = trabajoElementoNecesarioBuscado;
    }

    /**
     * @return the oidOrdenTrabajo
     */
    public String getOidOrdenTrabajo() {
        return oidOrdenTrabajo;
    }

    /**
     * @param oidOrdenTrabajo the oidOrdenTrabajo to set
     */
    public void setOidOrdenTrabajo(String oidOrdenTrabajo) {
        this.oidOrdenTrabajo = oidOrdenTrabajo;
    }

    /**
     * @return the ordenTrabajoBuscado
     */
    public boolean isOrdenTrabajoBuscado() {
        return ordenTrabajoBuscado;
    }

    /**
     * @param ordenTrabajoBuscado the ordenTrabajoBuscado to set
     */
    public void setOrdenTrabajoBuscado(boolean ordenTrabajoBuscado) {
        this.ordenTrabajoBuscado = ordenTrabajoBuscado;
    }

    /**
     * @return the implementacion
     */
    public TrabajoImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(TrabajoImplementacion implementacion) {
        this.implementacion = implementacion;
    }

    public String getNombreTrabajo() {
        return implementacion.getNombreTrabajo();
    }

    public void setNombreTrabajo(String nombreTrabajo) {
        implementacion.setNombreTrabajo(nombreTrabajo);
    }
}
