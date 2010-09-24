/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public interface EstadoElementoTrabajo extends SuperDruperInterfaz {

    public int getcodigoestadoelementotrabajo();

    public String getnombreEstado();

    public void setcodigoestadoelementotrabajo(int newVal);

    public void setnombreEstado(String newVal);
}
