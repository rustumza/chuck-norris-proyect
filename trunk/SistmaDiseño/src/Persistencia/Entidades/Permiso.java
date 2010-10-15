/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Entidades;

/**
 *
 * @author informatica
 */
public interface Permiso extends SuperDruperInterfaz {


    public int getNroPermiso();

    public String getNombrePermiso();

    public void setNroPermiso(Integer nroPerm);

    public void setNombrePermiso(String nomPermiso);
}
