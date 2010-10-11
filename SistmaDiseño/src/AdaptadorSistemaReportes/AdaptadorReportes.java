/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AdaptadorSistemaReportes;

import DTO.DTOOrden;
import Utilidades.WorkingDirectory;
import java.util.HashMap;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author diego
 */
public class AdaptadorReportes {

    private String directorioReporteOrdenRep = WorkingDirectory.getPath().split("build")[0] + "/Reportes/OrdenDeReparacionConSubReportes.jasper";
    private String directorioReporteOrdenMant = WorkingDirectory.getPath().split("build")[0] + "/Reportes/OrdenDeMantenimientoConSubReportes.jasper";

    public void generarReporteReparacion(List<DTOOrden> listaOrdenesRep) {

        System.out.println(WorkingDirectory.getPath());
        String fileName = WorkingDirectory.getPath().split("build")[0] + "/Reportes/OrdenDeReparacionConSubReportes.jasper";

        HashMap param = new HashMap();

        OrdenesReparacionDataSource dsOrdenes = new OrdenesReparacionDataSource();
        dsOrdenes.addAllOrden(listaOrdenesRep);



        try {
            // llenamos el reporte con un origen de datos vacio donde le pasamos como argumentos
            //el nombre del archvios jasper, el hasmap y una JREMptyDataSource que especifica que no habra conexion a
            // base de datos
            //JasperPrint print = JasperFillManager.fillReport(fileName, param, new JREmptyDataSource());
            JasperPrint print = JasperFillManager.fillReport(fileName, param, dsOrdenes);

            //lanzamos ej jasper viewer recibiendo coo argumento el informe y un valor boolenano para indicar
            // que una vez cerrado el visor, no termine la aplicacion principal
            JasperViewer jviewer = new JasperViewer(print, false);

            //Establecemos el titulo del visor
            jviewer.setTitle("OrdenReparacion");
            jviewer.setVisible(true);

        } catch (JRException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public void generarReportes(List<DTOOrden> listaOrdenesRep) {


        HashMap param = new HashMap();

        OrdenesReparacionDataSource dsOrdenesRep = new OrdenesReparacionDataSource();
        OrdenesMantenimientoDataSource dsOrdenesMant = new OrdenesMantenimientoDataSource();

        for (DTOOrden dTOOrden : listaOrdenesRep) {
            if (dTOOrden.getTipo().equals("REPARACION")) {
                dsOrdenesRep.addOrden(dTOOrden);
            } else {
                dsOrdenesMant.addOrden(dTOOrden);
            }
        }

        try {
            // llenamos el reporte con un origen de datos vacio donde le pasamos como argumentos
            //el nombre del archvios jasper, el hasmap y una JREMptyDataSource que especifica que no habra conexion a
            // base de datos
            //JasperPrint print = JasperFillManager.fillReport(fileName, param, new JREmptyDataSource());
            if (!dsOrdenesRep.isVacio()) {
                JasperPrint printReparacion = JasperFillManager.fillReport(directorioReporteOrdenRep, param, dsOrdenesRep);
                //lanzamos ej jasper viewer recibiendo como argumento el informe y un valor boolenano para indicar
                // que una vez cerrado el visor, no termine la aplicacion principal
                JasperViewer jviewerReparacion = new JasperViewer(printReparacion, false);
                //Establecemos el titulo del visor
                jviewerReparacion.setTitle("OrdenReparacion");
                jviewerReparacion.setVisible(true);
            }

            if (!dsOrdenesMant.isVacio()) {
                JasperPrint printMantenimiento = JasperFillManager.fillReport(directorioReporteOrdenMant, param, dsOrdenesMant);
                //lanzamos ej jasper viewer recibiendo como argumento el informe y un valor boolenano para indicar
                // que una vez cerrado el visor, no termine la aplicacion principal
                JasperViewer jviewerMantenimiento = new JasperViewer(printMantenimiento, false);
                //Establecemos el titulo del visor
                jviewerMantenimiento.setTitle("Ordenes Mantenimiento");
                jviewerMantenimiento.setVisible(true);
            }

        } catch (JRException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}
