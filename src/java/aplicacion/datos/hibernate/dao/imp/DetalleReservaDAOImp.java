package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.IDetalleReservaDAO;
import aplicacion.modelo.dominio.DetalleReserva;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rojas, Guido G.
 */
public class DetalleReservaDAOImp implements IDetalleReservaDAO {
    /**
     * agregado detalle reserva
     * @param dr 
     */
    @Override
    public void add(DetalleReserva dr) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(dr);
        s.getTransaction().commit();
        s.close();
    }
    /**
     * borrado de detalle reserva
     * @param dr 
     */
    @Override
    public void delete(DetalleReserva dr) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(dr);
        s.getTransaction().commit();
        s.close();
    }
    /**
     * actualiza detalle reserva
     * @param dr 
     */
    @Override
    public void update(DetalleReserva dr) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(dr);
        s.getTransaction().commit();
        s.close();
    }
    /**
     * lista detalle reserva 
     * devuelve detalle reservas
     * @return 
     */
    @Override
    public List<DetalleReserva> devolverDetalleReservas() {        
        List<DetalleReserva> listaAux = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();        
        Criteria crit = s.createCriteria(DetalleReserva.class);        
        listaAux=crit.list();
        s.close();
        return listaAux;
    }
 

}
