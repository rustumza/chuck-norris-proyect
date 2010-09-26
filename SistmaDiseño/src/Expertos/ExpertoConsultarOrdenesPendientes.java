/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expertos;

import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.OrdenDeMantenimiento;
import Persistencia.Entidades.OrdenDeReparacion;
import Persistencia.Entidades.OrdenTrabajo;
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
        listaDeCriterios.add(FachadaExterna.getInstancia().crearCriterio("fechaInicioTrabajo", "=",FormateadorFechas.getInstancia().getFormat_dd_MM_yyyy().format(fecha)));
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

        listaCriterios.add(FabricaCriterios.getInstancia().crearCriterio("FechaInicioTrabajo", "=", FormateadorFechas.getInstancia().getFormat_dd_MM_yyyy().format(fecha)));
        listaCriterios.add(FabricaCriterios.getInstancia().crearCriterio("estado", "=", "pendiente"));

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

        listaCriterios.add(FabricaCriterios.getInstancia().crearCriterio("FechaInicioTrabajo", "=", FormateadorFechas.getInstancia().getFormat_dd_MM_yyyy().format(fecha)));
        listaCriterios.add(FabricaCriterios.getInstancia().crearCriterio("estado", "=", "pendiente"));

        for (SuperDruperInterfaz orden : FachadaExterna.getInstancia().buscar("OrdenDeReparacion", listaCriterios)) {
            ordenesEncontradas.add((OrdenDeReparacion) orden);
        }

        return ordenesEncontradas;
    }
}
