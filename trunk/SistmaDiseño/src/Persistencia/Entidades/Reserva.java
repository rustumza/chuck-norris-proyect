/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

import java.util.Date;
import java.util.List;

/**
 *
 * @author diego
 */
public interface Reserva extends SuperDruperInterfaz {

    public int getcodigoreserva();

    public Date getfecha();

    public void setcodigoreserva(int newVal);

    public void setfecha(Date newVal);

    public List<ReservaElementoTrabajo> getReservaElementoTrabajo();

    public void setReservaElementoTrabajo(List<ReservaElementoTrabajo> reservaElementoTrabajo);
}
