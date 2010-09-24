package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:15 p.m.
 */
public class NumeradorImplementacion implements Numerador {

	private String tipodocumentacion;
	private int ultimonumeroregistrado;

	public NumeradorImplementacion(){

	}

	
	public String gettipodocumentacion(){
		return tipodocumentacion;
	}

	public int getultimonumeroregistrado(){
		return ultimonumeroregistrado;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void settipodocumentacion(String newVal){
		tipodocumentacion = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setultimonumeroregistrado(int newVal){
		ultimonumeroregistrado = newVal;
	}

}
