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
    /**
     * agregado detalle prestamo
     * @param dp 
     */
    @Override
    public void add(DetallePrestamo dp) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(dp);
        s.getTransaction().commit();
        s.close();
    }
    /**
     * borrado detalle prestamos
     * @param dp 
     */
    @Override
    public void delete(DetallePrestamo dp) {        
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        dp.setDpEstado(false);
        s.update(dp);
        //s.delete(dp);
        s.getTransaction().commit();
        s.close();
    }
    /**
     * actualiza detalle prestamo
     * @param dp 
     */
    @Override
    public void update(DetallePrestamo dp) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(dp);
        s.getTransaction().commit();
        s.close();
    }
    /**
     * lista de detalle prestamos
     * @return 
     */
    @Override
    public List<DetallePrestamo> devolverDetallePrestamos() {
        List<DetallePrestamo> listaAux = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Criteria crit = s.createCriteria(DetallePrestamo.class);        
        listaAux = crit.list();
        s.close();
        return listaAux;
    }
    /**
     * lista detalle prestamo
     * que devuelve detalle prestamos codigo
     * @param codigoPrestamoBuscado
     * @return 
     */
    @Override
    public List<DetallePrestamo> devolverDetallePrestamosCodigo(int codigoPrestamoBuscado) {
        List<DetallePrestamo> listaAux = null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        Criteria crit = s.createCriteria(DetallePrestamo.class);
        crit.add(Restrictions.like("dpPrestamo", codigoPrestamoBuscado)); //1) como esta en clase 2)con que comparar
        if(!crit.list().isEmpty())
            listaAux = crit.list();
        s.close();
        return listaAux;
    }

}
