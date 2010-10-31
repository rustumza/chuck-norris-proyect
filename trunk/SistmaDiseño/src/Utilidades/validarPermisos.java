/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Utilidades;

import Persistencia.Entidades.Permiso;
import java.util.List;

/**
 *
 * @author rustu
 */
public class validarPermisos {

    public static boolean validarPermisos(List<Permiso> permisos, int nroPermiso){

        for (Permiso permiso : permisos) {
            if(permiso.getNroPermiso()==nroPermiso)
                return true;
        }
    return false;
    }

}
