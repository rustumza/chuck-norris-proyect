/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//4287227 pizzeria
package Expertos;

import Fabricas.FabricaAdaptadoresSistemaStock;
import Fabricas.FabricaExpertos;
import Persistencia.Entidades.EstadoOrdenTrabajo;
import Persistencia.Entidades.OrdenDeMantenimiento;
import Persistencia.Entidades.OrdenDeReparacion;
import Persistencia.Entidades.OrdenTrabajo;
import Persistencia.Entidades.OrdenTrabajoEstado;
import Persistencia.Entidades.Reserva;
import Persistencia.Entidades.ReservaElementoTrabajo;
import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.ExpertosPersistencia.FachadaExterna;
import Persistencia.Fabricas.FabricaCriterios;
import Persistencia.Fabricas.FabricaEntidades;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author informatica
 */
public class ExpertoEjecutarOrdenesTrabajo implements Experto{
    private String ConsultarOrdenesPendientes;

    public List<OrdenDeMantenimiento> consultarOrdenesMantenimientoPendientes(Date fecha) {

        List<OrdenDeMantenimiento>ordenesEncontradas = new ArrayList<OrdenDeMantenimiento>();
        
        ordenesEncontradas = ((ExpertoConsultarOrdenesPendientes)FabricaExpertos.getInstance().getExperto(ConsultarOrdenesPendientes)).buscarOrdenesMantPendiente(fecha);

        return ordenesEncontradas;
    }

    public List<OrdenDeReparacion> consultarOrdenesReparacionPendientes(Date fecha) {
        List<OrdenDeReparacion>ordenesEncontradas = new ArrayList<OrdenDeReparacion>();

        ordenesEncontradas =((ExpertoConsultarOrdenesPendientes)(FabricaExpertos.getInstance().getExperto(ConsultarOrdenesPendientes))).buscarOrdenesReparacionPendiente(fecha);

        return ordenesEncontradas;


    }
 public List<OrdenTrabajo> consultarOrdenesTrabajoPendientes(Date fecha) {
        List<OrdenTrabajo>ordenesEncontradas = new ArrayList<OrdenTrabajo>();

        ordenesEncontradas =((ExpertoConsultarOrdenesPendientes)(FabricaExpertos.getInstance().getExperto(ConsultarOrdenesPendientes))).buscarOrdenes(fecha);

        return ordenesEncontradas;


    }
    public void guardarOrdenTrabajo(List<OrdenTrabajo> ordenesEncontradas) {
        List<Criterio> listaCriterios = new ArrayList<Criterio>();
        listaCriterios.add(FabricaCriterios.getInstancia().crearCriterio("NombreEstado","=","en Reparacion"));

        EstadoOrdenTrabajo estado = (EstadoOrdenTrabajo) FachadaExterna.getInstancia().buscar("EstadoOrdenTrabajo", listaCriterios).get(0);

        for (OrdenTrabajo orden : ordenesEncontradas) {
            OrdenTrabajoEstado ordentrabajoestado = (OrdenTrabajoEstado)FabricaEntidades.getInstancia().crearEntidad("OrdenTrabajoEstado");
            ordentrabajoestado.setEstadoOrdenTrabajo(estado);
            ordentrabajoestado.setfechacambioestado(new Date());
            ordentrabajoestado.setindicadorestadoactual(true);
            for(OrdenTrabajoEstado ordenTrabEst : orden.getListaEstadosOrdenTrabajo()){
                if(ordenTrabEst.isindicadorestadoactual())
                    ordenTrabEst.setindicadorestadoactual(false);
            }
            orden.addEstado(ordentrabajoestado);
            
            llamarWebServiceConfirmarReservas(ordenesEncontradas);

            imprimirOrdenes(ordenesEncontradas);

            FachadaExterna.getInstancia().guardar("OrdenTrabajo", orden);
            
        }


    }

    private void imprimirOrdenes(List<OrdenTrabajo> ordenesEncontradas) {
        //MANDAR A IMPRIMIR LAS ORDENES
    }

    private void llamarWebServiceConfirmarReservas(List<OrdenTrabajo> ordenesEncontradas) {
        //LLAMAR WEB SERVICE
        for(OrdenTrabajo orden: ordenesEncontradas){
            for(Reserva res : orden.getRervas()){
                res.getcodigoreserva();     //resnro
                int[] codigosExternos = new int[res.getReservaElementoTrabajo().size()]; //arreglo codigos de bienes
                int cont = 0;
                for(ReservaElementoTrabajo resElemTrab : res.getReservaElementoTrabajo()){
                    codigosExternos[cont] = resElemTrab.getElementoTrabajo().getcodigosistemaexterno();
                }
                if(!FabricaAdaptadoresSistemaStock.getInstance().crearAdaptador().confirmarStock(res.getcodigoreserva(), codigosExternos)){
                    //tirar excepcion poruqe no se pudo reservar
                }
            }
            //con estos datos confirmo una reserva
            
           
        }
    }




}
