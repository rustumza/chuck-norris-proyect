package Persistencia.Entidades;

import java.util.Date;
import java.util.List;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:12 p.m.
 */
public class CasoImplementacion implements Caso{

    private Date fechacaso;
    private int tipocaso;
    private Operador operador;
    private List<Semaforo> semaforo;
    private List<Problema> problema;
    private Denunciante denunciante;
    

    public CasoImplementacion() {
    }

    public Date getfechacaso() {
        return fechacaso;
    }

    public int gettipocaso() {
        return tipocaso;
    }

    /**
     *
     * @param newVal
     */
    public void setfechacaso(Date newVal) {
        fechacaso = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void settipocaso(int newVal) {
        tipocaso = newVal;
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
     * @return the semaforo
     */
    public List<Semaforo> getSemaforo() {
        return semaforo;
    }

    /**
     * @param semaforo the semaforo to set
     */
    public void setSemaforo(List<Semaforo> semaforo) {
        this.semaforo = semaforo;
    }

    /**
     * @return the problema
     */
    public List<Problema> getProblema() {
        return problema;
    }

    /**
     * @param problema the problema to set
     */
    public void setProblema(List<Problema> problema) {
        this.problema = problema;
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
