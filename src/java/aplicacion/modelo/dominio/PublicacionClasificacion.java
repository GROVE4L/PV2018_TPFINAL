package aplicacion.modelo.dominio;
// Generated 19/06/2018 01:06:40 by Hibernate Tools 4.3.1



/**
 * PublicacionClasificacion generated by hbm2java
 */
public class PublicacionClasificacion  implements java.io.Serializable {


     private Integer pcCodigo;
     private boolean pcEstado;
     private String pcPublicacion;
     private int pcClasificacion;

    public PublicacionClasificacion() {
    }

    public PublicacionClasificacion(boolean pcEstado, String pcPublicacion, int pcClasificacion) {
       this.pcEstado = pcEstado;
       this.pcPublicacion = pcPublicacion;
       this.pcClasificacion = pcClasificacion;
    }
   
    public Integer getPcCodigo() {
        return this.pcCodigo;
    }
    
    public void setPcCodigo(Integer pcCodigo) {
        this.pcCodigo = pcCodigo;
    }
    public boolean isPcEstado() {
        return this.pcEstado;
    }
    
    public void setPcEstado(boolean pcEstado) {
        this.pcEstado = pcEstado;
    }
    public String getPcPublicacion() {
        return this.pcPublicacion;
    }
    
    public void setPcPublicacion(String pcPublicacion) {
        this.pcPublicacion = pcPublicacion;
    }
    public int getPcClasificacion() {
        return this.pcClasificacion;
    }
    
    public void setPcClasificacion(int pcClasificacion) {
        this.pcClasificacion = pcClasificacion;
    }




}


