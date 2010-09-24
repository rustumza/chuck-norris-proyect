/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

import Persistencia.Entidades.Problema;
import Persistencia.Entidades.Semaforo;
import java.util.List;

/**
 *
 * @author rustu
 */
public class DTOProblemasDelSemaforo {
    //Este DTO se usa para llevar de la interfaz al experto cada semaforo con sus problemas

    private Semaforo semaforo;
    private List<Problema> listaDeProblemas;

    /**
     * @return the semaforo
     */
    public Semaforo getSemaforo() {
        return semaforo;
    }

    /**
     * @param semaforo the semaforo to set
     */
    public void setSemaforo(Semaforo semaforo) {
        this.semaforo = semaforo;
    }

    /**
     * @return the listaDeProblemas
     */
    public List<Problema> getListaDeProblemas() {
        return listaDeProblemas;
    }

    /**
     * @param listaDeProblemas the listaDeProblemas to set
     */
    public void setListaDeProblemas(List<Problema> listaDeProblemas) {
        this.listaDeProblemas = listaDeProblemas;
    }


}
