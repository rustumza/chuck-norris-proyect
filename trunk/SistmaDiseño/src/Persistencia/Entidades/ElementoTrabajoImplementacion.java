package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:13 p.m.
 */
public class ElementoTrabajoImplementacion implements ElementoTrabajo{

	private Short codigosistemaexterno;
	private String tipoelemento;

	public ElementoTrabajoImplementacion(){

	}

	
	public short getcodigosistemaexterno(){
		return codigosistemaexterno;
	}

	public String gettipoelemento(){
		return tipoelemento;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcodigosistemaexterno(short newVal){
		codigosistemaexterno = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void settipoelemento(String newVal){
		tipoelemento = newVal;
	}



}
