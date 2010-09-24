/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AdaptadoresSistemaStock;


/*
import com.sun.org.apache.bcel.internal.Constants;
import com.sun.xml.internal.ws.wsdl.writer.document.Fault;
import java.net.*;
import java.util.*;

// Clases que guardan relación con el mensaje
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.soap.SOAPException;
import javax.xml.ws.Response;
import org.apache.soap.*;
// Clases que guardan relación con las llamadas
import org.apache.soap.rpc.*;
import org.omg.Dynamic.Parameter;

import java.net.*;
import java.util.*;

// Clases que guardan relación con el mensaje
import org.apache.soap.*;
// Clases que guardan relación con las llamadas
import org.apache.soap.rpc.*;
/**
 *
 * @author rustu
 */
public class AdaptadorSistemaStockCronos implements AdaptadorSistemaStock {
    
    final String user="INVITADO";
    final String pass="invitado";

    public boolean confirmarStock(int codigoReserva, int[] codigosBienes) {
        /*
            // Dirección del servicio de Apache SOAP
            URL url=null;
            try {
                url = new URL("http://www.frm.utn.edu.ar:8080/cronossistemastock/servlet/awsconfirmarreserva?wsdl");
            } catch (MalformedURLException ex) {
                Logger.getLogger(AdaptadorSistemaStockCronos.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Identificador del servicio. Proporcionado
            // al desplegar este
            String urn = "urn:"+user+":"+pass;
            // Prepara invocacion del servicio
            Call call = new Call();
            call.setTargetObjectURI(urn);
            //call.setMethodName( "getRate" );
            call.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
            // Parametros
            Vector params = new Vector();
            int[] bienes = new int[3];
            bienes[0] = 1;
            bienes[1] = 2;
            bienes[2] = 3;
            params.addElement(new Parameter("ResNro", int.class, 1, null));
            params.addElement(new Parameter("Bienes", int[].class, bienes, null));
            call.setParams(params);
            try {
                System.out.println("invocamos service\n" + " URL= " + url + "\n URN =" + urn);
                // invocamos
                Response response = call.invoke(url, "");
                // Hay fallo?
                if (!response.generatedFault()) {
                    // NO HAY FALLO
                    Parameter result = response.getReturnValue();
                    System.out.println("Result= " + result.getValue());
                } else {
                    // HAY FALLO
                    Fault f = response.getFault();
                    System.err.println("Fault= " + f.getFaultCode() + ", " + f.getFaultString());
                }
            } // La llamada ha tenido problemas
            catch (SOAPException e) {
                System.err.println(
                        "SOAPException= " + e.getFaultCode() + ", " + e.getMessage());
            }
*/
        return false;
    }
}
