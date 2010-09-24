package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:17 p.m.
 */
public class RangoAniosImplementacion implements RangoAnios{

	private int maxAnios;
	private int minAnios;

	public RangoAniosImplementacion(){

	}

	
	public int getmaxAnios(){
		return maxAnios;
	}

	public int getminAnios(){
		return minAnios;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setmaxAnios(int newVal){
		maxAnios = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setminAnios(int newVal){
		minAnios = newVal;
	}

}
