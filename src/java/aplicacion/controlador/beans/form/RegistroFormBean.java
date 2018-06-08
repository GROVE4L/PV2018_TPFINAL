package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.UsuarioBean;
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
    
    private Usuario usuarioRegistro;
    
    public RegistroFormBean() {
        this.usuarioRegistro = new Usuario();
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
        FacesContext facesContext = FacesContext.getCurrentInstance();
        
        if(existeUsuario) {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Nombre de usuario ya esta registrado.",
                            "Elija otro nombre de usuario."));
        }
        else {
            this.usuarioRegistro.setUsuEstado(true);
            this.usuarioRegistro.setUsuTipoUsuario("final");
            usuarioBean.agregarUsuario(this.usuarioRegistro);
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Usuario Registrado exitosamente!",
                            "Vuelva a la pantalla de inicio para ingresar con su nuevo usuario."));
        }        
    }
}
