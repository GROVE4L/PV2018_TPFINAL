package aplicacion.modelo.dominio;
// Generated 20/06/2018 20:13:14 by Hibernate Tools 4.3.1



/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private Integer usuCodigo;
     private String usuNombreUsuario;
     private String usuPassword;
     private String usuTipoUsuario;
     private boolean usuEstado;

    public Usuario() {
    }

    public Usuario(String usuNombreUsuario, String usuPassword, String usuTipoUsuario, boolean usuEstado) {
       this.usuNombreUsuario = usuNombreUsuario;
       this.usuPassword = usuPassword;
       this.usuTipoUsuario = usuTipoUsuario;
       this.usuEstado = usuEstado;
    }
   
    public Integer getUsuCodigo() {
        return this.usuCodigo;
    }
    
    public void setUsuCodigo(Integer usuCodigo) {
        this.usuCodigo = usuCodigo;
    }
    public String getUsuNombreUsuario() {
        return this.usuNombreUsuario;
    }
    
    public void setUsuNombreUsuario(String usuNombreUsuario) {
        this.usuNombreUsuario = usuNombreUsuario;
    }
    public String getUsuPassword() {
        return this.usuPassword;
    }
    
    public void setUsuPassword(String usuPassword) {
        this.usuPassword = usuPassword;
    }
    public String getUsuTipoUsuario() {
        return this.usuTipoUsuario;
    }
    
    public void setUsuTipoUsuario(String usuTipoUsuario) {
        this.usuTipoUsuario = usuTipoUsuario;
    }
    public boolean isUsuEstado() {
        return this.usuEstado;
    }
    
    public void setUsuEstado(boolean usuEstado) {
        this.usuEstado = usuEstado;
    }




}


