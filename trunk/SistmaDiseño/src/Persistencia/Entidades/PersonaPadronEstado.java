/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public interface PersonaPadronEstado extends SuperDruperInterfaz {

    public int getfechacambioestado();

    public boolean isindicadorestadoactual();

    public void setfechacambioestado(int newVal);

    public void setindicadorestadoactual(boolean newVal);

    public EstadoPersonaPadron getEtadoPersonaPadron();

    public void setEtadoPersonaPadron(EstadoPersonaPadron etadoPersonaPadron);
}
