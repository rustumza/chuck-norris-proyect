package Persistencia.Entidades;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:15 p.m.
 */
public class InterseccionImplementacion extends UbicacionImplementacion implements Interseccion{

	private List<Calle> calles;

	public InterseccionImplementacion(){

	}

	
    /**
     * @return the calle
     */
    public List<Calle> getCalles() {
        return calles;
    }

    /**
     * @param calle the calle to set
     */
    public void setCalles(List<Calle> calle) {
        this.calles = calle;
    }

    public void addCalle(Calle nuevaCalle){
        if(calles == null )
            calles = new ArrayList<Calle>();
        calles.add(nuevaCalle);
    }

}
