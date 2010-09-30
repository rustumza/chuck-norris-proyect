/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AdaptadoresSistemaStock;

import Persistencia.Entidades.OrdenTrabajo;
import Persistencia.Entidades.Reserva;
import Persistencia.Entidades.ReservaElementoTrabajo;
import sistemastock.ArrayOfint;
import sistemastock.WSConfirmarReservaExecute;
import sistemastock.WSConfirmarReservaExecuteResponse;



/**
 *
 * @author rustu
 */
public class AdaptadorSistemaStockCronos implements AdaptadorSistemaStock {
    
    final String user="INVITADO";
    final String pass="invitado";

    @Override
    public void confirmarStock(OrdenTrabajo orden) {

        for (Reserva res : orden.getRervas()) {    
            WSConfirmarReservaExecute confirma = new sistemastock.ObjectFactory().createWSConfirmarReservaExecute();

            ArrayOfint aux = new ArrayOfint();
            for (ReservaElementoTrabajo resElemTrab : res.getReservaElementoTrabajo()) {
                aux.getItem().add(resElemTrab.getElementoTrabajo().getcodigosistemaexterno());
                }
            confirma.setUsuario(user);
            confirma.setPassword(pass);
            confirma.setReserva((short) res.getcodigoreserva()); //nro reserva
            confirma.setBienes(aux);

            WSConfirmarReservaExecuteResponse respuesta =
                    new sistemastock.WSConfirmarReserva().getWSConfirmarReservaSoapPort().execute(confirma);

            System.out.println(respuesta.isFail());
            System.out.println(respuesta.getMensajeerror());

            if(respuesta.isFail()){
                //tirar excepcion
            }
    }

}
}
