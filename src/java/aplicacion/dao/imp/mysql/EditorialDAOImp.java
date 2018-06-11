package aplicacion.dao.imp.mysql;

import aplicacion.dao.IEditorialDAO;
import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.modelo.dominio.Editorial;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rojas, Guido G.
 */
public class EditorialDAOImp implements IEditorialDAO {

    @Override
    public void add(Editorial editorial) {
        
        /*System.out.println("Editorial que llego DAO IMP:");
        System.out.println("Nombre: "+editorial.getEditNombre());
        System.out.println("Estado: "+editorial.isEditEstado());*/
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.        
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(editorial);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void update(Editorial editorial) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Editorial editorial) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Editorial buscarEditorial(Editorial editorial) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.        
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();        
        Criteria crit = s.createCriteria(Editorial.class);
        crit.add(Restrictions.like("editNombre", editorial.getEditNombre())); //1) como esta en clase 2)con que comparar        
        if(crit.list().isEmpty())
            return null;
        else 
            return (Editorial) crit.list().get(0);            
    }

    @Override
    public List<Editorial> devolverEditoriales() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();        
        Criteria crit = s.createCriteria(Editorial.class);        
        return crit.list();        
    }

}
