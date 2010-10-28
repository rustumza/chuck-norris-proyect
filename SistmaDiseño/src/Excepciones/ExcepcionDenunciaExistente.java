/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Excepciones;

/**
 *
 * @author rustu
 */
public class ExcepcionDenunciaExistente extends Exception{

        private int numeroDeDenuncia;
        private int cantidadDeReclamos;

    /**
     * @return the numeroDeDenuncia
     */
    public int getNumeroDeDenuncia() {
        return numeroDeDenuncia;
    }

    /**
     * @param numeroDeDenuncia the numeroDeDenuncia to set
     */
    public void setNumeroDeDenuncia(int numeroDeDenuncia) {
        this.numeroDeDenuncia = numeroDeDenuncia;
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


}
