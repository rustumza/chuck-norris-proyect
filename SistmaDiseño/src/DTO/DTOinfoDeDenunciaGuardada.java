/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

/**
 *
 * @author rustu
 */
public class DTOinfoDeDenunciaGuardada {
    private boolean isDenuncia;
    private int codigo;
    private int cantidadDeReclamos;
    private boolean isInterseccion;
    private String calle1;
    private String calle2;
    private String algura;

    /**
     * @return the isDenuncia
     */
    public boolean isIsDenuncia() {
        return isDenuncia;
    }

    /**
     * @param isDenuncia the isDenuncia to set
     */
    public void setIsDenuncia(boolean isDenuncia) {
        this.isDenuncia = isDenuncia;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the cantidadDeReclamos
     */
    public int getCantidadDeReclamos() {
        return cantidadDeReclamos;
    }

    /**
     * @param cantidadDeReclamos the cantidadDeReclamos to set
     */
    public void setCantidadDeReclamos(int cantidadDeReclamos) {
        this.cantidadDeReclamos = cantidadDeReclamos;
    }

    /**
     * @return the isInterseccion
     */
    public boolean isIsInterseccion() {
        return isInterseccion;
    }

    /**
     * @param isInterseccion the isInterseccion to set
     */
    public void setIsInterseccion(boolean isInterseccion) {
        this.isInterseccion = isInterseccion;
    }

    /**
     * @return the calle1
     */
    public String getCalle1() {
        return calle1;
    }

    /**
     * @param calle1 the calle1 to set
     */
    public void setCalle1(String calle1) {
        this.calle1 = calle1;
    }

    /**
     * @return the calle2
     */
    public String getCalle2() {
        return calle2;
    }

    /**
     * @param calle2 the calle2 to set
     */
    public void setCalle2(String calle2) {
        this.calle2 = calle2;
    }

    /**
     * @return the algura
     */
    public String getAlgura() {
        return algura;
    }

    /**
     * @param algura the algura to set
     */
    public void setAlgura(String algura) {
        this.algura = algura;
    }
}
