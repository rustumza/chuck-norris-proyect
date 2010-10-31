/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.ExpertosPersistencia.FachadaInterna;
import Persistencia.Fabricas.FabricaCriterios;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class PersonaPadronAgente extends ObjetoPersistente implements PersonaPadron {

    private PersonaPadronImplementacion implementacion;
    //variable para saber si el objeto realacionado ya ha sido buscado en la BD
    private boolean personaPadronEstadoBuscado;

    public String getapellido() {
        return implementacion.getapellido();
    }

    public String getdomicilio() {
        return implementacion.getdomicilio();
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

    public void setdomicilio(String newVal) {
        implementacion.setdomicilio(newVal);
    }

    public void setnombre(String newVal) {
        implementacion.setnombre(newVal);
    }

    public void settipoDocumento(String newVal) {
        implementacion.settipoDocumento(newVal);
    }

    public String getNroDocumento() {
        return implementacion.getNroDocumento();
    }

    public void setNroDocumento(String nroDocumento) {
        implementacion.setNroDocumento(nroDocumento);
    }

    public List<PersonaPadronEstado> getPersonaPadronEstado() {
        if (isPersonaPadronEstadoBuscado() == false) {
            List<Criterio> listaCriterios = new ArrayList<Criterio>();
            listaCriterios.add(FachadaInterna.getInstancia().crearCriterio("OIDPersonaPadron", "OIDPersonaPadron", getOid()));
            
            for (SuperDruperInterfaz personaPadron : FachadaInterna.getInstancia().buscar("PersonaPadronEstado", listaCriterios)) {
                implementacion.addPersonaPadronEstado((PersonaPadronEstado) personaPadron);
            }
        }
        return implementacion.getPersonaPadronEstado();
    }

    /**
     * @return the implementacion
     */
    public PersonaPadronImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(PersonaPadronImplementacion implementacion) {
        this.implementacion = implementacion;
    }

        /**
     * @return the personaPadronEstadoBuscado
     */
    public boolean isPersonaPadronEstadoBuscado() {
        return personaPadronEstadoBuscado;
    }

    /**
     * @param personaPadronEstadoBuscado the personaPadronEstadoBuscado to set
     */
    public void setPersonaPadronEstadoBuscado(boolean personaPadronEstadoBuscado) {
        this.personaPadronEstadoBuscado = personaPadronEstadoBuscado;
    }

    public void setPersonaPadronEstado(List<PersonaPadronEstado> personaPadronEstado) {
        implementacion.setPersonaPadronEstado(personaPadronEstado);
    }
}
