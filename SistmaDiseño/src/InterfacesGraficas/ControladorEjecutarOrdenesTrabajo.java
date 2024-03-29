/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas;

import DTO.DTOOrden;
import DTO.DTOReserva;
import Excepciones.ExcepcionCampoInvalido;
import Excepciones.ExcepcionErrorConexion;
import Excepciones.ExcepcionSistemaStock;
import Excepciones.ExcepcionObjetoNoEncontrado;
import Expertos.ExpertoEjecutarOrdenesTrabajo;
import Fabricas.FabricaExpertos;
import InterfacesGraficas.ModelosTablas.ModeloTablaOrdenesTrabajo;
import InterfacesGraficas.ModelosTablas.ModeloTablaReserva;
import InterfacesGraficas.ModelosTablas.ModeloTablaReservaEquipamiento;
import InterfacesGraficas.ModelosTablas.ModeloTablaResevaRepuesto;
import Persistencia.Entidades.Operador;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author informatica
 */
public class ControladorEjecutarOrdenesTrabajo implements Controlador {

    ExpertoEjecutarOrdenesTrabajo experto;
    private PantallaEjecutarOrdenDeTrabajo pantalla;
    private ChuckNorrisControlador chuck;

    public ControladorEjecutarOrdenesTrabajo() {

        experto = (ExpertoEjecutarOrdenesTrabajo) FabricaExpertos.getInstance().getExperto("EjecutarOrdenesTrabajo");
        pantalla = new PantallaEjecutarOrdenDeTrabajo(this);

    }

    public ControladorEjecutarOrdenesTrabajo(ChuckNorrisControlador chuckCont) {
        chuck = chuckCont;
        experto = (ExpertoEjecutarOrdenesTrabajo) FabricaExpertos.getInstance().getExperto("EjecutarOrdenesTrabajo");
        pantalla = new PantallaEjecutarOrdenDeTrabajo(this);
    }

    public void iniciar() {
        getPantalla().setLocationRelativeTo(null);
        getPantalla().setVisible(true);
    }

    public void buscarOrdenesPendientes(Date fecha, int seleccion) {

        List<DTOOrden> listaDTOOrdens;
        try {
            listaDTOOrdens = experto.consultarOrdenesPendientes(fecha, seleccion);
            ModeloTablaOrdenesTrabajo nuevoModelo = new ModeloTablaOrdenesTrabajo();
            nuevoModelo.addAllRow(listaDTOOrdens);
            ((ModeloTablaOrdenesTrabajo) getPantalla().getTblOrdenesTrabajo().getModel()).setListaOrdenes(listaDTOOrdens);
            pantalla.mostrarBotonConfirmar();
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
        ((ModeloTablaReservaEquipamiento) getPantalla().getTblEquipamientoReservado().getModel()).setListaEquipamiento(reservaSeleccionada.getListaEquipamiento());
        ((ModeloTablaResevaRepuesto) getPantalla().getTblRepuestosReservado().getModel()).setListaRepuestos(reservaSeleccionada.getListaRepuesto());
    }

    public void confirmarOrdenesPendientes(Date fecha, int seleccion) {
        boolean ordenesEjecutadas = true;
        try {
            experto.guardarOrdenTrabajo(fecha, seleccion);
        } catch (ExcepcionErrorConexion ex) {
            JOptionPane.showMessageDialog(getPantalla(), ex.getMessage(), "ATENCION", JOptionPane.WARNING_MESSAGE);
            System.out.println(ex.getMessage());
        } catch(ExcepcionSistemaStock ex){
            JOptionPane.showMessageDialog(getPantalla(), ex.getMessage(), "ATENCION", JOptionPane.WARNING_MESSAGE);
            System.out.println(ex.getMessage());
        } finally {
            if (ordenesEjecutadas) {
                for (DTOOrden dTOOrden : ((ModeloTablaOrdenesTrabajo) getPantalla().getTblOrdenesTrabajo().getModel()).getOrdenesTrabajo()) {
                    dTOOrden.setEstado("En Ejecución");
                }
                ((ModeloTablaOrdenesTrabajo) getPantalla().getTblOrdenesTrabajo().getModel()).fireTableDataChanged();
                JOptionPane.showMessageDialog(pantalla, "Ordenes de Trabajo en Ejecución", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                pantalla.mostrarBotonImprimir();
                pantalla.setEstadoBtnConfirmar(PantallaEjecutarOrdenDeTrabajo.INACTIVO);
            }
        }

    }

    public void imprimirOrdenesPendientes() {
        experto.imprimirOrdenesPendientes();
    }

    public void cerrar() {
        getPantalla().setVisible(false);
        getPantalla().dispose();
        chuck.iniciar();
    }

    /**
     * @return the pantalla
     */
    public PantallaEjecutarOrdenDeTrabajo getPantalla() {
        return pantalla;
    }

    /**
     * @param chuck the chuck to set
     */
    public void setChuck(ChuckNorrisControlador chuck) {
        this.chuck = chuck;
    }

    /**
     * @return the operadorEncontrado
     */
    public Operador getOperadorEncontrado() {
        return chuck.getOperadorEncontrado();
    }
}
