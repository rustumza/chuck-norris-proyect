/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Utilidades;

/**
 *
 * @author diego
 */
public class ConvertidorBooleanos {

    private static ConvertidorBooleanos instancia;

    public static ConvertidorBooleanos getInstancia(){
        if (instancia == null)
            instancia = new ConvertidorBooleanos();
        return instancia;
    }

    public String convertirBooleanToString(boolean booleano){
        if(booleano){
            return "1";
        }else{
            return "0";
        }
    }

    public int convertirBooleanToInt(boolean booleano){
        if(booleano){
            return 1;
        }else{
            return 0;
        }
    }

    /*
     * convierte Booleano a Activo si es verdadero o Inactivo si es falso
     */
    public String convertirBooleanToActivoInactivo(boolean booleano){
        if(booleano){
            return "Activo";
        }else{
            return "Inactivo";
        }
    }
    /*
     * convierte un entero a booleano
     */
    public boolean convertirIntToBoolean(int booleano){
        if(booleano != 0){
            return true;
        }else{
            return false;
        }
    }

}
