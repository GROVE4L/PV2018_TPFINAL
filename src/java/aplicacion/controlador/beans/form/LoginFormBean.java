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
public class LoginFormBean implements Serializable{

    @ManagedProperty(value = "#{usuarioBean}")
    private UsuarioBean usuarioBean;
    
    private Usuario usuarioLogin;
    
    public LoginFormBean() {
        this.usuarioLogin = new Usuario();
    }

    public Usuario getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(Usuario usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }   

    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }
        
    public String validarUsuario() {
        
        Usuario usuarioValidado = usuarioBean.validarUsuario(this.usuarioLogin);
        System.out.println("LINEA 1");
        FacesContext facesContext = FacesContext.getCurrentInstance();        
        System.out.println("LINEA 2");
        
        if(usuarioValidado == null) {            
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Usuario no Existe!",
                            "No se encontraron coincidencias."));
            return null;
        }
        else {
            switch(usuarioValidado.getUsuTipoUsuario()) {
                case "administrativo": facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Usuario SI existe",
                            "Este usuario es Administrador"));
                return "usuarioAdministrador?faces-redirect=true";                
                case "supervisor": facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Usuario SI existe",
                            "Este usuario es Supervisor")); 
                return "usuarioSupervisor?faces-redirect=true";
                case "final": facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Usuario SI existe",
                            "Este usuario es Común")); 
                return "usuarioComun?faces-redirect=true";
                default: facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Usuario SI existe",
                            "Este ususario es Indeterminado")); 
                return null;
            }
        }
    }
}
