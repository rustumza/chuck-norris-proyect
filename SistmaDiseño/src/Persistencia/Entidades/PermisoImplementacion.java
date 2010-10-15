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
    private Perfil perfil;

    public PermisoImplementacion(){

    }

    public int getNroPermiso(){
        return NroPermiso;
    }

    public String getNombrePermiso(){
        return NombrePermiso;
    }

    public Perfil getPerfil(){
        return perfil;
    }

    public void setNroPermiso(Integer nroPerm){
        this.NroPermiso = nroPerm;
    }

    public void setNombrePermiso(String nomPermiso){
        this.NombrePermiso = nomPermiso;
    }

    public void setPerfil(Perfil perf){
        this.perfil = perf;
    }

}
