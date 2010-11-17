/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Fabricas;

import AdaptadorSistemaReportes.AdaptadorReportesPDF;
import AdaptadorSistemaReportes.InterfaceAdaptadorReportes;

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

    public InterfaceAdaptadorReportes crearAdaptadorReportes(){
        return new AdaptadorReportesPDF();
    }
}
