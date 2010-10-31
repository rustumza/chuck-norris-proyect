
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas;

import Persistencia.Entidades.Usuario;


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
    private ControladorSubSistemaPermisos contSubSisPerm;
    private Usuario usuarioEncontrado;

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


        getPantPrinc().setLocationRelativeTo(null);
        getPantPrinc().setVisible(true);
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
        getPantPrinc().setVisible(false);
        getPantPrinc().dispose();
        contSubSisPerm.iniciar();

    }

    /**
     * @param contSubSisPerm the contSubSisPerm to set
     */
    public void setContSubSisPerm(ControladorSubSistemaPermisos contSubSisPerm) {
        this.contSubSisPerm = contSubSisPerm;
    }

    /**
     * @return the usuarioEncontrado
     */
    public Usuario getUsuarioEncontrado() {
        return usuarioEncontrado;
    }

    /**
     * @param usuarioEncontrado the usuarioEncontrado to set
     */
    public void setUsuarioEncontrado(Usuario usuarioEncontrado) {
        this.usuarioEncontrado = usuarioEncontrado;
    }
    
}
