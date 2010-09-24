/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author Bicentenario
 */
public interface Denunciante extends SuperDruperInterfaz {

    public String getcelular();

    public String getdomicilio();

    public String getemail();

    public String gettelefonofijo();

    public void setcelular(String newVal);

    public void setdomicilio(String newVal);

    public void setemail(String newVal);

    public void settelefonofijo(String newVal);

    public PersonaPadron getPersonaPadron();

    public void setPersonaPadron(PersonaPadron personaPadron);

    public boolean isEstadoBaja();

    public void setEstadoBaja(boolean estadoBaja);
}
