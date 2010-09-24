package Persistencia.ExpertosPersistencia;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */




import java.util.UUID;

/**
 *
 * @author diego
 */
public class generadorOid {

    static generadorOid goid = null;

    private  generadorOid() {
    }

    public static generadorOid getInstance(){
        if(goid==null)
            goid = new generadorOid();

        return goid;
    }

    public String generarOid(){

        String oid = UUID.randomUUID().toString();
        
        return oid;
    }
}
