package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.IDetallePrestamoDAO;
import aplicacion.modelo.dominio.DetallePrestamo;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rojas, Guido G.
 */
public class DetallePrestamoDAOImp implements IDetallePrestamoDAO {

    @Override
    public void add(DetallePrestamo dp) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(dp);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void delete(DetallePrestamo dp) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(dp);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void update(DetallePrestamo dp) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(dp);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public List<DetallePrestamo> devolverDetallePrestamos() {
        List<DetallePrestamo> listaAux = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Criteria crit = s.createCriteria(DetallePrestamo.class);        
        listaAux = crit.list();
        s.close();
        return listaAux;
    }

}
