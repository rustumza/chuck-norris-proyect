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
public interface ReparacionTareaRealizada extends SuperDruperInterfaz {

    public String getcomentario();

    public Date getfechafinrealizaciontarea();

    public Date getfechainiciorealizaciontarea();

    public Time gethorafintarea();

    public Time gethorainiciotarea();

    public void setcomentario(String newVal);

    public void setfechafinrealizaciontarea(Date newVal);

    public void setfechainiciorealizaciontarea(Date newVal);

    public void sethorafintarea(Time newVal);

    public void sethorainiciotarea(Time newVal);

    public ElementoTrabajoReparacion getElementoTrabajoReparacion();

    public void setElementoTrabajoReparacion(ElementoTrabajoReparacion elementoTrabajoReparacion);

    public Tarea getTarea();

    public void setTarea(Tarea tarea);
}
