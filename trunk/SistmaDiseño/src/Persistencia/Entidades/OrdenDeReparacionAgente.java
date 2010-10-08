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
public class OrdenDeReparacionAgente extends OrdenTrabajoAgente implements OrdenDeReparacion {

    private String oidDenuncia;
    //variable para saber si el atributo relacionado ya fue buscado en la BD
    private boolean denunciaBuscado;
    private boolean informeReparacionBuscado;

    public int getcodigoordenreparacion() {
        return ((OrdenDeReparacionImplementacion) super.getImplementacion()).getcodigoordenreparacion();
    }

    public void setcodigoordenreparacion(int newVal) {
        ((OrdenDeReparacionImplementacion) super.getImplementacion()).setcodigoordenreparacion(newVal);
    }

    public Denuncia getDenuncia() {
        if (isDenunciaBuscado() == false) {
            ((OrdenDeReparacionImplementacion) super.getImplementacion()).setDenuncia((Denuncia) FachadaInterna.getInstancia().buscar("Denuncia", oidDenuncia));
            denunciaBuscado = true;
        }
        return ((OrdenDeReparacionImplementacion) super.getImplementacion()).getDenuncia();

    }

    public void setDenuncia(Denuncia denuncia) {
        ((OrdenDeReparacionImplementacion) super.getImplementacion()).setDenuncia(denuncia);
    }

    public InformeReparacion getInformeReparacion() {
        if (isInformeReparacionBuscado() == false) {
            List<Criterio> listaCriterios = new ArrayList<Criterio>();
            listaCriterios.add(FabricaCriterios.getInstancia().crearCriterio("OIDOrdenTrabajo", "=", getOid()));
            ((OrdenDeReparacionImplementacion) super.getImplementacion()).setInformeReparacion((InformeReparacion) FachadaInterna.getInstancia().buscar("InformeReparacion", listaCriterios).get(0));
        }
        return ((OrdenDeReparacionImplementacion) super.getImplementacion()).getInformeReparacion();
    }

    public void setInformeReparacion(InformeReparacion informeReparacion) {
        ((OrdenDeReparacionImplementacion)super.getImplementacion()).setInformeReparacion(informeReparacion);
    }

    /**
     * @return the oidDenuncia
     */
    public String getOidDenuncia() {
        return oidDenuncia;
    }

    /**
     * @param oidDenuncia the oidDenuncia to set
     */
    public void setOidDenuncia(String oidDenuncia) {
        this.oidDenuncia = oidDenuncia;
    }

    /**
     * @return the denunciaBuscado
     */
    public boolean isDenunciaBuscado() {
        return denunciaBuscado;
    }

    /**
     * @param denunciaBuscado the denunciaBuscado to set
     */
    public void setDenunciaBuscado(boolean denunciaBuscado) {
        this.denunciaBuscado = denunciaBuscado;
    }

    /**
     * @return the informeReparacionBuscado
     */
    public boolean isInformeReparacionBuscado() {
        return informeReparacionBuscado;
    }

    /**
     * @param informeReparacionBuscado the informeReparacionBuscado to set
     */
    public void setInformeReparacionBuscado(boolean informeReparacionBuscado) {
        this.informeReparacionBuscado = informeReparacionBuscado;
    }
}
