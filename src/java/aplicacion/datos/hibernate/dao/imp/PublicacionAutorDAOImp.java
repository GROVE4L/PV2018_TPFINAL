package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.IPublicacionAutorDAO;
import aplicacion.modelo.dominio.PublicacionAutor;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rojas, Guido G.
 */
public class PublicacionAutorDAOImp implements IPublicacionAutorDAO {
    /**
     * agregado publicacion autor
     * @param pb 
     */
    @Override
    public void add(PublicacionAutor pb) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(pb);
        s.getTransaction().commit();
        s.close();
    }
    /**
     * borrado publicacion autor
     * @param pb 
     */
    @Override
    public void delete(PublicacionAutor pb) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(pb);
        s.getTransaction().commit();
        s.close();
    }
    /**
     * actualiza pulicacion autor
     * @param pb 
     */
    @Override
    public void update(PublicacionAutor pb) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(pb);
        s.getTransaction().commit();
        s.close();
    }
    /**
     * lista publicacion autor
     * devuelve publicaciones autores
     * @param codigoPublicacion
     * @return 
     */
    @Override
    public List<PublicacionAutor> devolverPublicacionesAutores(String codigoPublicacion) {        
        List<PublicacionAutor> listaAux = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();        
        Criteria crit = s.createCriteria(PublicacionAutor.class);
        crit.add(Restrictions.like("paUblicacion", codigoPublicacion));
        listaAux = crit.list();  
        s.close();
        return listaAux;
    }


}
