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
/**
 *la clase ClasificacinBean
 */
public class ClasificacionBean implements Serializable{

    private Clasificacion clasificacion;
    
    public ClasificacionBean() {
        this.clasificacion = new Clasificacion();        
    }
    /**
     * se crea el constructor de Clasificicacion con su Get y Set
     * @return 
     */
    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Clasificacion buscarPorCodigo(int codigoBuscado) {
        ClasificacionDAOImp clasificacionDAOImp = new ClasificacionDAOImp();
        return clasificacionDAOImp.buscarCodigoClasificacion(codigoBuscado);
    }
    /**
       * se crea un procedimiento llamado borrarClasificacion 
       * en el cual se podra borrar la Clasificacion
       * @param c 
       */     
    public void borrarClasificacion(Clasificacion c) {
        ClasificacionDAOImp clasificacionDAOImp = new ClasificacionDAOImp();
        clasificacionDAOImp.delete(c);
    }
    /**
      * se crea un procedimiento llamado modificarClasificacion
      * en el cual se podra modificar la Clasificacion
      * @param c 
      */
    public void modificarClasificacion(Clasificacion c) {
        ClasificacionDAOImp clasificacionDAOImp = new ClasificacionDAOImp();
        clasificacionDAOImp.update(c);
    }
    /**
      * se crea un procedimiento llamado agregarClasificacion
      * @param c 
      */
    public void agregarClasificacion(Clasificacion c) {
        ClasificacionDAOImp clasificacionDAOImp = new ClasificacionDAOImp();
        clasificacionDAOImp.add(c);
    }
    /**
     * buscar la Clasificacion 
     * @param c
     * @return 
     */
    public Clasificacion buscarClasificacion(Clasificacion c) {
        ClasificacionDAOImp clasificacionDAOImp = new ClasificacionDAOImp();
        return clasificacionDAOImp.buscarClasificacion(c);
    }
    public List<Clasificacion> listarClasificaciones() {
        ClasificacionDAOImp clasificacionDAOImp = new ClasificacionDAOImp();
        return clasificacionDAOImp.devolverClasificaciones();
    }
}