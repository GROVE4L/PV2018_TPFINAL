package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.imp.PublicacionDAOImp;
import aplicacion.modelo.dominio.Publicacion;
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
public class PublicacionBean implements Serializable{

    private Publicacion publicacion;
    
    public PublicacionBean() {
        this.publicacion = new Publicacion();
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public Publicacion buscarPublicacion(Publicacion p) {
        PublicacionDAOImp publicacionDAOImp = new PublicacionDAOImp();
        return publicacionDAOImp.buscarPublicacion(p);
    }
    public void agregarPublicacion(Publicacion p) {
        PublicacionDAOImp publicacionDAOImp = new PublicacionDAOImp();
        publicacionDAOImp.add(p);
    }
    
    public List<Publicacion> listarPublicaciones() {        
        PublicacionDAOImp publicacionDAOImp = new PublicacionDAOImp();        
        return publicacionDAOImp.devolverPublicaciones();        
    }
}