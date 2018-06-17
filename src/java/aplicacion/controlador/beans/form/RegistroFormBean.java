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

    public PerfilBean getPerfilBean() {
        return perfilBean;
    }

    public void setPerfilBean(PerfilBean perfilBean) {
        this.perfilBean = perfilBean;
    }

    public Perfil getUsuarioPerfil() {
        return usuarioPerfil;
    }

    public void setUsuarioPerfil(Perfil usuarioPerfil) {
        this.usuarioPerfil = usuarioPerfil;
    }

    public Usuario getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(Usuario usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }   

    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }
        
    public void registrarUsuario() {
        boolean existeUsuario = usuarioBean.buscarUsuario(this.usuarioRegistro);
        boolean existePerfil = perfilBean.buscarPerfil(this.usuarioPerfil);
        FacesContext facesContext = FacesContext.getCurrentInstance();        
        System.out.println("El usuario Existe?: "+existeUsuario);
        System.out.println("El perfil existe?: "+existePerfil);
        System.out.println("El perfil existe?: "+usuarioPerfil.getPerDni().getClass());
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
            
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Usuario Registrado exitosamente!",
                            "Vuelva a la pantalla de inicio para ingresar con su nuevo usuario."));
        }
    }
}
