
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas;


/**
 *
 * @author rustu
 */
public class ChuckNorrisControlador implements Controlador{

    private PantallaSubSistemaPermiso pantPermisos;
    private PantallaPrincipal pantPrinc;
    ControladorAtenderReclamoPorDesperfecto contAtendRecl;
    ControladorConsultarAvanceDeReclamo contConsAvancRec;
    ControladorConsultarOrdenesPendientes contConsOrdPend;
    ControladorEjecutarOrdenesTrabajo contEjecOrdTrab;
    ControladorSubSistemaPermisos contSubSisPerm;

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


    public ChuckNorrisControlador (ControladorSubSistemaPermisos contPerm){
         contSubSisPerm = contPerm;
         pantPrinc = new PantallaPrincipal(this);
    }

    public void iniciar() {


        pantPrinc.setLocationRelativeTo(null);
        pantPrinc.setVisible(true);
    }

    public void iniciarCUAtenderReclamoPorDesperfecto() {
        getPantPrinc().setVisible(false);
        contAtendRecl = new ControladorAtenderReclamoPorDesperfecto(this);
        contAtendRecl.setChuck(this);
        contAtendRecl.iniciar();


    }

    public void iniciarCUConsultarAvanceDeReclamo() {
        getPantPrinc().setVisible(false);
        contConsAvancRec = new ControladorConsultarAvanceDeReclamo(this);
        contConsAvancRec.setChuck(this);
        contConsAvancRec.iniciar();

    }

    public void iniciarCUConsultarOrdenesPendientes() {
        getPantPrinc().setVisible(false);
        contConsOrdPend = new ControladorConsultarOrdenesPendientes(this);
        contConsOrdPend.setChuck(this);
        contConsOrdPend.iniciar();


    }

    public void iniciarCUEjecutarOrdenesPendientes() {

        getPantPrinc().setVisible(false);
        contEjecOrdTrab = new ControladorEjecutarOrdenesTrabajo(this);
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
        pantPrinc.setVisible(false);
        pantPrinc.dispose();
        contSubSisPerm.iniciar();

    }
    
}
