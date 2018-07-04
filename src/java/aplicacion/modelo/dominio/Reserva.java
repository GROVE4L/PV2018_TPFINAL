package aplicacion.modelo.dominio;
// Generated 24/06/2018 14:09:26 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Reserva generated by hbm2java
 */
public class Reserva  implements java.io.Serializable {


     private Integer revCodigo;
     private Date revFechaEmision;
     private Date revFechaTurno;
     private boolean revEstado;
     private int revPerfil;

    public Reserva() {
    }
    /**
     * 
     * @param revFechaEmision
     * @param revFechaTurno
     * @param revEstado
     * @param revPerfil 
     */
    public Reserva(Date revFechaEmision, Date revFechaTurno, boolean revEstado, int revPerfil) {
       this.revFechaEmision = revFechaEmision;
       this.revFechaTurno = revFechaTurno;
       this.revEstado = revEstado;
       this.revPerfil = revPerfil;
    }
    /**
     *  constructor de RevCodigo con su get
     * @return 
     */
    public Integer getRevCodigo() {
        return this.revCodigo;
    }
    /**
     * constructor de RevCodigo con su set
     * @param revCodigo 
     */
    public void setRevCodigo(Integer revCodigo) {
        this.revCodigo = revCodigo;
    }
    /**
     * constructor de RevFechaEmision con su get
     * @return 
     */
    public Date getRevFechaEmision() {
        return this.revFechaEmision;
    }
    /**
     * constructor de RevFechaEmision con su set
     * @param revFechaEmision 
     */
    public void setRevFechaEmision(Date revFechaEmision) {
        this.revFechaEmision = revFechaEmision;
    }
    /**
     * constructor de RevFechaTurno con su get
     * @return 
     */
    public Date getRevFechaTurno() {
        return this.revFechaTurno;
    }
    /**
     * constructor de RevFechaTurno con su set
     * @param revFechaTurno 
     */
    public void setRevFechaTurno(Date revFechaTurno) {
        this.revFechaTurno = revFechaTurno;
    }
    /**
     * constructor de RevEstado
     * @return 
     */
    public boolean isRevEstado() {
        return this.revEstado;
    }
    /**
     * constructor de RevEstado con su set
     * @param revEstado 
     */
    public void setRevEstado(boolean revEstado) {
        this.revEstado = revEstado;
    }
    /**
     * constructor de RevPerfil con su get
     * @return 
     */
    public int getRevPerfil() {
        return this.revPerfil;
    }
    /**
     * constructor de RevPerfil con su get
     * @param revPerfil 
     */
    public void setRevPerfil(int revPerfil) {
        this.revPerfil = revPerfil;
    }




}


