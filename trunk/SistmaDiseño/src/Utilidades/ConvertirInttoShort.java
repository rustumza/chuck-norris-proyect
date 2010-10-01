/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Utilidades;

/**
 *
 * @author rustu
 */
public class ConvertirInttoShort {

    private static ConvertirInttoShort instance;

    public static ConvertirInttoShort getInstace(){
        if(instance == null)
            instance = new ConvertirInttoShort();
        return instance;
    }

    private ConvertirInttoShort(){

    }

    public short convertirInttoShort(int i){

            String s = String.valueOf(i);
            return Short.parseShort(s);

    }
}
