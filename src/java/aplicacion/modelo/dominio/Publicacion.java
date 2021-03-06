package aplicacion.modelo.dominio;
// Generated 24/06/2018 14:09:26 by Hibernate Tools 4.3.1



/**
 * Publicacion generated by hbm2java
 */
public class Publicacion  implements java.io.Serializable {


     private String pubCodigo;
     private String pubNombre;
     private String pubResumen;
     private boolean pubEstado;
     private String pubTipo;
     private int pubStock;
     private int pubEditorial;

    public Publicacion() {
    }
    /**
     * 
     * @param pubCodigo
     * @param pubNombre
     * @param pubEstado
     * @param pubTipo
     * @param pubStock
     * @param pubEditorial 
     */
	
    public Publicacion(String pubCodigo, String pubNombre, boolean pubEstado, String pubTipo, int pubStock, int pubEditorial) {
        this.pubCodigo = pubCodigo;
        this.pubNombre = pubNombre;
        this.pubEstado = pubEstado;
        this.pubTipo = pubTipo;
        this.pubStock = pubStock;
        this.pubEditorial = pubEditorial;
    }
    public Publicacion(String pubCodigo, String pubNombre, String pubResumen, boolean pubEstado, String pubTipo, int pubStock, int pubEditorial) {
       this.pubCodigo = pubCodigo;
       this.pubNombre = pubNombre;
       this.pubResumen = pubResumen;
       this.pubEstado = pubEstado;
       this.pubTipo = pubTipo;
       this.pubStock = pubStock;
       this.pubEditorial = pubEditorial;
    }
    /**
     * constructor de PubCodigo con su get
     * @return 
     */
    public String getPubCodigo() {
        return this.pubCodigo;
    }
    /**
     * constructor de PubCodigo con su set
     * @param pubCodigo 
     */
    public void setPubCodigo(String pubCodigo) {
        this.pubCodigo = pubCodigo;
    }
    /**
     * constructor de PubNombre con su get
     * @return 
     */
    public String getPubNombre() {
        return this.pubNombre;
    }
    /**
     *  constructor de PubNombre con su set
     * @param pubNombre 
     */
    public void setPubNombre(String pubNombre) {
        this.pubNombre = pubNombre;
    }
    /**
     *  constructor de PubResumen con su get
     * @return 
     */
    public String getPubResumen() {
        return this.pubResumen;
    }
    /**
     *  constructor de PubResumen con su get
     * @param pubResumen 
     */
    public void setPubResumen(String pubResumen) {
        this.pubResumen = pubResumen;
    }
    /**
     *  constructor de PubEstado
     * @return 
     */
    public boolean isPubEstado() {
        return this.pubEstado;
    }
    /**
     *  constructor de PubEstado con su set
     * @param pubEstado 
     */
    public void setPubEstado(boolean pubEstado) {
        this.pubEstado = pubEstado;
    }
    /**
     *  constructor de PubTipo con su get
     * @return 
     */
    public String getPubTipo() {
        return this.pubTipo;
    }
    /**
     *  constructor de PubTipo con su set
     * @param pubTipo 
     */
    public void setPubTipo(String pubTipo) {
        this.pubTipo = pubTipo;
    }
    /**
     *  constructor de PubStock con su get
     * @return 
     */
    public int getPubStock() {
        return this.pubStock;
    }
    /**
     *  constructor de PubStock con su set
     * @param pubStock 
     */
    public void setPubStock(int pubStock) {
        this.pubStock = pubStock;
    }
    /**
     *  constructor de PubEditorial con su get
     * @return 
     */
    public int getPubEditorial() {
        return this.pubEditorial;
    }
    /**
     *  constructor de PubEditorial con su set
     * @param pubEditorial 
     */
    public void setPubEditorial(int pubEditorial) {
        this.pubEditorial = pubEditorial;
    }




}


