/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

import java.util.Date;
import java.util.List;

/**
 *
 * @author diego
 */
public interface Caso extends SuperDruperInterfaz {

    public Date getfechacaso();

    public int gettipocaso();

    public void setfechacaso(Date newVal);

    public void settipocaso(int newVal);

    public Operador getOperador();

    public void setOperador(Operador operador);

    public List<Semaforo> getSemaforo();

    public void setSemaforo(List<Semaforo> semaforo);

    public List<Problema> getProblema();

    public void setProblema(List<Problema> problema);

    public Denunciante getDenunciante();

    public void setDenunciante(Denunciante denunciante);


}
