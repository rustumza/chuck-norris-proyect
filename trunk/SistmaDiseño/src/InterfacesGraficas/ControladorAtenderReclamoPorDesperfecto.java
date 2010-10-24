/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas;

import DTO.DTOinfoParaCrearDenuncia;
import Excepciones.ExcepcionDenunciaExistente;
import Persistencia.Entidades.Denunciante;
import Expertos.ExpertoAntenderReclamoPorDesperfecto;
import Fabricas.FabricaExpertos;
import InterfacesGraficas.ModelosTablas.ModeloTablaSemaforos;
import Persistencia.Entidades.Calle;
import Persistencia.Entidades.Problema;
import java.util.List;
import javax.swing.SpinnerListModel;
/**
 *
 * @author LEIVA
 */
public class ControladorAtenderReclamoPorDesperfecto implements Controlador{

    ExpertoAntenderReclamoPorDesperfecto earpd;
    private PantallaAtenderReclamoPorDesperfecto pantallaARPD;
    private ChuckNorrisControlador chuck;

    public ControladorAtenderReclamoPorDesperfecto(){
        earpd = (ExpertoAntenderReclamoPorDesperfecto)FabricaExpertos.getInstance().getExperto("AtenderReclamoPorDesperfecto");
        pantallaARPD = new PantallaAtenderReclamoPorDesperfecto(this);

    }
    public ControladorAtenderReclamoPorDesperfecto(ChuckNorrisControlador chuckCont){
         chuck=chuckCont;
         earpd = (ExpertoAntenderReclamoPorDesperfecto)FabricaExpertos.getInstance().getExperto("AtenderReclamoPorDesperfecto");
         pantallaARPD = new PantallaAtenderReclamoPorDesperfecto(this);
    }

    public void iniciar(){
        getPantallaARPD().setLocationRelativeTo(null);
        getPantallaARPD().setVisible(true);
    }

    public Denunciante buscarDenunciante(String dni){
        
        return earpd.buscarDenunciante(dni);
    }

    public void guardarDenunciante(Denunciante denunciante){

        earpd.guardarDenunciante(denunciante);

    }

    public void cerrar(){
        getPantallaARPD().setVisible(false);
        getPantallaARPD().dispose();
        chuck.iniciar();

    }


    public Calle[] buscarCalle(String calle){

        List<Calle> listaDeCalle = earpd.buscarCalle(calle);
        return listaDeCalle.toArray(new Calle[listaDeCalle.size()]);

    }


    public void buscarSemaforo(Calle calle1, Calle calle2){

        ModeloTablaSemaforos modTabSem = new ModeloTablaSemaforos();
        modTabSem.addAllRow(earpd.buscarSemaforo(calle1, calle2));
        getPantallaARPD().getTablaDeSemafor().setModel(modTabSem);
        getPantallaARPD().getTodosLosProblemas().setModel(new SpinnerListModel(buscarProblema()));
    }

    public Problema[] buscarProblema(){
        List<Problema> listaDeProblemas = earpd.buscarProblemas();
        return listaDeProblemas.toArray(new Problema[listaDeProblemas.size()]);
    }

    public void guardarDenuncia(DTOinfoParaCrearDenuncia infoParaCrearDenuncia){
        try{
        earpd.guardarDenuncia(infoParaCrearDenuncia);
        }catch(ExcepcionDenunciaExistente e){
            //abrir ventana en la interfaz!

        }

    }

    /**
     * @return the pantallaARPD
     */
    public PantallaAtenderReclamoPorDesperfecto getPantallaARPD() {
        return pantallaARPD;
    }

    /**
     * @param chuck the chuck to set
     */
    public void setChuck(ChuckNorrisControlador chuck) {
        this.chuck = chuck;
    }

    /*
    public static void main(String[] Args){

        ControladorAtenderReclamoPorDesperfecto cont = new ControladorAtenderReclamoPorDesperfecto();
        cont.pantallaARPD = new PantallaAtenderReclamoPorDesperfecto(cont);
        cont.iniciar();




    }
*/
}
