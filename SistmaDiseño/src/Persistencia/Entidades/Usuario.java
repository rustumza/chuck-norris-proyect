/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Entidades;

public interface Usuario extends SuperDruperInterfaz{

        public String getClave();

	public String getNombreUsuario();

	public int getNroUsuario();

	public void setClave(String newVal);

	public void setNombreUsuario(String newVal);

	public void setNroUsuario(int newVal);

        public void setPerfil(Perfil perf);

        public Perfil getPerfil();

}