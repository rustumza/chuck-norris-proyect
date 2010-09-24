/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public interface Modelo extends SuperDruperInterfaz {

    public int getcodigomodelo();

    public String getnombremodelo();

    public void setcodigomodelo(int newVal);

    public void setnombremodelo(String newVal);

    public Marca getMarca();

    public void setMarca(Marca marca);
}
