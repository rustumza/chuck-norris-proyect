/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public interface Ubicacion extends SuperDruperInterfaz {

    public int getcodigoubicacion();

    public int getPrioridad();

    public String gettipoubicacion();

    public void setcodigoubicacion(int newVal);

    public void setPrioridad(int newVal);

    public void settipoubicacion(String newVal);

    public Operador getOperador();

    public void setOperador(Operador operador);
}
