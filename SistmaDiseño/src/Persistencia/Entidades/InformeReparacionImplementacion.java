package Persistencia.Entidades;

import java.sql.Time;
import java.util.Date;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:14 p.m.
 */
public class InformeReparacionImplementacion implements InformeReparacion{

	private int duracionReparacion;
	private Date fechainforme;
	private Time horainforme;
	private DetalleInformeReparacion detalleInformeReparacion;

	public InformeReparacionImplementacion(){

	}

	
	public int getduracionReparacion(){
		return duracionReparacion;
	}

	public Date getfechainforme(){
		return fechainforme;
	}

	public Time gethorainforme(){
		return horainforme;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setduracionReparacion(int newVal){
		duracionReparacion = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setfechainforme(Date newVal){
		fechainforme = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void sethorainforme(Time newVal){
		horainforme = newVal;
	}

    /**
     * @return the detalleInformeReparacion
     */
    public DetalleInformeReparacion getDetalleInformeReparacion() {
        return detalleInformeReparacion;
    }

    /**
     * @param detalleInformeReparacion the detalleInformeReparacion to set
     */
    public void setDetalleInformeReparacion(DetalleInformeReparacion detalleInformeReparacion) {
        this.detalleInformeReparacion = detalleInformeReparacion;
    }

}
