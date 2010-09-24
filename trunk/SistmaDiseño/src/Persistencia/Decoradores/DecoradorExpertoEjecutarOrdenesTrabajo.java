/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Decoradores;


import Expertos.ExpertoEjecutarOrdenesTrabajo;
import Persistencia.Entidades.OrdenDeMantenimiento;
import Persistencia.Entidades.OrdenDeReparacion;
import Persistencia.Entidades.OrdenTrabajo;
import Persistencia.ExpertosPersistencia.FachadaInterna;
import java.util.Date;
import java.util.List;

/**
 *
 * @author informatica
 */
public class DecoradorExpertoEjecutarOrdenesTrabajo extends ExpertoEjecutarOrdenesTrabajo {

    @Override
    public List<OrdenTrabajo> consultarOrdenesTrabajoPendientes(Date fecha) {

        iniciarTx();
        List<OrdenTrabajo> aux = super.consultarOrdenesTrabajoPendientes(fecha);        
        return aux;
    }


    @Override
    public List<OrdenDeMantenimiento> consultarOrdenesMantenimientoPendientes(Date fecha) {
        iniciarTx();
        List<OrdenDeMantenimiento> aux = super.consultarOrdenesMantenimientoPendientes(fecha);
        return aux;
    }


    @Override
    public List<OrdenDeReparacion> consultarOrdenesReparacionPendientes(Date fecha) {
        iniciarTx();
        List<OrdenDeReparacion> aux = super.consultarOrdenesReparacionPendientes(fecha);        
        return aux;
    }

    @Override
    public void guardarOrdenTrabajo(List<OrdenTrabajo> ordenesEncontradas){
        guardarOrdenTrabajo(ordenesEncontradas);
        confirmarTx();
    }

    private void iniciarTx(){

        FachadaInterna.getInstancia().iniciarTransaccion();
    }

    private void confirmarTx(){

    FachadaInterna.getInstancia().confirmarTransaccion();
    }

}
