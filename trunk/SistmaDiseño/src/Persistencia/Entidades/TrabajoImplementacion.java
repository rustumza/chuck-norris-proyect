package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:18 p.m.
 */
public class TrabajoImplementacion implements Trabajo {

	private String nombreTrabajo;
	private int tiempoEstimadoTrabajo;
	private String tipotrabajo;
	private TrabajoElementoNecesario trabajoElementoNecesario;
	private OrdenTrabajo ordenTrabajo;

	public TrabajoImplementacion(){

	}

	
	public int gettiempoEstimadoTrabajo(){
		return tiempoEstimadoTrabajo;
	}

	public String gettipotrabajo(){
		return tipotrabajo;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void settiempoEstimadoTrabajo(int newVal){
		tiempoEstimadoTrabajo = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void settipotrabajo(String newVal){
		tipotrabajo = newVal;
	}

    /**
     * @return the trabajoElementoNecesario
     */
    public TrabajoElementoNecesario getTrabajoElementoNecesario() {
        return trabajoElementoNecesario;
    }

    /**
     * @param trabajoElementoNecesario the trabajoElementoNecesario to set
     */
    public void setTrabajoElementoNecesario(TrabajoElementoNecesario trabajoElementoNecesario) {
        this.trabajoElementoNecesario = trabajoElementoNecesario;
    }

    /**
     * @return the ordenTrabajo
     */
    public OrdenTrabajo getOrdenTrabajo() {
        return ordenTrabajo;
    }

    /**
     * @param ordenTrabajo the ordenTrabajo to set
     */
    public void setOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
    }

    /**
     * @return the nombreTrabajo
     */
    public String getNombreTrabajo() {
        return nombreTrabajo;
    }

    /**
     * @param nombreTrabajo the nombreTrabajo to set
     */
    public void setNombreTrabajo(String nombreTrabajo) {
        this.nombreTrabajo = nombreTrabajo;
    }

}
