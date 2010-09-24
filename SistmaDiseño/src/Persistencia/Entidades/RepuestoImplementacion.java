package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:17 p.m.
 */
public class RepuestoImplementacion extends ElementoTrabajoImplementacion implements Repuesto{

	private int codigoRepuesto;
	private String nombreRepuesto;

	public RepuestoImplementacion(){

	}

	
	public int getcodigoRepuesto(){
		return codigoRepuesto;
	}

	public String getnombreRepuesto(){
		return nombreRepuesto;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcodigoRepuesto(int newVal){
		codigoRepuesto = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setnombreRepuesto(String newVal){
		nombreRepuesto = newVal;
	}

}
