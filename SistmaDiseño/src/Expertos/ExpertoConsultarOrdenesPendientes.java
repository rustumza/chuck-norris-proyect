/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expertos;

import DTO.DTOEquipamientoReservado;
import DTO.DTOOrden;
import DTO.DTORepuestoReservado;
import DTO.DTOReserva;
import Persistencia.Entidades.ElementoTrabajo;
import Persistencia.Entidades.Equipamiento;
import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.OrdenDeMantenimiento;
import Persistencia.Entidades.OrdenDeReparacion;
import Persistencia.Entidades.OrdenTrabajo;
import Persistencia.Entidades.Repuesto;
import Persistencia.Entidades.Reserva;
import Persistencia.Entidades.ReservaElementoTrabajo;
import Persistencia.Entidades.SuperDruperInterfaz;
import Persistencia.ExpertosPersistencia.FachadaExterna;
import Persistencia.Fabricas.FabricaCriterios;
import Utilidades.FormateadorFechas;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author informatica
 */
public class ExpertoConsultarOrdenesPendientes implements Experto {

    public static final int ordenTrabajo = 1;
    public static final int ordenMantenimiento = 2;
    public static final int ordenReparacion = 3;

    public boolean validarFecha(Date fecha) {

        return (new Date().compareTo(fecha) < 0);
    }

    public List<OrdenTrabajo> buscarOrdenes(Date fecha) {
        if (!validarFecha(fecha)) {
            //Tirar excepcion por fecha incorrecta
            return null;
        }
        List<OrdenTrabajo> ordenesEncontradas = new ArrayList<OrdenTrabajo>();

        
        for (OrdenDeReparacion orden : buscarOrdenesReparacionPendiente(fecha)) {
            ordenesEncontradas.add(orden);
        }

        for (OrdenDeMantenimiento orden : buscarOrdenesMantPendiente(fecha)) {
            ordenesEncontradas.add(orden);
        }


        return ordenesEncontradas;

    }

    public List<OrdenDeMantenimiento> buscarOrdenesMantPendiente(Date fecha) {

        if (!validarFecha(fecha)) {
            //Tirar excepcion por fecha incorrecta
            return null;
        }

        List<Criterio> listaCriterios = new ArrayList<Criterio>();
        List<OrdenDeMantenimiento> ordenesEncontradas = new ArrayList<OrdenDeMantenimiento>();

        listaCriterios.add(FabricaCriterios.getInstancia().crearCriterio("FechaInicioPlanificada", "=", FormateadorFechas.getInstancia().formatearAMySql(fecha)));
        listaCriterios.add(FabricaCriterios.getInstancia().crearCriterio("estado", "=", "PENDIENTE"));
        

        for (SuperDruperInterfaz orden : FachadaExterna.getInstancia().buscar("OrdenDeMantenimiento", listaCriterios)) {
            ordenesEncontradas.add((OrdenDeMantenimiento) orden);
        }

        return ordenesEncontradas;
    }

    public List<OrdenDeReparacion> buscarOrdenesReparacionPendiente(Date fecha) {

        if (!validarFecha(fecha)) {
            //Tirar excepcion por fecha incorrecta
            return null;
        }

        List<Criterio> listaCriterios = new ArrayList<Criterio>();
        List<OrdenDeReparacion> ordenesEncontradas = new ArrayList<OrdenDeReparacion>();

        
        listaCriterios.add(FabricaCriterios.getInstancia().crearCriterio("FechaInicioPlanificada", "=", FormateadorFechas.getInstancia().formatearAMySql((fecha))));
        listaCriterios.add(FabricaCriterios.getInstancia().crearCriterio("estado", "=", "PENDIENTE"));


        for (SuperDruperInterfaz orden : FachadaExterna.getInstancia().buscar("OrdenReparacion", listaCriterios)) {
            ordenesEncontradas.add((OrdenDeReparacion) orden);
        }

        return ordenesEncontradas;
    }

    public List<DTOOrden> buscarOrdenesDTO(Date fecha, int tipoOrden) {
        List<DTOOrden> listaDTO = new ArrayList<DTOOrden>();
        List<OrdenTrabajo> listaOrdenes = new ArrayList<OrdenTrabajo>();

        switch (tipoOrden) {
            case ordenTrabajo:
                listaOrdenes = buscarOrdenes(fecha);
                break;
            case ordenMantenimiento:
                for (OrdenDeMantenimiento ordenMant : buscarOrdenesMantPendiente(fecha)) {
                    listaOrdenes.add((OrdenDeMantenimiento) ordenMant);
                }
                break;
            case ordenReparacion:
                for (OrdenDeReparacion ordenRep : buscarOrdenesReparacionPendiente(fecha)) {
                    listaOrdenes.add((OrdenDeMantenimiento) ordenRep);
                }
                break;
            default:
                break;
        }


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
}
