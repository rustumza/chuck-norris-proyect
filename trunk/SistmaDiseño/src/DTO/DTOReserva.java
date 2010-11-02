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

    public void addEquipamiento(DTOEquipamientoReservado nuevoEquipamiento) {
        if (listaEquipamiento == null) {
            listaEquipamiento = new ArrayList<DTOEquipamientoReservado>();
        }
        listaEquipamiento.add(nuevoEquipamiento);
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

    public void addRepuesto(DTORepuestoReservado nuevoRepuesto) {
        if (listaRepuesto == null) {
            listaRepuesto = new ArrayList<DTORepuestoReservado>();
        }
        listaRepuesto.add(nuevoRepuesto);
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

    public boolean seEncuentraEquipamiento(String nombre) {
        boolean esta = false;
        if (listaEquipamiento != null) {
            for (DTOEquipamientoReservado dTOEquipamientoReservado : listaEquipamiento) {
                if (dTOEquipamientoReservado.getNombreEquipamiento().equals(nombre)) {
                    esta = true;
                    break;
                }
                
            }
        }

        return esta;
    }

    public boolean seEncuentraRepuesto(String nombre) {
        boolean esta = false;
        if (listaRepuesto != null) {
            for (DTORepuestoReservado dTORepuestoReservado : listaRepuesto) {
                if (dTORepuestoReservado.getNombre().equals(nombre)) {
                    esta = true;
                    break;
                }
                
            }
        }
        return esta;
    }
}
