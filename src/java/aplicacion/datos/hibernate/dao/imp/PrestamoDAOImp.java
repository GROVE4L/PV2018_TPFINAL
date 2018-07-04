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
    /**
     * agregado prestamo
     * @param pre 
     */
    @Override
    public void add(Prestamo pre) {        
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(pre);
        s.getTransaction().commit();
        s.close();
    }
    /**
     * actualiza prestamo
     * @param pre 
     */
    @Override
    public void update(Prestamo pre) {        
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(pre);
        s.getTransaction().commit();
        s.close();
    }
    /**
     * borrado de perfil
     * @param pre 
     */
    @Override
    public void delete(Prestamo pre) {        
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        pre.setPreEstado(false);
        s.update(pre);
//        s.delete(pre);
        s.getTransaction().commit();
        s.close();
    }
    /**
     * lista prestamo
     * devuelve prestamos
     * @return 
     */
    @Override
    public List<Prestamo> devolverPrestamos() { //Devuelve prestamos activos
        List<Prestamo> listaAux;
        Session s = HibernateUtil.getSessionFactory().openSession();        
        Criteria crit = s.createCriteria(Prestamo.class);        
        crit.add(Restrictions.eq("preEstado", true)); //1) como esta en clase 2)con que comparar                
        if(crit.list().isEmpty())
            listaAux = null;
        else 
            listaAux = crit.list();
        s.close();
        return listaAux; 
    }
    /**
     * obtiene ultimo prestamo
     * @return 
     */
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
