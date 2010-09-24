package Persistencia.Entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:17 p.m.
 */
public class ReservaImplementacion implements Reserva{

	private int codigoreserva;
	private Date fecha;
	private List<ReservaElementoTrabajo> reservaElementoTrabajo;

	public ReservaImplementacion(){

	}

	
	   public int getcodigoreserva() {
        return codigoreserva;
    }

    public Date getfecha() {
        return fecha;
    }

    /**
     *
     * @param newVal
     */
    public void setcodigoreserva(int newVal) {
        codigoreserva = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void setfecha(Date newVal) {
        fecha = newVal;
    }

    /**
     * @return the reservaElementoTrabajo
     */
    public List<ReservaElementoTrabajo> getReservaElementoTrabajo() {
        return reservaElementoTrabajo;
    }

    /**
     * @param reservaElementoTrabajo the reservaElementoTrabajo to set
     */
    public void setReservaElementoTrabajo(List<ReservaElementoTrabajo> reservaElementoTrabajo) {
        this.reservaElementoTrabajo = reservaElementoTrabajo;
    }

    public void addReservaElementoTrabajo(ReservaElementoTrabajo nuevoElementoTrabajo){
        if(reservaElementoTrabajo == null)
            reservaElementoTrabajo = new ArrayList<ReservaElementoTrabajo>();
        reservaElementoTrabajo.add(nuevoElementoTrabajo);
    }

}
