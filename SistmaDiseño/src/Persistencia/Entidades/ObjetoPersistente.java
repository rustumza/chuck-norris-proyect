package Persistencia.Entidades;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author diego
 */
public class ObjetoPersistente implements SuperDruperInterfaz{

    private String oid;
    private boolean isNuevo;

    /**
     * @return the _oid
     */
    public String getOid() {
        return oid;
    }

    /**
     * @param oid the _oid to set
     */
    public void setOid(String oid) {
        this.oid = oid;
    }

    /**
     * @return the isNuevo
     */
    public boolean isIsNuevo() {
        return isNuevo;
    }

    /**
     * @param isNuevo the isNuevo to set
     */
    public void setIsNuevo(boolean isNuevo) {
        this.isNuevo = isNuevo;
    }

}
