/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Fabricas;

import AdaptadoresSistemaStock.AdaptadorSistemaStock;
import AdaptadoresSistemaStock.AdaptadorSistemaStockCronos;

/**
 *
 * @author rustu
 */
public class FabricaAdaptadoresSistemaStock {

    public static FabricaAdaptadoresSistemaStock instance;
    public static FabricaAdaptadoresSistemaStock getInstance(){
        if(instance == null){
            instance = new FabricaAdaptadoresSistemaStock();
        }
        return instance;
    }

    private FabricaAdaptadoresSistemaStock(){

    }

    public AdaptadorSistemaStock crearAdaptador(){
        return (AdaptadorSistemaStock) new AdaptadorSistemaStockCronos();
    }

}
