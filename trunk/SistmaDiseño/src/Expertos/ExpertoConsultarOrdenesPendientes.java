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

    public boolean validarFecha(Date fecha) {

        return (new Date().compareTo(fecha) >= 0);
    }

    public List<OrdenTrabajo> buscarOrdenes(Date fecha) {
        if (!validarFecha(fecha)) {
            //Tirar excepcion por fecha incorrecta
            return null;
        }


        List<Criterio> listaDeCriterios = new ArrayList<Criterio>();
        listaDeCriterios.add(FachadaExterna.getInstancia().crearCriterio("estado", "=", "PENDIENTE"));
        listaDeCriterios.add(FachadaExterna.getInstancia().crearCriterio("fechaInicioTrabajo", "=", FormateadorFechas.getInstancia().getFormat_dd_MM_yyyy().format(fecha)));
        List<SuperDruperInterfaz> ordenesEncontradas = FachadaExterna.getInstancia().buscar("OrdenTrabajo", listaDeCriterios);
        List<OrdenTrabajo> listaOrdenTrabajo = new ArrayList<OrdenTrabajo>();
        for (SuperDruperInterfaz orden : ordenesEncontradas) {
            listaOrdenTrabajo.add((OrdenTrabajo) orden);
        }
        return listaOrdenTrabajo;
    }

    public List<OrdenDeMantenimiento> buscarOrdenesMantPendiente(Date fecha) {

        if (!validarFecha(fecha)) {
            //Tirar excepcion por fecha incorrecta
            return null;
        }

        List<Criterio> listaCriterios = new ArrayList<Criterio>();
        List<OrdenDeMantenimiento> ordenesEncontradas = new ArrayList<OrdenDeMantenimiento>();

        listaCriterios.add(FabricaCriterios.getInstancia().crearCriterio("estado", "=", "PENDIENTE"));
        listaCriterios.add(FabricaCriterios.getInstancia().crearCriterio("FechaInicioTrabajo", "=", FormateadorFechas.getInstancia().getFormat_dd_MM_yyyy().format(fecha)));

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

        listaCriterios.add(FabricaCriterios.getInstancia().crearCriterio("estado", "=", "PENDIENTE"));
        listaCriterios.add(FabricaCriterios.getInstancia().crearCriterio("FechaInicioTrabajo", "=", FormateadorFechas.getInstancia().getFormat_dd_MM_yyyy().format(fecha)));


        for (SuperDruperInterfaz orden : FachadaExterna.getInstancia().buscar("OrdenDeReparacion", listaCriterios)) {
            ordenesEncontradas.add((OrdenDeReparacion) orden);
        }

        return ordenesEncontradas;
    }

    public List<DTOOrden> buscarOrdenesDTO(Date fecha) {
        List<DTOOrden> listaDTO = new ArrayList<DTOOrden>();
        List<OrdenTrabajo> listaOrdenes = buscarOrdenes(fecha);

        for (OrdenTrabajo ordenTrabajo : listaOrdenes) {//Por cada orden de trabajo encontrada
            DTOOrden nuevoDTO = new DTOOrden();

            nuevoDTO.setDuracionPrevista(ordenTrabajo.getduracionprevistatrabajo());
            nuevoDTO.setFechaFinTrabajo(ordenTrabajo.getfechafintrabajo());
            nuevoDTO.setFechaInicioPlanificada(ordenTrabajo.getfechainicioplanificada());
            nuevoDTO.setFechaInicioTrabajo(ordenTrabajo.getfechainiciotrabajo());

            for (Reserva reserva : ordenTrabajo.getRervas()) {//por cada reserva de la orden de trabajo
                DTOReserva nuevaReserva = new DTOReserva();
                nuevaReserva.setFechaReserva(reserva.getfecha());

                List<DTOEquipamientoReservado> listaEquipamiento = new ArrayList<DTOEquipamientoReservado>();
                List<DTORepuestoReservado> listaRepuestos = new ArrayList<DTORepuestoReservado>();

                for (ReservaElementoTrabajo reservaElementoTrabajo : reserva.getReservaElementoTrabajo()) {//por cada elemento reservado
                    if (reservaElementoTrabajo.getElementoTrabajo().gettipoelemento().equals("EQUIPAMIENTO")) {
                        DTOEquipamientoReservado nuevoEquipamiento = new DTOEquipamientoReservado();
                        nuevoEquipamiento.setNombreEquipamiento(((Equipamiento)reservaElementoTrabajo.getElementoTrabajo()).getnombreEquipamiento());
                        nuevoEquipamiento.setCantidad(reservaElementoTrabajo.getcantidadreservada());

                        listaEquipamiento.add(nuevoEquipamiento);
                    }else if(reservaElementoTrabajo.getElementoTrabajo().gettipoelemento().equals("REPUESTO")){
                        DTORepuestoReservado nuevoRepuesto = new DTORepuestoReservado();
                        nuevoRepuesto.setNombre(((Repuesto)reservaElementoTrabajo.getElementoTrabajo()).getnombreRepuesto());
                        nuevoRepuesto.setCantidad(reservaElementoTrabajo.getcantidadreservada());

                        listaRepuestos.add(nuevoRepuesto);
                    }
                }
                nuevaReserva.setListaEquipamiento(listaEquipamiento);
                nuevaReserva.setListaRepuesto(listaRepuestos);

                nuevoDTO.getListaReservas().add(nuevaReserva);
            }

        }

        return listaDTO;
    }
}
