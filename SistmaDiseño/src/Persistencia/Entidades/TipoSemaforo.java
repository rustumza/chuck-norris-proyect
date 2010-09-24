/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public interface TipoSemaforo extends SuperDruperInterfaz {

    public int getcodigoTipoSemaforo();

    public String getdescripciontiposemaforo();

    public void setcodigoTipoSemaforo(int newVal);

    public void setdescripciontiposemaforo(String newVal);
}
