package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.IPublicacionClasificacionDAO;
import aplicacion.modelo.dominio.PublicacionClasificacion;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rojas, Guido G.
 */
public class PublicacionClasificacionDAOImp implements IPublicacionClasificacionDAO {
    /**
     * agregado publicacion clasificacion
     * @param pc 
     */
    @Override
    public void add(PublicacionClasificacion pc) {        
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(pc);
        s.getTransaction().commit();
        s.close();
    }
    /**
     * borrado publicacion clasificacion
     * @param pc 
     */
    @Override
    public void delete(PublicacionClasificacion pc) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(pc);
        s.getTransaction().commit();
        s.close();
    }
    /**
     * actualiza publicacion clasificacion
     * @param pc 
     */
    @Override
    public void update(PublicacionClasificacion pc) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(pc);
        s.getTransaction().commit();
        s.close();
    }
    /**
     * lista publicacion clasificacion
     * devuelve publicaciones clasificaciones
     * @param codigoPublicacion
     * @return 
     */
    @Override
    public List<PublicacionClasificacion> devolverPublicacionesClasificaciones(String codigoPublicacion) {
        List<PublicacionClasificacion> listaAux = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();      
        Criteria crit = s.createCriteria(PublicacionClasificacion.class);
        crit.add(Restrictions.like("pcPublicacion", codigoPublicacion));
        listaAux = crit.list(); 
        s.close();
        return listaAux;
    }



}
