package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:12 p.m.
 */
public class CalleImplementacion implements Calle{

	private int codigoCalle;
	private String nombrecalle;

	public CalleImplementacion(){

	}

	
	public int getcodigoCalle(){
		return codigoCalle;
	}

	public String getnombrecalle(){
		return nombrecalle;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcodigoCalle(int newVal){
		codigoCalle = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setnombrecalle(String newVal){
		nombrecalle = newVal;
	}

}
