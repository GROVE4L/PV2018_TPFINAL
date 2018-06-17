package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.IClasificacionDAO;
import aplicacion.modelo.dominio.Clasificacion;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rojas, Guido G.
 */
public class ClasificacionDAOImp implements IClasificacionDAO {

    @Override
    public void add(Clasificacion c) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(c);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void update(Clasificacion c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Clasificacion c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Clasificacion buscarClasificacion(Clasificacion c) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();        
        Criteria crit = s.createCriteria(Clasificacion.class);
        crit.add(Restrictions.like("claIdentificador", c.getClaIdentificador())); //1) como esta en clase 2)con que comparar                
        if(crit.list().isEmpty())
            return null;
        else 
            return (Clasificacion) crit.list().get(0);
    }

    @Override
    public int obtenerCodigoClasificacion(Clasificacion c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Clasificacion> devolverClasificaciones() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();        
        Criteria crit = s.createCriteria(Clasificacion.class);        
        return crit.list();    
    }

    

}