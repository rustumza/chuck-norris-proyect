/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//4287227 pizzeria
package Expertos;

import DTO.DTOOrden;

import Excepciones.ExcepcionCampoInvalido;
import Excepciones.ExcepcionErrorConexion;
import Excepciones.ExcepcionObjetoNoEncontrado;
import Fabricas.FabricaAdaptadorSistemaReportes;
import Fabricas.FabricaAdaptadoresSistemaStock;
import Fabricas.FabricaExpertos;
import Persistencia.Entidades.DenunciaEstado;
import Persistencia.Entidades.EstadoDenuncia;
import Persistencia.Entidades.EstadoOrdenTrabajo;
import Persistencia.Entidades.OrdenDeReparacion;
import Persistencia.Entidades.OrdenTrabajo;
import Persistencia.Entidades.OrdenTrabajoEstado;
import Persistencia.Entidades.SuperDruperInterfaz;
import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.ExpertosPersistencia.FachadaExterna;
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
    private List<DTOOrden> listaDtoEncontrados = new ArrayList<DTOOrden>();

    public List<DTOOrden> consultarOrdenesMantenimientoPendientes(Date fecha) throws ExcepcionCampoInvalido, ExcepcionObjetoNoEncontrado {

        return ((ExpertoConsultarOrdenesPendientes) FabricaExpertos.getInstance().getExperto("ConsultarOrdenesPendientes")).buscarOrdenesDTO(fecha, ordenMantenimiento);

    }

    /*
     * Regresa lista de DTO de ordenes de reparacion
     * param Date fecha
     */
    public List<DTOOrden> consultarOrdenesReparacionPendientes(Date fecha) throws ExcepcionCampoInvalido, ExcepcionObjetoNoEncontrado {

        return ((ExpertoConsultarOrdenesPendientes) FabricaExpertos.getInstance().getExperto("ConsultarOrdenesPendientes")).buscarOrdenesDTO(fecha, ordenReparacion);

    }

    public List<DTOOrden> consultarOrdenesTrabajoPendientes(Date fecha) throws ExcepcionCampoInvalido, ExcepcionObjetoNoEncontrado {

        return ((ExpertoConsultarOrdenesPendientes) FabricaExpertos.getInstance().getExperto("ConsultarOrdenesPendientes")).buscarOrdenesDTO(fecha, ordenTrabajo);

    }

    public List<DTOOrden> consultarOrdenesPendientes(Date fecha, int seleccion) throws ExcepcionCampoInvalido, ExcepcionObjetoNoEncontrado {

        switch (seleccion) {
            case ordenTrabajo:
                listaDtoEncontrados.addAll(consultarOrdenesTrabajoPendientes(fecha));
                return listaDtoEncontrados;
            case ordenMantenimiento:
                listaDtoEncontrados.addAll(consultarOrdenesMantenimientoPendientes(fecha));
                return listaDtoEncontrados;
            case ordenReparacion:
                listaDtoEncontrados.addAll(consultarOrdenesReparacionPendientes(fecha));
                return listaDtoEncontrados;
            default:
                return null;
        }

    }

    public void guardarOrdenTrabajo(Date fecha) throws ExcepcionErrorConexion {

        List<OrdenTrabajo> ordenesEncontradas = new ArrayList<OrdenTrabajo>();

        List<Criterio> listaCriterios = new ArrayList<Criterio>();
        listaCriterios.add(FachadaExterna.getInstancia().crearCriterio("FechaInicioPlanificada", "=", FormateadorFechas.getInstancia().formatearAMySql(fecha)));
        listaCriterios.add(FachadaExterna.getInstancia().crearCriterio("estado", "LIKE", "PENDIENTE"));

        //busca ordenes de reparacion
        List<SuperDruperInterfaz> objetosEncontrados = FachadaExterna.getInstancia().buscar("OrdenReparacion", listaCriterios);

        if (!objetosEncontrados.isEmpty()) {
            for (SuperDruperInterfaz objeto : objetosEncontrados) {
                ordenesEncontradas.add((OrdenTrabajo) objeto);
            }
        }

        //busca ordenes de mantenimiento
        objetosEncontrados = FachadaExterna.getInstancia().buscar("OrdenDeMantenimiento", listaCriterios);

        if (!objetosEncontrados.isEmpty()) {
            for (SuperDruperInterfaz objeto : objetosEncontrados) {
                ordenesEncontradas.add((OrdenTrabajo) objeto);
            }
        }

        listaCriterios.clear();
        listaCriterios.add(FachadaExterna.getInstancia().crearCriterio("NombreEstado", "LIKE", "EN EJECUCION"));

        EstadoOrdenTrabajo estado = (EstadoOrdenTrabajo) FachadaExterna.getInstancia().buscar("EstadoOrdenTrabajo", listaCriterios).get(0);

        for (OrdenTrabajo orden : ordenesEncontradas) {//Por cada orden de trabajo

            for (OrdenTrabajoEstado ordenTrabEst : orden.getListaEstadosOrdenTrabajo()) {
                if (ordenTrabEst.isindicadorestadoactual()) {
                    ordenTrabEst.setindicadorestadoactual(false);
                }
            }

            orden.setfechainiciotrabajo(new Date());
            OrdenTrabajoEstado ordentrabajoestado = (OrdenTrabajoEstado) FabricaEntidades.getInstancia().crearEntidad("OrdenTrabajoEstado");
            ordentrabajoestado.setEstadoOrdenTrabajo(estado);
            ordentrabajoestado.setfechacambioestado(new Date());
            ordentrabajoestado.setindicadorestadoactual(true);

            orden.addEstado(ordentrabajoestado);


            if (orden.gettipoordentrabajo().equals("REPARACION")) {

                for (DenunciaEstado denunciaEstado : ((OrdenDeReparacion) orden).getDenuncia().getDenunciaEstado()) {
                    if (denunciaEstado.isindicadorestadoactual()) {
                        denunciaEstado.setindicadorestadoactual(false);
                    }
                }

                DenunciaEstado nuevoDenunciaEstado = (DenunciaEstado) FabricaEntidades.getInstancia().crearEntidad("DenunciaEstado");
                listaCriterios.clear();
                listaCriterios.add(FachadaExterna.getInstancia().crearCriterio("NombreEstado", "LIKE", "EN REPARACION"));
                EstadoDenuncia nuevoEstado = (EstadoDenuncia) FachadaExterna.getInstancia().buscar("EstadoDenuncia", listaCriterios).get(0);
                nuevoDenunciaEstado.setEstadoDenuncia(nuevoEstado);
                nuevoDenunciaEstado.setfechacambioestado(new Date());
                nuevoDenunciaEstado.setindicadorestadoactual(true);

                ((OrdenDeReparacion) orden).getDenuncia().agregarDenunciaEstado(nuevoDenunciaEstado);


                FachadaExterna.getInstancia().guardar("OrdenReparacion", orden);


            } else if (orden.gettipoordentrabajo().equals("MANTENIMIENTO")) {
                FachadaExterna.getInstancia().guardar("OrdenDeMantenimiento", orden);
            }

        }

        try {
            ConfirmarReservas(ordenesEncontradas);
        } catch (Exception ex) {
            ExcepcionErrorConexion excpErrCon = new ExcepcionErrorConexion();
            excpErrCon.setMensaje("Error de conexion con WebService. \nNo han sido confirmadas las reservas.\nOrdenes no confirmadas.");
            System.out.println(ex.getMessage());
            throw excpErrCon;
        }

    }

    private void ConfirmarReservas(List<OrdenTrabajo> ordenesEncontradas) {
        //LLAMAR WEB SERVICE
        for (OrdenTrabajo orden : ordenesEncontradas) {
            FabricaAdaptadoresSistemaStock.getInstance().crearAdaptador().confirmarStock(orden);
        }
    }

    public void imprimirOrdenesPendientes() {
        (FabricaAdaptadorSistemaReportes.getInstancia().crearAdaptadorReportes()).generarReportes(listaDtoEncontrados);
    }
}
