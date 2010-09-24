package Persistencia.Entidades;

import java.util.Date;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:16 p.m.
 */
public class PesoDeReclamoImplementacion implements PesoDeReclamo{

	private int cantidadReclamosDesde;
	private int cantidadReclamosHasta;
	private Date fechaDesde;
	private Date fechaHasta;
	private int peso;

	public PesoDeReclamoImplementacion(){

	}

	
	public int getcantidadReclamosDesde(){
		return cantidadReclamosDesde;
	}

	public int getcantidadReclamosHasta(){
		return cantidadReclamosHasta;
	}

	public Date getfechaDesde(){
		return fechaDesde;
	}

	public Date getfechaHasta(){
		return fechaHasta;
	}

	public int getpeso(){
		return peso;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcantidadReclamosDesde(int newVal){
		cantidadReclamosDesde = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcantidadReclamosHasta(int newVal){
		cantidadReclamosHasta = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setfechaDesde(Date newVal){
		fechaDesde = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setfechaHasta(Date newVal){
		fechaHasta = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setpeso(int newVal){
		peso = newVal;
	}

}
