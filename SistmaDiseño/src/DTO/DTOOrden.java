/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Persistencia.Entidades.ObjetoPersistente;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author informatica
 */
public class DTOOrden extends ObjetoPersistente {

    private String nroOrden;
    private int duracionPrevista;
    private Date fechaInicioTrabajo;
    private Date fechaFinTrabajo;
    private Date fechaInicioPlanificada;
    private String tipo;
    private List<DTOReserva> listaReservas;
    private String nombreEquipo;
    private String estado;
    private String nroCaso;
    private List<DTOSemaforo> listaSemaforos;
    private List<DTOFallaTecnica> listaFalla;
    private DTOInformeReparacion informeReparacion;
    private List<DTOTareaFichaMantenimiento> listaTareasMantenimiento;
    //datos adicionales usados para la generacion de reportes
    private DTOUbicacion ubicacion;

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
        if (listaReservas == null) {
            listaReservas = new ArrayList<DTOReserva>();
        }
        return listaReservas;
    }

    /**
     * @param listaReservas the listaReservas to set
     */
    public void setListaReservas(List<DTOReserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public void addReserva(DTOReserva nuevaReserva) {
        if (listaReservas == null) {
            listaReservas = new ArrayList<DTOReserva>();
        }
        listaReservas.add(nuevaReserva);
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
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the ubicacion
     */
    public DTOUbicacion getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(DTOUbicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * @return the listaFalla
     */
    public List<DTOFallaTecnica> getListaFalla() {
        if(listaFalla == null){
            listaFalla = new ArrayList<DTOFallaTecnica>();
        }
        return listaFalla;
    }

    /**
     * @param listaFalla the listaFalla to set
     */
    public void setListaFalla(List<DTOFallaTecnica> listaFalla) {
        this.listaFalla = listaFalla;
    }

    public void addFalla(DTOFallaTecnica falla) {
        if (listaFalla == null) {
            listaFalla = new ArrayList<DTOFallaTecnica>();
        }
        listaFalla.add(falla);
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
    public List<DTOSemaforo> getListaSemaforos() {
        if (listaSemaforos == null) {
            listaSemaforos = new ArrayList<DTOSemaforo>();
        }
        return listaSemaforos;
    }

    /**
     * @param listaSemaforos the listaSemaforos to set
     */
    public void setListaSemaforos(List<DTOSemaforo> listaSemaforos) {
        this.listaSemaforos = listaSemaforos;
    }

    public void addSemaforo(DTOSemaforo nuevoSem) {
        if (listaSemaforos == null) {
            listaSemaforos = new ArrayList<DTOSemaforo>();
        }
        listaSemaforos.add(nuevoSem);
    }

    /**
     * @return the informeReparacion
     */
    public DTOInformeReparacion getInformeReparacion() {
        return informeReparacion;
    }

    /**
     * @param informeReparacion the informeReparacion to set
     */
    public void setInformeReparacion(DTOInformeReparacion informeReparacion) {
        this.informeReparacion = informeReparacion;
    }

    public boolean seEncuentraSemaforo(String numeroSerie) {
        boolean esta = false;

        if (listaSemaforos != null) {
            for (DTOSemaforo dTOSemaforo : listaSemaforos) {
                if (dTOSemaforo.getNumeroSerie().equals(numeroSerie)) {
                    esta = true;
                    break;
                }
            }
        }
        return esta;
    }

    public boolean seEncuentraFalla(String codigoFalla) {
        boolean esta = false;

        if (listaFalla != null) {
            for (DTOFallaTecnica dTOFallaTecnica : listaFalla) {
                if (dTOFallaTecnica.getCodigoFalla().equals(codigoFalla)) {
                    esta = true;
                    break;
                }
            }
        }
        return esta;
    }

    /**
     * @return the listaTareasMantenimiento
     */
    public List<DTOTareaFichaMantenimiento> getListaTareasMantenimiento() {
        return listaTareasMantenimiento;
    }

    /**
     * @param listaTareasMantenimiento the listaTareasMantenimiento to set
     */
    public void setListaTareasMantenimiento(List<DTOTareaFichaMantenimiento> listaTareasMantenimiento) {
        this.listaTareasMantenimiento = listaTareasMantenimiento;
    }

    public void addTareaMantenimiento(DTOTareaFichaMantenimiento nuevaTareaMantenimiento) {
        if (listaTareasMantenimiento == null) {
            listaTareasMantenimiento = new ArrayList<DTOTareaFichaMantenimiento>();
        }
        listaTareasMantenimiento.add(nuevaTareaMantenimiento);
    }

    public boolean seEncuentraTareaMant(String codigo) {
        boolean esta = false;

        if (listaTareasMantenimiento != null) {
            for (DTOTareaFichaMantenimiento dtotareaFicha : listaTareasMantenimiento) {
                if (dtotareaFicha.getCodigoTarea().equals(codigo)) {
                    esta = true;
                    break;
                }
            }
        }
        return esta;
    }

    public boolean seEncuentraReserva(String nroReserva){
        boolean esta = false;
        if(listaReservas != null){
            for (DTOReserva dTOReserva : listaReservas) {
                if(String.valueOf(dTOReserva.getNumeroReserva()).equals(nroReserva)){
                    esta = true;
                    break;
                }
            }
        }
        return esta;
    }
}
