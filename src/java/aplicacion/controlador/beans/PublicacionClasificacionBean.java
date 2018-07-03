package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.imp.PublicacionClasificacionDAOImp;
import aplicacion.modelo.dominio.PublicacionClasificacion;
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
 * clase llamada PublicacionClasificacionBean
 */
public class PublicacionClasificacionBean implements Serializable{
    
    public PublicacionClasificacionBean() {
        
    }
    /**
     * procedimiento llamado agregarPublicacionClasificacion
     * @param pc 
     */
    public void agregarPublicacionClasificacion(PublicacionClasificacion pc) {
        PublicacionClasificacionDAOImp pcDAOImp = new PublicacionClasificacionDAOImp();
        pcDAOImp.add(pc);
    }
    /**
     * lista de publicacion clasificacion
     * @param codigoPublicacionBuscado
     * @return 
     */
    public List<PublicacionClasificacion> listarPublicacionClasificacion(String codigoPublicacionBuscado) {
        PublicacionClasificacionDAOImp pcDAOImp = new PublicacionClasificacionDAOImp();
        return pcDAOImp.devolverPublicacionesClasificaciones(codigoPublicacionBuscado);
    }
}