/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public interface Trabajo extends SuperDruperInterfaz {

    public int gettiempoEstimadoTrabajo();

    public String gettipotrabajo();

    public void settiempoEstimadoTrabajo(int newVal);

    public void settipotrabajo(String newVal);

    public TrabajoElementoNecesario getTrabajoElementoNecesario();

    public void setTrabajoElementoNecesario(TrabajoElementoNecesario trabajoElementoNecesario);

    public OrdenTrabajo getOrdenTrabajo();

    public void setOrdenTrabajo(OrdenTrabajo ordenTrabajo);

    public String getNombreTrabajo();

    public void setNombreTrabajo(String nombreTrabajo);
}
