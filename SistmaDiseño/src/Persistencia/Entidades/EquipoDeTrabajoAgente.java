/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.ExpertosPersistencia.FachadaInterna;
import Persistencia.Fabricas.FabricaCriterios;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class EquipoDeTrabajoAgente extends ObjetoPersistente implements EquipoDeTrabajo {

    private EquipoDeTrabajoImplementacion implementacion;
    private boolean trabajadorBuscado;

    public int getcargaHorariaMaxPorDia() {
        return implementacion.getcargaHorariaMaxPorDia();
    }

    public int getcodigoEquipo() {
        return implementacion.getcodigoEquipo();
    }

    public String getnombreEquipo() {
        return implementacion.getnombreEquipo();
    }

    public void setcargaHorariaMaxPorDia(int newVal) {
        implementacion.setcargaHorariaMaxPorDia(newVal);
    }

    public void setcodigoEquipo(int newVal) {
        implementacion.setcodigoEquipo(newVal);
    }

    public void setnombreEquipo(String newVal) {
        implementacion.setnombreEquipo(newVal);
    }

    public List<TrabajadorRol> getTrabajadorRol() {
        if (isTrabajadorBuscado() == false) {
            List<Criterio> listaCriterios = new ArrayList<Criterio>();
            listaCriterios.add(FabricaCriterios.getInstancia().crearCriterio("OIDEquipoDeTrabajo", "=", super.getOid()));

            for (SuperDruperInterfaz rol : FachadaInterna.getInstancia().buscar("TrabajadorRol", listaCriterios)) {
                implementacion.addRol((TrabajadorRol)rol);
            }
        }
        return implementacion.getTrabajadorRol();
    }

    public void setTrabajadorRol(List<TrabajadorRol> trabajadorRol) {
        implementacion.setTrabajadorRol(trabajadorRol);
    }

    /**
     * @return the implementacion
     */
    public EquipoDeTrabajoImplementacion getImplementacion() {
        return implementacion;
    }

    /**
     * @param implementacion the implementacion to set
     */
    public void setImplementacion(EquipoDeTrabajoImplementacion implementacion) {
        this.implementacion = implementacion;
    }

    /**
     * @return the trabajadorBuscado
     */
    public boolean isTrabajadorBuscado() {
        return trabajadorBuscado;
    }

    /**
     * @param trabajadorBuscado the trabajadorBuscado to set
     */
    public void setTrabajadorBuscado(boolean trabajadorBuscado) {
        this.trabajadorBuscado = trabajadorBuscado;
    }
}
