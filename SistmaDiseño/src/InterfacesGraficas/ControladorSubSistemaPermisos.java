/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas;


import Expertos.ExpertoSubSistemaPermisos;
import Fabricas.FabricaExpertos;
import Persistencia.Entidades.Usuario;
import de.javasoft.plaf.synthetica.SyntheticaSimple2DLookAndFeel;
import javax.swing.UIManager;

/**
 *
 * @author informatica
 */
public class ControladorSubSistemaPermisos {

    ExpertoSubSistemaPermisos essp;
    PantallaSubSistemaPermiso pantallaPSSP;
    ChuckNorrisControlador chuk;


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
    public Usuario buscarUsuario(String nombreUsuario, String clave){

        return essp.buscarUsuario(nombreUsuario,clave);
    }



}
