/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

import java.util.List;

/**
 *
 * @author informatica
 */
public interface Perfil extends SuperDruperInterfaz {

    public String getNombrePerfil();

    public int getNroPerfil();

    public void setNombrePerfil(String newVal);

    public void setNroPerfil(int newVal);

    public List<Permiso> getPermisos();

    public void setPermisos(List<Permiso> permisos);

    public void addPermiso(Permiso nuevoPermiso);
}
