package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.imp.UsuarioDAOImp;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Rojas, Guido G.
 */
@ManagedBean
@ViewScoped
/**
 * clase UsuarioBean
 */
public class UsuarioBean implements Serializable{

    private Usuario usuario;
    
    public UsuarioBean() {
        this.usuario = new Usuario();        
    }
    /**
     * constructor de Usuario con su get
     * @return 
     */
    public Usuario getUsuario() {
        return usuario;
    }
    /**
     * constructor de Usuario con set
     * @param usuario 
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    /**
     * obtener usuario
     * @param codigoBuscado
     * @return 
     */
    public Usuario obtenerUsuario(int codigoBuscado) {
        UsuarioDAOImp usuarioDAOImp = new UsuarioDAOImp();
        return usuarioDAOImp.obtenerUsuario(codigoBuscado);
    }
    /**
     * validacion de usuario
     * @param us
     * @return 
     */
    public Usuario validarUsuario(Usuario us) {
        UsuarioDAOImp usuarioDAOImp = new UsuarioDAOImp();
        return usuarioDAOImp.login(us);
    }
    /**
     * busqueda de usuario
     * @param us
     * @return 
     */
    public boolean buscarUsuario(Usuario us) {
        UsuarioDAOImp usuarioDAOImp = new UsuarioDAOImp();
        return usuarioDAOImp.buscarUsuario(us);
    }
    /**
     * obtencion de codigo usuario
     * @param us
     * @return 
     */
    public int obtenerCodigoUsuario(Usuario us) {
        UsuarioDAOImp usuarioDAOImp = new UsuarioDAOImp();
        return usuarioDAOImp.obtenerCodigoUsuario(us);
    }
    /**
     * agregado de usuario
     * @param us 
     */
    public void agregarUsuario(Usuario us) {
        UsuarioDAOImp usuarioDAOImp = new UsuarioDAOImp();
        usuarioDAOImp.add(us);
    } 
    /**
     * procedimiento llamado actualizarUsuario
     * 
     * @param us 
     */
    public void actualizarUsuario(Usuario us) {
        UsuarioDAOImp usuarioDAOImp = new UsuarioDAOImp();
        usuarioDAOImp.update(us);
    }
    /**
     * lista de usuario en la cual se obtendra los usuarios
     * @return 
     */
    public List<Usuario> obtenerUsuarios() {
        UsuarioDAOImp usuarioDAOImp = new UsuarioDAOImp();
        return usuarioDAOImp.devolverUsuarios();
    }
}
