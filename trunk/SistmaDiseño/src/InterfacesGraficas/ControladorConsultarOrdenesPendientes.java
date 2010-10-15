/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas;

import DTO.DTOOrden;
import DTO.DTOReserva;
import Excepciones.ExcepcionCampoInvalido;
import Expertos.ExpertoConsultarOrdenesPendientes;
import Fabricas.FabricaExpertos;
import InterfacesGraficas.ModelosTablas.ModeloTablaOrdenesTrabajo;
import InterfacesGraficas.ModelosTablas.ModeloTablaReserva;
import InterfacesGraficas.ModelosTablas.ModeloTablaReservaEquipamiento;
import InterfacesGraficas.ModelosTablas.ModeloTablaResevaRepuesto;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author informatica
 */
public class ControladorConsultarOrdenesPendientes implements Controlador{
    ExpertoConsultarOrdenesPendientes experto;
    PantallaConsultarOrdenesPendientes pantalla;
    ChuckNorrisControlador chuck;

    public ControladorConsultarOrdenesPendientes(){
        
    }

    public ControladorConsultarOrdenesPendientes(ChuckNorrisControlador chuckCont){
        chuck=chuckCont;
        pantalla = new PantallaConsultarOrdenesPendientes(this);
        experto = (ExpertoConsultarOrdenesPendientes) FabricaExpertos.getInstance().getExperto("ConsultarOrdenesPendientes");
    }

    void iniciar() {
        pantalla.setLocationRelativeTo(null);
        pantalla.setVisible(true);
    }

    void buscarOrdenes(Date fecha, int seleccion){

        List<DTOOrden> listaDTOOrdens;
        try {
            listaDTOOrdens = experto.buscarOrdenesDTO(fecha, seleccion);
            ModeloTablaOrdenesTrabajo nuevoModelo = new ModeloTablaOrdenesTrabajo();
        nuevoModelo.addAllRow(listaDTOOrdens);
        ((ModeloTablaOrdenesTrabajo)pantalla.getTblOrdenesTrabajo().getModel()).setListaOrdenes(listaDTOOrdens);
        } catch (ExcepcionCampoInvalido ex) {
            JOptionPane.showMessageDialog(pantalla, ex.getMessage(),"ATENCION",JOptionPane.WARNING_MESSAGE);
            System.out.println(ex.getMessage());
            //Logger.getLogger(ControladorConsultarOrdenesPendientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    void mostrarReservas(List<DTOReserva> reservas) {
        ((ModeloTablaReserva)pantalla.getTblReservas().getModel()).setListaReserva(reservas);
    }

    void mostrarDetalleReserva(DTOReserva reservaSeleccionada) {
        ((ModeloTablaReservaEquipamiento)pantalla.getTblEquipamientoReservado().getModel()).setListaEquipamiento(reservaSeleccionada.getListaEquipamiento());
        ((ModeloTablaResevaRepuesto)pantalla.getTblRepuestosReservado().getModel()).setListaRepuestos(reservaSeleccionada.getListaRepuesto());
    }

    public void cerrar(){
        pantalla.setVisible(false);
        pantalla.dispose();
        chuck.iniciar();

    }




}
