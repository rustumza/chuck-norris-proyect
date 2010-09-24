package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:15 p.m.
 */
public class MarcaImplementacion implements Marca{

	private int codigomarca;
	private String nombremarca;

	public MarcaImplementacion(){

	}

	public int getcodigomarca(){
		return codigomarca;
	}

	public String getnombremarca(){
		return nombremarca;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcodigomarca(int newVal){
		codigomarca = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setnombremarca(String newVal){
		nombremarca = newVal;
	}

}
