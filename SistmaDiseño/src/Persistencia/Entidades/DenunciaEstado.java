/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

import java.util.Date;

/**
 *
 * @author Bicentenario
 */
public interface DenunciaEstado extends SuperDruperInterfaz {

    public Date getfechacambioestado();

    public boolean isindicadorestadoactual();

    public void setfechacambioestado(Date newVal);

    public void setindicadorestadoactual(boolean newVal);

    public EstadoDenuncia getEstadoDenuncia();

    public void setEstadoDenuncia(EstadoDenuncia estadoDenuncia);
}
