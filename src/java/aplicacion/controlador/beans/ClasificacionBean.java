package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.imp.ClasificacionDAOImp;
import aplicacion.modelo.dominio.Clasificacion;
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
public class ClasificacionBean implements Serializable{

    private Clasificacion clasificacion;
    
    public ClasificacionBean() {
        this.clasificacion = new Clasificacion();        
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

        
    public void borrarClasificacion(Clasificacion c) {
        ClasificacionDAOImp clasificacionDAOImp = new ClasificacionDAOImp();
        clasificacionDAOImp.delete(c);
    }
    
    public void modificarClasificacion(Clasificacion c) {
        ClasificacionDAOImp clasificacionDAOImp = new ClasificacionDAOImp();
        clasificacionDAOImp.update(c);
    }

    public void agregarClasificacion(Clasificacion c) {
        ClasificacionDAOImp clasificacionDAOImp = new ClasificacionDAOImp();
        clasificacionDAOImp.add(c);
    }
    public Clasificacion buscarClasificacion(Clasificacion c) {
        ClasificacionDAOImp clasificacionDAOImp = new ClasificacionDAOImp();
        return clasificacionDAOImp.buscarClasificacion(c);
    }
    public List<Clasificacion> listarClasificaciones() {
        ClasificacionDAOImp clasificacionDAOImp = new ClasificacionDAOImp();
        return clasificacionDAOImp.devolverClasificaciones();
    }
}