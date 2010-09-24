package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:17 p.m.
 */
public class RolImplementacion implements Rol{

	private int codigoRol;
	private String nombreRol;

	public RolImplementacion(){

	}

	
	public int getcodigoRol(){
		return codigoRol;
	}

	public String getnombreRol(){
		return nombreRol;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcodigoRol(int newVal){
		codigoRol = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setnombreRol(String newVal){
		nombreRol = newVal;
	}

}
