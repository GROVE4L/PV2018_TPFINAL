package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.dao.IEditorialDAO;
import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.modelo.dominio.Editorial;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rojas, Guido G.
 */
public class EditorialDAOImp implements IEditorialDAO {
    /**
     * agregado editorial
     * @param editorial 
     */
    @Override
    public void add(Editorial editorial) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.        
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(editorial);
        s.getTransaction().commit();
        s.close();
    }
    /**
     * actualiza editorial
     * @param editorial 
     */
    @Override
    public void update(Editorial editorial) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(editorial);
        s.getTransaction().commit();
        s.close();
    }
    /**
     * borrado editorial
     * @param editorial 
     */
    @Override
    public void delete(Editorial editorial) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        Session s = HibernateUtil.getSessionFactory().openSession();        
        s.beginTransaction();
        s.update(editorial);
        s.getTransaction().commit();
        s.close();
        
    }
    /**
     * busqueda editorial
     * @param editorial
     * @return 
     */
    @Override
    public Editorial buscarEditorial(Editorial editorial) {
        Editorial objAux = new Editorial();
        Session s = HibernateUtil.getSessionFactory().openSession();        
        Criteria crit = s.createCriteria(Editorial.class);
        crit.add(Restrictions.like("editNombre", editorial.getEditNombre())); //1) como esta en clase 2)con que comparar        
        if(crit.list().isEmpty())
            objAux = null;
        else 
            objAux = (Editorial) crit.list().get(0);            
        return objAux;
    }
    /**
     * lista editorial
     * devuelve editoriales activas
     * @return 
     */
    @Override
    public List<Editorial> devolverEditorialesActivas() {        
        List<Editorial> listaAux = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();        
        Criteria crit = s.createCriteria(Editorial.class);
        crit.add(Restrictions.eq("editEstado", true));  //Para mostrar solo editoriales activas
        listaAux = crit.list();        
        s.close();
        return listaAux;
    }
    /**
     * lista editorial
     * devuelve editoriales
     * @return 
     */
    @Override
    public List<Editorial> devolverEditoriales() {        
        List<Editorial> listaAux = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();        
        Criteria crit = s.createCriteria(Editorial.class);
        //crit.add(Restrictions.eq("editEstado", true));  //Para mostrar solo editoriales activas
        listaAux= crit.list();        
        s.close();
        return listaAux;
    }
    /**
     * procedimiento recover
     * @param editorial 
     */
    @Override
    public void recover(Editorial editorial) {        
        Session s = HibernateUtil.getSessionFactory().openSession();        
        s.beginTransaction();
        s.update(editorial);
        s.getTransaction().commit();
        s.close();
    }
    /**
     * funcion devuelve nombre editorial
     * @param codigoBuscado
     * @return 
     */
    @Override
    public String devolverNombreEditorial(int codigoBuscado) {        
        String strAux;
        Session s = HibernateUtil.getSessionFactory().openSession();        
        Criteria crit = s.createCriteria(Editorial.class);
        crit.add(Restrictions.like("ediCodigo", codigoBuscado)); //1) como esta en clase 2)con que comparar        
        if(crit.list().isEmpty())
            strAux= null;
        else 
            strAux= ((Editorial) crit.list().get(0)).getEditNombre();
        s.close();
        return strAux;
    }

}
