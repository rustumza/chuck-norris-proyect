package Persistencia.Entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:15 p.m.
 */
public class OrdenTrabajoImplementacion implements OrdenTrabajo {

    private int duracionprevistatrabajo;
    private Date fechafintrabajo;
    private Date fechainicioplanificada;
    private Date fechainiciotrabajo;
    private String tipoordentrabajo;
    private List<Reserva> reservas;
    private EquipoDeTrabajo equipoDeTrabajo;
    private List<Trabajo> trabajos;
    private List<OrdenTrabajoEstado> listaEstadosOrdenTrabajo;

    public OrdenTrabajoImplementacion() {
    }

    public int getduracionprevistatrabajo() {
        return duracionprevistatrabajo;
    }

    public Date getfechafintrabajo() {
        return fechafintrabajo;
    }

    public Date getfechainicioplanificada() {
        return fechainicioplanificada;
    }

    public Date getfechainiciotrabajo() {
        return fechainiciotrabajo;
    }

    public String gettipoordentrabajo() {
        return tipoordentrabajo;
    }

    /**
     *
     * @param newVal
     */
    public void setduracionprevistatrabajo(int newVal) {
        duracionprevistatrabajo = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void setfechafintrabajo(Date newVal) {
        fechafintrabajo = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void setfechainicioplanificada(Date newVal) {
        fechainicioplanificada = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void setfechainiciotrabajo(Date newVal) {
        fechainiciotrabajo = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void settipoordentrabajo(String newVal) {
        tipoordentrabajo = newVal;
    }

    /**
     * @return the reJserva
     */
    public List<Reserva> getRervas() {
        return reservas;
    }

    /**
     * @param reJserva the reJserva to set
     */
    public void setReservas(List<Reserva> nuevasReservas) {
        this.reservas = nuevasReservas;
    }

    public void addReserva(Reserva nuevaReserva){
        if(reservas == null){
            reservas = new ArrayList<Reserva>();
        }
        reservas.add(nuevaReserva);
    }

    /**
     * @return the equipoDeTrabajo
     */
    public EquipoDeTrabajo getEquipoDeTrabajo() {
        return equipoDeTrabajo;
    }

    /**
     * @param equipoDeTrabajo the equipoDeTrabajo to set
     */
    public void setEquipoDeTrabajo(EquipoDeTrabajo equipoDeTrabajo) {
        this.equipoDeTrabajo = equipoDeTrabajo;
    }

    /**
     * @return the trabajo
     */
    public List<Trabajo> getTrabajos() {
        return trabajos;
    }

    /**
     * @param trabajo the trabajo to set
     */
    public void setTrabajos(List<Trabajo> trabajo) {
        this.trabajos = trabajo;
    }

    public void addTrabajo(Trabajo nuevoTrabajo){
        if(trabajos == null)
            trabajos = new ArrayList<Trabajo>();
        trabajos.add(nuevoTrabajo);
    }

    /**
     * @return the listaEstadosOrdenTrabajo
     */
    public List<OrdenTrabajoEstado> getListaEstadosOrdenTrabajo() {
        return listaEstadosOrdenTrabajo;
    }

    /**
     * @param listaEstadosOrdenTrabajo the listaEstadosOrdenTrabajo to set
     */
    public void setListaEstadosOrdenTrabajo(List<OrdenTrabajoEstado> listaEstadosOrdenTrabajo) {
        this.listaEstadosOrdenTrabajo = listaEstadosOrdenTrabajo;
    }

    public void addEstado(OrdenTrabajoEstado nuevoEstado){
        if(listaEstadosOrdenTrabajo == null){
            listaEstadosOrdenTrabajo = new ArrayList<OrdenTrabajoEstado>();
        }
        listaEstadosOrdenTrabajo.add(nuevoEstado);
    }

}
