/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public interface Problema extends SuperDruperInterfaz {

    @Override
    public String toString();

    public int getcodigoProblema();

    public String getdescripcionProblema();

    public void setcodigoProblema(int newVal);

    public void setdescripcionProblema(String newVal);

    public Caso getCaso();

    public void setCaso(Caso caso);
}
