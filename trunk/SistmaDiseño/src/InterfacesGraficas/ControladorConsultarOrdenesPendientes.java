/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas;

import DTO.DTOOrden;
import DTO.DTOReserva;
import Excepciones.ExcepcionCampoInvalido;
import Excepciones.ExcepcionObjetoNoEncontrado;
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
public class ControladorConsultarOrdenesPendientes implements Controlador {

    ExpertoConsultarOrdenesPendientes experto;
    private PantallaConsultarOrdenesPendientes pantalla;
    private ChuckNorrisControlador chuck;

    public ControladorConsultarOrdenesPendientes() {

        pantalla = new PantallaConsultarOrdenesPendientes(this);
        experto = (ExpertoConsultarOrdenesPendientes) FabricaExpertos.getInstance().getExperto("ConsultarOrdenesPendientes");

    }

    public ControladorConsultarOrdenesPendientes(ChuckNorrisControlador chuckCont) {
        chuck = chuckCont;
        pantalla = new PantallaConsultarOrdenesPendientes(this);
        experto = (ExpertoConsultarOrdenesPendientes) FabricaExpertos.getInstance().getExperto("ConsultarOrdenesPendientes");
    }

    public void iniciar() {
        getPantalla().setLocationRelativeTo(null);
        getPantalla().setVisible(true);
    }

    public void buscarOrdenes(Date fecha, int seleccion) {

        List<DTOOrden> listaDTOOrdens;
        try {

            listaDTOOrdens = experto.buscarOrdenesDTO(fecha, seleccion);
            ModeloTablaOrdenesTrabajo nuevoModelo = new ModeloTablaOrdenesTrabajo();
            nuevoModelo.addAllRow(listaDTOOrdens);
            ((ModeloTablaOrdenesTrabajo) getPantalla().getTblOrdenesTrabajo().getModel()).setListaOrdenes(listaDTOOrdens);

        } catch (ExcepcionCampoInvalido ex) {
            JOptionPane.showMessageDialog(getPantalla(), ex.getMessage(), "ATENCION", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(ex.getMessage());
        } catch (ExcepcionObjetoNoEncontrado ex) {
            JOptionPane.showMessageDialog(getPantalla(), ex.getMessage(), "ATENCION", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(ex.getMessage());
        }

    }

    public void mostrarReservas(List<DTOReserva> reservas) {
        ((ModeloTablaReserva) getPantalla().getTblReservas().getModel()).setListaReserva(reservas);
    }

    public void mostrarDetalleReserva(DTOReserva reservaSeleccionada) {
        ((ModeloTablaReservaEquipamiento) getPantalla().getTblEquipamientoReservado().getModel()).clear();
        ((ModeloTablaResevaRepuesto) getPantalla().getTblRepuestosReservado().getModel()).clear();
        ((ModeloTablaReservaEquipamiento) getPantalla().getTblEquipamientoReservado().getModel()).addAllRow(reservaSeleccionada.getListaEquipamiento());
        ((ModeloTablaResevaRepuesto) getPantalla().getTblRepuestosReservado().getModel()).addAllRow(reservaSeleccionada.getListaRepuesto());
    }

    public void cerrar() {
        getPantalla().setVisible(false);
        getPantalla().dispose();
        chuck.iniciar();

    }

    /**
     * @return the pantalla
     */
    public PantallaConsultarOrdenesPendientes getPantalla() {
        return pantalla;
    }

    /**
     * @param chuck the chuck to set
     */
    public void setChuck(ChuckNorrisControlador chuck) {
        this.chuck = chuck;
    }
}
