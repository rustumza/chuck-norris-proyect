/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas;

import DTO.DTOOrdenes;
import Expertos.ExpertoConsultarOrdenesPendientes;
import Fabricas.FabricaExpertos;
import Persistencia.Entidades.OrdenTrabajo;
import java.util.Date;
import java.util.List;

/**
 *
 * @author informatica
 */
public class ControladorConsultarOrdenesPendientes {
    ExpertoConsultarOrdenesPendientes ecop;
    //PantallaEjecutarOrdenTrabajo pantalla;

    public ControladorConsultarOrdenesPendientes(){
        //pantalla = new PantallaEjecutarOrdenTrabajo(this);
        ecop = (ExpertoConsultarOrdenesPendientes) FabricaExpertos.getInstance().getExperto("ConsultarOrdenesPendientes");
    }

public List<OrdenTrabajo> buscarOrdenes(String fechaString){

    ecop = (ExpertoConsultarOrdenesPendientes)FabricaExpertos.getInstance().getExperto("ExpertoConsultarOrdenesPendientes");
    Date fechaDate = new Date(fechaString);


    
return ecop.buscarOrdenes(fechaDate);
}

    void iniciar() {
        //pantalla.setVisible(true);
    }




}
