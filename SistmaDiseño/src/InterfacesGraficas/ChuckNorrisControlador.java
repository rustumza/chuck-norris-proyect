
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas;

import Fabricas.FabricaControladores;
import Persistencia.Entidades.Operador;


/**
 *
 * @author rustu
 */
public class ChuckNorrisControlador implements Controlador{

    
    private PantallaPrincipal pantPrinc;
    private ControladorAtenderReclamoPorDesperfecto contAtendRecl;
    private ControladorConsultarAvanceDeReclamo contConsAvancRec;
    private ControladorConsultarOrdenesPendientes contConsOrdPend;
    private ControladorEjecutarOrdenesTrabajo contEjecOrdTrab;
    private Operador operadorEncontrado;

   /** public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new SyntheticaSimple2DLookAndFeel());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        ChuckNorrisControlador chuck = new ChuckNorrisControlador();

        chuck.setPantPrinc(new PantallaPrincipal(chuck));
        chuck.iniciar();


    }
*/

    public ChuckNorrisControlador() {
    
        pantPrinc = new PantallaPrincipal(this);

    }

    

    public void iniciar() {


        getPantPrinc().setLocationRelativeTo(null);
        getPantPrinc().setVisible(true);
    }

    public void iniciarCUAtenderReclamoPorDesperfecto() {
        getPantPrinc().setVisible(false);
        contAtendRecl = (ControladorAtenderReclamoPorDesperfecto) FabricaControladores.getInstance().getControlador("AtenderReclamoPorDesperfecto");
        contAtendRecl.setChuck(this);
        contAtendRecl.iniciar();


    }

    public void iniciarCUConsultarAvanceDeReclamo() {
        getPantPrinc().setVisible(false);
        contConsAvancRec = (ControladorConsultarAvanceDeReclamo)FabricaControladores.getInstance().getControlador("ConsultarAvanceDeReclamo");
        contConsAvancRec.setChuck(this);
        contConsAvancRec.iniciar();

    }

    public void iniciarCUConsultarOrdenesPendientes() {
        getPantPrinc().setVisible(false);
        contConsOrdPend = (ControladorConsultarOrdenesPendientes)FabricaControladores.getInstance().getControlador("ConsultarOrdenesPendientes");
        contConsOrdPend.setChuck(this);
        contConsOrdPend.iniciar();


    }

    public void iniciarCUEjecutarOrdenesPendientes() {

        getPantPrinc().setVisible(false);
        contEjecOrdTrab = (ControladorEjecutarOrdenesTrabajo)FabricaControladores.getInstance().getControlador("EjecutarOrdenesTrabajo");
        contEjecOrdTrab.setChuck(this);
        contEjecOrdTrab.iniciar();

    }

    //public void iniciarSistemaPermiso(){
    //    contSubSisPerm = new ControladorSubSistemaPermisos(this);
    //   contSubSisPerm.iniciar();
    //}

    /**
     * @return the pantPrinc
     */
    public PantallaPrincipal getPantPrinc() {
        return pantPrinc;
    }

    

    /**
     * @param pantPrinc the pantPrinc to set
     */
    public void setPantPrinc(PantallaPrincipal pantPrinc) {
        this.pantPrinc = pantPrinc;
    }

    public void cerrar(){
        getPantPrinc().setVisible(false);
        getPantPrinc().dispose();
        ((ControladorSubSistemaPermisos)FabricaControladores.getInstance().getControlador("SubSistemaDePermisos")).iniciar();

    }

    /**
     * @param contSubSisPerm the contSubSisPerm to set
     */

    /**
     * @return the usuarioEncontrado
     */
    public Operador getOperadorEncontrado() {
        return operadorEncontrado;
    }

    /**
     * @param usuarioEncontrado the usuarioEncontrado to set
     */
    public void setOperadorEncontrado(Operador operadorEncontrado) {
        this.operadorEncontrado = operadorEncontrado;
    }
    
}
