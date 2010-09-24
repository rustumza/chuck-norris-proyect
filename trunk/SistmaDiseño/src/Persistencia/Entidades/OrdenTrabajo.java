/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

import java.util.Date;
import java.util.List;

/**
 *
 * @author diego
 */
public interface OrdenTrabajo extends SuperDruperInterfaz {

    public int getduracionprevistatrabajo();

    public Date getfechafintrabajo();

    public Date getfechainicioplanificada();

    public Date getfechainiciotrabajo();

    public String gettipoordentrabajo();

    public void setduracionprevistatrabajo(int newVal);

    public void setfechafintrabajo(Date newVal);

    public void setfechainicioplanificada(Date newVal);

    public void setfechainiciotrabajo(Date newVal);

    public void settipoordentrabajo(String newVal);

    public List<Reserva> getRervas();

    public void setReservas(List<Reserva> nuevasReservas);

    public EquipoDeTrabajo getEquipoDeTrabajo();

    public void setEquipoDeTrabajo(EquipoDeTrabajo equipoDeTrabajo);

    public List<Trabajo> getTrabajos();

    public void setTrabajos(List<Trabajo> trabajo);

    public List<OrdenTrabajoEstado> getListaEstadosOrdenTrabajo();

    public void setListaEstadosOrdenTrabajo(List<OrdenTrabajoEstado> listaEstadosOrdenTrabajo);

     public void addEstado(OrdenTrabajoEstado nuevoEstado);
}
