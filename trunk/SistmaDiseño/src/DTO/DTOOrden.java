/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author informatica
 */
public class DTOOrden {

    private String nroOrden;
    private int duracionPrevista;
    private Date fechaInicioTrabajo;
    private Date fechaFinTrabajo;
    private Date fechaInicioPlanificada;
    private String tipo;
    private List<DTOReserva> listaReservas;

    /**
     * @return the nroOrden
     */
    public String getNroOrden() {
        return nroOrden;
    }

    /**
     * @param nroOrden the nroOrden to set
     */
    public void setNroOrden(String nroOrden) {
        this.nroOrden = nroOrden;
    }

    /**
     * @return the duracionPrevista
     */
    public int getDuracionPrevista() {
        return duracionPrevista;
    }

    /**
     * @param duracionPrevista the duracionPrevista to set
     */
    public void setDuracionPrevista(int duracionPrevista) {
        this.duracionPrevista = duracionPrevista;
    }

    /**
     * @return the fechaInicioTrabajo
     */
    public Date getFechaInicioTrabajo() {
        return fechaInicioTrabajo;
    }

    /**
     * @param fechaInicioTrabajo the fechaInicioTrabajo to set
     */
    public void setFechaInicioTrabajo(Date fechaInicioTrabajo) {
        this.fechaInicioTrabajo = fechaInicioTrabajo;
    }

    /**
     * @return the fechaFinTrabajo
     */
    public Date getFechaFinTrabajo() {
        return fechaFinTrabajo;
    }

    /**
     * @param fechaFinTrabajo the fechaFinTrabajo to set
     */
    public void setFechaFinTrabajo(Date fechaFinTrabajo) {
        this.fechaFinTrabajo = fechaFinTrabajo;
    }

    /**
     * @return the fechaInicioPlanificada
     */
    public Date getFechaInicioPlanificada() {
        return fechaInicioPlanificada;
    }

    /**
     * @param fechaInicioPlanificada the fechaInicioPlanificada to set
     */
    public void setFechaInicioPlanificada(Date fechaInicioPlanificada) {
        this.fechaInicioPlanificada = fechaInicioPlanificada;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the listaReservas
     */
    public List<DTOReserva> getListaReservas() {
        if(listaReservas==null)
            listaReservas = new ArrayList<DTOReserva>();
        return listaReservas;
    }

    /**
     * @param listaReservas the listaReservas to set
     */
    public void setListaReservas(List<DTOReserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

}
