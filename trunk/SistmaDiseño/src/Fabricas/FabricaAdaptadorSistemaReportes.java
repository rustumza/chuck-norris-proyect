/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Fabricas;

import AdaptadorSistemaReportes.AdaptadorReportes;

/**
 *
 * @author diego
 */
public class FabricaAdaptadorSistemaReportes {

    private static FabricaAdaptadorSistemaReportes instancia;

    public static FabricaAdaptadorSistemaReportes getInstancia(){
        if(instancia == null){
            instancia = new FabricaAdaptadorSistemaReportes();
        }
        return instancia;
    }

    public AdaptadorReportes crearAdaptadorReportes(){
        return new AdaptadorReportes();
    }
}
