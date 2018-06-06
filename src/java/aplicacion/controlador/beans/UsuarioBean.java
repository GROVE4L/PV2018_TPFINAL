package aplicacion.controlador.beans;

import aplicacion.dao.imp.mysql.UsuarioDAOImp;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Rojas, Guido G.
 */
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable{

    private Usuario usuario;
    
    public UsuarioBean() {
        this.usuario = new Usuario();        
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Usuario validarUsuario(Usuario us) {
        UsuarioDAOImp usuarioDAOImp = new UsuarioDAOImp();
        return usuarioDAOImp.login(us);
    }
    public boolean buscarUsuario(Usuario us) {
        UsuarioDAOImp usuarioDAOImp = new UsuarioDAOImp();
        return usuarioDAOImp.buscarUsuario(us);
    }
    public void agregarUsuario(Usuario us) {
        UsuarioDAOImp usuarioDAOImp = new UsuarioDAOImp();
        usuarioDAOImp.add(us);
    }
}
