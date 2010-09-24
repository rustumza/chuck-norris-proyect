/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

import Persistencia.ExpertosPersistencia.FachadaInterna;
import java.util.List;

/**
 *
 * @author diego
 */
public class InterseccionAgente extends ObjetoPersistente implements Interseccion {

    private InterseccionImplementacion implementacion;
    private List<String> listaOidCalle;
    //variable para saber si el objeto relacionado ya ha sido buscado en la BD
    private boolean calleBuscado;

    public List<Calle> getCalles() {
        if (isCalleBuscado() == false) {
            for (String oid : listaOidCalle) {
                implementacion.addCalle((Calle) FachadaInterna.getInstancia().buscar("Calle", oid));
            }
        }
        return implementacion.getCalles();
    }

    public void setCalles(List<Calle> calle) {
        implementacion.setCalles(calle);
    }

    public void addCalle(Calle nuevaCalle){
        implementacion.addCalle(nuevaCalle);
    }

    /**
     * @return the implementacion
     */
    public InterseccionImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(InterseccionImplementacion implementacion) {
        this.implementacion = implementacion;
    }

    /**
     * @return the oidCalle
     */
    public List<String> getOidsCalle() {
        return listaOidCalle;
    }

    /**
     * @param oidCalle the oidCalle to set
     */
    public void setOidsCalle(List<String> oidCalle) {
        this.listaOidCalle = oidCalle;
    }


    public void addOidCalle(String oid){
        listaOidCalle.add(oid);
    }

    /**
     * @return the calle
     */
    public boolean isCalleBuscado() {
        return calleBuscado;
    }

    /**
     * @param calle the calle to set
     */
    public void setCalle(boolean calle) {
        this.calleBuscado = calle;
    }
}
