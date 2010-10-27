/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfacesGraficas.ModelosTablas;

import Persistencia.Entidades.Problema;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.event.EventListenerList;

/**
 *
 * @author rustu
 */
public class ModeloJListListaProblemas extends AbstractListModel{

    private List<Problema> listaDeProblemas;

    public ModeloJListListaProblemas() {
        inicializarValores();
    }

    public ModeloJListListaProblemas(List<Problema> problemas) {
        inicializarValores();
        listaDeProblemas.addAll(problemas);

    }

    private void inicializarValores(){
        listaDeProblemas = new ArrayList<Problema>();
    }

    public int getSize() {
        return listaDeProblemas.size();

    }

    public Problema getElementAt(int index) {
        return listaDeProblemas.get(index);

    }

    public List<Problema> getProblemas(){

        return listaDeProblemas;
    }

    public void removeProblem(int indice){

        listaDeProblemas.remove(indice);

    }

    public void addElement(Problema prob){

        listaDeProblemas.add(prob);

    }





}
