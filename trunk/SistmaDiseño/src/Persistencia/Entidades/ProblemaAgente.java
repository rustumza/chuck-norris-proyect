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
public class ProblemaAgente extends ObjetoPersistente implements Problema {

    private ProblemaImplementacion implementacion;
    private String oidCaso;
    //variable para saber si el atributo relacionado ya ha sido buscado en la BD
    private boolean casoBuscado;

    @Override
    public String toString(){
        return implementacion.getdescripcionProblema();
    }

    public int getcodigoProblema() {
        return implementacion.getcodigoProblema();
    }

    public String getdescripcionProblema() {
        return implementacion.getdescripcionProblema();
    }

    public void setcodigoProblema(int newVal) {
        implementacion.setcodigoProblema(newVal);
    }

    public void setdescripcionProblema(String newVal) {
        implementacion.setdescripcionProblema(newVal);
    }

    public Caso getCaso() {
        if (isCasoBuscado() == false) {
            implementacion.setCaso((Caso) FachadaInterna.getInstancia().buscar("Caso", oidCaso));
        }
        return implementacion.getCaso();
    }

    public void setCaso(Caso caso) {
        implementacion.setCaso(caso);
    }

    /**
     * @return the implementacion
     */
    public ProblemaImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(ProblemaImplementacion implementacion) {
        this.implementacion = implementacion;
    }

    /**
     * @return the oidCaso
     */
    public String getOidCaso() {
        return oidCaso;
    }

    /**
     * @param oidCaso the oidCaso to set
     */
    public void setOidCaso(String oidCaso) {
        this.oidCaso = oidCaso;
    }

    /**
     * @return the casoBuscado
     */
    public boolean isCasoBuscado() {
        return casoBuscado;
    }

    /**
     * @param casoBuscado the casoBuscado to set
     */
    public void setCasoBuscado(boolean casoBuscado) {
        this.casoBuscado = casoBuscado;
    }
}
