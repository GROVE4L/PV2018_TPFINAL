package aplicacion.modelo.dominio;
// Generated 14/06/2018 00:50:07 by Hibernate Tools 4.3.1



/**
 * Clasificacion generated by hbm2java
 */
public class Clasificacion  implements java.io.Serializable {


     private Integer claCodigo;
     private int claIdentificador;
     private String claDescripcion;

    public Clasificacion() {
    }

    public Clasificacion(int claIdentificador, String claDescripcion) {
       this.claIdentificador = claIdentificador;
       this.claDescripcion = claDescripcion;
    }
   
    public Integer getClaCodigo() {
        return this.claCodigo;
    }
    
    public void setClaCodigo(Integer claCodigo) {
        this.claCodigo = claCodigo;
    }
    public int getClaIdentificador() {
        return this.claIdentificador;
    }
    
    public void setClaIdentificador(int claIdentificador) {
        this.claIdentificador = claIdentificador;
    }
    public String getClaDescripcion() {
        return this.claDescripcion;
    }
    
    public void setClaDescripcion(String claDescripcion) {
        this.claDescripcion = claDescripcion;
    }




}


