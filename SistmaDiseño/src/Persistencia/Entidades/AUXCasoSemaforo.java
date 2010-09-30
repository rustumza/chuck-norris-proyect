/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public class AUXCasoSemaforo extends ObjetoPersistente{
    private String oidCaso;
    private String oidSemaforo;

    /**
     * @return the oidSemaforo
     */
    public String getOidSemaforo() {
        return oidSemaforo;
    }

    /**
     * @param oidSemaforo the oidSemaforo to set
     */
    public void setOidSemaforo(String oidSemaforo) {
        this.oidSemaforo = oidSemaforo;
    }
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

}
