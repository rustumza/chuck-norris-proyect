/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Entidades;

import Persistencia.ExpertosPersistencia.FachadaInterna;

/**
 *
 * @author diego
 */
public class UbicacionSimpleAgente extends UbicacionAgente implements UbicacionSimple{

    private String oidCalle;
    //variable para saber si ya se ha buscado el objeto relacionado en la BD
    private boolean CalleBuscado;

    public int getaltura() {

        return ((UbicacionSimpleImplementacion)getImplementacion()).getaltura();
    }

    public void setaltura(int newVal) {
        ((UbicacionSimpleImplementacion)getImplementacion()).setaltura(newVal);
    }

    public Calle getCalle() {
        if(isCalleBuscado()==false)
            ((UbicacionSimpleImplementacion)getImplementacion()).setCalle((Calle)FachadaInterna.getInstancia().buscar("Calle", oidCalle));
        return ((UbicacionSimpleImplementacion)getImplementacion()).getCalle();
    }

    public void setCalle(Calle calle) {
        ((UbicacionSimpleImplementacion)getImplementacion()).setCalle(calle);
    }

    /**
     * @return the oidCalle
     */
    public String getOidCalle() {
        return oidCalle;
    }

    /**
     * @param oidCalle the oidCalle to set
     */
    public void setOidCalle(String oidCalle) {
        this.oidCalle = oidCalle;
    }

    /**
     * @return the CalleBuscado
     */
    public boolean isCalleBuscado() {
        return CalleBuscado;
    }

    /**
     * @param CalleBuscado the CalleBuscado to set
     */
    public void setCalleBuscado(boolean CalleBuscado) {
        this.CalleBuscado = CalleBuscado;
    }

}
