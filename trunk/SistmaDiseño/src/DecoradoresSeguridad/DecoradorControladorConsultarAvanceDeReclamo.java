/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/

package DecoradoresSeguridad;


import InterfacesGraficas.ControladorConsultarAvanceDeReclamo;

/**
*
* @author rustu
*/
public class DecoradorControladorConsultarAvanceDeReclamo extends ControladorConsultarAvanceDeReclamo{





    @Override
    public void iniciar() {
        super.iniciar();
    }

    @Override
    public void ConsultarEstadoCaso(String numcaso, int seleccion) {
        super.ConsultarEstadoCaso(numcaso, seleccion);
    }

    @Override
    public void mostrarMensaje(int seleccion, String mensaje) {
        super.mostrarMensaje(seleccion, mensaje);
    }

    @Override
    public void cerrar(){
        super.cerrar();
    }

    }
