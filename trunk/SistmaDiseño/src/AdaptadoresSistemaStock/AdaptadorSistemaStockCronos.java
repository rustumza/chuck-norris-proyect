/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AdaptadoresSistemaStock;

import Excepciones.ExcepcionErrorConexion;
import Excepciones.ExcepcionSistemaStock;
import Persistencia.Entidades.OrdenTrabajo;
import Persistencia.Entidades.Reserva;
import Persistencia.Entidades.ReservaElementoTrabajo;
import Utilidades.ConvertirInttoShort;
import sistemastock.ArrayOfint;
import sistemastock.WSConfirmarReservaExecute;
import sistemastock.WSConfirmarReservaExecuteResponse;

/**
 *
 * @author rustu
 */
public class AdaptadorSistemaStockCronos implements AdaptadorSistemaStock {

    final String user = "INVITADO";
    final String pass = "invitado";

    @Override
    public void confirmarStock(OrdenTrabajo orden) throws ExcepcionSistemaStock, ExcepcionErrorConexion {

        for (Reserva res : orden.getRervas()) {
            WSConfirmarReservaExecute confirma = new sistemastock.ObjectFactory().createWSConfirmarReservaExecute();


            ArrayOfint aux = new ArrayOfint();
            for (ReservaElementoTrabajo resElemTrab : res.getReservaElementoTrabajo()) {
                aux.getItem().add(ConvertirInttoShort.getInstace().convertirInttoShort(resElemTrab.getElementoTrabajo().getcodigosistemaexterno()));
            }
            confirma.setUsuario(user);
            confirma.setPassword(pass);
            confirma.setReserva((short) res.getcodigoreserva()); //nro reserva
            confirma.setBienes(aux);

            WSConfirmarReservaExecuteResponse respuesta = null;
            try {
                respuesta = new sistemastock.WSConfirmarReserva().getWSConfirmarReservaSoapPort().execute(confirma);
            } catch (Exception ex) {
                ExcepcionErrorConexion errCon = new ExcepcionErrorConexion();
                errCon.setMensaje("Error de conexion con el webservice");
                throw errCon;
            }
            System.out.println(respuesta.isFail());
            if(!respuesta.isFail()){
                System.out.println("******** CRONOS WEB SERVICE ******** "
                        + "\n* Reserva confirmada Exitosamente. *"
                        + "\n************************************");
            }else{
                System.out.println("******** CRONOS WEB SERVICE ******** "
                        + "\n* No se pudo realizar la Reserva.  *"
                        + "\n* Contactese con su administrador  *"
                        + "\n* de sistema                       *"
                        + "\n************************************");
            }
            //System.out.println(respuesta.getMensajeerror());

            if (respuesta.isFail()) {
                ExcepcionSistemaStock ex = new ExcepcionSistemaStock();
                ex.setMensaje("No se pudo confirmar la reserva Nº: " + String.valueOf(confirma.getReserva()));
                throw ex;
            }
        }

    }
}
