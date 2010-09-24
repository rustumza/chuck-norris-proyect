/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public interface Periodicidad extends SuperDruperInterfaz {

    public int getdias();

    public String getperiodicidad();

    public void setdias(int newVal);

    public void setperiodicidad(String newVal);
}
