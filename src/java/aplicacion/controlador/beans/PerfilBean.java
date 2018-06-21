package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.imp.PerfilDAOImp;
import aplicacion.modelo.dominio.Perfil;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Rojas, Guido G.
 */
@ManagedBean
@ViewScoped
public class PerfilBean implements Serializable{

    private Perfil perfil;
    
    public PerfilBean() {
        this.perfil = new Perfil();        
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    
    public Perfil obtenerPerfilDirecto(int codigoPerfilBuscado) { //Busca un perfil dado un ID de PERFIL
        PerfilDAOImp perfilDAOImp = new PerfilDAOImp();
        return perfilDAOImp.obtenerPerfilDirecto(codigoPerfilBuscado);
    }

    public Perfil obtenerPerfil(int codigoPerfilBuscado) { //Busca un perfil dado un ID de USSARIO
        PerfilDAOImp perfilDAOImp = new PerfilDAOImp();
        return perfilDAOImp.obtenerPerfil(codigoPerfilBuscado);
    }    
    
    public void agregarPerfil(Perfil perfil) {
        PerfilDAOImp perfilDAOImp = new PerfilDAOImp();
        perfilDAOImp.add(perfil);
    }
    
    public boolean buscarPerfil(Perfil p){
        PerfilDAOImp perfilDAOImp = new PerfilDAOImp();
        return perfilDAOImp.buscarPerfil(p);
    }
    
    public void actualizarPerfil(Perfil p) {
        PerfilDAOImp perfilDAOImp = new PerfilDAOImp();
        perfilDAOImp.update(p);
    }
    
    public List<Perfil> obtenerPerfiles() {
        PerfilDAOImp perfilDAOImp = new PerfilDAOImp();
        return perfilDAOImp.listarPerfiles();
    }
    
    public List<Perfil> obtenerPerfilesEspecificos(String tipoPerfil) {
        UsuarioBean ub = new UsuarioBean();
        List<Perfil> listaFinal = new ArrayList<Perfil>();
        for(Usuario u: ub.obtenerUsuarios()) {
            if(u.getUsuTipoUsuario().equals(tipoPerfil)) {
                listaFinal.add( this.obtenerPerfil(u.getUsuCodigo()) );
            }
        }
        return listaFinal;
    }
}
