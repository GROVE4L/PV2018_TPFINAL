package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.IReservaDAO;
import aplicacion.modelo.dominio.Reserva;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rojas, Guido G.
 */
public class ReservaDAOImp implements IReservaDAO {

    @Override
    public void add(Reserva re) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(re);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void update(Reserva re) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(re);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void delete(Reserva re) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(re);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public List<Reserva> devolverReservas() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();        
        Criteria crit = s.createCriteria(Reserva.class);
        return crit.list();
    }

    @Override
    public Reserva obtenerUltimaReserva() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();        
        Criteria crit = s.createCriteria(Reserva.class);
        return (Reserva) crit.list().get(crit.list().size()-1);
    }

}
