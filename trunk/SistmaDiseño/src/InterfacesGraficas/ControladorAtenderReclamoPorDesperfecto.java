/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas;

import DTO.DTOinfoDeDenunciaGuardada;
import DTO.DTOinfoParaCrearDenuncia;
import Excepciones.ExcepcionCampoInvalido;
import Excepciones.ExcepcionDenunciaExistente;
import Excepciones.ExcepcionObjetoNoEncontrado;
import Persistencia.Entidades.Denunciante;
import Expertos.ExpertoAntenderReclamoPorDesperfecto;
import Fabricas.FabricaExpertos;
import InterfacesGraficas.ModelosTablas.ModeloJListListaProblemas;
import InterfacesGraficas.ModelosTablas.ModeloTablaSemaforos;
import Persistencia.Entidades.Calle;
import Persistencia.Entidades.Operador;
import Persistencia.Entidades.Problema;
import Persistencia.Entidades.bs;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javazoom.jlgui.basicplayer.*;
import java.io.File;
import javax.sound.sampled.*;





/* Importamos Las clases del Package Media */


/* Tambien necesitamos importar AudioFormat del package javax.media.format para poder agregar los codecs */


/**
 *
 * @author LEIVA
 */
public class ControladorAtenderReclamoPorDesperfecto implements Controlador,BasicPlayerListener {

    ExpertoAntenderReclamoPorDesperfecto earpd;
    private PantallaAtenderReclamoPorDesperfecto pantallaARPD;
    private ChuckNorrisControlador chuck;
    private File archivoAudio;//archivo de Audio a reproducir

    bs reproductor = new bs();
    

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

    public Denunciante buscarDenunciante(String dni) throws ExcepcionObjetoNoEncontrado{
        
        return earpd.buscarDenunciante(dni);
    }

    public void guardarDenunciante(Denunciante denunciante){
        try {
            earpd.guardarDenunciante(denunciante);
        } catch (ExcepcionCampoInvalido ex) {
            JOptionPane.showMessageDialog(pantallaARPD, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

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


    public void buscarAlturas(Calle calle){

        List<Integer> listaDeAlturas = earpd.buscarAltura(calle);
        if(!listaDeAlturas.isEmpty())
            pantallaARPD.getAltura().setModel(new DefaultComboBoxModel(listaDeAlturas.toArray(new Integer[listaDeAlturas.size()])));
    }

    public void buscarSemaforo(Calle calle1, Calle calle2){
        try {
            ModeloTablaSemaforos modTabSem = new ModeloTablaSemaforos();
            modTabSem.addAllRow(earpd.buscarSemaforo(calle1, calle2));
            getPantallaARPD().getTablaDeSemafor().setModel(modTabSem);
            getPantallaARPD().getTodosLosProblemas().setModel(new ModeloJListListaProblemas(buscarProblemaList()));
        } catch (ExcepcionObjetoNoEncontrado ex) {
            JOptionPane.showMessageDialog(pantallaARPD, ex.getMessage(), "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void buscarSemaforo(Calle calle1, int altura){
        ModeloTablaSemaforos modTabSem = new ModeloTablaSemaforos();
        modTabSem.addAllRow(earpd.buscarSemaforo(calle1, altura));
        getPantallaARPD().getTablaDeSemafor().setModel(modTabSem);
        getPantallaARPD().getTodosLosProblemas().setModel(new ModeloJListListaProblemas(buscarProblemaList()));
    }

    public Problema[] buscarProblema(){
        List<Problema> listaDeProblemas = earpd.buscarProblemas();
        return listaDeProblemas.toArray(new Problema[listaDeProblemas.size()]);
    }

    public List<Problema> buscarProblemaList(){
        return earpd.buscarProblemas();
    }

    public void guardarDenuncia(DTOinfoParaCrearDenuncia infoParaCrearDenuncia) throws Exception{
        try{
            infoParaCrearDenuncia.setOperador(getOperadorEncontrado());
            DTOinfoDeDenunciaGuardada dto = earpd.guardarDenuncia(infoParaCrearDenuncia);
            if(dto.isIsDenuncia())
                pantallaARPD.getDenunciaReclamo().setText("Denuncia");
            else
                pantallaARPD.getDenunciaReclamo().setText("Reclamo");
            pantallaARPD.getcodigoDenunciaReclamo().setText(String.valueOf(dto.getCodigo()));          
            pantallaARPD.reproducir();
            pantallaARPD.getPantallaDenunciaGuardad().setVisible(true);
          
            // reproductor.AbrirFichero("/home/edu/Descargas/welcome.wav");
           // reproductor.Play();

            pantallaARPD.ponerTodoEnBlancoPublico();


            
        }catch(ExcepcionDenunciaExistente e){
            pantallaARPD.getNumeroDeDenuncia().setText(String.valueOf(e.getCantidadDeReclamos()));
            pantallaARPD.getCantidadDeReclamos().setText(String.valueOf(e.getCantidadDeReclamos()));
            pantallaARPD.getPantallaDenunciaExistente().setVisible(true);
            pantallaARPD.ponerTodoEnBlancoPublico();

        }catch(ExcepcionObjetoNoEncontrado e){

            JOptionPane.showMessageDialog(pantallaARPD, e.getMessage(), "ERROR", JOptionPane.INFORMATION_MESSAGE);

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

    

    /**
     * @return the operadorEncontrado
     */
    public Operador getOperadorEncontrado() {
        return chuck.getOperadorEncontrado();
    }

    public void opened(Object o, Map map) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void progress(int i, long l, byte[] bytes, Map map) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void stateUpdated(BasicPlayerEvent bpe) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setController(BasicController bc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    


    /*
    public static void main(String[] Args){

        ControladorAtenderReclamoPorDesperfecto cont = new ControladorAtenderReclamoPorDesperfecto();
        cont.pantallaARPD = new PantallaAtenderReclamoPorDesperfecto(cont);
        cont.iniciar();




     *
     *
     *
     * package mp3player;

/**

*

* @author Esteban Fuentealba

*/



}

