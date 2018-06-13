package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.IAutorDAO;
import aplicacion.modelo.dominio.Autor;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rojas, Guido G.
 */
public class AutorDAOImp implements IAutorDAO {

    @Override
    public void add(Autor a) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(a);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void update(Autor a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Autor a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Autor buscarAutor(Autor a) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();        
        Criteria crit = s.createCriteria(Autor.class);
        crit.add(Restrictions.like("autNombres", a.getAutNombres())); //1) como esta en clase 2)con que comparar        
        crit.add(Restrictions.like("autApellidos", a.getAutApellidos())); //1) como esta en clase 2)con que comparar        
        if(crit.list().isEmpty())
            return null;
        else 
            return (Autor) crit.list().get(0);
    }

    @Override
    public int obtenerCodigoAutor(Autor a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Autor> devolverAutores() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();        
        Criteria crit = s.createCriteria(Autor.class);        
        return crit.list(); 
    }

}
