package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:17 p.m.
 */
public class ReclamoImplementacion extends CasoImplementacion implements Reclamo{

	private int codigoreclamo;

	public ReclamoImplementacion(){

	}


	public int getcodigoreclamo(){
		return codigoreclamo;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcodigoreclamo(int newVal){
		codigoreclamo = newVal;
	}

}
