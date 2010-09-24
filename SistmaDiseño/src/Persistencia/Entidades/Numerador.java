/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public interface Numerador extends SuperDruperInterfaz {

    public String gettipodocumentacion();

    public int getultimonumeroregistrado();

    public void settipodocumentacion(String newVal);

    public void setultimonumeroregistrado(int newVal);
}
