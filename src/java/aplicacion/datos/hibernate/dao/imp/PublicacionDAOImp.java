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
        
        System.out.println("Hasta AQUIIII");
            System.out.println("Nombre: "+p.getPubNombre());
            System.out.println("Resumen: "+p.getPubResumen());
            System.out.println("Tipo: "+p.getPubTipo());
            System.out.println("Codigo Editorial: "+p.getPubEditorial());
            System.out.println("Stock: "+p.getPubStock());
            System.out.println("Estado: "+p.isPubEstado());
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(p);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void update(Publicacion p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Publicacion p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Publicacion buscarPublicacion(Publicacion p) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();        
        Criteria crit = s.createCriteria(Publicacion.class);
        crit.add(Restrictions.like("pubCodigo", p.getPubCodigo())); //1) como esta en clase 2)con que comparar        
        if(crit.list().isEmpty())
            return null;
        else 
            return (Publicacion) crit.list().get(0);
    }

    @Override
    public int obtenerCodigoPublicacion(Publicacion p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Publicacion> devolverPublicaciones() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();        
        Criteria crit = s.createCriteria(Publicacion.class);
        return crit.list();
        
    }

}
