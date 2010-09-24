/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas;

import DTO.DTOEstadoDenuncia;
import Expertos.ExpertoConsultarAvanceDeReclamo;
import Fabricas.FabricaExpertos;
import InterfacesGraficas.ModelosTablas.ModeloTablaConsultarAvanceReclamo;
import java.util.List;

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
    pantalla.setVisible(true);
}


    public void ConsultarEstadoCaso(String numcaso) {

     experto = (ExpertoConsultarAvanceDeReclamo) FabricaExpertos.getInstance().getExperto("ConsultarAvanceDeReclamo");
        
        
        modelo.addAllRow(experto.ConsultarEstadoCaso(numcaso));
        pantalla.getTablaConsultarAvanceReclamo().setModel(modelo);
    }


/*
 public static void main(String[] args){
    (new ControladorConsultarAvanceDeReclamo()).iniciar();
}
*/


}
