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
public class DTOReserva {
    private Date fechaReserva;
    private int numeroReserva;
    private List<DTOEquipamientoReservado> listaEquipamiento;
    private List<DTORepuestoReservado> listaRepuesto;

    /**
     * @return the fechaReserva
     */
    public Date getFechaReserva() {
        return fechaReserva;
    }

    /**
     * @param fechaReserva the fechaReserva to set
     */
    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    /**
     * @return the listaEquipamiento
     */
    public List<DTOEquipamientoReservado> getListaEquipamiento() {
        return listaEquipamiento;
    }

    /**
     * @param listaEquipamiento the listaEquipamiento to set
     */
    public void setListaEquipamiento(List<DTOEquipamientoReservado> listaEquipamiento) {
        this.listaEquipamiento = listaEquipamiento;
    }

    /**
     * @return the listaRepuesto
     */
    public List<DTORepuestoReservado> getListaRepuesto() {
        return listaRepuesto;
    }

    /**
     * @param listaRepuesto the listaRepuesto to set
     */
    public void setListaRepuesto(List<DTORepuestoReservado> listaRepuesto) {
        this.listaRepuesto = listaRepuesto;
    }

    /**
     * @return the numeroReserva
     */
    public int getNumeroReserva() {
        return numeroReserva;
    }

    /**
     * @param numeroReserva the numeroReserva to set
     */
    public void setNumeroReserva(int numeroReserva) {
        this.numeroReserva = numeroReserva;
    }




}
