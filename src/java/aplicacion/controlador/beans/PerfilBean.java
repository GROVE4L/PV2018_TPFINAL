package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.imp.PerfilDAOImp;
import aplicacion.modelo.dominio.Perfil;
import java.io.Serializable;
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

    public Perfil obtenerPerfil(int codigoPerfilBuscado) {
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
}
