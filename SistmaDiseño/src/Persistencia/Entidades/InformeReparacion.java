/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author diego
 */
public interface InformeReparacion extends SuperDruperInterfaz {

    public int getduracionReparacion();

    public Date getfechainforme();

    public Time gethorainforme();

    public void setduracionReparacion(int newVal);

    public void setfechainforme(Date newVal);

    public void sethorainforme(Time newVal);

    public DetalleInformeReparacion getDetalleInformeReparacion();

    public void setDetalleInformeReparacion(DetalleInformeReparacion detalleInformeReparacion);
}
