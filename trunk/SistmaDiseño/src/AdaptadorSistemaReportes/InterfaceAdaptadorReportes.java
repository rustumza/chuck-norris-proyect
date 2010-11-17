/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AdaptadorSistemaReportes;

import DTO.DTOOrden;
import java.util.List;

/**
 *
 * @author diego
 */
public interface InterfaceAdaptadorReportes {

    public void generarReportes(List<DTOOrden> listaOrdenesRep);
    
}
