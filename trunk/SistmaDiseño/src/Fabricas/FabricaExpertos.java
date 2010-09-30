/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabricas;

import Expertos.Experto;
import Expertos.ExpertoAntenderReclamoPorDesperfecto;
import Expertos.ExpertoConsultarAvanceDeReclamo;
import Expertos.ExpertoConsultarOrdenesPendientes;
import Expertos.ExpertoEjecutarOrdenesTrabajo;
import Persistencia.Decoradores.DecoradorExpertoAntenderReclamoPorDesperfecto;
import Persistencia.Decoradores.DecoradorExpertoConsultarAvanceDeReclamo;
import Persistencia.Decoradores.DecoradorExpertoConsultarOrdenesPendientes;
import Persistencia.Decoradores.DecoradorExpertoEjecutarOrdenesTrabajo;

/**
 *
 * @author LEIVA
 */
public class FabricaExpertos {

    private static FabricaExpertos instance = null;

    private FabricaExpertos() {
    }

    public static FabricaExpertos getInstance() {

        if (instance == null) {
            instance = new FabricaExpertos();
        }

        return instance;

    }

    public Experto getExperto(String tipo) {
        Experto retorno = null;

        if (tipo.equals("AtenderReclamoPorDesperfecto")) {
            retorno = (Experto) new DecoradorExpertoAntenderReclamoPorDesperfecto();
        } else if (tipo.equals("ConsultarAvanceDeReclamo")) {
            retorno =(Experto) new DecoradorExpertoConsultarAvanceDeReclamo();
        } else if (tipo.equals("ConsultarOrdenesPendientes")) {
            retorno = (Experto) new DecoradorExpertoConsultarOrdenesPendientes();
        } else if (tipo.equals("EjecutarOrdenesTrabajo")) {
            retorno = (Experto) new DecoradorExpertoEjecutarOrdenesTrabajo();
        }

        return retorno;
    }
}
