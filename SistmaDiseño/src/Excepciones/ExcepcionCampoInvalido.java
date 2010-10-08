/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Excepciones;

/**
 *
 * @author diego
 */
public class ExcepcionCampoInvalido extends Exception {

    private String mensaje;


    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMessage(){
        return mensaje;
    }

}
