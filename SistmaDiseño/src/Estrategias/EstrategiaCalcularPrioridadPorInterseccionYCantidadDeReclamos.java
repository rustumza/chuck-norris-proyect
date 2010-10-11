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
public class EstrategiaCalcularPrioridadPorInterseccionYCantidadDeReclamos implements EstrategiaCalculoDePrioridad{

    @Override
    public float calcularPrioridad(Denuncia denuncia, Ubicacion ubicacion) {
        float prioridadDenuncia = 0;
        int cantReclamos = denuncia.getReclamo().size();
        float pesoReclamos=0;
        if(cantReclamos <= 2)
            pesoReclamos=1;
        else if(cantReclamos <=5)
            pesoReclamos=2;
        else if (cantReclamos <=7)
            pesoReclamos=3;
        else if (cantReclamos <=10)
            pesoReclamos=4;
        else
            pesoReclamos=5;

        float prioridadInterseccion = ubicacion.getPrioridad();
        prioridadDenuncia = (float) (0.75 * prioridadInterseccion + 0.25 * pesoReclamos);

        return prioridadDenuncia;
    }

}
