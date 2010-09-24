package Persistencia.Entidades;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author diego
 */
public class FallaTecnicaAgente extends TrabajoAgente implements FallaTecnica{

    public int getcodigoFallaTecnica() {
        return ((FallaTecnicaImplementacion)super.getImplementacion()).getcodigoFallaTecnica();
    }

    public String getdescripcionfalla() {
        return ((FallaTecnicaImplementacion)super.getImplementacion()).getdescripcionfalla();
    }

    public void setcodigoFallaTecnica(int newVal) {
        ((FallaTecnicaImplementacion)super.getImplementacion()).setcodigoFallaTecnica(newVal);
    }

    public void setdescripcionfalla(String newVal) {
        ((FallaTecnicaImplementacion)super.getImplementacion()).setdescripcionfalla(newVal);
    }

}
