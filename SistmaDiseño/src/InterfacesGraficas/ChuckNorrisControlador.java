
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas;

import de.javasoft.plaf.synthetica.SyntheticaSimple2DLookAndFeel;
import javax.swing.UIManager;

/**
 *
 * @author rustu
 */
public class ChuckNorrisControlador {

    private PantallaPrincipal pantPrinc;
    ControladorAtenderReclamoPorDesperfecto contAtendRecl;
    ControladorConsultarAvanceDeReclamo contConsAvancRec;
    ControladorConsultarOrdenesPendientes contConsOrdPend;
    ControladorEjecutarOrdenesTrabajo contEjecOrdTrab;

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new SyntheticaSimple2DLookAndFeel());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        ChuckNorrisControlador chuck = new ChuckNorrisControlador();
        chuck.setPantPrinc(new PantallaPrincipal(chuck));
        chuck.iniciar();


    }

    public ChuckNorrisControlador() {
    }

    public void iniciar() {


        pantPrinc.setLocationRelativeTo(null);
        pantPrinc.setVisible(true);
    }

    public void iniciarCUAtenderReclamoPorDesperfecto() {
        getPantPrinc().setVisible(false);
        contAtendRecl = new ControladorAtenderReclamoPorDesperfecto();
        contAtendRecl.iniciar();


    }

    public void iniciarCUConsultarAvanceDeReclamo() {
        getPantPrinc().setVisible(false);
        contConsAvancRec = new ControladorConsultarAvanceDeReclamo();
        contConsAvancRec.iniciar();

    }

    public void iniciarCUConsultarOrdenesPendientes() {
        getPantPrinc().setVisible(false);
        contConsOrdPend = new ControladorConsultarOrdenesPendientes();
        contConsOrdPend.iniciar();


    }

    public void iniciarCUEjecutarOrdenesPendientes() {

        getPantPrinc().setVisible(false);
        contEjecOrdTrab = new ControladorEjecutarOrdenesTrabajo();
        contEjecOrdTrab.iniciar();

    }

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
}
