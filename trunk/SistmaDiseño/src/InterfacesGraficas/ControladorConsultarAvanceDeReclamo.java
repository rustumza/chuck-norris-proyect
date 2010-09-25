/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas;

import Expertos.ExpertoConsultarAvanceDeReclamo;
import Fabricas.FabricaExpertos;
import InterfacesGraficas.ModelosTablas.ModeloTablaConsultarAvanceReclamo;

/**
 *
 * @author LEIVA
 */
public class ControladorConsultarAvanceDeReclamo {

   ExpertoConsultarAvanceDeReclamo experto;
   PantallaConsultarAvanceDeReclamo pantalla;
   ModeloTablaConsultarAvanceReclamo modelo;

public ControladorConsultarAvanceDeReclamo(){
    experto = (ExpertoConsultarAvanceDeReclamo) FabricaExpertos.getInstance().getExperto("ConsultarAvanceDeReclamo");
    pantalla = new PantallaConsultarAvanceDeReclamo(this);
    modelo = new ModeloTablaConsultarAvanceReclamo();
    pantalla.getTablaConsultarAvanceReclamo().setModel(modelo);
}

public void iniciar(){
    pantalla.setLocationRelativeTo(null);
    pantalla.setVisible(true);
}


    public void ConsultarEstadoCaso(String numcaso, int seleccion) {

     experto = (ExpertoConsultarAvanceDeReclamo) FabricaExpertos.getInstance().getExperto("ConsultarAvanceDeReclamo");
        
        
        modelo.addAllRow(experto.ConsultarEstadoCaso(numcaso,seleccion));
        pantalla.getTablaConsultarAvanceReclamo().setModel(modelo);
    }


 public static void main(String[] args){
    (new ControladorConsultarAvanceDeReclamo()).iniciar();
}

    void salir() {
        pantalla.dispose();
    }


}
