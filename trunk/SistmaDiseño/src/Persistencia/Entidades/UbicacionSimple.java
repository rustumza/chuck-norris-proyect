/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public interface UbicacionSimple extends Ubicacion {

    public int getaltura();


    public void setaltura(int newVal);

    public Calle getCalle();

    public void setCalle(Calle calle);
}
