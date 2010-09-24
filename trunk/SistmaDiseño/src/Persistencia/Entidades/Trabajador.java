/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public interface Trabajador extends SuperDruperInterfaz {

    public String getapellido();

    public String getDocumento();

    public String getlegajo();

    public String getnombre();

    public String gettipoDocumento();

    public void setapellido(String newVal);

    public void setDocumento(String newVal);

    public void setlegajo(String newVal);

    public void setnombre(String newVal);

    public void settipoDocumento(String newVal);

    public Trabajo getTrabajo();

    public void setTrabajo(Trabajo trabajo);
}
