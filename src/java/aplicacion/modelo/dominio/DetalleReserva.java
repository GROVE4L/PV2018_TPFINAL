package aplicacion.modelo.dominio;
// Generated 24/06/2018 14:09:26 by Hibernate Tools 4.3.1



/**
 * DetalleReserva generated by hbm2java
 */
public class DetalleReserva  implements java.io.Serializable {


     private Integer drevCodigo;
     private int drevCantidad;
     private boolean drevEstado;
     private int drevReserva;
     private String drevPublicacion;

    public DetalleReserva() {
    }

    public DetalleReserva(int drevCantidad, boolean drevEstado, int drevReserva, String drevPublicacion) {
       this.drevCantidad = drevCantidad;
       this.drevEstado = drevEstado;
       this.drevReserva = drevReserva;
       this.drevPublicacion = drevPublicacion;
    }
   
    public Integer getDrevCodigo() {
        return this.drevCodigo;
    }
    
    public void setDrevCodigo(Integer drevCodigo) {
        this.drevCodigo = drevCodigo;
    }
    public int getDrevCantidad() {
        return this.drevCantidad;
    }
    
    public void setDrevCantidad(int drevCantidad) {
        this.drevCantidad = drevCantidad;
    }
    public boolean isDrevEstado() {
        return this.drevEstado;
    }
    
    public void setDrevEstado(boolean drevEstado) {
        this.drevEstado = drevEstado;
    }
    public int getDrevReserva() {
        return this.drevReserva;
    }
    
    public void setDrevReserva(int drevReserva) {
        this.drevReserva = drevReserva;
    }
    public String getDrevPublicacion() {
        return this.drevPublicacion;
    }
    
    public void setDrevPublicacion(String drevPublicacion) {
        this.drevPublicacion = drevPublicacion;
    }




}


