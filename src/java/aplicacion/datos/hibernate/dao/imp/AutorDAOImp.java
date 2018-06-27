package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.IAutorDAO;
import aplicacion.modelo.dominio.Autor;
import java.util.ArrayList;
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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(a);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void delete(Autor a) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(a);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public Autor buscarAutor(Autor a) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        Autor autorAux = new Autor();
        Criteria crit = s.createCriteria(Autor.class);
        crit.add(Restrictions.like("autNombres", a.getAutNombres())); //1) como esta en clase 2)con que comparar        
        crit.add(Restrictions.like("autApellidos", a.getAutApellidos())); //1) como esta en clase 2)con que comparar        
        if(crit.list().isEmpty())
            autorAux=null;
        else 
            autorAux=(Autor) crit.list().get(0);
        s.close();
        return autorAux;
    }

    @Override
    public int obtenerCodigoAutor(Autor a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Autor> devolverAutores() {
        List<Autor> listaAux = new ArrayList<Autor>();
        Session s = HibernateUtil.getSessionFactory().openSession();        
        Criteria crit = s.createCriteria(Autor.class);
        listaAux = crit.list();
        s.close();
        return listaAux; 
    }

    @Override
    public Autor buscarCodigoAutor(int codigoBuscado) {
        Autor autorAux = new Autor();
        Session s = HibernateUtil.getSessionFactory().openSession();        
        Criteria crit = s.createCriteria(Autor.class);
        crit.add(Restrictions.like("autCodigo", codigoBuscado)); //1) como esta en clase 2)con que comparar        
        if(crit.list().isEmpty())
            autorAux=null;
        else 
            autorAux=(Autor) crit.list().get(0);
        s.close();
        return autorAux;
    }

}
