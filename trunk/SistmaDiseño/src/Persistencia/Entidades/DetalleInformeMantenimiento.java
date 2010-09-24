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
public interface DetalleInformeMantenimiento extends SuperDruperInterfaz {

    public String getcomentario();

    public Date getfechafinrealizaciontarea();

    public Date getfechainiciorealizaciontarea();

    public Date gethorafintarea();

    public Date gethorainiciotarea();

    public void setcomentario(String newVal);

    public void setfechafinrealizaciontarea(Date newVal);

    public void setfechainiciorealizaciontarea(Date newVal);

    public void sethorafintarea(Date newVal);

    public void sethorainiciotarea(Date newVal);

    public Tarea getTarea();

    public void setTarea(Tarea tarea);

    public ElementoTrabajoMantenimiento getElementoTrabajoMantenimiento();

    public void setElementoTrabajoMantenimiento(ElementoTrabajoMantenimiento elementoTrabajoMantenimiento);
}
