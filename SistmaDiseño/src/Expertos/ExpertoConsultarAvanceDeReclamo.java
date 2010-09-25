/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expertos;

import DTO.DTOEstadoDenuncia;
import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.Denuncia;
import Persistencia.Entidades.DenunciaEstado;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Entidades.Reclamo;
import Persistencia.Entidades.SuperDruperInterfaz;
import Persistencia.ExpertosPersistencia.FachadaExterna;
import Persistencia.Fabricas.FabricaCriterios;
import Utilidades.FormateadorFechas;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author RUSTU
 */
public class ExpertoConsultarAvanceDeReclamo implements Experto {

    public List<DTOEstadoDenuncia> ConsultarEstadoCaso(String numcaso, int seleccion) {

        Denuncia casoEncontrado;
        List<DTOEstadoDenuncia> listaDtoEstado = new ArrayList<DTOEstadoDenuncia>();

        if (seleccion == 1) {//es denuncia

            Criterio criterio = FachadaExterna.getInstancia().crearCriterio("CodigoDenuncia", "=", numcaso);
            List<Criterio> listaDeCriterio = new ArrayList<Criterio>();
            listaDeCriterio.add(criterio);
            List<SuperDruperInterfaz> denunciasBuscadas = FachadaExterna.getInstancia().buscar("Denuncia", listaDeCriterio);

            if (denunciasBuscadas == null) {
                JOptionPane.showMessageDialog(null, "No se han encontrado Denuncias con el numero: "+numcaso,"ATENCIÓN",JOptionPane.WARNING_MESSAGE);
            } else {
                casoEncontrado = (Denuncia) denunciasBuscadas.get(0);
                listaDtoEstado = armarDtoEstadoDenuncia(casoEncontrado);
            }

            

        } else if (seleccion == 2) {//es reclamo
            List<Criterio> listaDeCriterio = new ArrayList<Criterio>();
            listaDeCriterio.add(FabricaCriterios.getInstancia().crearCriterio("CodigoReclamo", "=", numcaso));
            List<SuperDruperInterfaz> listaDeInterfaces = FachadaExterna.getInstancia().buscar("Reclamo", listaDeCriterio);

            Reclamo reclamoEncontrado = (Reclamo) listaDeInterfaces.get(0);

            listaDeCriterio.clear();
            listaDeCriterio.add(FabricaCriterios.getInstancia().crearCriterio("Reclamo", "=", (ObjetoPersistente) reclamoEncontrado));
            List<SuperDruperInterfaz> denunciasBuscadas = FachadaExterna.getInstancia().buscar("Denuncia", listaDeCriterio);

            casoEncontrado = (Denuncia) denunciasBuscadas.get(0);

            listaDtoEstado = armarDtoEstadoDenuncia(casoEncontrado);

        }

        return listaDtoEstado;

    }

    public List<DTOEstadoDenuncia> armarDtoEstadoDenuncia(Denuncia denuncia) {

        List<DTOEstadoDenuncia> listaDtoEstado = new ArrayList<DTOEstadoDenuncia>();

        for (DenunciaEstado denunciaEstado : denuncia.getDenunciaEstado()) {

            DTOEstadoDenuncia dtoEstado = new DTOEstadoDenuncia();
            FormateadorFechas.getInstancia().getFormat_dd_MM_yyyy().format(denunciaEstado.getfechacambioestado());
            dtoEstado.setFecha(FormateadorFechas.getInstancia().getFormat_dd_MM_yyyy().format(denunciaEstado.getfechacambioestado()));
            dtoEstado.setNombreEstadoDenuncia(denunciaEstado.getEstadoDenuncia().getnombreestado());
            listaDtoEstado.add(dtoEstado);
        }
        return listaDtoEstado;
    }
}
