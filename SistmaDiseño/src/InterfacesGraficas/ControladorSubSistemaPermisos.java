
        /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas;


import Excepciones.ExcepcionObjetoNoEncontrado;
import Expertos.ExpertoSubSistemaPermisos;
import Fabricas.FabricaExpertos;
import Fabricas.FabricaControladores;
import Persistencia.Entidades.Operador;
import de.javasoft.plaf.synthetica.SyntheticaSimple2DLookAndFeel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author informatica
 */
public class ControladorSubSistemaPermisos implements Controlador{

    private ExpertoSubSistemaPermisos essp;
    private PantallaSubSistemaPermiso pantallaPSSP;
    private ChuckNorrisControlador chuk;
    private Operador operadorEncontrado;


     public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new SyntheticaSimple2DLookAndFeel());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        ControladorSubSistemaPermisos contPerm = new ControladorSubSistemaPermisos();        
        contPerm.setPantPermisos(new PantallaSubSistemaPermiso(contPerm));
        contPerm.iniciar();



    }

    public ControladorSubSistemaPermisos(){
        essp = (ExpertoSubSistemaPermisos) FabricaExpertos.getInstance().getExperto("ExpertoSubSistemaPermisos");


    }

    
    public void iniciar(){
        pantallaPSSP.setLocationRelativeTo(null);
        pantallaPSSP.setVisible(true);
        pantallaPSSP.getPass().setText("");
        pantallaPSSP.getNombreDelUsuario().setText("");
        operadorEncontrado = null;
    }


    public PantallaSubSistemaPermiso getPantPermisos(){
        return pantallaPSSP;
    }

    public void setPantPermisos(PantallaSubSistemaPermiso pantPerm){
        this.pantallaPSSP = pantPerm;
    }

    //realiza la busqueda del usuario y contraseña
    //para habilitarle los casos de uso que le corresponden
    public void buscarUsuario(String nombreUsuario, String clave){
        try{

            operadorEncontrado = essp.buscarOperador(nombreUsuario, clave);


            getPantPermisos().setVisible(false);
            chuk = (ChuckNorrisControlador) FabricaControladores.getInstance().getControlador("ChuckNorris");
            chuk.setContSubSisPerm(this);
            chuk.setOperadorEncontrado(operadorEncontrado);
            chuk.iniciar();
        }catch(ExcepcionObjetoNoEncontrado e){
            JOptionPane.showMessageDialog(pantallaPSSP, e.getMessage(),"ATENCIÓN",JOptionPane.INFORMATION_MESSAGE);
        }

    }



}
