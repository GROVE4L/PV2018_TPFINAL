package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.IReservaDAO;
import aplicacion.modelo.dominio.Reserva;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rojas, Guido G.
 */
public class ReservaDAOImp implements IReservaDAO {
    /**
     * agregado reserva
     * @param re 
     */
    @Override
    public void add(Reserva re) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(re);
        s.getTransaction().commit();
        s.close();
    }
    /**
     * actualiza reserva
     * @param re 
     */
    @Override
    public void update(Reserva re) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(re);
        s.getTransaction().commit();
        s.close();
    }
    /**
     * borrado reserva
     * @param re 
     */
    @Override
    public void delete(Reserva re) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(re);
        s.getTransaction().commit();
        s.close();
    }
    /**
     * lista reserva
     * devuelve reservas
     * @return 
     */
    @Override
    public List<Reserva> devolverReservas() {
        List<Reserva> listaAux=new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();        
        Criteria crit = s.createCriteria(Reserva.class);
        listaAux = crit.list();
        s.close();
        return listaAux;
    }
    /**
     * obtiene ultima reserva
     * @return 
     */
    @Override
    public Reserva obtenerUltimaReserva() {
        Reserva objAux = new Reserva();
        Session s = HibernateUtil.getSessionFactory().openSession();        
        Criteria crit = s.createCriteria(Reserva.class);
        objAux= (Reserva) crit.list().get(crit.list().size()-1);
        s.close();
        return objAux;
    }

}
