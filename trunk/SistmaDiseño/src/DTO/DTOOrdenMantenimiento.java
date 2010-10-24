/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

import java.util.Date;
import java.util.List;

/**
 *
 * @author diego
 */
public class DTOOrdenMantenimiento {

    private String nroOrden;
    private Date fechaInicioTrabajo;
    private Date fechaFinTrabajo;
    private Date fechaInicioPlanificada;
    private List<DTOEquipamientoReservado> equipamientos;
    private List<DTORepuestoReservado> repuestos;
    private String nombreEquipo;
    private String nroCaso;
    private DTOSemaforo listaSemaforos;
    private List<DTOTarea> listaDTOTarea;
    private String calle1;
    private String calle2;
    private String altura;

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
     * @return the equipamientos
     */
    public List<DTOEquipamientoReservado> getEquipamientos() {
        return equipamientos;
    }

    /**
     * @param equipamientos the equipamientos to set
     */
    public void setEquipamientos(List<DTOEquipamientoReservado> equipamientos) {
        this.equipamientos = equipamientos;
    }

    /**
     * @return the repuestos
     */
    public List<DTORepuestoReservado> getRepuestos() {
        return repuestos;
    }

    /**
     * @param repuestos the repuestos to set
     */
    public void setRepuestos(List<DTORepuestoReservado> repuestos) {
        this.repuestos = repuestos;
    }

    /**
     * @return the nombreEquipo
     */
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    /**
     * @param nombreEquipo the nombreEquipo to set
     */
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    /**
     * @return the nroCaso
     */
    public String getNroCaso() {
        return nroCaso;
    }

    /**
     * @param nroCaso the nroCaso to set
     */
    public void setNroCaso(String nroCaso) {
        this.nroCaso = nroCaso;
    }

    /**
     * @return the listaSemaforos
     */
    public DTOSemaforo getListaSemaforos() {
        return listaSemaforos;
    }

    /**
     * @param listaSemaforos the listaSemaforos to set
     */
    public void setListaSemaforos(DTOSemaforo listaSemaforos) {
        this.listaSemaforos = listaSemaforos;
    }

    /**
     * @return the listaDTOTarea
     */
    public List<DTOTarea> getListaDTOTarea() {
        return listaDTOTarea;
    }

    /**
     * @param listaDTOTarea the listaDTOTarea to set
     */
    public void setListaDTOTarea(List<DTOTarea> listaDTOTarea) {
        this.listaDTOTarea = listaDTOTarea;
    }

    /**
     * @return the calle1
     */
    public String getCalle1() {
        return calle1;
    }

    /**
     * @param calle1 the calle1 to set
     */
    public void setCalle1(String calle1) {
        this.calle1 = calle1;
    }

    /**
     * @return the calle2
     */
    public String getCalle2() {
        return calle2;
    }

    /**
     * @param calle2 the calle2 to set
     */
    public void setCalle2(String calle2) {
        this.calle2 = calle2;
    }

    /**
     * @return the altura
     */
    public String getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(String altura) {
        this.altura = altura;
    }


}
