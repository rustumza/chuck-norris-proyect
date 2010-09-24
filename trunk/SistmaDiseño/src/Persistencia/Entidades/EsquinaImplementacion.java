package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:13 p.m.
 */
public class EsquinaImplementacion implements Esquina{

	private int codigoEsquina;
	private String descripcion;

	public EsquinaImplementacion(){

	}

	
	public int getcodigoEsquina(){
		return codigoEsquina;
	}

	public String getdescripcion(){
		return descripcion;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcodigoEsquina(int newVal){
		codigoEsquina = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setdescripcion(String newVal){
		descripcion = newVal;
	}

}
