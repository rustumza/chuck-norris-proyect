/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas;

import DTO.DTOOrden;
import Expertos.ExpertoConsultarOrdenesPendientes;
import Fabricas.FabricaExpertos;
import InterfacesGraficas.ModelosTablas.ModeloTablaOrdenesTrabajo;
import Persistencia.Entidades.OrdenTrabajo;
import Utilidades.FormateadorFechas;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author informatica
 */
public class ControladorConsultarOrdenesPendientes {
    ExpertoConsultarOrdenesPendientes experto;
    PantallaConsultarOrdenesPendientes pantalla;

    public ControladorConsultarOrdenesPendientes(){
        pantalla = new PantallaConsultarOrdenesPendientes(this);
        experto = (ExpertoConsultarOrdenesPendientes) FabricaExpertos.getInstance().getExperto("ConsultarOrdenesPendientes");
    }

public List<OrdenTrabajo> buscarOrdenes(String fechaString){

    experto = (ExpertoConsultarOrdenesPendientes)FabricaExpertos.getInstance().getExperto("ExpertoConsultarOrdenesPendientes");
    Date fechaDate = null;
        try {
            fechaDate = FormateadorFechas.getInstancia().StringAFecha(fechaString);
        } catch (ParseException ex) {
            Logger.getLogger(ControladorConsultarOrdenesPendientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    
return experto.buscarOrdenes(fechaDate);
}

    void iniciar() {
        //pantalla.setVisible(true);
    }

    void buscarOrdenes(Date fecha, int seleccion) {
        List<DTOOrden> listaDTOOrdens = experto.buscarOrdenesDTO(fecha, seleccion);
        ModeloTablaOrdenesTrabajo nuevoModelo = new ModeloTablaOrdenesTrabajo();
        nuevoModelo.setListaOrdenes(listaDTOOrdens);
        pantalla.getTblOrdenesTrabajo().setModel(nuevoModelo);
    }




}
