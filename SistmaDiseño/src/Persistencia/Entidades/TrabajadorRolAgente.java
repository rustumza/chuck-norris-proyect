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
public class TrabajadorRolAgente implements TrabajadorRol {

    private TrabajadorRolImplementacion implementacion;
    private String oidRol;
    private String oidTrabajador;
    //variable para saber si el objeto relacionado ya ha sido buscado en la BD
    private boolean rolBuscado;
    private boolean trabajadorBuscado;

    public Date getfechafinrol() {
        return implementacion.getfechafinrol();
    }

    public Date getfechainiciorol() {
        return implementacion.getfechainiciorol();
    }

    public void setfechafinrol(Date newVal) {
        implementacion.setfechafinrol(newVal);
    }

    public void setfechainiciorol(Date newVal) {
        implementacion.setfechainiciorol(newVal);
    }

    public Rol getRol() {
        if (isRolBuscado() == false) {
            implementacion.setRol((Rol) FachadaInterna.getInstancia().buscar("Rol", oidRol));
            rolBuscado = true;
        }
        return implementacion.getRol();
    }

    public void setRol(Rol rol) {
        implementacion.setRol(rol);
    }

    public Trabajador getTrabajador() {
        if (isTrabajadorBuscado() == false) {
            implementacion.setTrabajador((Trabajador) FachadaInterna.getInstancia().buscar("Trabajador", oidTrabajador));
            trabajadorBuscado = true;
        }
        return implementacion.getTrabajador();
    }

    public void setTrabajador(Trabajador trabajador) {
        implementacion.setTrabajador(trabajador);
    }

    /**
     * @return the implementacion
     */
    public TrabajadorRolImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(TrabajadorRolImplementacion implementacion) {
        this.implementacion = implementacion;
    }

    /**
     * @return the oidRol
     */
    public String getOidRol() {
        return oidRol;
    }

    /**
     * @param oidRol the oidRol to set
     */
    public void setOidRol(String oidRol) {
        this.oidRol = oidRol;
    }

    /**
     * @return the rolBuscado
     */
    public boolean isRolBuscado() {
        return rolBuscado;
    }

    /**
     * @param rolBuscado the rolBuscado to set
     */
    public void setRolBuscado(boolean rolBuscado) {
        this.rolBuscado = rolBuscado;
    }

    /**
     * @return the oidTrabajador
     */
    public String getOidTrabajador() {
        return oidTrabajador;
    }

    /**
     * @param oidTrabajador the oidTrabajador to set
     */
    public void setOidTrabajador(String oidTrabajador) {
        this.oidTrabajador = oidTrabajador;
    }

    /**
     * @return the trabajadorBuscado
     */
    public boolean isTrabajadorBuscado() {
        return trabajadorBuscado;
    }

    /**
     * @param trabajadorBuscado the trabajadorBuscado to set
     */
    public void setTrabajadorBuscado(boolean trabajadorBuscado) {
        this.trabajadorBuscado = trabajadorBuscado;
    }
}
