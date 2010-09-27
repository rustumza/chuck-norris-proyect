/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

import java.util.List;

/**
 *
 * @author RUSTU
 */
public interface Interseccion extends Ubicacion{

    public List<Calle> getCalles();

    public void setCalles(List<Calle> calle);
}
