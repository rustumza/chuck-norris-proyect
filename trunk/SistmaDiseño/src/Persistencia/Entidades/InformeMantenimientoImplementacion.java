package Persistencia.Entidades;

import java.util.Date;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:14 p.m.
 */
public class InformeMantenimientoImplementacion implements InformeMantenimiento{

	private int codigoInformeMantenimiento;
	private int duracionMantenimiento;
	private Date fechaInforme;
	private Date horainforme;
	private DetalleInformeMantenimiento detalleInformeMantenimiento;

	public InformeMantenimientoImplementacion(){

	}

	
	public int getcodigoInformeMantenimiento(){
		return codigoInformeMantenimiento;
	}

	public int getduracionMantenimiento(){
		return duracionMantenimiento;
	}

	public Date getfechaInforme(){
		return fechaInforme;
	}

	public Date gethorainforme(){
		return horainforme;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcodigoInformeMantenimiento(int newVal){
		codigoInformeMantenimiento = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setduracionMantenimiento(int newVal){
		duracionMantenimiento = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setfechaInforme(Date newVal){
		fechaInforme = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void sethorainforme(Date newVal){
		horainforme = newVal;
	}

    /**
     * @return the detalleInformeMantenimiento
     */
    public DetalleInformeMantenimiento getDetalleInformeMantenimiento() {
        return detalleInformeMantenimiento;
    }

    /**
     * @param detalleInformeMantenimiento the detalleInformeMantenimiento to set
     */
    public void setDetalleInformeMantenimiento(DetalleInformeMantenimiento detalleInformeMantenimiento) {
        this.detalleInformeMantenimiento = detalleInformeMantenimiento;
    }

}
