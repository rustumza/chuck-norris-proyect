
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas;

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


    public static void main(String[] args){

        ChuckNorrisControlador chuck = new ChuckNorrisControlador();
        chuck.setPantPrinc(new PantallaPrincipal(chuck));
        chuck.iniciar();


    }

    public ChuckNorrisControlador(){
        
        
    }
    public void iniciar(){

        pantPrinc.setVisible(true);
    }


    public void iniciarCUAtenderReclamoPorDesperfecto(){
        getPantPrinc().setVisible(false);
        contAtendRecl=new ControladorAtenderReclamoPorDesperfecto();
        contAtendRecl.iniciar();


    }


    public void iniciarCUConsultarAvanceDeReclamo(){
        getPantPrinc().setVisible(false);
        contConsAvancRec = new ControladorConsultarAvanceDeReclamo();
        contConsAvancRec.iniciar();

    }


    public void iniciarCUConsultarOrdenesPendientes(){
        getPantPrinc().setVisible(false);
        contConsOrdPend = new ControladorConsultarOrdenesPendientes();
        contConsOrdPend.iniciar();


    }


    public void iniciarCUEjecutarOrdenesPendientes(){

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
