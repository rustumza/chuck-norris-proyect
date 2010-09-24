package Persistencia.Entidades;

import java.util.Date;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:18 p.m.
 */
public class TrabajadorRolImplementacion implements TrabajadorRol {

    private Date fechafinrol;
    private Date fechainiciorol;
    private Rol rol;
    private Trabajador trabajador;

    public TrabajadorRolImplementacion() {
    }

    public Date getfechafinrol() {
        return fechafinrol;
    }

    public Date getfechainiciorol() {
        return fechainiciorol;
    }

    /**
     *
     * @param newVal
     */
    public void setfechafinrol(Date newVal) {
        fechafinrol = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void setfechainiciorol(Date newVal) {
        fechainiciorol = newVal;
    }

    /**
     * @return the rol
     */
    public Rol getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    /**
     * @return the trabajador
     */
    public Trabajador getTrabajador() {
        return trabajador;
    }

    /**
     * @param trabajador the trabajador to set
     */
    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }
}
