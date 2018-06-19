package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.IPublicacionClasificacionDAO;
import aplicacion.modelo.dominio.PublicacionClasificacion;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rojas, Guido G.
 */
public class PublicacionClasificacionDAOImp implements IPublicacionClasificacionDAO {

    @Override
    public void add(PublicacionClasificacion pc) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(pc);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void delete(PublicacionClasificacion pc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(PublicacionClasificacion pc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PublicacionClasificacion> devolverPublicacionesClasificaciones(String codigoPublicacion) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Criteria crit = s.createCriteria(PublicacionClasificacion.class);
        crit.add(Restrictions.like("pcPublicacion", codigoPublicacion));
        return crit.list(); 
    }



}
