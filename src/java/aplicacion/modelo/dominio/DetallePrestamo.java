package aplicacion.modelo.dominio;
// Generated 20/06/2018 20:13:14 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * DetallePrestamo generated by hbm2java
 */
public class DetallePrestamo  implements java.io.Serializable {


     private Integer dpCodigo;
     private boolean dpEstado;
     private Date dpFechaADevolver;
     private String dpTurno;
     private Date dpFechaDevolucion;
     private int dpPrestamo;
     private String dpPublicacion;

    public DetallePrestamo() {
    }

    public DetallePrestamo(boolean dpEstado, Date dpFechaADevolver, String dpTurno, Date dpFechaDevolucion, int dpPrestamo, String dpPublicacion) {
       this.dpEstado = dpEstado;
       this.dpFechaADevolver = dpFechaADevolver;
       this.dpTurno = dpTurno;
       this.dpFechaDevolucion = dpFechaDevolucion;
       this.dpPrestamo = dpPrestamo;
       this.dpPublicacion = dpPublicacion;
    }
   
    public Integer getDpCodigo() {
        return this.dpCodigo;
    }
    
    public void setDpCodigo(Integer dpCodigo) {
        this.dpCodigo = dpCodigo;
    }
    public boolean isDpEstado() {
        return this.dpEstado;
    }
    
    public void setDpEstado(boolean dpEstado) {
        this.dpEstado = dpEstado;
    }
    public Date getDpFechaADevolver() {
        return this.dpFechaADevolver;
    }
    
    public void setDpFechaADevolver(Date dpFechaADevolver) {
        this.dpFechaADevolver = dpFechaADevolver;
    }
    public String getDpTurno() {
        return this.dpTurno;
    }
    
    public void setDpTurno(String dpTurno) {
        this.dpTurno = dpTurno;
    }
    public Date getDpFechaDevolucion() {
        return this.dpFechaDevolucion;
    }
    
    public void setDpFechaDevolucion(Date dpFechaDevolucion) {
        this.dpFechaDevolucion = dpFechaDevolucion;
    }
    public int getDpPrestamo() {
        return this.dpPrestamo;
    }
    
    public void setDpPrestamo(int dpPrestamo) {
        this.dpPrestamo = dpPrestamo;
    }
    public String getDpPublicacion() {
        return this.dpPublicacion;
    }
    
    public void setDpPublicacion(String dpPublicacion) {
        this.dpPublicacion = dpPublicacion;
    }




}

