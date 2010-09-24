 
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expertos;

import DTO.DTOEstadoDenuncia;
import Persistencia.Entidades.Caso;
import Persistencia.ExpertosPersistencia.Criterio;
import Persistencia.Entidades.Denuncia;
import Persistencia.Entidades.DenunciaEstado;
import Persistencia.Entidades.ObjetoPersistente;
import Persistencia.Entidades.Reclamo;
import Persistencia.Entidades.SuperDruperInterfaz;
import Persistencia.ExpertosPersistencia.FachadaExterna;
import Persistencia.Fabricas.FabricaCriterios;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RUSTU
 */
public class ExpertoConsultarAvanceDeReclamo implements Experto {

    public List<DTOEstadoDenuncia> ConsultarEstadoCaso(String numcaso) {

        Criterio criterio = FachadaExterna.getInstancia().crearCriterio("CodigoDenuncia", "=", numcaso);
        List<Criterio> listaDeCriterio = new ArrayList<Criterio>();
        listaDeCriterio.add(criterio);
        List<SuperDruperInterfaz> listaDeInterfaces = FachadaExterna.getInstancia().buscar("Denuncia", listaDeCriterio);

        Caso casoEncontrado = (Caso) listaDeInterfaces.get(0);
        List<DTOEstadoDenuncia> dtoDetAvance = new ArrayList<DTOEstadoDenuncia>();

        //if (casoEncontrado.gettipocaso() == 1) {//si 1 es denuncia

            for (DenunciaEstado aux : ((Denuncia) casoEncontrado).getDenunciaEstado()) {
                DTOEstadoDenuncia estDenuncia = new DTOEstadoDenuncia();
                estDenuncia.setFecha(aux.getfechacambioestado());
                estDenuncia.setNombreEstadoDenuncia(aux.getEstadoDenuncia().getnombreestado());
                dtoDetAvance.add(estDenuncia);
            }
       /*
        }else{
            listaDeCriterio.clear();
            listaDeCriterio.add(FabricaCriterios.getInstancia().crearCriterio("Reclamo", "=", (ObjetoPersistente)casoEncontrado));

            for (DenunciaEstado estado : ((Denuncia) FachadaExterna.getInstancia().buscar("Denuncia", listaDeCriterio).get(0)).getDenunciaEstado()){
                DTOEstadoDenuncia estDenuncia = new DTOEstadoDenuncia();
                estDenuncia.setFecha(estado.getfechacambioestado());
                estDenuncia.setNombreEstadoDenuncia(estado.getEstadoDenuncia().getnombreestado());
                dtoDetAvance.add(estDenuncia);
            }
        }

*/
        return dtoDetAvance;



    }
}