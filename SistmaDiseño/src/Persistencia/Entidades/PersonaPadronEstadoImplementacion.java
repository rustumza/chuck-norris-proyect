package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:16 p.m.
 */
public class PersonaPadronEstadoImplementacion implements PersonaPadronEstado{

	private int fechacambioestado;
	private boolean indicadorestadoactual;
	private EstadoPersonaPadron etadoPersonaPadron;

	public PersonaPadronEstadoImplementacion(){

	}


	   public int getfechacambioestado() {
        return fechacambioestado;
    }

    public boolean isindicadorestadoactual() {
        return indicadorestadoactual;
    }

    /**
     *
     * @param newVal
     */
    public void setfechacambioestado(int newVal) {
        fechacambioestado = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void setindicadorestadoactual(boolean newVal) {
        indicadorestadoactual = newVal;
    }

    /**
     * @return the etadoPersonaPadron
     */
    public EstadoPersonaPadron getEtadoPersonaPadron() {
        return etadoPersonaPadron;
    }

    /**
     * @param etadoPersonaPadron the etadoPersonaPadron to set
     */
    public void setEtadoPersonaPadron(EstadoPersonaPadron etadoPersonaPadron) {
        this.etadoPersonaPadron = etadoPersonaPadron;
    }
}
