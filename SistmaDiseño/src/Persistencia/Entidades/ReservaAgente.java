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
public class ReservaAgente extends ObjetoPersistente implements Reserva {

    private ReservaImplementacion implementacion;
    private String oidOrdenTrabajo;
    //variable para saber si el objeto relacionado ha sido buscado en la BD
    private boolean reservaElementoTrabajoBuscado;

    public int getcodigoreserva() {
        return implementacion.getcodigoreserva();
    }

    public Date getfecha() {
        return implementacion.getfecha();
    }

    public void setcodigoreserva(int newVal) {
        implementacion.setcodigoreserva(newVal);
    }

    public void setfecha(Date newVal) {
        implementacion.setfecha(newVal);
    }

    public List<ReservaElementoTrabajo> getReservaElementoTrabajo() {
        if (isReservaElementoTrabajoBuscado() == false) {
            List<Criterio> listaCriterio = new ArrayList<Criterio>();
            listaCriterio.add(FabricaCriterios.getInstancia().crearCriterio("OIDReserva", "=", super.getOid()));

            for (SuperDruperInterfaz objEncontrado : FachadaInterna.getInstancia().buscar("ReservaElementoTrabajo", listaCriterio)) {
                implementacion.addReservaElementoTrabajo((ReservaElementoTrabajo) objEncontrado);
                reservaElementoTrabajoBuscado = true;
            }
        }
        return implementacion.getReservaElementoTrabajo();
    }

    public void setReservaElementoTrabajo(List<ReservaElementoTrabajo> reservaElementoTrabajo) {
        implementacion.setReservaElementoTrabajo(reservaElementoTrabajo);
    }

    /**
     * @return the implementacion
     */
    public ReservaImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(ReservaImplementacion implementacion) {
        this.implementacion = implementacion;
    }

    /**
     * @return the reservaElementoTrabajoBuscado
     */
    public boolean isReservaElementoTrabajoBuscado() {
        return reservaElementoTrabajoBuscado;
    }

    /**
     * @param reservaElementoTrabajoBuscado the reservaElementoTrabajoBuscado to set
     */
    public void setReservaElementoTrabajoBuscado(boolean reservaElementoTrabajoBuscado) {
        this.reservaElementoTrabajoBuscado = reservaElementoTrabajoBuscado;
    }

    /**
     * @return the oidOrdenTrabajo
     */
    public String getOidOrdenTrabajo() {
        return oidOrdenTrabajo;
    }

    /**
     * @param oidOrdenTrabajo the oidOrdenTrabajo to set
     */
    public void setOidOrdenTrabajo(String oidOrdenTrabajo) {
        this.oidOrdenTrabajo = oidOrdenTrabajo;
    }
}
