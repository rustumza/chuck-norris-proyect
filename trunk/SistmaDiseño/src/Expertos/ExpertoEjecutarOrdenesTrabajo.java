/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//4287227 pizzeria
package Expertos;

import DTO.DTOEquipamientoReservado;
import DTO.DTOOrden;
import DTO.DTORepuestoReservado;
import DTO.DTOReserva;
import Fabricas.FabricaAdaptadoresSistemaStock;
import Fabricas.FabricaExpertos;
import Persistencia.Entidades.Equipamiento;
import Persistencia.Entidades.EstadoOrdenTrabajo;
import Persistencia.Entidades.OrdenDeMantenimiento;
import Persistencia.Entidades.OrdenDeReparacion;
import Persistencia.Entidades.OrdenTrabajo;
import Persistencia.Entidades.OrdenTrabajoEstado;
import Persistencia.Entidades.Repuesto;
import Persistencia.Entidades.Reserva;
import Persistencia.Entidades.ReservaElementoTrabajo;
import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.ExpertosPersistencia.FachadaExterna;
import Persistencia.Fabricas.FabricaCriterios;
import Persistencia.Fabricas.FabricaEntidades;
import Utilidades.FormateadorFechas;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author informatica
 */
public class ExpertoEjecutarOrdenesTrabajo implements Experto {

    public static final int ordenTrabajo = 1;
    public static final int ordenMantenimiento = 2;
    public static final int ordenReparacion = 3;

    private String ConsultarOrdenesPendientes;
    private List<OrdenTrabajo> ordenesTrabajoPendientes = new ArrayList<OrdenTrabajo>();

    public List<DTOOrden> consultarOrdenesMantenimientoPendientes(Date fecha) {

        List<OrdenDeMantenimiento> ordenesEncontradas = new ArrayList<OrdenDeMantenimiento>();

        ordenesEncontradas = ((ExpertoConsultarOrdenesPendientes) FabricaExpertos.getInstance().getExperto("ConsultarOrdenesPendientes")).buscarOrdenesMantPendiente(fecha);

        ordenesTrabajoPendientes.clear();
        ordenesTrabajoPendientes.addAll(ordenesEncontradas);

        return armarListaDTOOrden(ordenesTrabajoPendientes);
    }

    public List<DTOOrden> consultarOrdenesReparacionPendientes(Date fecha) {
        List<OrdenDeReparacion> ordenesEncontradas = new ArrayList<OrdenDeReparacion>();

        ordenesEncontradas = ((ExpertoConsultarOrdenesPendientes) (FabricaExpertos.getInstance().getExperto("ConsultarOrdenesPendientes"))).buscarOrdenesReparacionPendiente(fecha);

        ordenesTrabajoPendientes.clear();
        ordenesTrabajoPendientes.addAll(ordenesEncontradas);

        return armarListaDTOOrden(ordenesTrabajoPendientes);


    }

    public List<DTOOrden> consultarOrdenesTrabajoPendientes(Date fecha) {

        List<OrdenTrabajo> ordenesEncontradas = new ArrayList<OrdenTrabajo>();

        ordenesEncontradas = ((ExpertoConsultarOrdenesPendientes) (FabricaExpertos.getInstance().getExperto("ConsultarOrdenesPendientes"))).buscarOrdenes(fecha);

        ordenesTrabajoPendientes.clear();
        ordenesTrabajoPendientes.addAll(ordenesEncontradas);

        return armarListaDTOOrden(ordenesEncontradas);

    }

     public List<DTOOrden> consultarOrdenesPendientes(Date fecha, int seleccion){
         List<OrdenTrabajo> ordenesEncontradas = new ArrayList<OrdenTrabajo>();

         switch(seleccion){
             case ordenTrabajo:
                 return consultarOrdenesTrabajoPendientes(fecha);
             case ordenMantenimiento:
                 return consultarOrdenesMantenimientoPendientes(fecha);
             case ordenReparacion:
                 return consultarOrdenesReparacionPendientes(fecha);
             default:
                 return null;
         }

     }

    // <editor-fold defaultstate="collapsed" desc="comment">
    public void guardarOrdenTrabajo(List<OrdenTrabajo> ordenesTrabajo) {// </editor-fold>
        List<Criterio> listaCriterios = new ArrayList<Criterio>();
        listaCriterios.add(FabricaCriterios.getInstancia().crearCriterio("NombreEstado", "=", "EN EJECUCION"));

        EstadoOrdenTrabajo estado = (EstadoOrdenTrabajo) FachadaExterna.getInstancia().buscar("EstadoOrdenTrabajo", listaCriterios).get(0);

        for (OrdenTrabajo orden : ordenesTrabajo) {

            orden.setfechainiciotrabajo(new Date());
            OrdenTrabajoEstado ordentrabajoestado = (OrdenTrabajoEstado) FabricaEntidades.getInstancia().crearEntidad("OrdenTrabajoEstado");
            ordentrabajoestado.setEstadoOrdenTrabajo(estado);
            ordentrabajoestado.setfechacambioestado(new Date());
            

            for (OrdenTrabajoEstado ordenTrabEst : orden.getListaEstadosOrdenTrabajo()) {
                if (ordenTrabEst.isindicadorestadoactual()) {
                    ordenTrabEst.setindicadorestadoactual(false);
                }
            }
            ordentrabajoestado.setindicadorestadoactual(true);
            orden.addEstado(ordentrabajoestado);

            ConfirmarReservas(ordenesTrabajo);

            //imprimirOrdenes(ordenesTrabajo);

            if (orden.gettipoordentrabajo().equals("REPARACION")) {
                FachadaExterna.getInstancia().guardar("OrdenReparacion", orden);
            } else if (orden.gettipoordentrabajo().equals("MANTENIMIENTO")) {
                FachadaExterna.getInstancia().guardar("OrdenDeMantenimiento", orden);
            }

        }


    }

    private void imprimirOrdenes(List<OrdenTrabajo> ordenesEncontradas) {
        //MANDAR A IMPRIMIR LAS ORDENES
    }

    private void ConfirmarReservas(List<OrdenTrabajo> ordenesEncontradas) {
        //LLAMAR WEB SERVICE
        for (OrdenTrabajo orden : ordenesEncontradas) {
            FabricaAdaptadoresSistemaStock.getInstance().crearAdaptador().confirmarStock(orden);
        }
    }

    private List<DTOOrden> armarListaDTOOrden(List<OrdenTrabajo> listaOrdenes) {
        List<DTOOrden> listaDTO = new ArrayList<DTOOrden>();


        for (OrdenTrabajo orden : listaOrdenes) {//Por cada orden de trabajo encontrada
            DTOOrden nuevoDTO = new DTOOrden();

            nuevoDTO.setTipo(orden.gettipoordentrabajo());
            if (orden.gettipoordentrabajo().equalsIgnoreCase("REPARACION")) {
                nuevoDTO.setNroOrden(String.valueOf(((OrdenDeReparacion) orden).getcodigoordenreparacion()));
            } else if (orden.gettipoordentrabajo().equalsIgnoreCase("MANTENIMIENTO")) {
                nuevoDTO.setNroOrden(String.valueOf(((OrdenDeMantenimiento) orden).getcodigoordenmantenimiento()));
            }
            nuevoDTO.setDuracionPrevista(orden.getduracionprevistatrabajo());
            nuevoDTO.setFechaFinTrabajo(orden.getfechafintrabajo());
            nuevoDTO.setFechaInicioPlanificada(orden.getfechainicioplanificada());
            nuevoDTO.setFechaInicioTrabajo(orden.getfechainiciotrabajo());
            nuevoDTO.setNombreEquipo(orden.getEquipoDeTrabajo().getnombreEquipo());

            for (Reserva reserva : orden.getRervas()) {//por cada reserva de la orden de trabajo
                DTOReserva nuevaReserva = new DTOReserva();
                nuevaReserva.setFechaReserva(reserva.getfecha());
                nuevaReserva.setNumeroReserva(reserva.getcodigoreserva());

                List<DTOEquipamientoReservado> listaEquipamiento = new ArrayList<DTOEquipamientoReservado>();
                List<DTORepuestoReservado> listaRepuestos = new ArrayList<DTORepuestoReservado>();

                for (ReservaElementoTrabajo reservaElementoTrabajo : reserva.getReservaElementoTrabajo()) {//por cada elemento reservado
                    if (reservaElementoTrabajo.getElementoTrabajo().gettipoelemento().equalsIgnoreCase("EQUIPAMIENTO")) {
                        DTOEquipamientoReservado nuevoEquipamiento = new DTOEquipamientoReservado();
                        nuevoEquipamiento.setNombreEquipamiento(((Equipamiento) reservaElementoTrabajo.getElementoTrabajo()).getnombreEquipamiento());
                        nuevoEquipamiento.setCantidad(reservaElementoTrabajo.getcantidadreservada());

                        listaEquipamiento.add(nuevoEquipamiento);

                    } else if (reservaElementoTrabajo.getElementoTrabajo().gettipoelemento().equals("REPUESTO")) {
                        DTORepuestoReservado nuevoRepuesto = new DTORepuestoReservado();
                        nuevoRepuesto.setNombre(((Repuesto) reservaElementoTrabajo.getElementoTrabajo()).getnombreRepuesto());
                        nuevoRepuesto.setCantidad(reservaElementoTrabajo.getcantidadreservada());

                        listaRepuestos.add(nuevoRepuesto);
                    }
                }
                nuevaReserva.setListaEquipamiento(listaEquipamiento);
                nuevaReserva.setListaRepuesto(listaRepuestos);

                nuevoDTO.getListaReservas().add(nuevaReserva);
            }

            listaDTO.add(nuevoDTO);
        }

        return listaDTO;
    }

    public void confirmarOrdenesPendientes() {
        guardarOrdenTrabajo(ordenesTrabajoPendientes);

        //llamarWebServiceConfirmarReservas(ordenesTrabajo);

        //imprimirOrdenes(ordenesTrabajo);
    }
}
