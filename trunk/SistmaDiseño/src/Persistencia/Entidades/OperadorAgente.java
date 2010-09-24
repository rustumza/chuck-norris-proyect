/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public class OperadorAgente implements Operador{

    private OperadorImplementacion implementacion;

    public String getlegajo() {
        return implementacion.getlegajo();
    }

    public String getnombreOperador() {
        return implementacion.getnombreOperador();
    }

    public void setlegajo(String newVal) {
        implementacion.setlegajo(newVal);
    }

    public void setnombreOperador(String newVal) {
        implementacion.setnombreOperador(newVal);
    }

    /**
     * @return the implementacion
     */
    public OperadorImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(OperadorImplementacion implementacion) {
        this.implementacion = implementacion;
    }

}
