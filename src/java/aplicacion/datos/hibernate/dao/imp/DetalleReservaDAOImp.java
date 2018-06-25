package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.IDetalleReservaDAO;
import aplicacion.modelo.dominio.DetalleReserva;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rojas, Guido G.
 */
public class DetalleReservaDAOImp implements IDetalleReservaDAO {

    @Override
    public void add(DetalleReserva dr) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(dr);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void delete(DetalleReserva dr) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(dr);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void update(DetalleReserva dr) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(dr);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public List<DetalleReserva> devolverDetalleReservas() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();        
        Criteria crit = s.createCriteria(DetalleReserva.class);        
        return crit.list();
    }
 

}