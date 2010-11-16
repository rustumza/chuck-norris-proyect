/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expertos;

import DTO.DTOOrden;
import Excepciones.ExcepcionCampoInvalido;
import Excepciones.ExcepcionObjetoNoEncontrado;
import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.OrdenDeMantenimiento;
import Persistencia.Entidades.OrdenDeReparacion;
import Persistencia.Entidades.OrdenTrabajo;
import Persistencia.Entidades.SuperDruperInterfaz;
import Persistencia.ExpertosPersistencia.FachadaExterna;
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

    public boolean esFechaIncorrecta(Date fecha) {

        return (new Date().compareTo(fecha) < 0);
    }

    public List<OrdenTrabajo> buscarOrdenes(Date fecha) throws ExcepcionCampoInvalido {
        if (fecha == null) {
            ExcepcionCampoInvalido ex = new ExcepcionCampoInvalido();
            ex.setMensaje("Fecha incorrecta.");
            throw ex;
        } else if (esFechaIncorrecta(fecha)) {
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

    public List<OrdenTrabajo> buscarOrdenes(Date fecha, int seleccion) throws ExcepcionCampoInvalido {
        if (fecha == null) {
            ExcepcionCampoInvalido ex = new ExcepcionCampoInvalido();
            ex.setMensaje("Fecha incorrecta.");
            throw ex;
        } else if (esFechaIncorrecta(fecha)) {
            //Tirar excepcion por fecha incorrecta
            return null;
        }
        List<OrdenTrabajo> ordenesEncontradas = new ArrayList<OrdenTrabajo>();

        if (seleccion == ordenReparacion || seleccion == ordenTrabajo) {
            for (OrdenDeReparacion orden : buscarOrdenesReparacionPendiente(fecha)) {
                ordenesEncontradas.add(orden);
            }
        }


        if (seleccion == ordenMantenimiento || seleccion == ordenTrabajo) {
            for (OrdenDeMantenimiento orden : buscarOrdenesMantPendiente(fecha)) {
                ordenesEncontradas.add(orden);
            }
        }




        return ordenesEncontradas;

    }

    public List<OrdenDeMantenimiento> buscarOrdenesMantPendiente(Date fecha) {

        if (esFechaIncorrecta(fecha)) {
            //Tirar excepcion por fecha incorrecta
            return null;
        }

        List<Criterio> listaCriterios = new ArrayList<Criterio>();
        List<OrdenDeMantenimiento> ordenesEncontradas = new ArrayList<OrdenDeMantenimiento>();

        listaCriterios.add(FachadaExterna.getInstancia().crearCriterio("FechaInicioPlanificada", "=", FormateadorFechas.getInstancia().formatearAMySql(fecha)));
        listaCriterios.add(FachadaExterna.getInstancia().crearCriterio("estado", "LIKE", "PENDIENTE"));


        for (SuperDruperInterfaz orden : FachadaExterna.getInstancia().buscar("OrdenDeMantenimiento", listaCriterios)) {
            ordenesEncontradas.add((OrdenDeMantenimiento) orden);
        }

        return ordenesEncontradas;
    }

    public List<OrdenDeReparacion> buscarOrdenesReparacionPendiente(Date fecha) {

        if (esFechaIncorrecta(fecha)) {
            //Tirar excepcion por fecha incorrecta
            return null;
        }

        List<Criterio> listaCriterios = new ArrayList<Criterio>();
        List<OrdenDeReparacion> ordenesEncontradas = new ArrayList<OrdenDeReparacion>();


        listaCriterios.add(FachadaExterna.getInstancia().crearCriterio("FechaInicioPlanificada", "=", FormateadorFechas.getInstancia().formatearAMySql(fecha)));
        listaCriterios.add(FachadaExterna.getInstancia().crearCriterio("estado", "LIKE", "PENDIENTE"));


        for (SuperDruperInterfaz orden : FachadaExterna.getInstancia().buscar("OrdenReparacion", listaCriterios)) {
            ordenesEncontradas.add((OrdenDeReparacion) orden);
        }

        return ordenesEncontradas;
    }

    public List<DTOOrden> buscarOrdenesDTO(Date fecha, int tipoOrden) throws ExcepcionCampoInvalido, ExcepcionObjetoNoEncontrado {

        if (fecha == null) {
            ExcepcionCampoInvalido ex = new ExcepcionCampoInvalido();
            ex.setMensaje("Debe Ingresar una Fecha.");
            throw ex;
        }
        List<Criterio> listacCriterios = new ArrayList<Criterio>();
        listacCriterios.add(FachadaExterna.getInstancia().crearCriterio("FechaInicioPlanificada", "=", FormateadorFechas.getInstancia().getFormatMySQLyyyyMMdd().format(fecha)));
        listacCriterios.add(FachadaExterna.getInstancia().crearCriterio("NombreEstado", " LIKE ", "Pendiente"));

        switch (tipoOrden) {
            case ordenTrabajo:
                return buscarOrdenesMantYRepDTO(listacCriterios);
            case ordenMantenimiento:
                return buscarOrdenesMantenimientoDTO(listacCriterios);
            case ordenReparacion:
                return buscarOrdenesReparacionDTO(listacCriterios);
            default:
                return null;
        }
    }

    /*
     * Busca Dto Ordenes de mantenimiento
     */
    public List<DTOOrden> buscarOrdenesMantenimientoDTO(List<Criterio> criterios) throws ExcepcionObjetoNoEncontrado {
        List<DTOOrden> listaDTO = new ArrayList<DTOOrden>();

        for (SuperDruperInterfaz objeto : FachadaExterna.getInstancia().buscar("DTOOrdenMantenimiento", criterios)) {
            listaDTO.add((DTOOrden) objeto);
        }
        if (listaDTO.isEmpty()) {
            ExcepcionObjetoNoEncontrado ex = new ExcepcionObjetoNoEncontrado();
            ex.setMensaje("No hay órdenes de Mantenimiento Pendientes para la fecha ingresada.");
            throw ex;
        }

        return listaDTO;
    }
    /*
     * Busca Dto Ordenes de Reparacion
     */

    public List<DTOOrden> buscarOrdenesReparacionDTO(List<Criterio> criterios) throws ExcepcionObjetoNoEncontrado {
        List<DTOOrden> listaDTO = new ArrayList<DTOOrden>();

        for (SuperDruperInterfaz objeto : FachadaExterna.getInstancia().buscar("DTOOrdenReparacion", criterios)) {
            listaDTO.add((DTOOrden) objeto);
        }
        if (listaDTO.isEmpty()) {
            ExcepcionObjetoNoEncontrado ex = new ExcepcionObjetoNoEncontrado();
            ex.setMensaje("No hay órdenes de Reparación Pendientes para la fecha ingresada.");
            throw ex;
        }

        return listaDTO;
    }
    /*
     * Busca Dto Ordenes de mantenimiento y reparacion
     */

    public List<DTOOrden> buscarOrdenesMantYRepDTO(List<Criterio> criterios) throws ExcepcionObjetoNoEncontrado {

        List<DTOOrden> listaDTO = new ArrayList<DTOOrden>();

        try {
            listaDTO.addAll(buscarOrdenesMantenimientoDTO(criterios));
        } catch (ExcepcionObjetoNoEncontrado ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                listaDTO.addAll(buscarOrdenesReparacionDTO(criterios));

            } catch (ExcepcionObjetoNoEncontrado ex) {
                System.out.println(ex.getMessage());
            } finally {
                if (listaDTO.isEmpty()) {
                    ExcepcionObjetoNoEncontrado ex = new ExcepcionObjetoNoEncontrado();
                    ex.setMensaje("Órdenes no encontradas para la fecha ingresada.");
                    throw ex;
                }
                return listaDTO;
            }
        }
    }
}
