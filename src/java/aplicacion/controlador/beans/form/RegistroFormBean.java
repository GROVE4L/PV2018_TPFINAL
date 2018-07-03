package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.PerfilBean;
import aplicacion.controlador.beans.UsuarioBean;
import aplicacion.modelo.dominio.Perfil;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rojas, Guido G.
 */
@ManagedBean
@ViewScoped
/**
 * clase RegistroFormBean
 */
public class RegistroFormBean implements Serializable{

    @ManagedProperty(value = "#{usuarioBean}")
    private UsuarioBean usuarioBean;
    @ManagedProperty(value = "#{perfilBean}")
    private PerfilBean perfilBean;
    
    
    private Usuario usuarioRegistro;
    private Perfil usuarioPerfil;
    
    public RegistroFormBean() {
        this.usuarioRegistro = new Usuario();
        this.usuarioPerfil = new Perfil();
    }
    /**
     * constructor de  PerfilBean con su get
     * @return 
     */
    public PerfilBean getPerfilBean() {
        return perfilBean;
    }
    /**
     * constructor de PerfilBean con su set
     * @param perfilBean 
     */
    public void setPerfilBean(PerfilBean perfilBean) {
        this.perfilBean = perfilBean;
    }
    /**
     * constructor de UsuarioPerfil con su get
     * @return 
     */
    public Perfil getUsuarioPerfil() {
        return usuarioPerfil;
    }
    /**
     * constructor de UsuarioPerfil con su set
     * @param usuarioPerfil 
     */
    public void setUsuarioPerfil(Perfil usuarioPerfil) {
        this.usuarioPerfil = usuarioPerfil;
    }
    /**
     * constructor de UsuarioRegistro con su get
     * @return 
     */
    public Usuario getUsuarioRegistro() {
        return usuarioRegistro;
    }
    /**
     * constructor de UsuarioRegistro con su set
     * @param usuarioRegistro 
     */
    public void setUsuarioRegistro(Usuario usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }   
    /**
     * constructor de UsuarioBean con su get
     * @return 
     */
    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }
    /**
     * constructor de UsuarioBean con su set
     * @param usuarioBean 
     */
    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }
     /**
      * procedimiento llamado registrarUsuario
      * en el cual se prodra registrar el usuario y comprovar que el usuario no este registrado anteriormente
      */     
    public void registrarUsuario() {
        boolean existeUsuario = usuarioBean.buscarUsuario(this.usuarioRegistro);
        boolean existePerfil = perfilBean.buscarPerfil(this.usuarioPerfil);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if(existeUsuario || existePerfil)
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Este usuario ya esta registrado.",
                            "Elija otro nombre de usuario."));        
        else 
        {
            this.usuarioRegistro.setUsuEstado(true);
            this.usuarioRegistro.setUsuTipoUsuario("final");
            usuarioBean.agregarUsuario(this.usuarioRegistro);            
            int codigo = usuarioBean.obtenerCodigoUsuario(this.usuarioRegistro); //Obtener codigo de usuario
            //para guardarlo en el perfil. Relación.
            
            this.usuarioPerfil.setPerUsuario(codigo);
            perfilBean.agregarPerfil(this.usuarioPerfil);
            
            this.usuarioRegistro = new Usuario();
            this.usuarioPerfil = new Perfil();
            
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Usuario Registrado exitosamente!",
                            "Vuelva a la pantalla de inicio para ingresar con su nuevo usuario."));
        }
    }
}
