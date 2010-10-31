/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Entidades;

/**
 *
 * @author diego
 */
public interface Operador extends SuperDruperInterfaz {

    public String getlegajo();

    public String getnombreOperador();

    public void setlegajo(String newVal);

    public void setnombreOperador(String newVal);

    public TipoOperador getTipoOperador();

    public void setTipoOperador(TipoOperador tipoOperador);

    public Usuario getUsuario();

    public void setUsuario(Usuario usuario);




}
