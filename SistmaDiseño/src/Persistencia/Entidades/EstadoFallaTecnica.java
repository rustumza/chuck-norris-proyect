/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public interface EstadoFallaTecnica extends SuperDruperInterfaz {

    public int getcodigoEstadoFalla();

    public String getnombreEstado();

    public void setcodigoEstadoFalla(int newVal);

    public void setnombreEstado(String newVal);
}
