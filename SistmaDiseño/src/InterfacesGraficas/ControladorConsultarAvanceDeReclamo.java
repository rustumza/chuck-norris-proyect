/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas;

import DTO.DTODenuncia;
import Expertos.ExpertoConsultarAvanceDeReclamo;
import Fabricas.FabricaExpertos;
import InterfacesGraficas.ModelosTablas.ModeloTablaConsultarAvanceReclamo;
import InterfacesGraficas.ModelosTablas.ModeloTablaFallas;
import InterfacesGraficas.ModelosTablas.ModeloTablaOrdenesTrabajo;

/**
 *
 * @author LEIVA
 */
public class ControladorConsultarAvanceDeReclamo {

   ExpertoConsultarAvanceDeReclamo experto;
   PantallaConsultarAvanceDeReclamo pantalla;
   ModeloTablaConsultarAvanceReclamo modeloEstados;
   ModeloTablaOrdenesTrabajo modeloOrdenes;
   ModeloTablaFallas modeloFallas;

public ControladorConsultarAvanceDeReclamo(){
    experto = (ExpertoConsultarAvanceDeReclamo) FabricaExpertos.getInstance().getExperto("ConsultarAvanceDeReclamo");
    pantalla = new PantallaConsultarAvanceDeReclamo(this);
    modeloEstados = new ModeloTablaConsultarAvanceReclamo();
    modeloOrdenes = new ModeloTablaOrdenesTrabajo();
    modeloFallas = new ModeloTablaFallas();
    pantalla.getTablaConsultarAvanceReclamo().setModel(modeloEstados);
    pantalla.getTblOrdenReparacion().setModel(modeloOrdenes);
    pantalla.getTblFallas().setModel(modeloFallas);
}

public void iniciar(){
    pantalla.setTitle("Consultar Avance de Reclamo");
    pantalla.setLocationRelativeTo(null);
    pantalla.setVisible(true);
}


    public void ConsultarEstadoCaso(String numcaso, int seleccion) {

     experto = (ExpertoConsultarAvanceDeReclamo) FabricaExpertos.getInstance().getExperto("ConsultarAvanceDeReclamo");
        
        modeloEstados.clear();
        DTODenuncia dtoDenuncia = experto.ConsultarEstadoCaso(numcaso,seleccion);
        modeloEstados.addAllRow(dtoDenuncia.getListaEstados());
        modeloOrdenes.addRow(dtoDenuncia.getOrdenRep());
        pantalla.getTablaConsultarAvanceReclamo().setModel(modeloEstados);
        pantalla.getLblEstadoOrden().setText(dtoDenuncia.getOrdenRep().getEstado());
        pantalla.getLblEstadoOrden().setVisible(true);
        modeloFallas.addAllRow(dtoDenuncia.getListaFallas());
        
    }


   


}
