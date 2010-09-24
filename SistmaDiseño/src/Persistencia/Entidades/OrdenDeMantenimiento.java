/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public interface OrdenDeMantenimiento extends OrdenTrabajo {

    public int getcodigoordenmantenimiento();

    public void setcodigoordenmantenimiento(int newVal);

    public Semaforo getSemaforo();

    public void setSemaforo(Semaforo semaforo);

    public InformeMantenimiento getInformeMantenimiento();

    public void setInformeMantenimiento(InformeMantenimiento informeMantenimiento);

    public FichaMantenimiento getFichaMantenimiento();

    public void setFichaMantenimiento(FichaMantenimiento fichaMantenimiento);
}
