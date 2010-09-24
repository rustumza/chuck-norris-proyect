/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

import java.util.Date;

/**
 *
 * @author diego
 */
public interface InformeMantenimiento extends SuperDruperInterfaz {

    public int getcodigoInformeMantenimiento();

    public int getduracionMantenimiento();

    public Date getfechaInforme();

    public Date gethorainforme();

    public void setcodigoInformeMantenimiento(int newVal);

    public void setduracionMantenimiento(int newVal);

    public void setfechaInforme(Date newVal);

    public void sethorainforme(Date newVal);

    public DetalleInformeMantenimiento getDetalleInformeMantenimiento();

    public void setDetalleInformeMantenimiento(DetalleInformeMantenimiento detalleInformeMantenimiento);
}
