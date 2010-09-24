/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

import java.util.List;

/**
 *
 * @author diego
 */
public interface EquipoDeTrabajo extends SuperDruperInterfaz {

    public int getcargaHorariaMaxPorDia();

    public int getcodigoEquipo();

    public String getnombreEquipo();

    public void setcargaHorariaMaxPorDia(int newVal);

    public void setcodigoEquipo(int newVal);

    public void setnombreEquipo(String newVal);

    public List<TrabajadorRol> getTrabajadorRol();

    public void setTrabajadorRol(List<TrabajadorRol> trabajadorRol);
}
