package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:13 p.m.
 */
public class DetalleInformeReparacionImplementacion implements DetalleInformeReparacion {

	private String comentario;
	private ReparacionTareaRealizada reparacionTareaRealizada;
	private FallaTecnica fallaTecnica;
	private EstadoFallaTecnica estadoFallaTecnica;

        

	public DetalleInformeReparacionImplementacion(){

	}

	
	   public String getcomentario() {
        return comentario;
    }

    /**
     *
     * @param newVal
     */
    public void setcomentario(String newVal) {
        comentario = newVal;
    }

    /**
     * @return the reparacionTareaRealizada
     */
    public ReparacionTareaRealizada getReparacionTareaRealizada() {
        return reparacionTareaRealizada;
    }

    /**
     * @param reparacionTareaRealizada the reparacionTareaRealizada to set
     */
    public void setReparacionTareaRealizada(ReparacionTareaRealizada reparacionTareaRealizada) {
        this.reparacionTareaRealizada = reparacionTareaRealizada;
    }

    /**
     * @return the fallaTecnica
     */
    public FallaTecnica getFallaTecnica() {
        return fallaTecnica;
    }

    /**
     * @param fallaTecnica the fallaTecnica to set
     */
    public void setFallaTecnica(FallaTecnica fallaTecnica) {
        this.fallaTecnica = fallaTecnica;
    }

    /**
     * @return the estadoFallaTecnica
     */
    public EstadoFallaTecnica getEstadoFallaTecnica() {
        return estadoFallaTecnica;
    }

    /**
     * @param estadoFallaTecnica the estadoFallaTecnica to set
     */
    public void setEstadoFallaTecnica(EstadoFallaTecnica estadoFallaTecnica) {
        this.estadoFallaTecnica = estadoFallaTecnica;
    }
}
