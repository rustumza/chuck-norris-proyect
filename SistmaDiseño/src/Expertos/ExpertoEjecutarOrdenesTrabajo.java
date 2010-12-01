/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//4287227 pizzeria
package Expertos;

import DTO.DTOOrden;

import Excepciones.ExcepcionCampoInvalido;
import Excepciones.ExcepcionErrorConexion;
import Excepciones.ExcepcionSistemaStock;
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
import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.ExpertosPersistencia.FachadaExterna;
import Persistencia.Fabricas.FabricaEntidades;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public void guardarOrdenTrabajo(Date fecha, int seleccion) throws ExcepcionErrorConexion, ExcepcionSistemaStock {

        List<OrdenTrabajo> ordenesEncontradas = new ArrayList<OrdenTrabajo>();
        try {
            ordenesEncontradas = ((ExpertoConsultarOrdenesPendientes) FabricaExpertos.getInstance().getExperto("ConsultarOrdenesPendientes")).buscarOrdenes(fecha, seleccion);
            List<Criterio> listaCriterios = new ArrayList<Criterio>();

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
            } catch (ExcepcionErrorConexion ex) {
                ExcepcionErrorConexion excpErrCon = new ExcepcionErrorConexion();
                excpErrCon.setMensaje("Error de conexion con WebService. \nNo han sido confirmadas las reservas.");
                System.out.println(excpErrCon.getMessage());
                throw excpErrCon;
            } 
        } catch (ExcepcionCampoInvalido ex) {
            Logger.getLogger(ExpertoEjecutarOrdenesTrabajo.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    /*
     * Confirma las reservas con el webservice y retorna un arreglo que contiene las reservas que no han podido confirmarse
     * si el arreglo es null, se han confirmado todas las reservas.
     */
    private void ConfirmarReservas(List<OrdenTrabajo> ordenesEncontradas) throws ExcepcionErrorConexion, ExcepcionSistemaStock {
        //LLAMAR WEB SERVICE
        String reservasFallidas = "Las siguientes reservas no han podido ser confirmadas: \n";
        boolean lanzarExcepcionReservasFallidas = false;
        for (OrdenTrabajo orden : ordenesEncontradas) {
            try {
                FabricaAdaptadoresSistemaStock.getInstance().crearAdaptador().confirmarStock(orden);
            } catch (ExcepcionSistemaStock ex) {
                reservasFallidas = reservasFallidas + ex.getMessage().split(":")[1]+"\n";
                lanzarExcepcionReservasFallidas = true;
                continue;
            } catch (ExcepcionErrorConexion ex) {
                throw ex;
            }
        }
        if(lanzarExcepcionReservasFallidas){
            ExcepcionSistemaStock ex = new ExcepcionSistemaStock();
            ex.setMensaje(reservasFallidas);
            throw ex;
        }
    }

    public void imprimirOrdenesPendientes() {
        (FabricaAdaptadorSistemaReportes.getInstancia().crearAdaptadorReportes()).generarReportes(listaDtoEncontrados);
    }
}
