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
public class PersonaPadronEstadoAgente implements PersonaPadronEstado{

    private PersonaPadronEstadoImplementacion implementacion;
    private String oidEstadoPersonaPadron;
    //variable para saber si el objeto relacionado ha sido buscado en la BD
    private boolean estadoPersonaPadronBuscado;

    public int getfechacambioestado() {
        return implementacion.getfechacambioestado();
    }

    public boolean isindicadorestadoactual() {
        return implementacion.isindicadorestadoactual();
    }

    public void setfechacambioestado(int newVal) {
        implementacion.setfechacambioestado(newVal);
    }

    public void setindicadorestadoactual(boolean newVal) {
        implementacion.setindicadorestadoactual(newVal);
    }

    public EstadoPersonaPadron getEtadoPersonaPadron() {
        if(isEstadoPersonaPadronBuscado()==false)
            implementacion.setEtadoPersonaPadron((EstadoPersonaPadron)FachadaInterna.getInstancia().buscar("EstadoPersonaPadron", oidEstadoPersonaPadron));
        return implementacion.getEtadoPersonaPadron();
    }

    public void setEtadoPersonaPadron(EstadoPersonaPadron etadoPersonaPadron) {
        implementacion.setEtadoPersonaPadron(etadoPersonaPadron);
    }

    /**
     * @return the implementacion
     */
    public PersonaPadronEstadoImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(PersonaPadronEstadoImplementacion implementacion) {
        this.implementacion = implementacion;
    }

    /**
     * @return the oidEstadoPersonaPadron
     */
    public String getOidEstadoPersonaPadron() {
        return oidEstadoPersonaPadron;
    }

    /**
     * @param oidEstadoPersonaPadron the oidEstadoPersonaPadron to set
     */
    public void setOidEstadoPersonaPadron(String oidEstadoPersonaPadron) {
        this.oidEstadoPersonaPadron = oidEstadoPersonaPadron;
    }

    /**
     * @return the estadoPersonaPadronBuscado
     */
    public boolean isEstadoPersonaPadronBuscado() {
        return estadoPersonaPadronBuscado;
    }

    /**
     * @param estadoPersonaPadronBuscado the estadoPersonaPadronBuscado to set
     */
    public void setEstadoPersonaPadronBuscado(boolean estadoPersonaPadronBuscado) {
        this.estadoPersonaPadronBuscado = estadoPersonaPadronBuscado;
    }

}
