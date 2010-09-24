/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author Bicentenario
 */
public interface EstadoDenuncia extends SuperDruperInterfaz {

    public int getcodigoestadodenuncia();

    public String getnombreestado();

    public void setcodigoestadodenuncia(int newVal);

    public void setnombreestado(String newVal);
}
