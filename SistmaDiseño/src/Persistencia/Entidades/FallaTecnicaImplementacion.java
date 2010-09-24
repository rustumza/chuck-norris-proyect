package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:14 p.m.
 */
public class FallaTecnicaImplementacion extends TrabajoImplementacion implements FallaTecnica{

	private int codigoFallaTecnica;
	private String descripcionfalla;

	public FallaTecnicaImplementacion(){

	}

	
	public int getcodigoFallaTecnica(){
		return codigoFallaTecnica;
	}

	public String getdescripcionfalla(){
		return descripcionfalla;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcodigoFallaTecnica(int newVal){
		codigoFallaTecnica = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setdescripcionfalla(String newVal){
		descripcionfalla = newVal;
	}

}
