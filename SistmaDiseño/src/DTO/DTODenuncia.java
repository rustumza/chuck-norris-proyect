/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 * DTO para contener datos de la denuncia, sus estados, fallas y orden de reparacion
 * su uso es para construir tablas
 */
public class DTODenuncia {

    private List<DTOEstadoDenuncia> listaEstados;
    private DTOOrden ordenRep;
    private List<DTOFallaTecnica> listaFallas;
    private String nombreOperador;
    private String fechaCaso;

    /**
     * @return the listaFallas
     */
    public List<DTOFallaTecnica> getListaFallas() {
        return listaFallas;
    }

    /**
     * @param nuevalistaFallas the listaFallas to set
     */
    public void setListaFallas(List<DTOFallaTecnica> nuevalistaFallas) {
        if(listaFallas == null )
            listaFallas = new ArrayList<DTOFallaTecnica>();
        listaFallas.addAll(nuevalistaFallas);
    }

    /**
     * @return the listaEstados
     */
    public List<DTOEstadoDenuncia> getListaEstados() {
        return listaEstados;
    }

    /**
     * @param listaEstados the listaEstados to set
     */
    public void setListaEstados(List<DTOEstadoDenuncia> nuevalistaEstados) {
        if(listaEstados == null)
            listaEstados = new ArrayList<DTOEstadoDenuncia>();
        listaEstados.addAll(nuevalistaEstados);
    }

    /**
     * @return the ordenRep
     */
    public DTOOrden getOrdenRep() {
        return ordenRep;
    }

    /**
     * @param ordenRep the ordenRep to set
     */
    public void setOrdenRep(DTOOrden ordenRep) {
        this.ordenRep = ordenRep;
    }

    /**
     * @return the nombreOperador
     */
    public String getNombreOperador() {
        return nombreOperador;
    }

    /**
     * @param nombreOperador the nombreOperador to set
     */
    public void setNombreOperador(String nombreOperador) {
        this.nombreOperador = nombreOperador;
    }

    /**
     * @return the fechaCaso
     */
    public String getFechaCaso() {
        return fechaCaso;
    }

    /**
     * @param fechaCaso the fechaCaso to set
     */
    public void setFechaCaso(String fechaCaso) {
        this.fechaCaso = fechaCaso;
    }
}
