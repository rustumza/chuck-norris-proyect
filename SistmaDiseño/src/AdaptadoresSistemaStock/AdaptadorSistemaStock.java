/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AdaptadoresSistemaStock;

import Persistencia.Entidades.OrdenTrabajo;

/**
 *
 * @author rustu
 */
public interface AdaptadorSistemaStock {
    public void confirmarStock(OrdenTrabajo orden);
}
