/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Estrategias;

import Persistencia.Entidades.Denuncia;
import Persistencia.Entidades.Ubicacion;

/**
 *
 * @author rustu
 */
public interface EstrategiaCalculoDePrioridad{

    public float calcularPrioridad(Denuncia denuncia, Ubicacion ubicacion);

}
