package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.IPrestamoDAO;
import aplicacion.modelo.dominio.Prestamo;
import java.util.ArrayList;
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
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(pre);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void update(Prestamo pre) {        
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(pre);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void delete(Prestamo pre) {        
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(pre);
        s.getTransaction().commit();
        s.close();
    }
    @Override
    public List<Prestamo> devolverPrestamos() {
        List<Prestamo> listaAux = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();        
        Criteria crit = s.createCriteria(Prestamo.class);
        listaAux=crit.list();
        s.close();
        return listaAux; 
    }

    @Override
    public Prestamo obtenerUltimoPrestamo() {
        Prestamo objAux = new Prestamo();
        Session s = HibernateUtil.getSessionFactory().openSession();        
        Criteria crit = s.createCriteria(Prestamo.class);
        objAux = (Prestamo) crit.list().get(crit.list().size()-1);
        s.close();
        return objAux;
    }

}
