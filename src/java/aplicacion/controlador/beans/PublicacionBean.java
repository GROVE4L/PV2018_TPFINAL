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
/**
 * clase publicacionBean
 */
public class PublicacionBean implements Serializable{

    private Publicacion publicacion;
    
    public PublicacionBean() {
        this.publicacion = new Publicacion();
    }
    /***
     * constructor de publicacion con su get y set
     * @return 
     */
    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }
    /**
     * procedimiento llamado buscarPublicacion
     * busqueda de publicacion
     * @param p
     * @return 
     */
    public Publicacion buscarPublicacion(Publicacion p) {
        PublicacionDAOImp publicacionDAOImp = new PublicacionDAOImp();
        return publicacionDAOImp.buscarPublicacion(p);
    }
    /**
     * procemiento llamado agregarPublicacion
     * agregado de publicacion
     * @param p 
     */
    public void agregarPublicacion(Publicacion p) {
        PublicacionDAOImp publicacionDAOImp = new PublicacionDAOImp();
        publicacionDAOImp.add(p);
    }
    /**
     * procedimiento llamado modificarPublicacion}
     * modificacion de publicacion
     * @param p 
     */
    public void modificarPublicacion(Publicacion p) {
        PublicacionDAOImp publicacionDAOImp = new PublicacionDAOImp();
        publicacionDAOImp.update(p);
    }
    /**
     * lista de publicaciones
     * @return 
     */
    public List<Publicacion> listarPublicaciones() {        
        PublicacionDAOImp publicacionDAOImp = new PublicacionDAOImp();        
        return publicacionDAOImp.devolverPublicaciones();        
    }
    /**
     * lista de publicaciones con stock
     * @return 
     */
    public List<Publicacion> listarPublicacionesConStock() {
        PublicacionDAOImp publicacionDAOImp = new PublicacionDAOImp();        
        return publicacionDAOImp.devolverPublicacionesConStock();        
    }
}