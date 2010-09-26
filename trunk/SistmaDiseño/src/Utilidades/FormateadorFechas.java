
/*
 * Clase para formatear fechas
 */
package Utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Bicentenario
 */
public class FormateadorFechas {

    private static FormateadorFechas instancia;
    private SimpleDateFormat format_dd_MM_yyyy = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat formatMySQLyyyyMMdd = new  SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat format_yyyy_MM_dd = new SimpleDateFormat("yyyy/MM/dd");

    public static FormateadorFechas getInstancia() {
        if (instancia == null) {
            instancia = new FormateadorFechas();
        }
        return instancia;
    }

    /**
     * @return the format_dd_MM_yyyy
     */
    public SimpleDateFormat getFormat_dd_MM_yyyy() {
        return format_dd_MM_yyyy;
    }

    public SimpleDateFormat getFormat_yyyy_MM_dd() {
        return format_yyyy_MM_dd;
    }

    /**
     * @return the formatMySQLyyyyMMdd
     */
    public SimpleDateFormat getFormatMySQLyyyyMMdd() {
        return formatMySQLyyyyMMdd;
    }

    public Date StringAFecha(String strFecha) throws ParseException {

        Date nuevaFecha = null;

        if (strFecha.split("-").length != 1) {//la fecha ingresada tiene separador "-"
            if (strFecha.split("-")[0].length() == 4) {//la fecha ingresada tiene formato yyyy-MM-dd
                nuevaFecha = formatMySQLyyyyMMdd.parse(strFecha);
            }else{//la fecha ingresada tiene formato dd-MM-yyyy
                nuevaFecha = format_dd_MM_yyyy.parse(strFecha);
            }
        } else if (strFecha.split("/").length !=1) {//la fecha ingresada tiene separador "/"
            if(strFecha.split("/")[0].length() == 4){//la fecha ingresada tiene formatoo yyyy/MM/dd
                nuevaFecha = format_yyyy_MM_dd.parse(strFecha);
            }else{//la fecha ingresada tiene formato dd/MM/yyyy
                nuevaFecha = format_dd_MM_yyyy.parse(strFecha);
            }
        }

        return nuevaFecha;
    }
}
