package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:14 p.m.
 */
public class EstadoFallaTecnicaImplementacion implements EstadoFallaTecnica{

	private int codigoEstadoFalla;
	private String nombreEstado;

	public EstadoFallaTecnicaImplementacion(){

	}

	
	public int getcodigoEstadoFalla(){
		return codigoEstadoFalla;
	}

	public String getnombreEstado(){
		return nombreEstado;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcodigoEstadoFalla(int newVal){
		codigoEstadoFalla = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setnombreEstado(String newVal){
		nombreEstado = newVal;
	}

}
