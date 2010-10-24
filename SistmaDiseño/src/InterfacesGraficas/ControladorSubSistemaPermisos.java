/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas;


import Excepciones.ExcepcionObjetoNoEncontrado;
import Expertos.ExpertoSubSistemaPermisos;
import Fabricas.FabricaExpertos;
import Persistencia.Entidades.Usuario;
import de.javasoft.plaf.synthetica.SyntheticaSimple2DLookAndFeel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author informatica
 */
public class ControladorSubSistemaPermisos {

    private ExpertoSubSistemaPermisos essp;
    private PantallaSubSistemaPermiso pantallaPSSP;
    private ChuckNorrisControlador chuk;
    private Usuario usuarioEncontrado;


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
    }

    public void iniciarChuckNorris(){
        getPantPermisos().setVisible(false);
        chuk = new ChuckNorrisControlador(this);
        chuk.iniciar();
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

            usuarioEncontrado = essp.buscarUsuario(nombreUsuario, clave);
            iniciarChuckNorris();
        }catch(ExcepcionObjetoNoEncontrado e){
            JOptionPane.showMessageDialog(pantallaPSSP, e.getMessage(),"ATENCIÓN",JOptionPane.INFORMATION_MESSAGE);
        }

    }



}
