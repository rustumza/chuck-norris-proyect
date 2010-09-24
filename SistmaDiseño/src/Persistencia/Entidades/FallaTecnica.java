/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public interface FallaTecnica extends Trabajo {

    public int getcodigoFallaTecnica();

    public String getdescripcionfalla();

    public void setcodigoFallaTecnica(int newVal);

    public void setdescripcionfalla(String newVal);
}
