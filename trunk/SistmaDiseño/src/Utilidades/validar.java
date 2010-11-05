/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Utilidades;

import Persistencia.Entidades.Permiso;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author rustu
 */
public class validar {

    public static boolean validarPermisos(List<Permiso> permisos, int nroPermiso){

        if(permisos.isEmpty())
            return false;
        for (Permiso permiso : permisos) {
            if(permiso.getNroPermiso()==nroPermiso)
                return true;
        }
    return false;
    }


    public static boolean validarNumerosEnteros(String numero){
    

        try {

            Integer.parseInt(numero);

            return true;

        } catch (NumberFormatException nfe) {

            return false;

        }

    }

    public static boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            return true;
        }else{
            return false;
        }
    }

}
