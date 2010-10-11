/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Fabricas;

import Estrategias.EstrategiaCalcularPrioridadPorInterseccionYCantidadDeReclamos;
import Estrategias.EstrategiaCalculoDePrioridad;

/**
 *
 * @author rustu
 */
public class FabricaDeEstrategiaCalcularPrioridad {

    private static FabricaDeEstrategiaCalcularPrioridad instace = null;


    private FabricaDeEstrategiaCalcularPrioridad() {
    }



    public static FabricaDeEstrategiaCalcularPrioridad getInstace(){
        if(instace == null)
            instace = new FabricaDeEstrategiaCalcularPrioridad();
        return instace;
    }

    public EstrategiaCalculoDePrioridad crearEstrategiaDeCalculoDePrioridadDenuncia(){

        return (EstrategiaCalculoDePrioridad) new EstrategiaCalcularPrioridadPorInterseccionYCantidadDeReclamos();

    }
}
