/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//4287227 pizzeria
package Expertos;

import DTO.DTOEquipamientoReservado;
import DTO.DTOFallaTecnica;
import DTO.DTOOrden;
import DTO.DTORepuestoReservado;
import DTO.DTOReserva;
//<<<<<<< .mine
//import Fabricas.FabricaAdaptadoresSistemaStock;
//

import DTO.DTOSemaforo;
import DTO.DTOUbicacion;
import Excepciones.ExcepcionCampoInvalido;
import Fabricas.FabricaAdaptadorSistemaReportes;
import Fabricas.FabricaAdaptadoresSistemaStock;
import Fabricas.FabricaExpertos;
import Persistencia.Entidades.Denuncia;
import Persistencia.Entidades.DenunciaEstado;
import Persistencia.Entidades.Equipamiento;
import Persistencia.Entidades.EstadoDenuncia;
import Persistencia.Entidades.EstadoOrdenTrabajo;
import Persistencia.Entidades.FallaTecnica;
import Persistencia.Entidades.Interseccion;
import Persistencia.Entidades.OrdenDeMantenimiento;
import Persistencia.Entidades.OrdenDeReparacion;
import Persistencia.Entidades.OrdenTrabajo;
import Persistencia.Entidades.OrdenTrabajoEstado;
import Persistencia.Entidades.Repuesto;
import Persistencia.Entidades.Reserva;
import Persistencia.Entidades.ReservaElementoTrabajo;
import Persistencia.Entidades.Semaforo;
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
public class ExpertoEjecutarOrdenesTrabajo implements Experto {

    public static final int ordenTrabajo = 1;
    public static final int ordenMantenimiento = 2;
    public static final int ordenReparacion = 3;
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

    public List<DTOOrden> consultarOrdenesTrabajoPendientes(Date fecha) throws ExcepcionCampoInvalido {

        List<OrdenTrabajo> ordenesEncontradas = new ArrayList<OrdenTrabajo>();

        ordenesEncontradas = ((ExpertoConsultarOrdenesPendientes) (FabricaExpertos.getInstance().getExperto("ConsultarOrdenesPendientes"))).buscarOrdenes(fecha);

        ordenesTrabajoPendientes.clear();
        ordenesTrabajoPendientes.addAll(ordenesEncontradas);

        return armarListaDTOOrden(ordenesEncontradas);

    }

    public List<DTOOrden> consultarOrdenesPendientes(Date fecha, int seleccion) throws ExcepcionCampoInvalido {

        switch (seleccion) {
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
    public void guardarOrdenTrabajo() {// </editor-fold>
        List<Criterio> listaCriterios = new ArrayList<Criterio>();
        listaCriterios.add(FachadaExterna.getInstancia().crearCriterio("NombreEstado", "LIKE", "EN EJECUCION"));

        EstadoOrdenTrabajo estado = (EstadoOrdenTrabajo) FachadaExterna.getInstancia().buscar("EstadoOrdenTrabajo", listaCriterios).get(0);

        for (OrdenTrabajo orden : ordenesTrabajoPendientes) {//Por cada orden de trabajo

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
                    if(denunciaEstado.isindicadorestadoactual()){
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

        ConfirmarReservas(ordenesTrabajoPendientes);


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
            DTOOrden nuevoDtoOrden = new DTOOrden();

            nuevoDtoOrden.setTipo(orden.gettipoordentrabajo());
            if (orden.gettipoordentrabajo().equalsIgnoreCase("REPARACION")) {
                //setea numero de caso
                nuevoDtoOrden.setNroCaso(String.valueOf(((OrdenDeReparacion) orden).getDenuncia().getcodigoDenuncia()));
                nuevoDtoOrden.setNroOrden(String.valueOf(((OrdenDeReparacion) orden).getcodigoordenreparacion()));
                // busca la ubicacion para setearla al dto
                if (((OrdenDeReparacion) orden).getDenuncia().getSemaforo().get(0).getUbicacion().gettipoubicacion().equals("INTERSECCION")) {
                    DTOUbicacion dtoUbicacion = new DTOUbicacion();
                    dtoUbicacion.setCalle1(((Interseccion) ((OrdenDeReparacion) orden).getDenuncia().getSemaforo().get(0).getUbicacion()).getCalles().get(0).getnombrecalle());
                    dtoUbicacion.setCalle2(((Interseccion) ((OrdenDeReparacion) orden).getDenuncia().getSemaforo().get(0).getUbicacion()).getCalles().get(1).getnombrecalle());
                    nuevoDtoOrden.setUbicacion(dtoUbicacion);
                }
                //busca las fallas para generar reportes
                for (FallaTecnica falla : ((OrdenDeReparacion) orden).getDenuncia().getFallasTecnica()) {
                    DTOFallaTecnica dtoFalla = new DTOFallaTecnica();
                    dtoFalla.setNombreFalla(falla.getNombreTrabajo());
                    dtoFalla.setCodigoFalla(String.valueOf(falla.getcodigoFallaTecnica()));
                    nuevoDtoOrden.addFalla(dtoFalla);
                }
                //busca los semaforos
                for (Semaforo semaforo : ((OrdenDeReparacion) orden).getDenuncia().getSemaforo()) {
                    DTOSemaforo dTOSemaforo = new DTOSemaforo();
                    dTOSemaforo.setNumeroSerie(semaforo.getnumeroSerie());
                    dTOSemaforo.setModelo(semaforo.getModelo().getnombremodelo());
                    nuevoDtoOrden.addSemaforo(dTOSemaforo);
                }

            } else if (orden.gettipoordentrabajo().equalsIgnoreCase("MANTENIMIENTO")) {

                nuevoDtoOrden.setNroOrden(String.valueOf(((OrdenDeMantenimiento) orden).getcodigoordenmantenimiento()));

                //setea el semaforo
                DTOSemaforo dTOSemaforo = new DTOSemaforo();
                dTOSemaforo.setModelo(((OrdenDeMantenimiento) orden).getSemaforo().getModelo().getnombremodelo());
                dTOSemaforo.setNumeroSerie(((OrdenDeMantenimiento) orden).getSemaforo().getnumeroSerie());


                if (((OrdenDeMantenimiento) orden).getSemaforo().getUbicacion().gettipoubicacion().equals("INTERSECCION")) {
                    //setea la ubicacion
                    DTOUbicacion dtoUbicacion = new DTOUbicacion();
                    dtoUbicacion.setCalle1(((Interseccion) ((OrdenDeMantenimiento) orden).getSemaforo().getUbicacion()).getCalles().get(0).getnombrecalle());
                    dtoUbicacion.setCalle2(((Interseccion) ((OrdenDeMantenimiento) orden).getSemaforo().getUbicacion()).getCalles().get(1).getnombrecalle());
                    nuevoDtoOrden.setUbicacion(dtoUbicacion);
                }



                nuevoDtoOrden.addSemaforo(dTOSemaforo);
            }

            nuevoDtoOrden.setDuracionPrevista(orden.getduracionprevistatrabajo());
            nuevoDtoOrden.setFechaFinTrabajo(orden.getfechafintrabajo());
            nuevoDtoOrden.setFechaInicioPlanificada(orden.getfechainicioplanificada());
            nuevoDtoOrden.setFechaInicioTrabajo(orden.getfechainiciotrabajo());
            nuevoDtoOrden.setNombreEquipo(orden.getEquipoDeTrabajo().getnombreEquipo());



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

                nuevoDtoOrden.getListaReservas().add(nuevaReserva);
            }

            listaDTO.add(nuevoDtoOrden);
        }

        return listaDTO;
    }

    public void imprimirOrdenesPendientes() {
        (FabricaAdaptadorSistemaReportes.getInstancia().crearAdaptadorReportes()).generarReportes(armarListaDTOOrden(ordenesTrabajoPendientes));
    }
}
