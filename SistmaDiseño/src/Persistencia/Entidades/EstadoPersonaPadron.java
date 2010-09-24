/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public interface EstadoPersonaPadron extends SuperDruperInterfaz {

    public int getcodigoestadopersonapadron();

    public String getnombreestado();

    public void setcodigoestadopersonapadron(int newVal);

    public void setnombreestado(String newVal);
}
