/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;


import Persistencia.Entidades.Denuncia;
import Persistencia.Entidades.DenunciaImplementacion;
import Persistencia.Entidades.Denunciante;
import Persistencia.Entidades.Operador;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rustu
 */
public class DTOinfoParaCrearDenuncia {
    
    private List<DTOProblemasDelSemaforo> problemasDelSemaforo;
    private Operador operador;
    private Denunciante denunciante;

    /**
     * @return the problemasDelSemaforo
     */
    public List<DTOProblemasDelSemaforo> getProblemasDelSemaforo() {
        return problemasDelSemaforo;
    }

    /**
     * @param problemasDelSemaforo the problemasDelSemaforo to set
     */
    public void setProblemasDelSemaforo(List<DTOProblemasDelSemaforo> problemasDelSemaforo) {
        this.problemasDelSemaforo = problemasDelSemaforo;
    }

    /**
     * @return the operador
     */
    public Operador getOperador() {
        return operador;
    }

    /**
     * @param operador the operador to set
     */
    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    /**
     * @return the denunciante
     */
    public Denunciante getDenunciante() {
        return denunciante;
    }

    /**
     * @param denunciante the denunciante to set
     */
    public void setDenunciante(Denunciante denunciante) {
        this.denunciante = denunciante;
    }

    
}
