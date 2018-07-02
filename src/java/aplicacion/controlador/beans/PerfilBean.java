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
/**
 * se crea la clase llamada PerfilBean
 */
public class PerfilBean implements Serializable{

    private Perfil perfil;
    
    public PerfilBean() {
        this.perfil = new Perfil();        
    }
    /**
     * se crean los constructor Perfil co su Get y Set
     * @return 
     */
    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    /**
     * obtener Perfil Directo
     * @param codigoPerfilBuscado
     * @return 
     */
    public Perfil obtenerPerfilDirecto(int codigoPerfilBuscado) { //Busca un perfil dado un ID de PERFIL
        PerfilDAOImp perfilDAOImp = new PerfilDAOImp();
        return perfilDAOImp.obtenerPerfilDirecto(codigoPerfilBuscado);
    }
    /**
     * obtencion de Perfil
     * @param codigoPerfilBuscado
     * @return 
     */
    public Perfil obtenerPerfil(int codigoPerfilBuscado) { //Busca un perfil dado un ID de USSARIO
        PerfilDAOImp perfilDAOImp = new PerfilDAOImp();
        return perfilDAOImp.obtenerPerfil(codigoPerfilBuscado);
    }    
    /**
      * procedimiento llamado agregarPerfil
      * @param perfil 
      */
    public void agregarPerfil(Perfil perfil) {
        PerfilDAOImp perfilDAOImp = new PerfilDAOImp();
        perfilDAOImp.add(perfil);
    }
    /**
     * busqueda de Perfil
     * @param p
     * @return 
     */
    public boolean buscarPerfil(Perfil p){
        PerfilDAOImp perfilDAOImp = new PerfilDAOImp();
        return perfilDAOImp.buscarPerfil(p);
    }
    /**
      * procedimiento llamado actualizarPerfil
      * @param p 
      */
    public void actualizarPerfil(Perfil p) {
        PerfilDAOImp perfilDAOImp = new PerfilDAOImp();
        perfilDAOImp.update(p);
    }
    /**
     * lista de Perfil
     * @return 
     */
    public List<Perfil> obtenerPerfiles() {
        PerfilDAOImp perfilDAOImp = new PerfilDAOImp();
        return perfilDAOImp.listarPerfiles();
    }
    /**
     * 
     * @param tipoPerfil
     * @return 
     */
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
