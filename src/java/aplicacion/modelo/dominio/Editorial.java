package aplicacion.modelo.dominio;
// Generated 18/06/2018 18:30:26 by Hibernate Tools 4.3.1



/**
 * Editorial generated by hbm2java
 */
public class Editorial  implements java.io.Serializable {


     private Integer ediCodigo;
     private String editNombre;
     private boolean editEstado;

    public Editorial() {
    }

    public Editorial(String editNombre, boolean editEstado) {
       this.editNombre = editNombre;
       this.editEstado = editEstado;
    }
   
    public Integer getEdiCodigo() {
        return this.ediCodigo;
    }
    
    public void setEdiCodigo(Integer ediCodigo) {
        this.ediCodigo = ediCodigo;
    }
    public String getEditNombre() {
        return this.editNombre;
    }
    
    public void setEditNombre(String editNombre) {
        this.editNombre = editNombre;
    }
    public boolean isEditEstado() {
        return this.editEstado;
    }
    
    public void setEditEstado(boolean editEstado) {
        this.editEstado = editEstado;
    }




}


