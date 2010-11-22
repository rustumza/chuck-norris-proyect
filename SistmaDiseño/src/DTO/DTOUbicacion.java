/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author diego
 */
public class DTOUbicacion {

    private String tipo = "";
    private String calle1 = "";
    private String calle2 = "";
    private String altura = "";

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
     * @return the altura
     */
    public String getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(String altura) {
        this.altura = altura;
    }

    public boolean seEncuentraCalle(String calle) {
        boolean esta = false;
        if (calle1.equals(calle)) {
            esta = true;
        } else if (calle2.equals(calle)) {
            esta = true;
        }
        return esta;
    }

    public void addCalle(String calle) {
        if (calle1.isEmpty()) {
            calle1 = calle;
        } else if (calle2.isEmpty()) {
            calle2 = calle;
        }
    }
}
