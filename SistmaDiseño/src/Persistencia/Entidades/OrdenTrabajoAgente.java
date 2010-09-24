/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.ExpertosPersistencia.FachadaInterna;
import Persistencia.Fabricas.FabricaCriterios;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author diego
 */
public class OrdenTrabajoAgente extends ObjetoPersistente implements OrdenTrabajo {

    private OrdenTrabajoImplementacion implementacion;
    private String oidEquipoDeTrabajo;
    private List<String> oidTrabajos;
    //variable para saber si el objeto relacionado ha sido buscado en la BD
    private boolean reservasBuscado;
    private boolean equipoDeTrabajoBuscado;
    private boolean trabajoBuscado;
    private boolean ordenTrabajoEstadosBuscado;

    public int getduracionprevistatrabajo() {
        return implementacion.getduracionprevistatrabajo();
    }

    public Date getfechafintrabajo() {
        return implementacion.getfechafintrabajo();
    }

    public Date getfechainicioplanificada() {
        return implementacion.getfechainicioplanificada();
    }

    public Date getfechainiciotrabajo() {
        return implementacion.getfechainiciotrabajo();
    }

    public String gettipoordentrabajo() {
        return implementacion.gettipoordentrabajo();
    }

    public void setduracionprevistatrabajo(int newVal) {
        implementacion.setduracionprevistatrabajo(newVal);
    }

    public void setfechafintrabajo(Date newVal) {
        implementacion.setfechafintrabajo(newVal);
    }

    public void setfechainicioplanificada(Date newVal) {
        implementacion.setfechainicioplanificada(newVal);
    }

    public void setfechainiciotrabajo(Date newVal) {
        implementacion.setfechainiciotrabajo(newVal);
    }

    public void settipoordentrabajo(String newVal) {
        implementacion.settipoordentrabajo(newVal);
    }

    public List<Reserva> getRervas() {
        if (isReservaBuscado() == false) {
            List<Criterio> listaCriterios = new ArrayList<Criterio>();
            listaCriterios.add(FabricaCriterios.getInstancia().crearCriterio("OIDOrdenDeTrabajo", "=", super.getOid()));
            for (SuperDruperInterfaz nuevaReserva : FachadaInterna.getInstancia().buscar("Reserva", listaCriterios)) {
                implementacion.addReserva((Reserva) nuevaReserva);
            }
        }
        return implementacion.getRervas();
    }

    public void setReservas(List<Reserva> reservas) {
        implementacion.setReservas(reservas);
    }

    public EquipoDeTrabajo getEquipoDeTrabajo() {
        if (isEquipoDeTrabajoBuscado() == false) {
            implementacion.setEquipoDeTrabajo((EquipoDeTrabajo) FachadaInterna.getInstancia().buscar("EquipoDeTrabajo", oidEquipoDeTrabajo));
        }
        return implementacion.getEquipoDeTrabajo();
    }

    public void setEquipoDeTrabajo(EquipoDeTrabajo equipoDeTrabajo) {
        implementacion.setEquipoDeTrabajo(equipoDeTrabajo);
    }

    public List<Trabajo> getTrabajos() {
        if (isTrabajosBuscado() == false) {
            for (String oidTrabBus : oidTrabajos) {
                implementacion.addTrabajo((Trabajo) FachadaInterna.getInstancia().buscar("Trabajo", oidTrabBus));
            }
        }

        return implementacion.getTrabajos();
    }

    public void setTrabajos(List<Trabajo> trabajo) {
        implementacion.setTrabajos(trabajo);
    }

    /**
     * @return the implementacion
     */
    public OrdenTrabajoImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(OrdenTrabajoImplementacion implementacion) {
        this.implementacion = implementacion;
    }

    /**
     * @return the reservaBuscado
     */
    public boolean isReservaBuscado() {
        return reservasBuscado;
    }

    /**
     * @param reservaBuscado the reservaBuscado to set
     */
    public void setReservaBuscado(boolean reservaBuscado) {
        this.reservasBuscado = reservaBuscado;
    }

    /**
     * @return the oidEquipoDeTrabajo
     */
    public String getOidEquipoDeTrabajo() {
        return oidEquipoDeTrabajo;
    }

    /**
     * @param oidEquipoDeTrabajo the oidEquipoDeTrabajo to set
     */
    public void setOidEquipoDeTrabajo(String oidEquipoDeTrabajo) {
        this.oidEquipoDeTrabajo = oidEquipoDeTrabajo;
    }

    /**
     * @return the equipoDeTrabajoBuscado
     */
    public boolean isEquipoDeTrabajoBuscado() {
        return equipoDeTrabajoBuscado;
    }

    /**
     * @param equipoDeTrabajoBuscado the equipoDeTrabajoBuscado to set
     */
    public void setEquipoDeTrabajoBuscado(boolean equipoDeTrabajoBuscado) {
        this.equipoDeTrabajoBuscado = equipoDeTrabajoBuscado;
    }

    /**
     * @return the oidTrabajo
     */
    public List<String> getOidTrabajos() {
        return oidTrabajos;
    }

    /**
     * @param oidTrabajo the oidTrabajo to set
     */
    public void setOidTrabajos(List<String> oidsTrabajo) {
        this.oidTrabajos = oidsTrabajo;
    }

    public void addOidTrabajo(String nuevoOid) {
        if (oidTrabajos == null) {
            oidTrabajos = new ArrayList<String>();
        }
        this.oidTrabajos.add(nuevoOid);
    }

    /**
     * @return the trabajoBuscado
     */
    public boolean isTrabajosBuscado() {
        return trabajoBuscado;
    }

    /**
     * @param trabajoBuscado the trabajoBuscado to set
     */
    public void setTrabajoBuscado(boolean trabajoBuscado) {
        this.trabajoBuscado = trabajoBuscado;
    }

    public List<OrdenTrabajoEstado> getListaEstadosOrdenTrabajo() {
        if (isOrdenTrabajoEstadosBuscado() == false) {
            List<Criterio> listaCriterios = new ArrayList<Criterio>();
            listaCriterios.add(FachadaInterna.getInstancia().crearCriterio("OIDOrdenDeTrabajo", "=", super.getOid()));

            for (SuperDruperInterfaz estado : FachadaInterna.getInstancia().buscar("OrdenTrabajoEstado", listaCriterios)) {
                implementacion.addEstado((OrdenTrabajoEstado) estado);
            }
        }
        return implementacion.getListaEstadosOrdenTrabajo();
    }

    public void setListaEstadosOrdenTrabajo(List<OrdenTrabajoEstado> listaEstadosOrdenTrabajo) {
        implementacion.setListaEstadosOrdenTrabajo(listaEstadosOrdenTrabajo);
    }

    
    /**
     * @return the ordenTrabajoEstadosBuscado
     */
    public boolean isOrdenTrabajoEstadosBuscado() {
        return ordenTrabajoEstadosBuscado;
    }

    /**
     * @param ordenTrabajoEstadosBuscado the ordenTrabajoEstadosBuscado to set
     */
    public void setOrdenTrabajoEstadosBuscado(boolean ordenTrabajoEstadosBuscado) {
        this.ordenTrabajoEstadosBuscado = ordenTrabajoEstadosBuscado;
    }

    public void addEstado(OrdenTrabajoEstado nuevoEstado) {
        implementacion.addEstado(nuevoEstado);
    }
}
