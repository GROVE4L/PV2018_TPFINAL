package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.IPrestamoDAO;
import aplicacion.modelo.dominio.Prestamo;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rojas, Guido G.
 */
public class PrestamoDAOImp implements IPrestamoDAO {

    @Override
    public void add(Prestamo pre) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(pre);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void update(Prestamo pre) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(pre);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void delete(Prestamo pre) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(pre);
        s.getTransaction().commit();
        s.close();
    }
    @Override
    public List<Prestamo> devolverPrestamos() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();        
        Criteria crit = s.createCriteria(Prestamo.class);
        return crit.list(); 
    }

    @Override
    public Prestamo obtenerUltimoPrestamo() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();        
        Criteria crit = s.createCriteria(Prestamo.class);
        return (Prestamo) crit.list().get(crit.list().size()-1);
    }

}
