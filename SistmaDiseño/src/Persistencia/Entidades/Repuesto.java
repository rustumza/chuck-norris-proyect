/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public interface Repuesto extends ElementoTrabajo {

    public int getcodigoRepuesto();

    public String getnombreRepuesto();

    public void setcodigoRepuesto(int newVal);

    public void setnombreRepuesto(String newVal);
}
