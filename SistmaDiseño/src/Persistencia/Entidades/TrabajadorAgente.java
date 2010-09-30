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
public class TrabajadorAgente implements Trabajador {

    private TrabajadorImplementacion implementacion;
    private String oidTrabajo;
    //variable para saber si el objeto relacionado ha sido buscado en la BD
    private boolean trabajoBuscado;

    public String getapellido() {
        return implementacion.getapellido();
    }

    public String getDocumento() {
        return implementacion.getDocumento();
    }

    public String getlegajo() {
        return implementacion.getlegajo();
    }

    public String getnombre() {
        return implementacion.getnombre();
    }

    public String gettipoDocumento() {
        return implementacion.gettipoDocumento();
    }

    public void setapellido(String newVal) {
        implementacion.setapellido(newVal);
    }

    public void setDocumento(String newVal) {
        implementacion.setDocumento(newVal);
    }

    public void setlegajo(String newVal) {
        implementacion.setlegajo(newVal);
    }

    public void setnombre(String newVal) {
        implementacion.setnombre(newVal);
    }

    public void settipoDocumento(String newVal) {
        implementacion.setDocumento(newVal);
    }

    public Trabajo getTrabajo() {
        if (isTrabajoBuscado() == false) {
            implementacion.setTrabajo((Trabajo) FachadaInterna.getInstancia().buscar("Trabajo", oidTrabajo));
            trabajoBuscado = true;
        }
        return implementacion.getTrabajo();
    }

    public void setTrabajo(Trabajo trabajo) {
        implementacion.setTrabajo(trabajo);
    }

    /**
     * @return the implementacion
     */
    public TrabajadorImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(TrabajadorImplementacion implementacion) {
        this.implementacion = implementacion;
    }

    /**
     * @return the oidTrabajo
     */
    public String getOidTrabajo() {
        return oidTrabajo;
    }

    /**
     * @return the trabajoBuscado
     */
    public boolean isTrabajoBuscado() {
        return trabajoBuscado;
    }

    /**
     * @param trabajoBuscado the trabajoBuscado to set
     */
    public void setTrabajoBuscado(boolean trabajoBuscado) {
        this.trabajoBuscado = trabajoBuscado;
    }

    /**
     * @param oidTrabajo the oidTrabajo to set
     */
    public void setOidTrabajo(String oidTrabajo) {
        this.oidTrabajo = oidTrabajo;
    }
}
