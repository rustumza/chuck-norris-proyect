/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

import Persistencia.Entidades.Semaforo;
import java.util.List;

/**
 *
 * @author rustu
 */
public class DTOTodosLosSemaforosNumeroDeDenuncia {

    private List<Semaforo> listaDeSemaforo;
    private int numeroDeDenuncia;

    /**
     * @return the listaDeSemaforo
     */
    public List<Semaforo> getListaDeSemaforo() {
        return listaDeSemaforo;
    }

    /**
     * @param listaDeSemaforo the listaDeSemaforo to set
     */
    public void setListaDeSemaforo(List<Semaforo> listaDeSemaforo) {
        this.listaDeSemaforo = listaDeSemaforo;
    }

    /**
     * @return the numeroDeDenuncia
     */
    public int getNumeroDeDenuncia() {
        return numeroDeDenuncia;
    }

    /**
     * @param numeroDeDenuncia the numeroDeDenuncia to set
     */
    public void setNumeroDeDenuncia(int numeroDeDenuncia) {
        this.numeroDeDenuncia = numeroDeDenuncia;
    }

}
