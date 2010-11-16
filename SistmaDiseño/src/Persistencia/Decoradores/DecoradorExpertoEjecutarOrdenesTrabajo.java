/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Decoradores;

import DTO.DTOOrden;
import Excepciones.ExcepcionCampoInvalido;
import Excepciones.ExcepcionErrorConexion;
import Excepciones.ExcepcionObjetoNoEncontrado;
import Expertos.ExpertoEjecutarOrdenesTrabajo;
import Persistencia.ExpertosPersistencia.FachadaInterna;
import java.util.Date;
import java.util.List;

/**
 *
 * @author informatica
 */
public class DecoradorExpertoEjecutarOrdenesTrabajo extends ExpertoEjecutarOrdenesTrabajo {

    @Override
    public List<DTOOrden> consultarOrdenesTrabajoPendientes(Date fecha) throws ExcepcionCampoInvalido, ExcepcionObjetoNoEncontrado {

        iniciarTx();
        List<DTOOrden> aux = super.consultarOrdenesTrabajoPendientes(fecha);
        return aux;
    }

    @Override
    public List<DTOOrden> consultarOrdenesMantenimientoPendientes(Date fecha) throws ExcepcionCampoInvalido, ExcepcionObjetoNoEncontrado{
        iniciarTx();
        List<DTOOrden>  aux = super.consultarOrdenesMantenimientoPendientes(fecha);
        return aux;
    }

    @Override
    public List<DTOOrden> consultarOrdenesReparacionPendientes(Date fecha) throws ExcepcionCampoInvalido, ExcepcionObjetoNoEncontrado {
        iniciarTx();
        List<DTOOrden> aux = super.consultarOrdenesReparacionPendientes(fecha);
        return aux;
    }

    @Override
    public List<DTOOrden> guardarOrdenTrabajo(Date fecha, int seleccion) throws ExcepcionErrorConexion {
        iniciarTx();
        List<DTOOrden> aux = super.guardarOrdenTrabajo(fecha, seleccion);
        confirmarTx();
        return aux;
    }

    private void iniciarTx() {

        FachadaInterna.getInstancia().iniciarTransaccion();
    }

    private void confirmarTx() {

        FachadaInterna.getInstancia().confirmarTransaccion();
    }
}
