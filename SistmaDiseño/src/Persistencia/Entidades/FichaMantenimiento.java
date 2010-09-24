/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public interface FichaMantenimiento extends SuperDruperInterfaz {

    public int getcodigoFichaMantenimiento();

    public void setcodigoFichaMantenimiento(int newVal);

    public Modelo getModelo();

    public void setModelo(Modelo modelo);

    public Periodicidad getPeriodicidad();

    public void setPeriodicidad(Periodicidad periodicidad);

    public RangoAnios getRangoAnios();

    public void setRangoAnios(RangoAnios rangoAnios);

    public Tarea getTarea();

    public void setTarea(Tarea tarea);
}
