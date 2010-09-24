package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:16 p.m.
 */
public class PeriodicidadImplementacion implements Periodicidad{

	private int dias;
	private String periodicidad;

	public PeriodicidadImplementacion(){

	}

	
	public int getdias(){
		return dias;
	}

	public String getperiodicidad(){
		return periodicidad;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setdias(int newVal){
		dias = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setperiodicidad(String newVal){
		periodicidad = newVal;
	}

}
