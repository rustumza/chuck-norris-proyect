/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public class AUXProblemaCaso extends ObjetoPersistente{
    private String oidCaso;
    private String oidProblema;

    /**
     * @return the oidCaso
     */
    public String getOidCaso() {
        return oidCaso;
    }

    /**
     * @param oidCaso the oidCaso to set
     */
    public void setOidCaso(String oidCaso) {
        this.oidCaso = oidCaso;
    }

    /**
     * @return the oidProblema
     */
    public String getOidProblema() {
        return oidProblema;
    }

    /**
     * @param oidProblema the oidProblema to set
     */
    public void setOidProblema(String oidProblema) {
        this.oidProblema = oidProblema;
    }
}
