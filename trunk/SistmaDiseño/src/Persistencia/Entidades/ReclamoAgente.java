/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public class ReclamoAgente extends CasoAgente implements Reclamo{

    private String oidDenuncia;


    public int getcodigoreclamo() {
        return ((ReclamoImplementacion)super.getImplementacion()).getcodigoreclamo();
    }

    public void setcodigoreclamo(int newVal) {
        ((ReclamoImplementacion)super.getImplementacion()).setcodigoreclamo(newVal);
    }

    /**
     * @return the oidDenuncia
     */
    public String getOidDenuncia() {
        return oidDenuncia;
    }

    /**
     * @param oidDenuncia the oidDenuncia to set
     */
    public void setOidDenuncia(String oidDenuncia) {
        this.oidDenuncia = oidDenuncia;
    }

}
