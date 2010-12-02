
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

    public String formatearAMySql(Date fecha){

        String fechaFormateada = formatMySQLyyyyMMdd.format(fecha);

        return  fechaFormateada;

    }

    /**
     * Compara 2 fechas ingresadas
     * @return Regresa -1 si fecha1 es  mayor a fecha2. Regresa 1 si fecha2 es mayor a fecha1. Regresa 0 si son iguales
     * 
     * 
     */
    public int compararFechas(Date fecha1, Date fecha2){
        int resultado = 0;
        if(fecha1.getYear() < fecha2.getYear()){
            resultado = 1;
        }else if(fecha1.getYear() > fecha2.getYear()){
            resultado = -1;
        }else if(fecha1.getYear() == fecha2.getYear()){
            if(fecha1.getMonth() < fecha2.getMonth()){
                resultado = 1;
            }else if(fecha1.getMonth() > fecha2.getMonth()){
                resultado = -1;
            }else if(fecha1.getMonth() == fecha2.getMonth()){
                if(fecha1.getDay() < fecha2.getDay()){
                    resultado = 1;
                }else if(fecha1.getDay() > fecha2.getDay()){
                    resultado = -1;
                }else if(fecha1.getDay() == fecha2.getDay()){
                    resultado = 0;
                }
            }
        }
        return resultado;
    }
}
