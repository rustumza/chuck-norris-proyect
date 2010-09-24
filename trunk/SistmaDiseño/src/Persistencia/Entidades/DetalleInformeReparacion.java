/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public interface DetalleInformeReparacion extends SuperDruperInterfaz {

    public String getcomentario();

    public void setcomentario(String newVal);

    public ReparacionTareaRealizada getReparacionTareaRealizada();

    public void setReparacionTareaRealizada(ReparacionTareaRealizada reparacionTareaRealizada);

    public FallaTecnica getFallaTecnica();

    public void setFallaTecnica(FallaTecnica fallaTecnica);

    public EstadoFallaTecnica getEstadoFallaTecnica();

    public void setEstadoFallaTecnica(EstadoFallaTecnica estadoFallaTecnica);
}
