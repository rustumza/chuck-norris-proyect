package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:16 p.m.
 */
public class OrientacionImplementacion implements Orientacion{

	private int codigoOrientacion;
	private String descripcion;

	public OrientacionImplementacion(){

	}

	public int getcodigoOrientacion(){
		return codigoOrientacion;
	}

	public String getdescripcion(){
		return descripcion;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcodigoOrientacion(int newVal){
		codigoOrientacion = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setdescripcion(String newVal){
		descripcion = newVal;
	}

}
