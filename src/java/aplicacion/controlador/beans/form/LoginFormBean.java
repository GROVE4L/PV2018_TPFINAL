package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.PerfilBean;
import aplicacion.controlador.beans.UsuarioBean;
import aplicacion.modelo.dominio.Perfil;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.List;
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
 * clase LoginFormBean
 */
public class LoginFormBean implements Serializable{

    @ManagedProperty(value = "#{usuarioBean}")
    private UsuarioBean usuarioBean;
    
    @ManagedProperty(value = "#{perfilBean}")
    private PerfilBean perfilBean;
    
    private Usuario usuarioLogin;
    private Usuario usuarioLoginSeleccionado;
    private Perfil perfilLoginSeleccionado;

    public LoginFormBean() {
        this.usuarioLogin = new Usuario();
        this.usuarioLoginSeleccionado = new Usuario();
        this.perfilLoginSeleccionado = new Perfil();
    }
    /**
     * constructor de PerfilLoginSeleccionado con su get
     * @return 
     */
    public Perfil getPerfilLoginSeleccionado() {
        return perfilLoginSeleccionado;
    }
    /**
     * constructor de PerfilLoginSeleccionado con su set
     * @param perfilLoginSeleccionado 
     */
    public void setPerfilLoginSeleccionado(Perfil perfilLoginSeleccionado) {
        this.perfilLoginSeleccionado = perfilLoginSeleccionado;
    }

    /**
     * constructor de PerfilBean con su get
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
     * constructor de UsuarioLoginSeleccionado con su get
     * @return 
     */
    public Usuario getUsuarioLoginSeleccionado() {
        return usuarioLoginSeleccionado;
    }
    /**
     * constructor de AutorSeleccionado con su get
     * @param usuarioLoginSeleccionado 
     */
    public void setUsuarioLoginSeleccionado(Usuario usuarioLoginSeleccionado) {
        this.usuarioLoginSeleccionado = usuarioLoginSeleccionado;
    }

    /**
     * constructor de UsuarioLogin con su get
     * @return 
     */
    public Usuario getUsuarioLogin() {
        return usuarioLogin;
    }
    /**
     * constructor de UsuarioLogin con su set
     * @param usuarioLogin 
     */
    public void setUsuarioLogin(Usuario usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
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
     * deslog
     * @return 
     */   
    public String deslog() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioValido", null);
        return "login?faces-redirect=true";
    }
    /**
     * lista perfil
     * obtencion de perfiles
     * @return 
     */
    public List<Perfil> obtenerPerfiles() {
        return perfilBean.obtenerPerfiles();
    }
    /**
     * verficacion de reserva
     * @return 
     */
    
    public boolean verificarReserva(){
        boolean sesionValida = false;
        if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("reserva") != null){
            sesionValida=true;
        }
        return sesionValida;
    }
    /**
     * verificacion de prestamo
     * @return 
     */
    public boolean verificarPrestamo(){
        boolean sesionValida = false;
        if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("prestamo") != null){
            sesionValida=true;
        }
        return sesionValida;
    }
    /**
     * verificacion de sesion 
     * @return 
     */
    public boolean verificarSesion(){ //Verifica si hay alguna sesion activa
        boolean sesionValida = false;
        if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValido") != null){
            sesionValida=true;
        }
        return sesionValida;
    }
    /**
     * muestra si la sesion actual es de un Administrador
     * @return 
     */   
    public boolean esAdministrativo() { //returna true si la sesion actual es de un Administrativo
        boolean resultado = false;
        if(this.obtenerSesion() != null && this.obtenerSesion().getUsuTipoUsuario().equalsIgnoreCase("administrativo"))
            resultado = true;        
        return resultado;                
    }
    /**
     * muestra si la sesion actual es de un supervisor
     * @return 
     */
    public boolean esSupervisor() { //returna true si la sesion actual es de un Supervisor
        boolean resultado = false;
        if(this.obtenerSesion() != null && this.obtenerSesion().getUsuTipoUsuario().equalsIgnoreCase("supervisor"))
            resultado = true;        
        return resultado;                
    }
    /**
     * muestra si la sesion actual es de un usuario Final
     * @return 
     */
    public boolean esFinal() { //returna true si la sesion actual es de un usuario Final
        boolean resultado = false;
        if(this.obtenerSesion() != null && this.obtenerSesion().getUsuTipoUsuario().equalsIgnoreCase("final"))
            resultado = true;        
        return resultado;                
    }  
    /**
     * se usa para obtener los atributos del usuario logeado
     * @return 
     */
    public Usuario obtenerSesion() { //Se usa para obtener los atributos del usuario logeado
        return (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValido");
    }
    /**
     * se usa para obtener los atributos del perfil logeado
     * @return 
     */
    public Perfil obtenerPerfilSesion() { //Se usa para obtener los atributos del perfil logeado
        PerfilBean pBean = new PerfilBean();
        return pBean.obtenerPerfil(this.obtenerSesion().getUsuCodigo());
    }
    /**
     * procedimiento recibirUsuario
     * en el cual recibe un usuario
     * @param u 
     */
    public void recibirUsuario(Usuario u) {
        int codigoUsuario = usuarioBean.obtenerCodigoUsuario(u);
        this.usuarioLoginSeleccionado = u;
        this.perfilLoginSeleccionado = perfilBean.obtenerPerfil(codigoUsuario);
    }
    /**
     * actualiza el rango del Usuario
     * @return 
     */
    public String actualizarRangoUsuario() {
        FacesContext facesContext = FacesContext.getCurrentInstance();        
        usuarioBean.actualizarUsuario(this.usuarioLoginSeleccionado);            
        perfilBean.actualizarPerfil(this.perfilLoginSeleccionado);
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Usuario Actualizado",""));
        if(this.usuarioLoginSeleccionado.getUsuCodigo().equals(this.obtenerSesion().getUsuCodigo())) { //Si se suicida xD
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioValido", null);
            return "login?faces-redirect=true";
        }
        else
            return null;
    }
    /**
     * procedimiento llamado actualizarUsuario
     * en el cual se actualiza el usuario
     */
    public void actualizarUsuario() {
        FacesContext facesContext = FacesContext.getCurrentInstance();        
        usuarioBean.actualizarUsuario(this.usuarioLoginSeleccionado);            
        perfilBean.actualizarPerfil(this.perfilLoginSeleccionado);
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Usuario Actualizado",""));                
    }
    
    public Usuario obtenerUsuarioDePerfil(int idUsuarioBuscado) {        
        return usuarioBean.obtenerUsuario(idUsuarioBuscado);
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
                case "administrativo": /*facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Usuario SI existe",
                            "Este usuario es Administrador"));*/              
                return "usuarioAdministrador?faces-redirect=true";                
                case "supervisor": /*facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Usuario SI existe",
                            "Este usuario es Supervisor"));*/ 
                return "usuarioSupervisor?faces-redirect=true";
                case "final": /*facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Usuario SI existe",
                            "Este usuario es Común"));*/ 
                return "usuarioComun?faces-redirect=true";
                default: /*facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Usuario SI existe",
                            "Este ususario es Indeterminado"));*/ 
                return null;
            }
        }
    }
}
