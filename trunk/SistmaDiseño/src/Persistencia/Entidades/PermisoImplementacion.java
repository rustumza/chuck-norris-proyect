/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Entidades;

/**
 *
 * @author informatica
 */
public class PermisoImplementacion implements Permiso{

    private int NroPermiso;
    private String NombrePermiso;
    

    public PermisoImplementacion(){

    }

    public int getNroPermiso(){
        return NroPermiso;
    }

    public String getNombrePermiso(){
        return NombrePermiso;
    }

    

    public void setNroPermiso(Integer nroPerm){
        this.NroPermiso = nroPerm;
    }

    public void setNombrePermiso(String nomPermiso){
        this.NombrePermiso = nomPermiso;
    }

    
}
