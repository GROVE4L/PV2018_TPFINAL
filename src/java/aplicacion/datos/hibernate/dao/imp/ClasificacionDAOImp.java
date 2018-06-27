package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.IClasificacionDAO;
import aplicacion.modelo.dominio.Clasificacion;
import java.util.ArrayList;
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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(c);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void delete(Clasificacion c) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(c);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public Clasificacion buscarClasificacion(Clasificacion c) {        
        Session s = HibernateUtil.getSessionFactory().openSession();
        Clasificacion clasAux = new Clasificacion();
        Criteria crit = s.createCriteria(Clasificacion.class);
        crit.add(Restrictions.like("claIdentificador", c.getClaIdentificador())); //1) como esta en clase 2)con que comparar                
        if(crit.list().isEmpty())
            clasAux = null;
        else 
            clasAux = (Clasificacion) crit.list().get(0);
        s.close();
        return clasAux;
    }

    @Override
    public int obtenerCodigoClasificacion(Clasificacion c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Clasificacion> devolverClasificaciones() {
        List<Clasificacion> listaAux = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();        
        Criteria crit = s.createCriteria(Clasificacion.class);        
        listaAux = crit.list();
        s.close();
        return listaAux;
    }

    @Override
    public Clasificacion buscarCodigoClasificacion(int codigoBuscado) {        
        Clasificacion objAux = new Clasificacion();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Criteria crit = s.createCriteria(Clasificacion.class);
        crit.add(Restrictions.like("claCodigo", codigoBuscado)); //1) como esta en clase 2)con que comparar        
        if(crit.list().isEmpty())
            objAux=null;
        else 
            objAux= (Clasificacion) crit.list().get(0);
        s.close();
        return objAux;
    }    

}
