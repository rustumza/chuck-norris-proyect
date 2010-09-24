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
public interface CronogramaDeMantenimiento extends SuperDruperInterfaz {

    public int getcodigoCronograma();

    public Date getfechaDeCreacion();

    public Date getfechaFinCronograma();

    public Date getfechaInicioCronograma();

    public String getobservacionesCronograma();

    public void setcodigoCronograma(int newVal);

    public void setfechaDeCreacion(Date newVal);

    public void setfechaFinCronograma(Date newVal);

    public void setfechaInicioCronograma(Date newVal);

    public void setobservacionesCronograma(String newVal);

    public FichaMantenimiento getFichaMantenimiento();

    public void setFichaMantenimiento(FichaMantenimiento fichaMantenimiento);
}
