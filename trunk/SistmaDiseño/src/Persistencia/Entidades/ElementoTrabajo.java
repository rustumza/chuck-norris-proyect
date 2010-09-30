/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public interface ElementoTrabajo extends SuperDruperInterfaz {

    public short getcodigosistemaexterno();

    public String gettipoelemento();

    public void setcodigosistemaexterno(short newVal);

    public void settipoelemento(String newVal);
}
