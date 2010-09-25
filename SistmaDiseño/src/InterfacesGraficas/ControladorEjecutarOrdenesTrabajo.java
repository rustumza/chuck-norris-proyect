/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas;

import Expertos.ExpertoEjecutarOrdenesTrabajo;
import Fabricas.FabricaExpertos;
import Persistencia.Entidades.OrdenDeMantenimiento;
import Persistencia.Entidades.OrdenDeReparacion;
import Persistencia.Entidades.OrdenTrabajo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author informatica
 */
public class ControladorEjecutarOrdenesTrabajo {

    ExpertoEjecutarOrdenesTrabajo experto;
    PantallaEjecutarOrdenTrabajo pantalla;

    public ControladorEjecutarOrdenesTrabajo() {
        experto = (ExpertoEjecutarOrdenesTrabajo) FabricaExpertos.getInstance().getExperto("ExpertoEjecutarOrdenesTrabajo");
        pantalla = new PantallaEjecutarOrdenTrabajo(this);
    }

    public void iniciar() {
        pantalla.setLocationRelativeTo(null);
        pantalla.setVisible(true);
    }

    public List<OrdenTrabajo> consultarOrdenesPendientes(Date fecha, String tipo) {
        if(tipo.equals("Trabajo"))
            return experto.consultarOrdenesTrabajoPendientes(fecha);
        else if(tipo.equals("Reparacion")){
            List<OrdenDeReparacion> listaOrdenesRep = experto.consultarOrdenesReparacionPendientes(fecha);
            List<OrdenTrabajo> listaOrdenTrabajo = new ArrayList<OrdenTrabajo>();
            for( OrdenDeReparacion aux : listaOrdenesRep ){
                listaOrdenTrabajo.add((OrdenTrabajo)aux );

                 return listaOrdenTrabajo;
           }

        }        
            else if(tipo.equals("Mantenimiento")){
            List<OrdenDeMantenimiento> listaOrdenesMant = experto.consultarOrdenesMantenimientoPendientes(fecha);
            List<OrdenTrabajo> listaOrdenTrabajo = new ArrayList<OrdenTrabajo>();
            for (OrdenDeMantenimiento aux : listaOrdenesMant){
                listaOrdenTrabajo.add((OrdenTrabajo) aux);
            
            return listaOrdenTrabajo;
            } 
     
       }return null;
    }



 public void confirmarOrden(OrdenTrabajo listaOrdenTrabajo){

        experto.guardarOrdenTrabajo((List<OrdenTrabajo>) listaOrdenTrabajo);
     }
 }
