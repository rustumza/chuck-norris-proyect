/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Decoradores;

import DTO.DTOOrden;
import Excepciones.ExcepcionCampoInvalido;
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
    public List<DTOOrden> consultarOrdenesTrabajoPendientes(Date fecha) throws ExcepcionCampoInvalido {

        iniciarTx();
        List<DTOOrden> aux = super.consultarOrdenesTrabajoPendientes(fecha);
        return aux;
    }

    @Override
    public List<DTOOrden> consultarOrdenesMantenimientoPendientes(Date fecha){
        iniciarTx();
        List<DTOOrden>  aux = super.consultarOrdenesMantenimientoPendientes(fecha);
        return aux;
    }

    @Override
    public List<DTOOrden> consultarOrdenesReparacionPendientes(Date fecha) {
        iniciarTx();
        List<DTOOrden> aux = super.consultarOrdenesReparacionPendientes(fecha);
        return aux;
    }

    @Override
    public void guardarOrdenTrabajo() {
        iniciarTx();
        super.guardarOrdenTrabajo();
        confirmarTx();
    }

    private void iniciarTx() {

        FachadaInterna.getInstancia().iniciarTransaccion();
    }

    private void confirmarTx() {

        FachadaInterna.getInstancia().confirmarTransaccion();
    }
}
