package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.IPublicacionAutorDAO;
import aplicacion.modelo.dominio.PublicacionAutor;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rojas, Guido G.
 */
public class PublicacionAutorDAOImp implements IPublicacionAutorDAO {

    @Override
    public void add(PublicacionAutor pb) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(pb);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void delete(PublicacionAutor pb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(PublicacionAutor pb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PublicacionAutor> devolverPublicacionesAutores(String codigoPublicacion) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.        
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Criteria crit = s.createCriteria(PublicacionAutor.class);
        crit.add(Restrictions.like("paUblicacion", codigoPublicacion));
        return crit.list();  
    }


}
