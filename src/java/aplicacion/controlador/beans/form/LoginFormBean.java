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
       
    public String deslog() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioValido", null);
        return "login?faces-redirect=true";
    }
    
    public boolean verificarSesion(){ //Verifica si hay alguna sesion activa
        boolean sesionValida = false;
        if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValido") != null){
            sesionValida=true;
        }
        return sesionValida;
    }
       
    public boolean esAdministrativo() { //returna true si la sesion actual es de un Administrativo
        boolean resultado = false;
        if(this.obtenerSesion() != null && this.obtenerSesion().getUsuTipoUsuario().equalsIgnoreCase("administrativo"))
            resultado = true;        
        return resultado;                
    }
    public boolean esSupervisor() { //returna true si la sesion actual es de un Supervisor
        boolean resultado = false;
        if(this.obtenerSesion() != null && this.obtenerSesion().getUsuTipoUsuario().equalsIgnoreCase("supervisor"))
            resultado = true;        
        return resultado;                
    }
    public boolean esFinal() { //returna true si la sesion actual es de un usuario Final
        boolean resultado = false;
        if(this.obtenerSesion() != null && this.obtenerSesion().getUsuTipoUsuario().equalsIgnoreCase("final"))
            resultado = true;        
        return resultado;                
    }        
    public Usuario obtenerSesion() { //Se usa para obtener los atributos del usuario logeado
        return (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValido");
    }
   
    public String validarUsuario() {
        
        Usuario usuarioValidado = usuarioBean.validarUsuario(this.usuarioLogin);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        
        if(usuarioValidado == null) {            
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Usuario no Existe!",
                            "No se encontraron coincidencias."));            
            return null;
        }
        else {
            //VARIABLES DE SESION                        
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioValido", usuarioValidado);            
            //System.out.println("Se puso en sessionMap: ");
            //System.out.println("nombre: "+((Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValido")).getUsuNombreUsuario());
            /////////////////////
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
