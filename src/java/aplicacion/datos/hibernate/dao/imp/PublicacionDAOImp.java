package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.IPublicacionDAO;
import aplicacion.modelo.dominio.Publicacion;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rojas, Guido G.
 */
public class PublicacionDAOImp implements IPublicacionDAO {

    @Override
    public void add(Publicacion p) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(p);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void update(Publicacion p) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(p);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void delete(Publicacion p) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(p);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public Publicacion buscarPublicacion(Publicacion p) {
        Publicacion objAux = new Publicacion();
        Session s = HibernateUtil.getSessionFactory().openSession();        
        Criteria crit = s.createCriteria(Publicacion.class);
        crit.add(Restrictions.like("pubCodigo", p.getPubCodigo())); //1) como esta en clase 2)con que comparar        
        if(crit.list().isEmpty())
            objAux = null;
        else 
            objAux = (Publicacion) crit.list().get(0);
        s.close();
        return objAux;
    }

    @Override
    public int obtenerCodigoPublicacion(Publicacion p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Publicacion> devolverPublicaciones() {        
        List<Publicacion> listaAux = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();        
        Criteria crit = s.createCriteria(Publicacion.class);
        listaAux= crit.list();
        s.close();
        return listaAux;
    }
    @Override
    public List<Publicacion> devolverPublicacionesConStock() {
        List<Publicacion> listaAux = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();        
        Criteria crit = s.createCriteria(Publicacion.class);        
        crit.add(Restrictions.gt("pubStock",0)); //1) como esta en clase 2)con que comparar        
        if(crit.list().isEmpty())
            listaAux= null;
        else 
            listaAux= crit.list();   
        s.close();
        return listaAux;
    }

}
