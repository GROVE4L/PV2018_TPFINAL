package aplicacion.modelo.dominio;
// Generated 24/06/2018 14:09:26 by Hibernate Tools 4.3.1



/**
 * PublicacionAutor generated by hbm2java
 */
public class PublicacionAutor  implements java.io.Serializable {


     private Integer paCodigo;
     private boolean paEstado;
     private String paUblicacion;
     private int paAutor;

    public PublicacionAutor() {
    }

    public PublicacionAutor(boolean paEstado, String paUblicacion, int paAutor) {
       this.paEstado = paEstado;
       this.paUblicacion = paUblicacion;
       this.paAutor = paAutor;
    }
   
    public Integer getPaCodigo() {
        return this.paCodigo;
    }
    
    public void setPaCodigo(Integer paCodigo) {
        this.paCodigo = paCodigo;
    }
    public boolean isPaEstado() {
        return this.paEstado;
    }
    
    public void setPaEstado(boolean paEstado) {
        this.paEstado = paEstado;
    }
    public String getPaUblicacion() {
        return this.paUblicacion;
    }
    
    public void setPaUblicacion(String paUblicacion) {
        this.paUblicacion = paUblicacion;
    }
    public int getPaAutor() {
        return this.paAutor;
    }
    
    public void setPaAutor(int paAutor) {
        this.paAutor = paAutor;
    }




}


