package Persistencia.Entidades;

/**
 * @author Bicentenario
 * @version 1.0
 * @created 14-Sep-2010 06:52:12 p.m.
 */
public class DenuncianteImplementacion implements Denunciante{

	private String celular;
	private String domicilio;
	private String email;
	private String telefonofijo;
	private PersonaPadron personaPadron;
        private boolean estadoBaja;

        

	public DenuncianteImplementacion(){
    }

    public String getcelular() {
        return celular;
    }

    public String getdomicilio() {
        return domicilio;
    }

    public String getemail() {
        return email;
    }

    public String gettelefonofijo() {
        return telefonofijo;
    }

    /**
     *
     * @param newVal
     */
    public void setcelular(String newVal) {
        celular = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void setdomicilio(String newVal) {
        domicilio = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void setemail(String newVal) {
        email = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void settelefonofijo(String newVal) {
        telefonofijo = newVal;
    }

    /**
     * @return the personaPadron
     */
    public PersonaPadron getPersonaPadron() {
        return personaPadron;
    }

    /**
     * @param personaPadron the personaPadron to set
     */
    public void setPersonaPadron(PersonaPadron personaPadron) {
        this.personaPadron = personaPadron;
    }

    /**
     * @return the estadoBaja
     */
    public boolean isEstadoBaja() {
        return estadoBaja;
    }

    /**
     * @param estadoBaja the estadoBaja to set
     */
    public void setEstadoBaja(boolean estadoBaja) {
        this.estadoBaja = estadoBaja;
    }

}
